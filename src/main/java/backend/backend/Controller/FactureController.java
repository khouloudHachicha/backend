package backend.backend.Controller;

import backend.backend.Dao.FactureDao;
import backend.backend.Model.Facture;
import backend.backend.Model.FacturePDFExporter;
import backend.backend.Service.FactureService;
import com.lowagie.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/factures")
public class FactureController {

    private FactureService factureService;
    @Autowired
    private FactureDao factureDao;

    @GetMapping("/getAll")
    public List<Facture> getAllFactures() {
        return factureDao.findAll();
    }

    @GetMapping("/getFacture/{id}")
    public Facture getFactureByUserId(Long id) {
        return  factureDao.findByUserId(id);
    }
    @GetMapping("/pdf")
    public void generatePdfFile(HttpServletResponse response) throws DocumentException, IOException
    {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
        String currentDateTime = dateFormat.format(new Date());
        String headerkey = "Content-Disposition";
        String headervalue = "attachment; filename=facture" + currentDateTime + ".pdf";
        response.setHeader(headerkey, headervalue);
        List < Facture > listofFacture = factureDao.findAll();
        FacturePDFExporter generator = new FacturePDFExporter();
        generator.generate(listofFacture, response);
    }
    @GetMapping("/pdf/{num}")
    public void generatePdfFilebyNum(HttpServletResponse response, int num) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        String currentDateTime = dateFormat.format(new Date());
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=facture_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
        Facture facture = factureDao.findByNum(num);
        FacturePDFExporter pdfGenerator = new FacturePDFExporter();
        pdfGenerator.singlePdf(facture, response);
    }
}
