package backend.backend.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;
@Entity
@Table(name = "Facture")
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private int num;
    private Date date;
    private String client;
    private String montant;
    private Long user_id;

    public Facture() {
    }

    public Facture(Long id, int num, Date date, String client, String montant, Long user_id) {
        this.id = id;
        this.num = num;
        this.date = date;
        this.client = client;
        this.montant = montant;
        this.user_id = user_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getMontant() {
        return montant;
    }

    public void setMontant(String montant) {
        this.montant = montant;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facture facture = (Facture) o;
        return Objects.equals(num, facture.num);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
