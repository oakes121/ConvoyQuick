/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pdftest;

import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
 
public class TableAlignment extends MyFirstTable {
 
    /** The resulting PDF file. */
    public static final String RESULT
        = "src\\pdftest\\testOuput\\table_alignment.pdf";
 
    /**
     * Creates a PDF with information about the movies
     * @param    filename the name of the PDF file that will be created.
     * @throws    DocumentException 
     * @throws    IOException
     */
    public void createPdf(String filename)
        throws IOException, DocumentException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        PdfPTable table = createFirstTable();
        table.setWidthPercentage(50);
        table.setHorizontalAlignment(Element.ALIGN_LEFT);
        document.add(table);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        document.add(table);
        table.setHorizontalAlignment(Element.ALIGN_RIGHT);
        document.add(table);
        // step 5
        document.close();
    }
 
    /**
     * Main method.
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main(String[] args)
        throws IOException, DocumentException {
        new TableAlignment().createPdf(RESULT);
    }
}
