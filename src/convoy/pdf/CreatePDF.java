/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.pdf;

/**
 *
 * @author Mike Moye
 * 
 */

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


import org.allcolor.yahp.converter.CYaHPConverter;
import org.allcolor.yahp.converter.IHtmlToPdfTransformer;

public class CreatePDF {
    
    public static void main(String args[]) throws Exception {       
        
    String root = "src\\convoy\\resources\\html";
    String input = "convoy.htm";  // need to be charset utf-8
    String output = "src\\pdf\\" + input.replace(".htm","");
    htmlToPdfFile(new File(root, input),
                  new File(output + ".pdf"));
    //System.out.println("Done");
  }
    
    public  void createPDF() throws Exception {       
        
    String root = "src\\convoy\\resources\\html";
    String input = "convoy.htm";  // need to be charset utf-8
    String output = "src\\pdf\\" + input.replace(".htm","");
    htmlToPdfFile(new File(root, input),
                  new File(output + ".pdf"));
    //System.out.println("Done");
    
    open(new File(output + ".pdf"));
    
    
  }
    
    public  void createPDFPrint() throws Exception {       
        
    String root = "src\\convoy\\resources\\html";
    String input = "convoy.htm";  // need to be charset utf-8
    String output = "src\\pdf\\" + input.replace(".htm","");
    htmlToPdfFile(new File(root, input),
                  new File(output + ".pdf"));
    //System.out.println("Done");
    
    //open(new File(output + ".pdf"));
    
    
  }
    
    public static void open(File document) {
        
        try{
            Desktop dt = Desktop.getDesktop();
            dt.open(document);
        }catch(IOException ex){
            
        }
}
    
    

  public static void htmlToPdfFile(File htmlIn, File pdfOut) throws Exception {
    Scanner scanner =
       new Scanner(htmlIn).useDelimiter("\\Z");
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
}
