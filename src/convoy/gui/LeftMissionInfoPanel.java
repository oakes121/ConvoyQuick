package convoy.gui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.AbstractDocument;

import convoy.objects.MaximumSizeFilter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;

/**
 * @author Mike Moye <mtm5313@psu.edu>
 * @version 1.0
 * @since 2014-02-27
 *
 * <p>
 * This class is to create the left mission information panel at the top left of
 * the main window.
 * </p>
 */
public class LeftMissionInfoPanel extends javax.swing.JPanel {

    private String imagePath; //directory path of the unit patch

    /**
     * This constructor is use the initialize the left mission information
     * panel.
     */
    public LeftMissionInfoPanel() {
        super();
        initComponents();
        doFonts();
        setLayout(this.getLayout());
    }

    /**
     * Returns the classification of the convoy in uppercase
     *
     * @return classificationDropBox.getSelectedItem().toString().toUpperCase()
     */
    public String getClassification() {
        return this.classificationDropBox.getSelectedItem().toString().toUpperCase();
    }

    /**
     * Sets the convoy classification
     *
     * @param classification the classification to be set
     */
    public void setClassification(String classification) {
        if (classification.equalsIgnoreCase("For official use only")) {
            this.classificationDropBox.setSelectedIndex(0);
        }
        if (classification.equalsIgnoreCase("Unclassified")) {
            this.classificationDropBox.setSelectedIndex(1);
        }
        if (classification.equalsIgnoreCase("Classified")) {
            this.classificationDropBox.setSelectedIndex(2);
        }
        if (classification.equalsIgnoreCase("Secret")) {
            this.classificationDropBox.setSelectedIndex(3);
        }
        if (classification.equalsIgnoreCase("Top Secret")) {
            this.classificationDropBox.setSelectedIndex(4);
        }
        if (classification.equalsIgnoreCase("Confediential")) {
            this.classificationDropBox.setSelectedIndex(5);
        }
    }

    /**
     * Returns the convoy mission number
     *
     * @return this.missionNumberTextField.getText()
     */
    public String getMissionNumber() {
        return this.missionNumberTextField.getText();
    }

    /**
     * Sets the mission number
     *
     * @param missionNumber
     */
    public void setMissionNumber(String missionNumber) {
        missionNumberTextField.setText(missionNumber);
    }

    /**
     * Returns the beginning location of the convoy in the left mission
     * information panel
     *
     * @return this.fromTextField.getText()
     */
    public String getFrom() {
        return this.fromTextField.getText();
    }

    /**
     * Returns the destination of the convoy in the left mission information
     * panel
     *
     * @return this.toTextField.getText()
     */
    public String getTo() {
        return this.toTextField.getText();
    }

    /**
     * Returns the additional information of the left mission information panel
     *
     * @return this.additionalText.getText()
     */
    public String getAdditionalText() {
        return this.additionalTextPanel1.getAdditionalText();
    }

    /**
     * Sets the beginning location of the convoy in the left mission information
     * panel
     *
     * @param from
     */
    public void setFrom(String from) {
        this.fromTextField.setText(from);
    }

    /**
     * Sets destination of the convoy in the left mission information panel
     *
     * @param to
     */
    public void setTo(String to) {
        this.toTextField.setText(to);
    }

    /**
     * Sets the additional information of the left mission information panel
     *
     * @param text
     */
    public void setAdditionalText(String text) {
        this.additionalTextPanel1.setAdditionalText(text);
    }

    /**
     * Sets the image of the unit patch
     *
     * @param icon the image as a icon
     */
    public void setIcon(ImageIcon icon) {
        imageLabel.setText("");
        imageLabel.setIcon(icon);
    }

    /**
     * Gets the width of the label where the image goes
     *
     * @return this.imageLabel.getWidth()
     */
    public int getIconWidth() {
        return this.imageLabel.getWidth();
    }

    /**
     * Gets the height of the label where the image goes
     *
     * @return this.imageLabel.getHeight()
     */
    public int getIconHeight() {
        return this.imageLabel.getHeight();
    }

    /**
     * Gets icon of the label where the image goes
     *
     * @return this.imageLabel.getIcon()
     */
    public Icon getIcon() {
        return this.imageLabel.getIcon();
    }

    /**
     * Sets the path of the directory where the unit patch image is located
     *
     * @param path
     */
    public void setImagePath(String path) {
        this.imagePath = path;
    }

    /**
     * Gets the path of the directory where the unit patch image is located
     *
     * @return this.imagePath
     */
    public String getImagePath() {
        return this.imagePath;
    }

    /**
     * Sets and formats the fonts on the left mission information panel
     */
    private void doFonts() {
        try {
            Font captureItFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/convoy/resources/fonts/lucidaGrande.ttf"));
            captureItFont = captureItFont.deriveFont(Font.BOLD, 18f);

            classificationDropBox.setFont(captureItFont);
            missionNumberLabel.setFont(captureItFont);
            fromLabel.setFont(captureItFont);
            toLabel.setFont(captureItFont);
            
            classificationDropBox.setRenderer(new HighLightRowRenderer(classificationDropBox.getRenderer()));            
            
        } catch (FontFormatException | IOException ex) {
            //ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        classificationDropBox = new javax.swing.JComboBox();
        missionNumberTextField = new javax.swing.JTextField();
        missionNumberLabel = new javax.swing.JLabel();
        fromLabel = new javax.swing.JLabel();
        fromTextField = new javax.swing.JTextField();
        toLabel = new javax.swing.JLabel();
        toTextField = new javax.swing.JTextField();
        imageLabel = new javax.swing.JLabel();
        additionalTextPanel1 = new convoy.gui.AdditionalTextPanel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setBackground(new java.awt.Color(194, 178, 128));
        setPreferredSize(new java.awt.Dimension(650, 360));

        classificationDropBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "FOR OFFICIAL USE ONLY", "UNCLASSIFIED", "CLASSIFIED", "SECRET", "TOP SECRET", "CONFEDIENTAL" }));
        classificationDropBox.setToolTipText("Click to Select Mission Classification");
        classificationDropBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                classificationDropBoxItemStateChanged(evt);
            }
        });

        missionNumberTextField.setToolTipText("Enter Mission Number");

        missionNumberLabel.setText("Mission #");

        fromLabel.setText("Start Point: ");

        fromTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromTextFieldActionPerformed(evt);
            }
        });

        toLabel.setText("Rally Point: ");

        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/resources/images/2id.png"))); // NOI18N
        imageLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        imageLabel.setToolTipText("Click to change the Unit Patch");
        imageLabel.setBorder(null);
        imageLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                imageLabelMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(additionalTextPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imageLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(fromLabel)
                                    .addComponent(missionNumberLabel)
                                    .addComponent(toLabel))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(fromTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                                            .addComponent(toTextField)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(missionNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(classificationDropBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(classificationDropBox, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(missionNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(missionNumberLabel))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fromLabel))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(toTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toLabel)))
                    .addComponent(imageLabel))
                .addGap(26, 26, 26)
                .addComponent(additionalTextPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private static void copyFile(File source, File dest) throws IOException {

        Files.copy(source.toPath(), dest.toPath());

    }

    public static String getProgramPath() throws UnsupportedEncodingException {
        URL url = convoy.gui.MainMenu.class.getProtectionDomain().getCodeSource().getLocation();
        String jarPath = URLDecoder.decode(url.getFile(), "UTF-8");
        String parentPath = new File(jarPath).getParentFile().getPath();
        return parentPath;
    }

    private String getPath() {
        String path = null;
        try {
            path = getProgramPath();
        } catch (UnsupportedEncodingException ex) {
            //Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
        }

        String fileSeparator = System.getProperty("file.separator");
        String newDir = path + fileSeparator + "images" + fileSeparator;
        return newDir;
    }

    /**
     * <p>
     * Sets the unit patch image for the convoy when the user clicks on the
     * image. User selects an image file from the desired directory. The file
     * extensions can only be .jpg, .jpeg, .png, .gif. The file is resized and
     * the location of the file is stored.
     * </p>
     *
     * @param evt click image
     */
    private void imageLabelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imageLabelMousePressed
        try {
            FileDialog loadFile = null;
            loadFile = new FileDialog(loadFile, "Choose an Image", FileDialog.LOAD);
            loadFile.setFile("*.jpg;*.jpeg;*.png;*.gif");
            loadFile.setVisible(true);

            if (loadFile.getFile() != null) {
                this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
                File file = new File(loadFile.getFile());

                URL url = null;
                try {
                    url = new URL("file:\\" + loadFile.getDirectory() + file);

                    copyFile(new File(loadFile.getDirectory() + file), new File(getPath() + file));

                    this.setImagePath(getPath() + file);
                } catch (MalformedURLException ex) {
                    //Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
                Image img = null;
                try {
                    if (url != null) {
                        img = ImageIO.read(new File(getPath() + file));
                    } else {
                    }
                } catch (IOException ex) {
                    //Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (img != null) {
                    Image finalImage = img.getScaledInstance(202, 168, java.awt.Image.SCALE_SMOOTH); // getScaledInstance(width, hieght, algorithm)
                    ImageIcon icon = new ImageIcon(finalImage);
                    this.setIcon(icon);
                }
                this.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
        }
    }//GEN-LAST:event_imageLabelMousePressed

    private void fromTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromTextFieldActionPerformed

    private void classificationDropBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_classificationDropBoxItemStateChanged
        if(classificationDropBox.getSelectedIndex() >= 3){
            classificationDropBox.setForeground(Color.RED);
        }
    }//GEN-LAST:event_classificationDropBoxItemStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private convoy.gui.AdditionalTextPanel additionalTextPanel1;
    private javax.swing.JComboBox classificationDropBox;
    private javax.swing.JLabel fromLabel;
    private javax.swing.JTextField fromTextField;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel missionNumberLabel;
    private javax.swing.JTextField missionNumberTextField;
    private javax.swing.JLabel toLabel;
    private javax.swing.JTextField toTextField;
    // End of variables declaration//GEN-END:variables
}

class HighLightRowRenderer implements ListCellRenderer {

    private final ListCellRenderer delegate;
    private int height = -1;

    public HighLightRowRenderer(ListCellRenderer delegate) {
        this.delegate = delegate;
    }

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component component = delegate.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        Dimension size = component.getPreferredSize();
        
        if (index >= 3){
            component.setForeground(Color.RED);
            if (component instanceof JLabel) {
                ((JLabel) component).setHorizontalTextPosition(JLabel.CENTER);
            }
        }
                       
        return component;
    }
}
