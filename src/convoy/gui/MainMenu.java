package convoy.gui;

import convoy.loadsave.Load;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import convoy.objects.Mission;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Mike Moye <mtm5313@psu.edu> / Oakes Isaac <oki5001@psu.edu>
 * @version 1.0
 * @since 2014-03-15
 *
 * <p>
 * This class is to create the Main Menu.
 * </p>
 */
public class MainMenu extends javax.swing.JFrame {

    private static  MainMenu frame = MainMenu.getInstance();
    private static MainWindow mainWindow;
    protected static Mission mission;
    private BufferedImage image;

    /**
     * Creates new form MainMenu
     */
    private MainMenu() {
        /*
        createSaveDirectory();
        createImageDirectory();
        createHtmlDirectory();
        createTemplatesDirectory();
        createVehicleImageDirectory();
        try {
            copyTemplates();
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        mission = Mission.getInstance();
        initComponents();
        doMainMenuFont();
        setMainMenuButtonColor();
        setMainMenuButtonColor();
        repaint();
        revalidate();
        newProjectPanel.requestFocus();
        */
    }
    
    public static MainMenu getInstance() {
        // if uniqueInstance is null, instantiate it to new Mission()
        if (frame == null) {
            frame = new MainMenu();
        }        
        
        return frame;
    }    
    
    public MainWindow getMainWindow() {
        return mainWindow;
    }
    
    public void setMainWindow(MainWindow mw) {
        mainWindow = mw;
    }
    
    /**
     * displays and set the attribute and properties of the main menu frame
     */
    public void display() {
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        //frame.setTitle("Convoy Quick - Convoy documentation creator to help save lives");
        //frame.setExtendedState(MainMenu.MAXIMIZED_BOTH);
        //frame.setResizable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        picturePanel1 = new convoy.gui.PicturePanel("/convoy/resources/images/humveeWithGun.jpg");
        newProjectPanel = new javax.swing.JPanel();
        newProjectLabel = new javax.swing.JLabel();
        mainMenuTitle = new javax.swing.JLabel();
        templateProjectPanel = new javax.swing.JPanel();
        templateLabel = new javax.swing.JLabel();
        loadProjectPanel = new javax.swing.JPanel();
        loadProjectLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new ImageIcon(getClass().getResource("/convoy/resources/images/humveeIcon.png")).getImage());
        setMinimumSize(new java.awt.Dimension(1459, 829));
        setName("mainWindow"); // NOI18N

        picturePanel1.setBackground(new java.awt.Color(255, 255, 255));

        newProjectPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        newProjectPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        newProjectPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newProjectPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newProjectPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                newProjectPanelMousePressed(evt);
            }
        });

        newProjectLabel.setText("New Convoy");

        javax.swing.GroupLayout newProjectPanelLayout = new javax.swing.GroupLayout(newProjectPanel);
        newProjectPanel.setLayout(newProjectPanelLayout);
        newProjectPanelLayout.setHorizontalGroup(
            newProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, newProjectPanelLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(newProjectLabel)
                .addGap(20, 20, 20))
        );
        newProjectPanelLayout.setVerticalGroup(
            newProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(newProjectPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(newProjectLabel)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        mainMenuTitle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        mainMenuTitle.setText("Convoy Quick");

        templateProjectPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        templateProjectPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        templateProjectPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                templateProjectPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                templateProjectPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                templateProjectPanelMousePressed(evt);
            }
        });

        templateLabel.setText("Templates");

        javax.swing.GroupLayout templateProjectPanelLayout = new javax.swing.GroupLayout(templateProjectPanel);
        templateProjectPanel.setLayout(templateProjectPanelLayout);
        templateProjectPanelLayout.setHorizontalGroup(
            templateProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(templateProjectPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(templateLabel)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        templateProjectPanelLayout.setVerticalGroup(
            templateProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(templateProjectPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(templateLabel)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        loadProjectPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));
        loadProjectPanel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        loadProjectPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loadProjectPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loadProjectPanelMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                loadProjectPanelMousePressed(evt);
            }
        });

        loadProjectLabel.setText("Load Convoy");

        javax.swing.GroupLayout loadProjectPanelLayout = new javax.swing.GroupLayout(loadProjectPanel);
        loadProjectPanel.setLayout(loadProjectPanelLayout);
        loadProjectPanelLayout.setHorizontalGroup(
            loadProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadProjectPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(loadProjectLabel)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        loadProjectPanelLayout.setVerticalGroup(
            loadProjectPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loadProjectPanelLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(loadProjectLabel)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout picturePanel1Layout = new javax.swing.GroupLayout(picturePanel1);
        picturePanel1.setLayout(picturePanel1Layout);
        picturePanel1Layout.setHorizontalGroup(
            picturePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picturePanel1Layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(newProjectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addComponent(templateProjectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
                .addComponent(loadProjectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(300, 300, 300))
            .addGroup(picturePanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainMenuTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        picturePanel1Layout.setVerticalGroup(
            picturePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picturePanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(mainMenuTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 617, Short.MAX_VALUE)
                .addGroup(picturePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newProjectPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(templateProjectPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loadProjectPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picturePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picturePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Button animation when the mouse is over the new button
     *
     * @param evt mouse over
     */
    private void newProjectPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProjectPanelMouseEntered
        //newProjectPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
    }//GEN-LAST:event_newProjectPanelMouseEntered

    /**
     * Button animation when the mouse is over the loadProject button
     *
     * @param evt mouse over
     */
    private void templateProjectPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_templateProjectPanelMouseEntered
        //loadProjectPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
    }//GEN-LAST:event_templateProjectPanelMouseEntered

    /**
     * Button animation when the mouse is out of the loadProject button
     *
     * @param evt mouse out
     */
    private void templateProjectPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_templateProjectPanelMouseExited
        //loadProjectPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
    }//GEN-LAST:event_templateProjectPanelMouseExited

    /**
     * Button animation when the mouse is out of the new button
     *
     * @param evt mouse out
     */
    private void newProjectPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProjectPanelMouseExited
        //newProjectPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
    }//GEN-LAST:event_newProjectPanelMouseExited
           
    /**
     * Hides main menu and shows main window frame
     *
     * @param evt click new button
     */
    private void newProjectPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProjectPanelMousePressed
        this.setVisible(false);
        mainWindow = new MainWindow();
        mainWindow.display();
    }//GEN-LAST:event_newProjectPanelMousePressed
    
    /**
     * <p>
 Loads a previously saved convoy. The user selects a convoy file to be
 loadProjected. The convoy file must have the file extension .conx, After the
 user selects the convoy file the main menu frame is hidden and a new main
 window frame is displayed with the selected convoy file loadProjected.
 </p>
     *
     * @param evt click loadProject button
     */
    private void templateProjectPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_templateProjectPanelMousePressed
        
        try {
            Desktop.getDesktop().open(new File("src/convoy/templates"));
        } catch (IOException e) {
            //e.printStackTrace();
        }
        
    }//GEN-LAST:event_templateProjectPanelMousePressed

    private void loadProjectPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadProjectPanelMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_loadProjectPanelMouseEntered

    private void loadProjectPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadProjectPanelMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_loadProjectPanelMouseExited

    private void loadProjectPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadProjectPanelMousePressed
        Load load = new Load();
        try {
            load.loadProject();
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_loadProjectPanelMousePressed

    /**
     * The Main method
     *
     * @param args the comainMenuand line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainMenu fr = MainMenu.getInstance();
                fr.display();
            }
        });
    }

    /**
     * Sets and formats the fonts on the in the main menu
     */
    private void doMainMenuFont() {
        try {
            Font topSecretFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/convoy/resources/fonts/topSecret.ttf"));
            topSecretFont = topSecretFont.deriveFont(Font.BOLD, 96f);
            mainMenuTitle.setHorizontalAlignment(SwingConstants.CENTER);
            mainMenuTitle.setFont(topSecretFont);

            Font captureItFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/convoy/resources/fonts/captureIt.ttf"));
            captureItFont = captureItFont.deriveFont(Font.BOLD, 24f);

            newProjectLabel.setFont(captureItFont);
            templateLabel.setFont(captureItFont);
            loadProjectLabel.setFont(captureItFont);
        } catch (FontFormatException | IOException ex) {
            //ex.printStackTrace();;
        }
    }

    /**
     * Sets the button colors to desert storm
     */
    private void setMainMenuButtonColor() {
        Color desertStormColor = new Color(194, 178, 128);

        newProjectPanel.setBackground(desertStormColor);
        templateProjectPanel.setBackground(desertStormColor);
        loadProjectPanel.setBackground(desertStormColor);

        //newProjectPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        //loadProjectPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel loadProjectLabel;
    private javax.swing.JPanel loadProjectPanel;
    private javax.swing.JLabel mainMenuTitle;
    private javax.swing.JLabel newProjectLabel;
    private javax.swing.JPanel newProjectPanel;
    private convoy.gui.PicturePanel picturePanel1;
    private javax.swing.JLabel templateLabel;
    private javax.swing.JPanel templateProjectPanel;
    // End of variables declaration//GEN-END:variables

    private void createSaveDirectory(){       
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
    
    private void createImageDirectory(){
    
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
    
    private void createHtmlDirectory(){
    
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
    
    private void createTemplatesDirectory(){
    
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
    
    private void createVehicleImageDirectory(){
    
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
    
     private static void copyFile(File source, File dest)throws IOException {
        
        Files.copy(source.toPath(), dest.toPath());
         
    }
     
     public static void copyFolder(File src, File dest)
    	throws IOException{
 
    	if(src.isDirectory()){
 
    		//if directory not exists, create it
    		if(!dest.exists()){
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
    		   copyFolder(srcFile,destFile);
    		}
 
    	}else{
    		//if file, then copy it
    		//Use bytes stream to support all file types
    		InputStream in = new FileInputStream(src);
    	        OutputStream out = new FileOutputStream(dest); 
 
    	        byte[] buffer = new byte[1024];
 
    	        int length;
    	        //copy the file content in bytes 
    	        while ((length = in.read(buffer)) > 0){
    	    	   out.write(buffer, 0, length);
    	        }
 
    	        in.close();
    	        out.close();
    	        System.out.println("File copied from " + src + " to " + dest);
    	}
    }
     
     private void copyTemplates() throws IOException{
         
         //URL url = convoy.gui.MainMenu.class.getProtectionDomain().getClassLoader().getResource("/resources/images/vehicles");
      //String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
      //String parentPath = new File(jarPath).getParentFile().getPath();
        
      
         
          //System.out.print();
         //JOptionPane.showConfirmDialog(this, parentPath);
         try{
         //copyFolder(new File(parentPath.substring(1).replace("%20", " ")), new File(getProgramPath() + "\\vehicleImages"));
         //copyFolder(new File(getClass().getResource("/convoy/resources/templates").getPath().substring(1).replace("%20", " ")), new File(getProgramPath() + "\\templates"));
         
         //System.out.print(getClass().getResource("/convoy/resources/images/vehicles").getPath().substring(1).replace("%20", " "));
         }catch(Exception ex){
                     JOptionPane.showConfirmDialog(this, ex);
         }
         
         
        //try {
            //copyFile(new File(getClass().getResource("/convoy/resources/images/humvee.jpg").getFile()), new File(getProgramPath() ));
        //} catch (UnsupportedEncodingException ex) {
            //Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        //}
         
     }
    
    public static String getProgramPath() throws UnsupportedEncodingException {
      URL url = convoy.gui.MainMenu.class.getProtectionDomain().getCodeSource().getLocation();
      String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
      String parentPath = new File(jarPath).getParentFile().getPath();
      return parentPath;
   }
    
    
}
