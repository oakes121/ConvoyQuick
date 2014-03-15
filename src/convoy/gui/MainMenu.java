package convoy.gui;

import convoy.loadsave.Load;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import javax.swing.filechooser.FileNameExtensionFilter;

import convoy.objects.Mission;
import convoy.objects.Vehicle;
import java.util.ArrayList;

/**
 * @author Mike Moye <mtm5313@psu.edu>
 * @version 1.0
 * @since 2014-02-27
 *
 * <p>
 * This class is to create the Main Menu.
 * </p>
 */
public class MainMenu extends javax.swing.JFrame {

    protected int mainWindowCount = 0;
    protected int currentMainWindow = 0;
    private ArrayList<MainWindow> mainWindows = new ArrayList<MainWindow>();
    private static  MainMenu frame = MainMenu.getInstance();
    protected static Mission mission;
    private BufferedImage image;

    /**
     * Creates new form MainMenu
     */
    private MainMenu() {
        mission = Mission.getInstance();
        initComponents();
        doMainMenuFont();
        setMainMenuButtonColor();
        setMainMenuButtonColor();
        loadImage();
        repaint();
        revalidate();
        newProjectPanel.requestFocus();
    }
    
    public static MainMenu getInstance() {
        // if uniqueInstance is null, instantiate it to new Mission()
        if (frame == null) {
            frame = new MainMenu();
        }        
        
        return frame;
    }
    
    public void transferInformation(MainWindow mw) {
        String missionNumber, from, to, additionalText, cC, aCC, stagingArea, from2, to2, 
                fromLU, toLU, fromSP, toSP, additionalText2;
        ImageIcon icon;
        
        missionNumber = mainWindows.get(0).leftMissionInfoPanel1.getMissionNumber();
        from = mainWindows.get(0).leftMissionInfoPanel1.getFrom();
        to = mainWindows.get(0).leftMissionInfoPanel1.getTo();
        additionalText = mainWindows.get(0).leftMissionInfoPanel1.getAdditionalText();
        icon = (ImageIcon) mainWindows.get(0).leftMissionInfoPanel1.getIcon();
   
        cC = mainWindows.get(0).rightMissionInfoPanel2.getCC();
        aCC = mainWindows.get(0).rightMissionInfoPanel2.getACC();
        stagingArea = mainWindows.get(0).rightMissionInfoPanel2.getStagingArea();
        from2 = mainWindows.get(0).rightMissionInfoPanel2.getFrom();
        to2 = mainWindows.get(0).rightMissionInfoPanel2.getTo();
        fromLU = mainWindows.get(0).rightMissionInfoPanel2.getFromLU();
        toLU = mainWindows.get(0).rightMissionInfoPanel2.getToLU();
        fromSP = mainWindows.get(0).rightMissionInfoPanel2.getFromSP();
        toSP = mainWindows.get(0).rightMissionInfoPanel2.getToSP();
        additionalText2 = mainWindows.get(0).rightMissionInfoPanel2.getAdditionalText();
        
        mw.leftMissionInfoPanel1.setMissionNumber(missionNumber);
        mw.leftMissionInfoPanel1.setFrom(from);
        mw.leftMissionInfoPanel1.setTo(to);
        mw.leftMissionInfoPanel1.setAdditionalText(additionalText);
        mw.leftMissionInfoPanel1.setIcon((ImageIcon) icon);
        
        mw.rightMissionInfoPanel2.setCC(cC);
        mw.rightMissionInfoPanel2.setACC(aCC);
        mw.rightMissionInfoPanel2.setStagingArea(stagingArea);
        mw.rightMissionInfoPanel2.setFrom(from2);
        mw.rightMissionInfoPanel2.setTo(to2);
        mw.rightMissionInfoPanel2.setFromLU(fromLU);
        mw.rightMissionInfoPanel2.setToLU(toLU);
        mw.rightMissionInfoPanel2.setFromSP(fromSP);
        mw.rightMissionInfoPanel2.setToSP(toSP);
        mw.rightMissionInfoPanel2.setAddtionalText(additionalText2);
        
    }
    
    public ArrayList<MainWindow> getMainWindows() {
        return mainWindows;
    }
    
    /**
     * newMainWindow creates a new MainWindow
     */
    public void newMainWindow() {
        mainWindows.get(mainWindowCount).setVisible(false);
        mainWindowCount++;
        mainWindows.add(new MainWindow());
        currentMainWindow++;
        transferInformation(mainWindows.get(mainWindowCount));
        mainWindows.get(mainWindowCount).showLeftArrow();
        mainWindows.get(mainWindowCount).display();
    }
    
    /**
     * accessMainWindowToTheRight() allows user to access the mainWindow screen to the right
     */
    public void accessMainWindowToTheRight() {
        mainWindows.get(currentMainWindow++).setVisible(false);
        mainWindows.get(currentMainWindow).showLeftArrow();
        mainWindows.get(currentMainWindow).display(); 
        
    }
    
    /**
     * accessMainWindowToTheLeft() allows user to access the mainWindow screen to the left
     */
    public void accessMainWindowToTheLeft() {        
        mainWindows.get(currentMainWindow--).setVisible(false);
        mainWindows.get(currentMainWindow).showRightArrow();
        mainWindows.get(currentMainWindow).display();
    }

    /**
     * Sets the background image of the main menu
     *
     * @param g abstract graphics
     */
    protected void paintComponent(Graphics g) {
        this.paintComponent(g);
        int x = (this.getWidth() - image.getWidth(null)) / 2;
        int y = (this.getHeight() - image.getHeight(null)) / 2;
        g.drawImage(image, x, y, null); // see javadoc for more info on the parameters            
    }

    /**
     * Method used to loadProject an image.
     *
     * @param imageName the file path of the image to be loadProjected
     */
    private void loadImage() {
        try {
            image = ImageIO.read(getClass().getResource("/convoy/resources/images/humveeWithGun.jpg"));
        } catch (IOException ex) {
        }
    }

    /**
     * displays and set the attribute and properties of the main menu frame
     */
    public void display() {
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Convoy Quick - Convoy documentation creator to help save lives");
        frame.setExtendedState(MainMenu.MAXIMIZED_BOTH);
        frame.setResizable(false);
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
        loadProjectPanel = new javax.swing.JPanel();
        loadProjectLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(new ImageIcon(getClass().getResource("/convoy/resources/images/humveeIcon.png")).getImage());
        setName("mainWindow"); // NOI18N

        picturePanel1.setBackground(new java.awt.Color(255, 255, 255));

        newProjectPanel.setBorder(new javax.swing.border.SoftBevelBorder(0, null, new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 0, 0)));
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

        loadProjectPanel.setBorder(new javax.swing.border.SoftBevelBorder(0, null, new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 0, 0)));
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
                .addContainerGap(20, Short.MAX_VALUE))
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
                .addGap(120, 120, 120)
                .addComponent(newProjectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1003, Short.MAX_VALUE)
                .addComponent(loadProjectPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
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
        newProjectPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
    }//GEN-LAST:event_newProjectPanelMouseEntered

    /**
     * Button animation when the mouse is over the loadProject button
     *
     * @param evt mouse over
     */
    private void loadProjectPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadProjectPanelMouseEntered
        loadProjectPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
    }//GEN-LAST:event_loadProjectPanelMouseEntered

    /**
     * Button animation when the mouse is out of the loadProject button
     *
     * @param evt mouse out
     */
    private void loadProjectPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadProjectPanelMouseExited
        loadProjectPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
    }//GEN-LAST:event_loadProjectPanelMouseExited

    /**
     * Button animation when the mouse is out of the new button
     *
     * @param evt mouse out
     */
    private void newProjectPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProjectPanelMouseExited
        newProjectPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
    }//GEN-LAST:event_newProjectPanelMouseExited
           
    /**
     * Hides main menu and shows main window frame
     *
     * @param evt click new button
     */
    private void newProjectPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProjectPanelMousePressed
        this.setVisible(false);
        mainWindows.add(new MainWindow());
        mainWindows.get(0).display();
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
    private void loadProjectPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadProjectPanelMousePressed
        Load load = new Load();
        load.loadProject();
        setVisible(false);
       
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
                new MainMenu().display();
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
            captureItFont = captureItFont.deriveFont(Font.BOLD, 48f);

            newProjectLabel.setFont(captureItFont);
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
        loadProjectPanel.setBackground(desertStormColor);

        newProjectPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        loadProjectPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
    }

    private MainWindow mainWindow;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel loadProjectLabel;
    private javax.swing.JPanel loadProjectPanel;
    private javax.swing.JLabel mainMenuTitle;
    private javax.swing.JLabel newProjectLabel;
    private javax.swing.JPanel newProjectPanel;
    private convoy.gui.PicturePanel picturePanel1;
    // End of variables declaration//GEN-END:variables

}
