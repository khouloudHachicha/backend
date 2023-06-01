package backend.backend.Controller;

import backend.backend.Dao.EntrepriseDao;
import backend.backend.Model.Entreprise;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class EntrepriseController {
    private EntrepriseDao entrepriseDao;
    @GetMapping("/getAll")
    public List<Entreprise> getAll() {
        return entrepriseDao.findAll();
    }
}
