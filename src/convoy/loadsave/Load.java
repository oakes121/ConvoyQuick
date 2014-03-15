package convoy.loadsave;

import convoy.gui.MainMenu;
import convoy.gui.MainWindow;
import java.awt.Cursor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Oakes
 */
public class Load {
    
    public MainMenu mainMenu = MainMenu.getInstance();
    
    public Load() {
        
    }
    
    public void loadProject() {
        
        String missionNumber = null;
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
                    for (int i = 0; i < mainMenu.getMainWindows().size(); i++) {
                        mainMenu.getMainWindows().get(i).setVisible(false);
                    }                    
                    mainMenu.getMainWindows().clear();
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
               

            } catch (IOException ex) {
            } finally {
                //this.setCursor(Cursor.getDefaultCursor());
            }
        }
    }
    
}
