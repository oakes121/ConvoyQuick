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
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
 
/**
 * First iText example: Hello World.
 */
public class HellWorldColumn {
 
    /** Path to the resulting PDF file. */
    public static final String RESULT
        = "hello_column.pdf";
 
    /**
     * Creates a PDF file: hello_column.pdf
     * @param args no arguments needed
     */
    public static void main(String[] args)
    	throws DocumentException, IOException {
        // step 1
        Document document = new Document();
        // step 2
        PdfWriter writer
            = PdfWriter.getInstance(document, new FileOutputStream(RESULT));
        // step 3
        document.open();
        // step 4
        // we set the compression to 0 so that we can read the PDF syntax
        writer.setCompressionLevel(0);
        // writes something to the direct content using a convenience method
        Phrase hello = new Phrase("Hello World");
        PdfContentByte canvas = writer.getDirectContentUnder();
        ColumnText.showTextAligned(canvas, Element.ALIGN_LEFT,
            hello, 36, 788, 0);
        // step 5
        document.close();
    }
}