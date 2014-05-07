/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.UIManager;

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

        try {
             UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         }catch(Exception ex) {
             ex.printStackTrace();
         }
        
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

            ssb.setVisible(false);
            mainWindow = new MainWindow();
            mainWindow.setVisible(true);

        }
    }

    @SuppressWarnings("empty-statement")
    private void initComponents() {;
        Font topSecretFont = null;
        try {
            topSecretFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/convoy/resources/fonts/topSecret.ttf"));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(SplashScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        topSecretFont = topSecretFont.deriveFont(Font.BOLD, 96f);
        
        PicturePanel picturePanel1 = new PicturePanel("/convoy/resources/images/Splash Screen 01 NO LOADING BAR.png");

        picturePanel1.setBackground(new java.awt.Color(194, 178, 128));

        picturePanel1.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        
        this.add(picturePanel1);

        pack();
    }

    public void showSplash() {

        JPanel content = (JPanel) getContentPane();
        content.setBackground(Color.WHITE);

        // Set the window's bounds, centering the window
        int width = 517;
        int height = 370;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width - width) / 2;
        int y = (screen.height - height) / 2;
        setBounds(x, y, width, height);
        
        setVisible(true);
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
            OutputStream out;
            try ( //if file, then copy it
            //Use bytes stream to support all file types
                    InputStream in = new FileInputStream(src)) {
                out = new FileOutputStream(dest);
                byte[] buffer = new byte[1024];
                int length;
                //copy the file content in bytes
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
            }
            out.close();
            System.out.println("File copied from " + src + " to " + dest);
        }
    }

    public static String getProgramPath() throws UnsupportedEncodingException {
        URL url = convoy.gui.SplashScreen.class.getProtectionDomain().getCodeSource().getLocation();
        String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
        String parentPath = new File(jarPath).getParentFile().getPath();
        return parentPath;
    }

}
