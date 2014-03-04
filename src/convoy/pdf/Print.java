package convoy.pdf;

import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;

/**
 * @author Mike Moye <mtm5313@psu.edu>
 * @version 1.0
 * @since 2014-02-27
 *
 * <p>
 * This class is used to print the pdf. It opens the pdf file in the user's
 * default pdf application and opens the print dialog.
 * </p>
 */
public class Print {

    /**
     * opens a file externally to be printed
     *
     * @param file file to be printed
     */
    public void print(String file) {
        try {
            File document = new File(file + ".pdf");
            Desktop.getDesktop().print(document);
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }

    /**
     * The Main method
     *
     * @param args the command line arguments
     * @throws PrinterException
     */
    public static void main(String args[]) throws PrinterException {
        try {
            File document = new File("src\\pdf\\convoy.pdf");
            System.out.print(document.getName());
            Desktop.getDesktop().print(document);
        } catch (IOException ex) {
            //ex.printStackTrace();
        }
    }
}
