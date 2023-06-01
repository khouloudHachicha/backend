package backend.backend.Service;

import backend.backend.Model.Facture;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
public interface FactureService {
    void addFacture(Facture facture);
    List<Facture> getFactureList();
}
