package convoy.pdf;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.allcolor.yahp.converter.CYaHPConverter;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;

/**
 * @author Mike Moye <mtm5313@psu.edu>
 * @version 1.0
 * @since 2014-02-27
 *
 * <p>
 * This class is used to create the pdf. I creates the pdf using the pdf library
 * by grabbing the generated html and opening the pdf in the user's default pdf
 * application.
 * </p>
 */
public class Create {

    String location = ""; //loacation that the pdf is stored

    /**
     * Default constructor
     */
    public Create() {
    }

    /**
     * Constructor that creates the pdf in the specified location
     *
     * @param location location pdf will be stored
     */
    public Create(String location) {
        this.location = location;
    }

    /**
     * The Main method
     *
     * @param args the command line arguments
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {

        String root = "src\\convoy\\resources\\html";
        String input = "convoy.htm";  // need to be charset utf-8
        String output = "src\\pdf\\" + input.replace(".htm", "");
        htmlToPdfFile(new File(root, input),
                new File(output + ".pdf"));
        //System.out.println("Done");
    }

    /**
     * Creates pdf and opens pdf in the user's default pdf application
     *
     * @throws Exception
     */
    public void createPDF() throws Exception {
        String root = getProgramPath() + "\\conx\\html\\";
        String input = "convoy.html";  // need to be charset utf-8 
        htmlToPdfFile(new File(root, input),
                new File(location + ".pdf"));
        open(new File(location + ".pdf"));
    }

    /**
     * Creates pdf but does not open pdf
     *
     * @throws Exception
     */
    public void createPDFPrint() throws Exception {
        String root = getProgramPath() + "\\conx\\html\\";
        String input = "convoy.html";  // need to be charset utf-8 
        htmlToPdfFile(new File(root, input),
                new File(location + ".pdf"));
    }

    /**
     * Opens a file externally in its default application
     *
     * @param document file to be opened
     */
    public static void open(File document) {
        try {
            Desktop dt = Desktop.getDesktop();
            dt.open(document);
        } catch (IOException ex) {
        }
    }

    /**
     * Converts HTML to PDF using the pdf library
     *
     * @param htmlIn
     * @param pdfOut
     * @throws Exception
     */
    public static void htmlToPdfFile(File htmlIn, File pdfOut) throws Exception {
        Scanner scanner
                = new Scanner(htmlIn).useDelimiter("\\Z");
        String htmlContents = scanner.next();

        CYaHPConverter converter = new CYaHPConverter();
        try (FileOutputStream out = new FileOutputStream(pdfOut)) {
            Map properties = new HashMap();
            List headerFooterList = new ArrayList();

            properties.put(IHtmlToPdfTransformer.PDF_RENDERER_CLASS,
                    IHtmlToPdfTransformer.FLYINGSAUCER_PDF_RENDERER);
            //properties.put(IHtmlToPdfTransformer.FOP_TTF_FONT_PATH, fontPath);
            converter.convertToPdf(htmlContents,
                    IHtmlToPdfTransformer.A3L,
                    headerFooterList,
                    "file:///temp/html/",
                    out,
                    properties);
            out.flush();
        }
    }
    
    public static String getProgramPath() throws UnsupportedEncodingException {
      URL url = convoy.gui.MainMenu.class.getProtectionDomain().getCodeSource().getLocation();
      String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
      String parentPath = new File(jarPath).getParentFile().getPath();
      return parentPath;
   }
}
