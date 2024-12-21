package view;

import model.User;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class UserPdf {
    public void exportPdf(List<User> users) {
        System.out.println(users.size());

        // Initialize document
        Document document = new Document(PageSize.A4);

        try {
            // Create PDF writer
            PdfWriter writer = PdfWriter.getInstance(document,
                    new FileOutputStream(System.getProperty("user.dir") + File.separator + "users.pdf"));

            document.open();

            // Table setup
            float[] columnDefinitionSize = {1.5F, 3F, 4F};
            PdfPTable table = new PdfPTable(columnDefinitionSize);
            table.setWidthPercentage(100);

            // Table header
            table.addCell(new Phrase("No"));
            table.addCell(new Phrase("Name"));
            table.addCell(new Phrase("Email"));

            // Table content
            int no = 1;
            for (User user : users) {
                table.addCell(new Phrase(String.valueOf(no++)));
                table.addCell(new Phrase(user.getName()));
                table.addCell(new Phrase(user.getEmail()));
            }

            // Add table to document
            document.add(table);

        } catch (DocumentException | IOException ex) {
            System.err.println("Error creating PDF: " + ex.getMessage());
        } finally {
            document.close();
        }
    }
}
