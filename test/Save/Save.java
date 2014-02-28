/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Save;

import convoy.objects.Mission;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author dizoo548
 */
public class Save { 
    
    private File file;
    private static File saveFile;
    private static String name;
    private String fileName;
    
    public Save(String fileName, Mission mission){
        
        this.fileName = fileName;
        
    }
    
    public void save(){
        
        try{
            file = new File("src/convoy/save/" + fileName + ".conx");
        }catch(Exception ex){
            
        }finally{
        
        
        //String text = "Hello world";
        try {
            
            String test = "testByteString";
            
            byte[] dataToWrite = test.getBytes("UTF32");
            
            String str = new String(dataToWrite, "UTF32");
            
            System.out.print(str);
            
            try (FileOutputStream out = new FileOutputStream(file)) {
                out.write(dataToWrite);
            }
            
            
            
        } catch ( IOException e ) {
           e.printStackTrace();
        }
        }
        
    }
    
    public static void main(String args[]) throws IOException{
        
        name = "save";
                
        try{
            File saveFile = new File("src/convoy/save/" + name + ".conx");
        }catch(Exception ex){
            
        }finally{
        
        
        //String text = "Hello world";
        try {
            
            String test = "testByteString";
            
            byte[] dataToWrite = test.getBytes("UTF32");
            
            String str = new String(dataToWrite, "UTF32");
            
            System.out.print(str);
            
            try (FileOutputStream out = new FileOutputStream(saveFile)) {
                out.write(dataToWrite);
            }
            
            
            
        } catch ( IOException e ) {
           e.printStackTrace();
        }
        }
         
    }    
    
}
