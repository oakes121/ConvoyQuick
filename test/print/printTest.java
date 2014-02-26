/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package print;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author mtm5313
 */
public class printTest {
    
    public static void main(String args[]) throws PrinterException{
        
        try{
        //Doc document = new Doc();
        //File document = new File("src\\pdf\\convoy.pdf");
        
        PrinterJob printJob = PrinterJob.getPrinterJob();
        PrintService service = PrintServiceLookup.lookupDefaultPrintService(); 
        printJob.setPrintService(service); 
        System.out.print("file:\\\\" + "\\\\samba.cac.psu.edu\\mtm5313\\Desktop\\wsdl.txt");
        printJob.setJobName("file:\\\\" + "\\\\samba.cac.psu.edu\\mtm5313\\Desktop\\wsdl.txt");
        boolean doPrint = printJob.printDialog();
        printJob.print();
        
        //document.silentPrint(printJob);
        }catch(Exception ex){
            
        }
        
        
    }
    
}
