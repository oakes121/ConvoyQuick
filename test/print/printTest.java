/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package print;

import java.awt.Desktop;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author mtm5313
 */
public class printTest {
    
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
