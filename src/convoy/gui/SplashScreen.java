/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.gui;

//import static convoy.gui.MainMenu.mission;
import convoy.objects.Mission;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

/**
 *
 * @author Mike Moye <mtm5313@psu.edu>
 */
public class SplashScreen extends JWindow {

    private static SplashScreen ssb = SplashScreen.getInstance();
    //private static SplashScreen ssb = new SplashScreen();  
    private static MainWindow mainWindow;
    //protected static Mission mission;

    public static SplashScreen getInstance() {
        //if uniqueInstance is null, instantiate it to new Mission()
        if (ssb == null) {
            ssb = new SplashScreen();
        }

        return ssb;
    }

    public MainWindow getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(MainWindow mw) {
        mainWindow = mw;
    }

    /**
     * displays and set the attribute and properties of the main menu ssb
     */
    public void display() {
        //frame.setVisible(true);
        //frame.setLocationRelativeTo(null);
        //frame.setTitle("Convoy Quick - Convoy documentation creator to help save lives");
        //frame.setExtendedState(MainMenu.MAXIMIZED_BOTH);
        //frame.setResizable(true);
    }

    public SplashScreen() {

        initComponents();

    }

    public static void main(String args[]) {
        try {

            ssb.showSplash();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
            }
        } finally {

            ssb.dispose();
            mainWindow = new MainWindow();
            mainWindow.setVisible(true);

        }
    }

    private void initComponents() {

        javax.swing.JLabel mainMenuTitle = new javax.swing.JLabel();

        //mainMenuTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        mainMenuTitle.setText("Convoy Quick");

        //JLabel loadingBar = new JLabel();
        //loadingBar.setIcon(new ImageIcon("/convoy/resources/images/loadingBar.gif"));
        //loadingBar.setHorizontalAlignment(SwingConstants.CENTER);
        Font topSecretFont = null;
        try {
            topSecretFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/convoy/resources/fonts/topSecret.ttf"));
        } catch (FontFormatException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        topSecretFont = topSecretFont.deriveFont(Font.BOLD, 96f);
        mainMenuTitle.setHorizontalAlignment(SwingConstants.CENTER);
        mainMenuTitle.setFont(topSecretFont);

        PicturePanel picturePanel1 = new PicturePanel("/convoy/resources/images/humveeWithGun.png");

        picturePanel1.setBackground(new java.awt.Color(194, 178, 128));

        Color desertTan = new Color(0, 0, 0);
        picturePanel1.setBorder(BorderFactory.createLineBorder(desertTan, 10));
        //picturePanel1.setIconImage(new ImageIcon(getClass().getResource("/convoy/resources/images/humveeIcon.png")).getImage()); // NOI18N

        picturePanel1.add(mainMenuTitle);

        //picturePanel1.add(loadingBar);
        this.add(picturePanel1);

        pack();
    }

    public void showSplash() {

        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.WHITE);

        // Set the window's bounds, centering the window
        int width = 1000;
        int height = 775;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);

    // Build the splash screen
        //JLabel label = new JLabel(new ImageIcon("java-tip.gif"));
        //JLabel copyrt = new JLabel("Splash Screen!!!", JLabel.CENTER);
    //content.add(label, BorderLayout.CENTER);
    // Fun starts here...    
//        copyrt.setFont(new Font("Sans-Serif", Font.BOLD, 12));
//        content.add(copyrt, BorderLayout.SOUTH);
    //label.setLayout(new BorderLayout());
        //Font font = copyrt.getFont();
        //copyrt.setFont(font.deriveFont(Font.BOLD, 24f));
        //label.add(copyrt);
        Color desertTan = new Color(194, 178, 128);
        content.setBorder(BorderFactory.createLineBorder(desertTan, 10));

        // Display it
        setVisible(true);

    // Don't do this, as it will cause the EDT to be stopped.  Instead
        // setup some kind of callback that can tell when the resources are 
        // loaded and start the rest of the application from there...
        // Wait a little while, maybe while loading resources
        //try {
        //    Thread.sleep(duration);
        //} catch (Exception e) {
        //}
    //setVisible(false);
    }

    private void createSaveDirectory() {
        String path = null;
        try {
            path = getProgramPath();
        } catch (UnsupportedEncodingException ex) {
            //Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }

        String fileSeparator = System.getProperty("file.separator");
        String newDir = path + fileSeparator + "convoys" + fileSeparator;
        //JOptionPane.showMessageDialog(null, newDir);

        File file = new File(newDir);
        file.mkdir();

    }

    private void createImageDirectory() {

        String path = null;
        try {
            path = getProgramPath();
        } catch (UnsupportedEncodingException ex) {
            //Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }

        String fileSeparator = System.getProperty("file.separator");
        String newDir = path + fileSeparator + "images" + fileSeparator;
        //JOptionPane.showMessageDialog(null, newDir);

        File file = new File(newDir);
        file.mkdir();

    }

    private void createHtmlDirectory() {

        String path = null;
        try {
            path = getProgramPath();
        } catch (UnsupportedEncodingException ex) {
            //Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }

        String fileSeparator = System.getProperty("file.separator");
        String newDir = path + fileSeparator + "html" + fileSeparator;
        //JOptionPane.showMessageDialog(null, newDir);

        File file = new File(newDir);
        file.mkdir();

    }

    private void createTemplatesDirectory() {

        String path = null;
        try {
            path = getProgramPath();
        } catch (UnsupportedEncodingException ex) {
            //Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }

        String fileSeparator = System.getProperty("file.separator");
        String newDir = path + fileSeparator + "templates" + fileSeparator;
        //JOptionPane.showMessageDialog(null, newDir);

        File file = new File(newDir);
        file.mkdir();

    }

    private void createVehicleImageDirectory() {

        String path = null;
        try {
            path = getProgramPath();
        } catch (UnsupportedEncodingException ex) {
            //Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }

        String fileSeparator = System.getProperty("file.separator");
        String newDir = path + fileSeparator + "vehicleImages" + fileSeparator;
        //JOptionPane.showMessageDialog(null, newDir);

        File file = new File(newDir);
        file.mkdir();

    }

    private static void copyFile(File source, File dest) throws IOException {

        Files.copy(source.toPath(), dest.toPath());

    }

    public static void copyFolder(File src, File dest)
            throws IOException {

        if (src.isDirectory()) {

            //if directory not exists, create it
            if (!dest.exists()) {
                dest.mkdir();
                System.out.println("Directory copied from "
                        + src + "  to " + dest);
            }

            //list all the directory contents
            String files[] = src.list();

            for (String file : files) {
                //construct the src and dest file structure
                File srcFile = new File(src, file);
                File destFile = new File(dest, file);
                //recursive copy
                copyFolder(srcFile, destFile);
            }

        } else {
    		//if file, then copy it
            //Use bytes stream to support all file types
            InputStream in = new FileInputStream(src);
            OutputStream out = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];

            int length;
            //copy the file content in bytes 
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            in.close();
            out.close();
            System.out.println("File copied from " + src + " to " + dest);
        }
    }

    private void copyTemplates() throws IOException {

         //URL url = convoy.gui.MainMenu.class.getProtectionDomain().getClassLoader().getResource("/resources/images/vehicles");
        //String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
        //String parentPath = new File(jarPath).getParentFile().getPath();
          //System.out.print();
        //JOptionPane.showConfirmDialog(this, parentPath);
        try {
            copyFolder(new File(getClass().getResource("/convoy/resources/images/vehicles").getPath().substring(1).replace("%20", " ")), new File(getProgramPath() + "\\vehicleImages"));
            copyFolder(new File(getClass().getResource("/convoy/resources/templates").getPath().substring(1).replace("%20", " ")), new File(getProgramPath() + "\\templates"));

            //System.out.print(getClass().getResource("/convoy/resources/images/vehicles").getPath().substring(1).replace("%20", " "));
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this, ex);
        }

        //try {
        //copyFile(new File(getClass().getResource("/convoy/resources/images/humvee.jpg").getFile()), new File(getProgramPath() ));
        //} catch (UnsupportedEncodingException ex) {
        //Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }

    public static String getProgramPath() throws UnsupportedEncodingException {
        URL url = convoy.gui.SplashScreen.class.getProtectionDomain().getCodeSource().getLocation();
        String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
        String parentPath = new File(jarPath).getParentFile().getPath();
        return parentPath;
    }

}
