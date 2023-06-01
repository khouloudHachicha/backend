package backend.backend.Model;

import com.lowagie.text.*;
import com.lowagie.text.pdf.CMYKColor;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class FacturePDFExporter {
    private List<Facture> ListFacture;
    Facture facture = new Facture();

    public void generate(List < Facture > factureList, HttpServletResponse response) throws DocumentException, IOException {
        // Creating the Object of Document
        Document document = new Document(PageSize.A4);
        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());
        // Opening the created document to change it
        document.open();
        // Creating font
        // Setting font style and size
        Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTiltle.setSize(20);
        // Creating paragraph
        Paragraph paragraph1 = new Paragraph("Facture", fontTiltle);
        // Aligning the paragraph in the document
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        // Adding the created paragraph in the document
        document.add(paragraph1);
        // Creating a table of the 6 columns
        PdfPTable table = new PdfPTable(4);
        // Setting width of the table, its columns and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new int[] {3,3,3,3});
        table.setSpacingBefore(4);
        // Create Table Cells for the table header
        PdfPCell cell = new PdfPCell();
        // Setting the background color and padding of the table cell
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(4);
        // Creating font
        // Setting font style and size
        Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        font.setColor(CMYKColor.WHITE);
        // Adding headings in the created table cell or  header
        // Adding Cell to table
        cell.setPhrase(new Phrase("Numéro", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Date", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Client", font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Montant", font));
        table.addCell(cell);
        // Iterating the list of facture
        for (Facture facture: factureList) {
            table.addCell(String.valueOf(facture.getNum()));
            table.addCell(String.valueOf(facture.getDate()));
            table.addCell(facture.getClient());
            table.addCell(facture.getMontant());
        }
        // Adding the created table to the document
        document.add(table);
        // Closing the document
        document.close();
    }
    public void singlePdf(Facture facture, HttpServletResponse response) throws DocumentException, IOException {
        // Creating the object of Document
        Document document = new Document(PageSize.A4);
        // Getting instance of PdfWriter
        PdfWriter.getInstance(document, response.getOutputStream());
        // Opening the created document to change it
        document.open();
        // Creating font
        // Setting font style and size
        Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontTitle.setSize(20);
        // Creating paragraph
        Paragraph paragraph1 = new Paragraph("Facture", fontTitle);
        // Aligning the paragraph in the document
        paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
        // Adding the created paragraph in the document
        document.add(paragraph1);
        // Creating a table of 4 columns
        PdfPTable table = new PdfPTable(4);
        // Setting width of the table, its columns, and spacing
        table.setWidthPercentage(100f);
        table.setWidths(new float[]{3, 3, 3, 3});
        table.setSpacingBefore(4);
        // Creating font for table header
        // Setting font style, size, and color
        Font fontHeader = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        fontHeader.setColor(CMYKColor.WHITE);
        // Create Table Cells for the table header
        PdfPCell cell = new PdfPCell();
        // Setting the background color and padding of the table header cell
        cell.setBackgroundColor(CMYKColor.BLUE);
        cell.setPadding(4);
        // Adding headings to the table header cells
        cell.setPhrase(new Phrase("Numéro", fontHeader));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Date", fontHeader));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Client", fontHeader));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Montant", fontHeader));
        table.addCell(cell);
        // Creating font for table content
        Font fontContent = FontFactory.getFont(FontFactory.TIMES_ROMAN);
        // Adding content to the table cells
        table.addCell(String.valueOf(facture.getNum()));
        table.addCell(String.valueOf(facture.getDate()));
        table.addCell(facture.getClient());
        table.addCell(facture.getMontant());
        // Adding the table to the document
        document.add(table);
        // Closing the document
        document.close();
    }
}
