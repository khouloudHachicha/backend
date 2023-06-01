package backend.backend;

import backend.backend.Dao.UserDao;
import backend.backend.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BackendApplication {
	public static void main(String[] args) {
		ApplicationContext ctx;
		ctx =SpringApplication.run(BackendApplication.class, args);
//		 UserDao userDao = ctx.getBean(UserDao.class);
//		User user = new User(1,"admis","admis","admis","admis","admis","Super Admis");
//		 userDao.save(user);

	}

}
