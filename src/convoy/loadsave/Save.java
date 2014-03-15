/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.loadsave;

import convoy.gui.MainMenu;
import convoy.objects.Mission;
import convoy.objects.Vehicle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * @author Mike Moye <mtm5313@psu.edu>
 * @version 1.0
 * @since 2014-02-27
 *
 * <p>
 * This class is used to save the convoy. Tt grabs the convoy attributes then
 * converts them to byte code and stores them.
 * </p>
 */
public class Save {

    private File file;
    private final Mission mission;
    private MainMenu mainMenu = MainMenu.getInstance();
    private ArrayList<ArrayList<Vehicle>> mainWindowVehicles = new ArrayList<>();;

    /**
     * Constructor that grabs the mission obj from the convoy and save the
     * information in a file.
     *
     * @param mission mission to be saved
     */
    public Save(Mission mission) {
        this.mission = mission;
    }

    /**
     * <p>
     * save() Saves convoy into a file named after the mission number with the extension ".conx"
     * <p>
     */
    public void save() {
        if (mission.getMissionNumber().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please enter the mission number.");
        } else {
            file = new File("src/convoy/convoy/" + mission.getMissionNumber() + ".conx");
        }
        try {
            String saveData = mission.getMissionNumber() + ",";
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
            saveData += mission.getToSPTime() + ",";
            saveData += mission.getLeftAdditionalInfo().replaceAll("\\t", "'t'").replaceAll("\\r", "'r'").replaceAll("\\n", "'n'") + ",";
            saveData += mission.getRightAdditionalInfo().replaceAll("\\t", "'t'").replaceAll("\\r", "'r'").replaceAll("\\n", "'n'") + ",";
            saveData += mission.getAdditionalInfo().replaceAll("\\t", "'t'").replaceAll("\\r", "'r'").replaceAll("\\n", "'n'") + ",";
            saveData += "file:\\" + mission.getUnitPatch();

            byte[] dataToWrite = saveData.getBytes("UTF8");
            //String str = new String(dataToWrite, "UTF8");
            //System.out.print(str);
            try (FileOutputStream out = new FileOutputStream(file)) {
                out.write(dataToWrite);
            }
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Mission failed to save, please try again.");
        }
        
        saveVehicles();
    }
    
    /**
     * saveVehicles() Saves vehicles within the convoy into a file named after the mission number with 
     *  the extension "_vehicles.conx"
     */
    public void saveVehicles() {
        
        for (int i = 0; i < mainMenu.getMainWindows().size(); i++){
            mainWindowVehicles.add(new ArrayList<Vehicle>());
            
            for (int j = 0; j < mainMenu.getMainWindows().get(i).getVehicleGrid().getVehiclePanelArray().size(); j++){
                
                Vehicle v = new Vehicle();
                
                mainMenu.getMainWindows().get(i).getVehicleGrid().getVehiclePanelArray().get(j).batchVehicleGet(v);
                
                mainWindowVehicles.get(i).add(v);
                
                //JOptionPane.showMessageDialog(mainMenu, mainWindowVehicles.get(i).get(j).getDriverName() + " ");
            }
        }  
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("src/convoy/convoy/" + mission.getMissionNumber() +  "_vehicles.conx");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(mainWindowVehicles);
            out.close();
            fileOut.close();
        } catch (IOException e) {}
        
    }
}
