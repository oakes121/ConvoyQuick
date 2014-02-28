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
import javax.swing.JOptionPane;

/**
 *
 * @author dizoo548
 */
public class Save {
  
  private File file;
  private Mission mission;
    
    public Save(Mission mission){
        this.mission = mission;
        
    }
    
    public void save(){
                        
            file = new File("src/convoy/save/" + mission.getMissionNumber() + ".conx");
        
        
        //String text = "Hello world";
        try {
            
            String saveData = "missionNumber, classification, stagingArea, acc, cc, FromLinkUpTime, FromSPTime, LeftFrom, RightFrom, LeftTo, RightTo, ToLinkUpTime";
            
            saveData += mission.getMissionNumber() + ",";
            saveData += mission.getClassification() + ",";
            saveData += mission.getMissionstagingArea() + ",";
            saveData += mission.getACC() + ",";
            saveData += mission.getCC() + ",";
            saveData += mission.getFromLinkUpTime() + ",";
            saveData += mission.getFromSPTime() + ",";
            saveData += mission.getLeftFrom() + ",";
            saveData += mission.getRightFrom() + ",";
            saveData += mission.getLeftTo() + ",";
            saveData += mission.getRightTo() + ",";
            saveData += mission.getToLinkUpTime() + ",";
            saveData += mission.getToSPTime();
            
            
            byte[] dataToWrite = saveData.getBytes("UTF32");
            
            String str = new String(dataToWrite, "UTF32");
            
            System.out.print(str);
            
            try (FileOutputStream out = new FileOutputStream(file)) {
                out.write(dataToWrite);
            }
            
            
            
        } catch ( IOException e ) {
           JOptionPane.showMessageDialog(null, "Mission failed to save, please try again.");
        }
        
        
    } 
    
}
