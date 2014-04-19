package convoy.loadsave;

import convoy.gui.MainMenu;
import convoy.gui.MainWindow;
import convoy.gui.VehiclePanel;
import convoy.objects.Mission;
import convoy.objects.Vehicle;
import java.awt.Cursor;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private MainWindow mainWindow = null;
    private Mission mission = null;
    private String missionNumber = null;
    private int option;
    private boolean isLoaded = false;

    /**
     * loadProject() loads a file that with the file extension ".conx"
     *
     * @throws java.io.UnsupportedEncodingException
     */
    
    public void loadProject() {
        try {
            JFileChooser chooser = new JFileChooser(getProgramPath() + "\\conx\\saves\\");
            chooser.setAcceptAllFileFilterUsed(false);
            chooser.addChoosableFileFilter((new FileNameExtensionFilter("Convoy Quick Files", "conx")));
            chooser.setSelectedFile(new File("*.conx"));
            //chooser.setCurrentDirectory(new File(getPath()));

            option = chooser.showOpenDialog(null);
            if (option == JFileChooser.APPROVE_OPTION) {
                
                FileInputStream fileIn = new FileInputStream(chooser.getSelectedFile().getPath());
                ObjectInputStream in = new ObjectInputStream(fileIn);
                mission = (Mission) in.readObject();
                in.close();
                fileIn.close();

                missionNumber = mission.getMissionNumber();
                mainWindow = new MainWindow(missionNumber,
                        mission.getClassification(),
                        mission.getMissionstagingArea(),
                        mission.getACC(),
                        mission.getCC(),
                        mission.getFromLinkUpDate(),
                        mission.getFromSPDate(),
                        mission.getLeftFrom(),
                        mission.getLeftTo(),
                        mission.getToLinkUpDate(),
                        mission.getToSPDate(),
                        mission.getFromLinkUpTime(),
                        mission.getFromSPTime(),
                        mission.getToLinkUpTime(),
                        mission.getToSTime(),
                        mission.getFromSPTimeZone(),
                        mission.getFromSPTimeZone(),
                        mission.getToLinkUpTimeZone(),
                        mission.getToSPTimeZone(),
                        mission.getLeftAdditionalInfo(),
                        mission.getRightAdditionalInfo(),
                        mission.getAdditionalInfo(),
                        mission.getUnitPatch());

                mainMenu.setMainWindow(mainWindow);
                mainMenu.getMainWindow().display();
                loadVehicles();

            if (mainWindow != null) {
                isLoaded = true;
            }
            }
        } catch (HeadlessException | IOException | ClassNotFoundException ex) {
            Logger.getLogger(Load.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "There was an error while loading convoy.");
        }
    }

    public int getOption() {
        return option;
    }

    public boolean getIsLoaded() {
        return isLoaded;
    }

    /**
     * loadProject() loads a file that with the file extension "_vehicles.conx"
     */
    public void loadVehicles() {

        ArrayList<ArrayList<Vehicle>> vehicleGridsVehicles = new ArrayList<>();

        try {
            FileInputStream fileIn = new FileInputStream(getProgramPath() + "\\conx\\saves\\" + missionNumber + "_vehicles.conv");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            vehicleGridsVehicles = (ArrayList<ArrayList<Vehicle>>) in.readObject();
            in.close();
            fileIn.close();

            for (int i = 0; i < vehicleGridsVehicles.size(); i++) {

                if (i > 0) {
                    mainMenu.getMainWindow().newVehicleGrid();
                }

                for (int j = 0; j < vehicleGridsVehicles.get(i).size(); j++) {
                    //JOptionPane.showMessageDialog(mainMenu, vehicleGridsVehicles.get(0).get(1).getDriverName() + " ");
                    VehiclePanel vp = new VehiclePanel();
                    vp.batchVehicleSet(vehicleGridsVehicles.get(i).get(j));
                    mainMenu.getMainWindow().getVehicleGrids().get(i).replaceAddNewVehiclePanel(vp);
                    mainMenu.getMainWindow().getVehicleGrids().get(i).setMainWindow(mainMenu.getMainWindow());

                }
            }

            mainMenu.getMainWindow().showFirstVehicleGrid();

        } catch (Exception exc) {
            exc.printStackTrace(); // If there was an error, print the info.
            //JOptionPane.showMessageDialog(mainMenu, "You messed up");
        }

    }

    public static String getProgramPath() throws UnsupportedEncodingException {
        URL url = convoy.gui.MainMenu.class.getProtectionDomain().getCodeSource().getLocation();
        String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
        String parentPath = new File(jarPath).getParentFile().getPath();
        return parentPath;
    }

}
