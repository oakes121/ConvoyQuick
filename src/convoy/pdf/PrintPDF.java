/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convoy.pdf;

import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

/**
 *
 * @author mtm5313
 */
public class PrintPDF {
    
    public void print(){
    
        try{
            
        File document = new File("src\\pdf\\convoy.pdf");
        
        System.out.print(document.getName());
            
        Desktop.getDesktop().print(document);
        }catch(IOException ex){
            
        }
    
    }
    
    public static void main(String args[]) throws PrinterException{
        
        try{
            
        File document = new File("src\\pdf\\convoy.pdf");
        
        System.out.print(document.getName());
            
        Desktop.getDesktop().print(document);
        }catch(IOException ex){
            
        }
        
        
    }
}