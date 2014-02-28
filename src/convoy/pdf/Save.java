/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convoy.pdf;

import convoy.objects.Mission;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author dizoo548
 */
public class Save {
  
  private File file;
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
    
}
