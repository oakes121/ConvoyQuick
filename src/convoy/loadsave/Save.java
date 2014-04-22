/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.loadsave;

import convoy.gui.SplashScreen;
import convoy.objects.Mission;
import convoy.objects.Vehicle;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private SplashScreen mainMenu = SplashScreen.getInstance();
    private ArrayList<ArrayList<Vehicle>> vehicleGridsVehicles = new ArrayList<>();

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
     * save() Saves convoy into a file named after the mission number with the
     * extension ".conx"
     * <p>
     * @throws java.lang.Exception
     */
    /*
     public void save() throws Exception{
        
     if (mission.getMissionNumber().equalsIgnoreCase("")) {
     JOptionPane.showMessageDialog(null, "Please enter the mission number.");
     } else {
     file = new File(getProgramPath() + "\\conx\\saves\\" + mission.getMissionNumber() + ".conx");
     }
     try {
     String saveData = mission.getMissionNumber() + ",";
     saveData += mission.getClassification() + ",";
     saveData += mission.getMissionstagingArea() + ",";
     saveData += mission.getACC() + ",";
     saveData += mission.getCC() + ",";
     saveData += mission.getFromLinkUpDate() + ",";
     saveData += mission.getFromSPDate() + ",";
     saveData += mission.getLeftFrom() + ",";
     //saveData += mission.getRightFrom() + ",";
     saveData += mission.getLeftTo() + ",";
     //saveData += mission.getRightTo() + ",";
     saveData += mission.getToLinkUpDate() + ",";
     saveData += mission.getToSPDate() + ",";
     saveData += mission.getLeftAdditionalInfo().replaceAll("\\t", "'t'").replaceAll("\\r", "'r'").replaceAll("\\n", "'n'") + ",";
     saveData += mission.getRightAdditionalInfo().replaceAll("\\t", "'t'").replaceAll("\\r", "'r'").replaceAll("\\n", "'n'") + ",";
     saveData += mission.getAdditionalInfo().replaceAll("\\t", "'t'").replaceAll("\\r", "'r'").replaceAll("\\n", "'n'") + ",";
     saveData += mission.getUnitPatch();
            
     //JOptionPane.showMessageDialog(mainMenu, mission.getUnitPatch());

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
        
     JOptionPane.showMessageDialog(null, "Mission saved successfully.");
     }
    
     */
    public void save() {

        if (mission.getMissionNumber().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Please enter the mission number.");
        } else {
            try {

                FileOutputStream fileOut;
                fileOut = new FileOutputStream(getProgramPath() + "\\conx\\saves\\" + mission.getMissionNumber() + ".conx");
                try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                    out.writeObject(mission);
                }
                fileOut.close();
            } catch (IOException e) {

            } finally {
                saveVehicles();

                JOptionPane.showMessageDialog(null, "Mission saved successfully.");
            }

        }
    }

    /**
     * saveVehicles() Saves vehicles within the convoy into a file named after
     * the mission number with the extension "_vehicles.conx"
     */
    public void saveVehicles()  {

        File f;
        try {
            f = new File(getProgramPath() + "\\conx\\saves\\" + mission.getMissionNumber() + "_vehicles.conv");
            if(f.exists()) {                
                f.delete();
                JOptionPane.showMessageDialog(mainMenu, "deleted");
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        for (int i = 0; i < mainMenu.getMainWindow().getVehicleGrids().size(); i++) {
            //JOptionPane.showMessageDialog(mainMenu, "Saved page " + i);
            vehicleGridsVehicles.add(new ArrayList<Vehicle>());

            for (int j = 0; j < mainMenu.getMainWindow().getVehicleGrids().get(i).getVehiclePanelArray().size(); j++) {

                Vehicle v = new Vehicle();
                int selection1 = mainMenu.getMainWindow().getVehicleGrids().get(i).getAddVehiclePopUpArray().get(j).getSelection1();
                int selection2 = mainMenu.getMainWindow().getVehicleGrids().get(i).getAddVehiclePopUpArray().get(j).getSelection2();
                int selection3 = mainMenu.getMainWindow().getVehicleGrids().get(i).getAddVehiclePopUpArray().get(j).getSelection3();
                
                JOptionPane.showMessageDialog(mainMenu, selection1 + " " + selection2 + " " + selection3 );

                
                v.setSelections(selection1, selection2, selection3);
                //JOptionPane.showMessageDialog(mainMenu, mainMenu.getMainWindow().getVehicleGrids().get(i).getVehiclePanelArray().get(j).getDriverName());
                mainMenu.getMainWindow().getVehicleGrids().get(i).getVehiclePanelArray().get(j).batchVehicleGet(v);
                
                

                vehicleGridsVehicles.get(i).add(v);

                //JOptionPane.showMessageDialog(mainMenu, vehicleGridsVehicles.get(i).get(j).getDriverName() + " ");
            }
        }
        try {

            FileOutputStream fileOut;
            fileOut = new FileOutputStream(getProgramPath() + "\\conx\\saves\\" + mission.getMissionNumber() + "_vehicles.conv");
            
            try (ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                out.writeObject(vehicleGridsVehicles);
            }
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String getProgramPath() throws UnsupportedEncodingException {
        URL url = convoy.gui.MainMenu.class.getProtectionDomain().getCodeSource().getLocation();
        String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
        String parentPath = new File(jarPath).getParentFile().getPath();
        return parentPath;
    }

}
