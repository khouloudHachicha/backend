package backend.backend.Dao;

import backend.backend.Model.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureDao extends JpaRepository<Facture, String> {
    Facture findByNum(int num);
    Facture findByUserId(Long id);


}
