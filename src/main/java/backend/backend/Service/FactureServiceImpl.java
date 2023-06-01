package backend.backend.Service;

import backend.backend.Dao.FactureDao;
import backend.backend.Model.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FactureServiceImpl {
    @Autowired
    FactureDao factureDao;
    public void addFacture(Facture facture) {
        factureDao.save(facture);
    }

    public List<Facture> getFactureList() {
        return factureDao.findAll();
    }
}
