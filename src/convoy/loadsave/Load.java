package convoy.loadsave;

import convoy.gui.MainMenu;
import convoy.gui.MainWindow;
import convoy.gui.VehiclePanel;
import static convoy.loadsave.Save.getProgramPath;
import convoy.objects.Vehicle;
import java.awt.Cursor;
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
import javax.swing.JFileChooser;
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
    String missionNumber = null;
    private int option;
    private boolean isLoaded = false;

    /**
     * loadProject() loads a file that with the file extension ".conx"
     */
    public void loadProject() throws UnsupportedEncodingException {

        String classification = null;
        String stagingArea = null;
        String acc = null;
        String cc = null;
        Date fromLinkUpTime = null;
        Date fromSPTime = null;
        String leftFrom = null;
        //String rightFrom = null;
        String leftTo = null;
        //String rightTo = null;
        Date toLinkUpTime = null;
        Date toSPTime = null;
        String leftAdditionalText = null;
        String rightAdditionalText = null;
        String additionalText = null;
        String unitPatch = null;

        JFileChooser chooser = new JFileChooser(getProgramPath() + "\\conx\\saves\\");
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.addChoosableFileFilter((new FileNameExtensionFilter("Convoy Quick Files", "conx")));
        chooser.setSelectedFile(new File("*.conx"));
        //chooser.setCurrentDirectory(new File(getPath()));

        option = chooser.showOpenDialog(null);
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
                    if(classification != null){
                    classification = missionText[1];
                    }else{classification = " ";}
                    stagingArea = missionText[2];
                    acc = missionText[3];
                    cc = missionText[4];
                    //fromLinkUpTime = missionText[5];
                    //fromSPTime = missionText[6];
                    leftFrom = missionText[7];
                    //rightFrom = missionText[8];
                    leftTo = missionText[8];
                    //rightTo = missionText[10];
                    //toLinkUpTime = missionText[9];
                    //toSPTime = missionText[10];
                    leftAdditionalText = missionText[11].replaceAll("'t'", "\t").replaceAll("'r'", "\r").replaceAll("'n'", "\n");
                    rightAdditionalText = missionText[12].replaceAll("'t'", "\t").replaceAll("'r'", "\r").replaceAll("'n'", "\n");
                    additionalText = missionText[13].replaceAll("'t'", "\t").replaceAll("'r'", "\r").replaceAll("'n'", "\n");
                    unitPatch = missionText[14];

                }

                //mainWindow.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                mainWindow = new MainWindow(missionNumber,
                        classification,
                        stagingArea,
                        acc,
                        cc,
                        fromLinkUpTime,
                        fromSPTime,
                        leftFrom,
                        //rightFrom,
                        leftTo,
                        //rightTo,
                        toLinkUpTime,
                        toSPTime,
                        leftAdditionalText,
                        rightAdditionalText,
                        additionalText,
                        unitPatch);

                mainMenu.setMainWindow(mainWindow);
                mainMenu.getMainWindow().display();

                //JOptionPane.showMessageDialog(mainWindow, unitPatch);
                loadVehicles();

                if (mainWindow != null) {
                    isLoaded = true;
                }

            } catch (IOException ex) {
            } finally { //mainWindow.setCursor(Cursor.getDefaultCursor());
            }
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
