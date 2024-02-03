package com.carleasingsystem.api.Service ;
import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;

@Service
public class PdfGenerationService {

    public byte[] generatePdf(String customerId, LocalDate startDate, LocalDate endDate, double payment) throws IOException {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
            // Customize PDF content based on customer data
        	contentStream.setFont(PDType1Font.HELVETICA, 12);

            float margin = 50; // Margin from left
            float yPosition = page.getMediaBox().getHeight() - margin;
            float lineHeight = 15; // Adjust line spacing as needed

            contentStream.beginText();
            contentStream.newLineAtOffset(margin, yPosition);
            contentStream.showText("Lease Agreement");
            contentStream.newLine();

            // Adjust yPosition and add lines as needed
            yPosition -= lineHeight;
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("Customer ID: " + customerId);
            contentStream.newLine();

            yPosition -= lineHeight;
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("Start Date: " + startDate.toString());
            contentStream.newLine();

            yPosition -= lineHeight;
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("End Date: " + endDate.toString());
            contentStream.newLine();

            yPosition -= lineHeight;
            contentStream.newLineAtOffset(0, -lineHeight);
            contentStream.showText("Payment: $" + payment);
            contentStream.endText();
        }
        
        

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        document.save(byteArrayOutputStream);
        document.close();

        return byteArrayOutputStream.toByteArray();
    }
}

