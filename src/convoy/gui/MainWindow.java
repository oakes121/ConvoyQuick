/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convoy.gui;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dizoo548
 */
public class MainWindow extends javax.swing.JFrame {
    
    private static MainWindow frame = new MainWindow();

    /**
     * Creates new form mainWindow
     */
    public MainWindow() {
        
        initComponents();
        makeSelectPanelsTransparent();
        doMainWindowFont();
        setMainWindowButtonColor();
        picturePanel2 = new PicturePanel("/convoy/resources/images/camo.jpg");
        revalidate();
        repaint();
        
        //addMenuBar();
    }
    
    public void makeSelectPanelsTransparent() {
        missionNumberPanel.setOpaque(false);
        //vehiclePanel.setOpaque(false);
        additionalInfoPanel.setOpaque(false);
        //buttonsPanel.setOpaque(false);
    }
    
    private void display() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();        
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // added 
        frame.setTitle("Convoy QuicMaink - Convoy documentation creator to help save lives");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setIconImage(new ImageIcon(getClass().getResource("/convoy/resources/images/humveeIcon.png")).getImage());
        frame.setVisible(true);        
        revalidate();
        repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        picturePanel2 = new convoy.gui.PicturePanel("");
        missionNumberPanel = new javax.swing.JPanel();
        leftMissionInfoPanel1 = new convoy.gui.LeftMissionInfoPanel();
        rightMissionInfoPanel2 = new convoy.gui.RightMissionInfoPanel();
        additionalInfoPanel = new javax.swing.JPanel();
        additionalTextPanel1 = new convoy.gui.additionalTextPanel();
        vehicleGrid1 = new convoy.gui.VehicleGrid();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        helpMenu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        aboutMenu = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(1000, 800));
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        picturePanel2.setBackground(new java.awt.Color(204, 0, 0));

        missionNumberPanel.setBackground(new java.awt.Color(255, 255, 255));
        missionNumberPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        missionNumberPanel.setLayout(new javax.swing.BoxLayout(missionNumberPanel, javax.swing.BoxLayout.LINE_AXIS));
        missionNumberPanel.add(leftMissionInfoPanel1);
        missionNumberPanel.add(rightMissionInfoPanel2);

        additionalInfoPanel.setBackground(new java.awt.Color(255, 255, 255));
        additionalInfoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        additionalInfoPanel.setLayout(new java.awt.BorderLayout());
        additionalInfoPanel.add(additionalTextPanel1, java.awt.BorderLayout.CENTER);

        vehicleGrid1.setBackground(new java.awt.Color(255, 255, 255));
        vehicleGrid1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));

        javax.swing.GroupLayout picturePanel2Layout = new javax.swing.GroupLayout(picturePanel2);
        picturePanel2.setLayout(picturePanel2Layout);
        picturePanel2Layout.setHorizontalGroup(
            picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(additionalInfoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(missionNumberPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 870, Short.MAX_VALUE)
            .addComponent(vehicleGrid1, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );
        picturePanel2Layout.setVerticalGroup(
            picturePanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picturePanel2Layout.createSequentialGroup()
                .addComponent(missionNumberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(vehicleGrid1, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(additionalInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(picturePanel2);

        menuBar.setName("menuBar"); // NOI18N

        fileMenu.setText("File");

        newMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMenuItem.setText("New");
        newMenuItem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newMenuItemMouseClicked(evt);
            }
        });
        fileMenu.add(newMenuItem);

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Load");
        fileMenu.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText("Save");
        fileMenu.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText("Finalize");
        fileMenu.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("Print");
        fileMenu.add(jMenuItem4);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");
        menuBar.add(editMenu);

        helpMenu.setText("Help");

        jMenu1.setText("jMenu1");
        helpMenu.add(jMenu1);

        menuBar.add(helpMenu);

        aboutMenu.setText("About");
        menuBar.add(aboutMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newMenuItemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newMenuItemMouseClicked
        
        int response = JOptionPane.showConfirmDialog(null, "Are you sure you want to start a new convoy?\nAll unsaved data will be lost!", "New Convoy?",  JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.YES_OPTION)
        {
           this.setVisible(false); 
            MainWindow mainWindow = new MainWindow();
            mainWindow.setVisible(true);
            mainWindow.setExtendedState(mainWindow.MAXIMIZED_BOTH);
            mainWindow.toFront();
            repaint();
            revalidate();
        }
    }//GEN-LAST:event_newMenuItemMouseClicked

    /**
     * @param args the command line arguments
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().display();
                
                
            }
        });
    }
    
    private void doMainWindowFont() {
        try {
            
            //Font topSecretFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/convoy/resources/fonts/topSecret.ttf"));
            
            Font captureItFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/convoy/resources/fonts/captureIt.ttf"));
            captureItFont = captureItFont.deriveFont(Font.ITALIC, 15f);
                        
            //finalizeLabel.setFont(captureItFont);
            //mainMenuLabel.setFont(captureItFont);
            //printLabel.setFont(captureItFont);
            //saveLabel.setFont(captureItFont);
            
            
        } catch (Exception ex) {
            ex.printStackTrace();;
        }

    }
    
    private void setMainWindowButtonColor(){
        
       //Color desertStormColor = new  Color(194, 178, 128);
       /*
       finalizePanel.setBackground(desertStormColor);
       mainMenuPanel.setBackground(desertStormColor);
       printPanel.setBackground(desertStormColor);
       savePanel.setBackground(desertStormColor);
       
       finalizePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
       mainMenuPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
       printPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
       savePanel.setBorder(new BevelBorder(BevelBorder.RAISED));
       */
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu aboutMenu;
    private javax.swing.JPanel additionalInfoPanel;
    private convoy.gui.additionalTextPanel additionalTextPanel1;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel2;
    private convoy.gui.LeftMissionInfoPanel leftMissionInfoPanel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel missionNumberPanel;
    private javax.swing.JMenuItem newMenuItem;
    private convoy.gui.PicturePanel picturePanel2;
    private convoy.gui.RightMissionInfoPanel rightMissionInfoPanel2;
    private convoy.gui.VehicleGrid vehicleGrid1;
    // End of variables declaration//GEN-END:variables
}
