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
     * Saves convoy into a file
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
            saveData += mission.getLeftAdditionalInfo() + ",";
            saveData += mission.getRightAdditionalInfo() + ",";
            saveData += mission.getAdditionalInfo() + ",";
            saveData += mission.getUnitPatch();

            byte[] dataToWrite = saveData.getBytes("UTF8");
            //String str = new String(dataToWrite, "UTF8");
            //System.out.print(str);
            try (FileOutputStream out = new FileOutputStream(file)) {
                out.write(dataToWrite);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Mission failed to save, please try again.");
        }
    }
}
