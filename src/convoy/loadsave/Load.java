package convoy.loadsave;

import convoy.gui.MainMenu;
import convoy.gui.MainWindow;
import convoy.gui.VehiclePanel;
import convoy.objects.Vehicle;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author Oakes Isaac <oki5001@psu.edu>
 * @version 1.0
 * @since 2014-03-14
 *
 * <p>
 * This class is used to load the convoy. 
 * </p>
 */
public class Load {
    
    private MainMenu mainMenu = MainMenu.getInstance();
    String missionNumber = null;
    
    
    /**
     * loadProject() loads a file that with the file extension ".conx"
     */
    public void loadProject() {
        
        
        String classification = null;
        String stagingArea = null;
        String acc = null;
        String cc = null;
        String fromLinkUpTime = null;
        String fromSPTime = null;
        String leftFrom = null;
        String rightFrom = null;
        String leftTo = null;
        String rightTo = null;
        String toLinkUpTime = null;
        String toSPTime = null;
        String leftAdditionalText = null;
        String rightAdditionalText = null;
        String additionalText = null;
        String unitPatch = null;

        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter((new FileNameExtensionFilter("Convoy Quick Files", "conx")));
        chooser.setSelectedFile(new File("*.conx"));
        chooser.setCurrentDirectory(new File("src/convoy/convoy"));

        int option = chooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedReader br;
                File file = chooser.getSelectedFile();
                String line;
                String cvsSplitBy = ",";

                br = new BufferedReader(new FileReader(file));
                while ((line = br.readLine()) != null) {
                    // use comma as separator
                    String[] missionText = line.split(cvsSplitBy);

                    missionNumber = missionText[0];
                    classification = missionText[1];
                    stagingArea = missionText[2];
                    acc = missionText[3];
                    cc = missionText[4];
                    fromLinkUpTime = missionText[5];
                    fromSPTime = missionText[6];
                    leftFrom = missionText[7];
                    rightFrom = missionText[8];
                    leftTo = missionText[9];
                    rightTo = missionText[10];
                    toLinkUpTime = missionText[11];
                    toSPTime = missionText[12];
                    leftAdditionalText = missionText[13].replaceAll("'t'", "\t").replaceAll("'r'", "\r").replaceAll("'n'", "\n");
                    rightAdditionalText = missionText[14].replaceAll("'t'", "\t").replaceAll("'r'", "\r").replaceAll("'n'", "\n");
                    additionalText = missionText[15].replaceAll("'t'", "\t").replaceAll("'r'", "\r").replaceAll("'n'", "\n");
                    unitPatch = missionText[16];
                }
                
                //this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

                // clears arraylist of MainWindows
                if (mainMenu.getMainWindows().size() != 0) {
                    mainMenu.clearMainWindows();
                }
                
                mainMenu.getMainWindows().add(new MainWindow(missionNumber,
                        classification,
                        stagingArea,
                        acc,
                        cc,
                        fromLinkUpTime,
                        fromSPTime,
                        leftFrom,
                        rightFrom,
                        leftTo,
                        rightTo,
                        toLinkUpTime,
                        toSPTime,
                        leftAdditionalText,
                        rightAdditionalText,
                        additionalText,
                        unitPatch));
                mainMenu.getMainWindows().get(0).display();   
                
                loadVehicles();
                
                
               

            } catch (IOException ex) {} finally { /*this.setCursor(Cursor.getDefaultCursor());*/ }
        }
    }
   
    /**
     * loadProject() loads a file that with the file extension "_vehicles.conx"
     */
    public void loadVehicles() {      
        
        ArrayList<ArrayList<Vehicle>> mainWindowVehicles = new ArrayList<>();
        
        try{            
            FileInputStream fileIn = new FileInputStream("src/convoy/convoy/" + missionNumber +  "_vehicles.conx");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            mainWindowVehicles = (ArrayList<ArrayList<Vehicle>>) in.readObject();
            in.close();
            fileIn.close();
            
            
            
            for (int i = 0; i < mainWindowVehicles.size(); i++) {
                
                if (i > 0) 
                    mainMenu.newMainWindow(false);
                
                mainMenu.getMainWindows().get(i).getVehicleGrid().setMainWindow(mainMenu.getMainWindows().get(i));
                
                for (int j = 0; j < mainWindowVehicles.get(i).size(); j++) {
                    //JOptionPane.showMessageDialog(mainMenu, mainWindowVehicles.get(0).get(1).getDriverName() + " ");
                    VehiclePanel vp = new VehiclePanel();
                    vp.batchVehicleSet(mainWindowVehicles.get(i).get(j));
                    mainMenu.getMainWindows().get(i).getVehicleGrid().replaceAddNewVehiclePanel(vp);
                }
            }
            
            mainMenu.setCurrentMainWindow(0);
            mainMenu.getMainWindows().get(0).display();
            
        }
        catch(Exception exc){
            exc.printStackTrace(); // If there was an error, print the info.
            JOptionPane.showMessageDialog(mainMenu, "You messed up");
        }
        
    }
    
}
