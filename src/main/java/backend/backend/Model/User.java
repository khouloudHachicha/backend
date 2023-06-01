package backend.backend.Model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String cin;
    private String phone;
    private String email;
    private String password;
    private String role;
    @OneToMany(fetch = FetchType.EAGER)
    private Collection<Facture> factures;

    public User(){
        super();
    }

    public User(int id, String username, String cin, String phone, String email, String password,
                String role, Collection<Facture> factures) {
        this.id = id;
        this.username = username;
        this.cin = cin;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.factures = factures;
    }

    public User(String username, String username1) {
    }

    public String getRole() {
        return role;
    }

    public Collection<Facture> getFactures() {
        return factures;
    }

    public void setFactures(Collection<Facture> factures) {
        this.factures = factures;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getCin() {
        return cin;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username);
    }
}
