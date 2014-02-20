/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.gui;

import convoy.objects.Mission;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

/**
 *
 * @author dizoo548
 */
public class MainMenu extends javax.swing.JFrame {
    

    private static MainMenu frame = new MainMenu();
    protected static Mission mission;
    
    private BufferedImage image;
    
    protected void paintComponent(Graphics g) {
        this.paintComponent(g);
        int x = (this.getWidth() - image.getWidth(null)) / 2;
        int y = (this.getHeight() - image.getHeight(null)) / 2;
        
        BufferedImage tmpImg = new BufferedImage(image.getWidth(), image.getHeight(), 
                                                  BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) tmpImg.getGraphics();
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.3f)); 
                 // set the transparency level in range 0.0f - 1.0f 
        g2d.drawImage(image, 0, 0, null);
        image = tmpImg;
        
        g.drawImage(image, x, y, null); // see javadoc for more info on the parameters            
    }
    
    /**
     * Method used to load an image
     * @param imageName the file path of the image to be loaded
     */
    private void loadImage() {
       try {
            image = ImageIO.read(getClass().getResource("/convoy/resources/images/humveeWithGun.jpg"));
        } catch (IOException ex) {
        }
    }
    
    /**
     * Creates new form MainMenu
     */
    public MainMenu() {        
        mission = Mission.getInstance();
        initComponents();
        doMainMenuFont();
        setMainMenuButtonColor();
        setMainMenuButtonColor();
        loadImage();
        repaint();
        revalidate();
    }
    
    public void display() {
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Convoy Quick - Convoy documentation creator to help save lives");
        frame.setExtendedState(MainMenu.MAXIMIZED_BOTH);
        frame.setResizable(false);
        //frame.setUndecorated(true); 
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

        newProjectPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                newProjectPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                newProjectPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                newProjectPanelMouseExited(evt);
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

        loadProjectPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loadProjectPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loadProjectPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loadProjectPanelMouseExited(evt);
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1015, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 623, Short.MAX_VALUE)
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

    private void newProjectPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProjectPanelMouseEntered
        
        newProjectPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        
    }//GEN-LAST:event_newProjectPanelMouseEntered

    private void loadProjectPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadProjectPanelMouseEntered
        
        loadProjectPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
        
    }//GEN-LAST:event_loadProjectPanelMouseEntered

    private void loadProjectPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadProjectPanelMouseExited
        
        loadProjectPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        
    }//GEN-LAST:event_loadProjectPanelMouseExited

    private void newProjectPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProjectPanelMouseExited
        
        newProjectPanel.setBorder(new BevelBorder(BevelBorder.RAISED));
        
    }//GEN-LAST:event_newProjectPanelMouseExited

    private void newProjectPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newProjectPanelMouseClicked
        this.setVisible(false); 
        mainWindow = new MainWindow();
        mainWindow.setVisible(true);
        mainWindow.setTitle("Convoy Quick - Convoy documentation creator to help save lives");
        mainWindow.setIconImage(new ImageIcon(getClass().getResource("/convoy/resources/images/humveeIcon.png")).getImage());
        mainWindow.setExtendedState(mainWindow.MAXIMIZED_BOTH);
        mainWindow.toFront();
        repaint();
        revalidate();
    }//GEN-LAST:event_newProjectPanelMouseClicked

    private void loadProjectPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loadProjectPanelMouseClicked
       
        //To load a previously saved convoy
        FileDialog loadFile;
        loadFile = new FileDialog(this, "Choose a file", FileDialog.LOAD);
        loadFile.setDirectory("C:\\");
        loadFile.setVisible(true);
    }//GEN-LAST:event_loadProjectPanelMouseClicked
        
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
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().display();
            }
        });
    }

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

            
        } catch (Exception ex) {
            ex.printStackTrace();;
        }

    }
    
    private void setMainMenuButtonColor(){
        
       Color desertStormColor = new  Color(194, 178, 128);
       
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
