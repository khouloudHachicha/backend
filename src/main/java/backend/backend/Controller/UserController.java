package backend.backend.Controller;

import backend.backend.Dao.UserDao;
import backend.backend.Model.Login;
import backend.backend.Model.User;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/")
public class UserController {

        @Autowired
        private UserDao userDao;

        @GetMapping("/getAll")
        public List<User> getAllUsers() {
            return userDao.findAll();
        }

        @PostMapping("/register")
        public User register(@RequestBody User user) {
            Optional<User> userOptional = userDao.findByEmail(user.getEmail());
            if (userOptional.isPresent()) {
                throw new RuntimeException("Email already exists");
            }
            return userDao.save(user);
        }
        @PostMapping("/login")
        public User login(@RequestBody Login login) {
            Optional<User> userOptional = userDao.findByEmail(login.getEmail());
            if (!userOptional.isPresent()) {
                throw new RuntimeException("Invalid email or password");
            }
            User user = userOptional.get();
            if (!user.getPassword().equals(login.getPassword())) {
                throw new RuntimeException("Invalid email or password");
            }
            return user;
        }
        @GetMapping("/getRole/{username}")
        public User getUserByusername(@PathVariable String username) {
            return userDao.findByUsername(username)
                    .orElseThrow(() -> new ResourceNotFoundException("User"));
        }

        @PutMapping("/update/{id}")
        public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
            User user = userDao.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("User"));

            user.setUsername(userDetails.getUsername());
            user.setCin(userDetails.getCin());
            user.setEmail(userDetails.getEmail());
            user.setPhone(userDetails.getPhone());

            return userDao.save(user);
        }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id) {
       userDao.deleteById(id);
    }

    @PutMapping("/user/updateRole/{id}")
    public ResponseEntity<?> updateUserRole( @PathVariable int id, @RequestBody String newRole) {
        User user = userDao.findById(Long.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        user.setRole(newRole);
        userDao.save(user);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/search/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        Optional<User> user = userDao.findByUsername(username);

        if (user != null) {
            return user;
        } else {
            return null;
        }
    }
}
