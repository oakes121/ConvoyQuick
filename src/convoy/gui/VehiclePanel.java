/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.gui;

import convoy.objects.Mission;
import convoy.objects.Personnel;
import convoy.objects.Vehicle;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

/**
 *
 * @author Oakes
 */
public class VehiclePanel extends javax.swing.JPanel {

    
    private static int maxTextfieldLength = 20;
    private String imageName;
    private String iconPath;
    private Image finalImage;
    private Image img;
    private boolean isCC = false;
    private boolean isACC = false;
    private int addVehiclePopUpJComboBox1Selection = 0;
    private int addVehiclePopUpJComboBox2Selection = 0;
    private int addVehiclePopUpJComboBox3Selection = 0;
    /*
    private AddVehiclePopUp addVehicleObj; 
    public boolean medic = addVehicleObj.medic;
    private boolean cc = addVehicleObj.cc;
    private boolean acc = addVehicleObj.acc;
    private Image img; 
    private ImageIcon imgIcon;
*/
    /**
     * Creates new form VehiclePanel
     */
    public VehiclePanel() {
        //this.setOpaque(false);
        initComponents();
        doMainMenuFont();
        setTransparent();
        /*
           img.getClass().getResource("/convoy/resources/icons/steeringWheel.png");
            finalImage =  img.getScaledInstance(268, 209, java.awt.Image.SCALE_SMOOTH);
             ImageIcon icon = new ImageIcon(finalImage);
            driverWheelLabel.setIcon(icon);
        */
        //loadImage();
        deleteButton.setMargin(new Insets(0, 0, 0, 0));
        deleteButton.setBorder(null);
        
      
        revalidate();
        repaint();
    }
    
    public JLabel getDriverLabel() {
        return driverLabel;
    }
    
    public JLabel getPassengerLabel1() {
        return this.passenger1Label;
    }
    
    public JLabel getPassengerLabel2() {
        return this.passenger2Label;
    }
    
    public JLabel getPassengerLabel3() {
        return this.passenger3Label;
    }
    
    public Icon getImageIcon() {
        return imageLabel.getIcon();
    }
    
    /**
     * setIconPath(String newPath) sets the file path for the imageLabel icon
     * @param newPath the file path that iconPath will be set to
     */
    public void setIconPath(String newPath) {
        iconPath = newPath;
    }
    
    /**
     * getIconPath() returns iconPath
     * @return iconPath
     */
    public String getIconPath() {
        return iconPath;
    }
    
    // This method sets the Convoy Commander Image if passenger type is convoy commander
    // This method sets the Convoy Commander Image if passenger type is convoy commander
    public void setDriverIcon (Image img){
        
      try{  
          /*
            URL url = getClass().getResource("convoy/resources/icons/steeringWheel.png");
            img = ImageIO.read(url);
          */
             Image driverImage = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(driverImage);
            driverWheelLabel.setIcon(icon);
            revalidate();
            repaint();
      }
      
      catch (Exception ex){}        
    }
    
    // This method sets the medic Image if passenger type is medic
    public void setMedicIcon (Image img, int x){
        
      try{  
          /*
            URL url = getClass().getResource("convoy/resources/icons/steeringWheel.png");
            img = ImageIO.read(url);
          */
            
            int labelNumber = x;
            Image medicImage = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(medicImage);
            
            if (labelNumber == 1 ){
            iconLabel1.setVisible(true);
            iconLabel1.setIcon(icon);
             }
            if (labelNumber == 2){
                iconLabel2.setVisible(true);
                iconLabel2.setIcon(icon);
            }
             if (labelNumber == 3){
                iconLabel3.setVisible(true);
                iconLabel3.setIcon(icon);
            }
            revalidate();
            repaint();
      }
      catch (Exception ex){  
      }   
    }
    
    public void removeCCORACCIcon() {
        //ccOrACC.setIcon(null);
        ccOrACC.setVisible(false);
    }
    
    // This method sets the CC Image if passenger type is Convoy Commander
    public void setCCIORACCIcon (Image img){
        
      try{  
          /*
            URL url = getClass().getResource("convoy/resources/icons/steeringWheel.png");
            img = ImageIO.read(url);
          */
         
            Image ccImage = img.getScaledInstance(28, 28, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(ccImage);
            this.ccOrACC.setIcon(icon);
            this.ccOrACC.setVisible(true);            
            revalidate();
            repaint();
      }
      catch (Exception ex){ 
      }  
    }
    
    // This method sets the ACC Image if passenger type is Convoy Commander
    public void setACCIcon (Image img, int x){
        
      try {  
          /*
            URL url = getClass().getResource("convoy/resources/icons/steeringWheel.png");
            img = ImageIO.read(url);
          */
            int labelNumber = x;
            Image accImage = img.getScaledInstance(20, 20, java.awt.Image.SCALE_SMOOTH);
            ImageIcon icon = new ImageIcon(accImage);
            if (labelNumber == 1){
            iconLabel1.setVisible(true);
            iconLabel1.setIcon(icon);
            }
            
            if (labelNumber == 2){
                iconLabel2.setVisible(true);
                iconLabel2.setIcon(icon);
            }
             if (labelNumber == 3){
                iconLabel3.setVisible(true);
                iconLabel3.setIcon(icon);
            }
            revalidate();
            repaint();
      }
      catch (Exception ex) {}  
    }
    
    //This method removes the CC icon from the label
    public void removeIconImage(int x){
         int labelNumber = x;
        if (labelNumber == 1){
            iconLabel1.setVisible(false);
        }
        if (labelNumber == 2){
            iconLabel2.setVisible(false);
        }
         if (labelNumber == 3){
            iconLabel3.setVisible(false);
        }
    }    
    
    //This method removes the medic icon from the label
    public void removeMedicIcon(int x){
         int labelNumber = x;
        if (labelNumber == 1){
            iconLabel1.setVisible(false);
        }
        if (labelNumber == 2){
            iconLabel2.setVisible(false);
        }
        if (labelNumber == 3){
            iconLabel3.setVisible(false);
        }
    }
    
    public void setImage(Image img) {
        try {

            finalImage = img.getScaledInstance(92, 50, java.awt.Image.SCALE_SMOOTH); // getScaledInstance(width, hieght, algorithm)
            ImageIcon icon = new ImageIcon(finalImage);
            imageLabel.setIcon(icon);
            revalidate();
            repaint();

        } catch (Exception ex) {
            //Logger.getLogger(CreateVehiclePopUp.class.getName()).log(Level.SEVERE, null, ex);
            //System.out.print("Image Error");
        }
    }
 
    public JButton getDeleteButton() {
        return deleteButton;
    }
    
    /**
     * String getDriverName() returns string in driverLabel
     * @return driverLabel.getText()
     */
    public String getDriverName() {
        return driverLabel.getText();
    }
    
    /**
     * getPassenger1() returns string in passenger1Label
     * @return passenger1Label.getText()
     */
    public String getPassenger1() {
        return passenger1Label.getText();
        
    }
    
    /**
     * getPassenger2() returns string in passenger2Label
     * @return passenger2Label.getText()
     */
    public String getPassenger2() {
        return passenger2Label.getText();
    }
    
    /**
     * getPassenger3() returns string in passenger3Label
     * @return passenger3Label.getText()
     */
    public String getPassenger3() {
        return passenger3Label.getText();
    }
    
    /**
     * getBumperNumber() returns string in bumperNumberLabel
     * @return bumperNumberLabel.getText()
     */
    public String getBumperNumber() {
        return bumperNumberLabel.getText();
    }
    
    public String getCallSign() {
        return callSignLabel.getText();
    }
    
    public String getAdditonalInfo() {
        return additionalInfoField.getText();
    }

    /**
     * setCallSign() returns string in callSignLabel
     * @return callSignLabelget.getText()
     */
    public String setCallSign() {
        return callSignLabel.getText();
    }

    public void setDriverName(String driverName) {
        driverLabel.setText(driverName);
    }

    public void setPassenger1(String passenger1) {
        passenger1Label.setText(passenger1);
       // setPassengerType();
    }

    public void setPassenger2(String passenger2) {
        passenger2Label.setText(passenger2);
    }

    public void setPassenger3(String passenger3) {
        passenger3Label.setText(passenger3);
    }

    public void setBumperNumber(String bumperNumber) {
        bumperNumberLabel.setText(bumperNumber);
    }

    public void setCallSign(String callSign) {
        callSignLabel.setText(callSign);
    }

    public void setTransparent() {
        //componentPanel.setOpaque(false);
    }
    public void setAdditionalInfo(String additionalInfo){
        additionalInfoField.setText(additionalInfo);
    }
    
    /**
     * batchVehicleGet(Vehicle v) sets bumperNumber, callSign, driver and all
     *  passengers in v according to the values in the corresponding JLabels. 
     * @param v the vehicle object that will be receiving the values from the 
     *  various JLabels associated with this class
     */
    public void batchVehicleGet(Vehicle v) {
        v.setBumperNumber(bumperNumberLabel.getText());
        v.setCallSign(callSignLabel.getText());        
        v.setDriver(driverLabel.getText());
        v.setVehicleIcon(imageLabel.getIcon());
        v.setIconPath(iconPath);
        v.setAdditionalInfo(additionalInfoField.getText());
        v.addPassengers(passenger1Label.getText());
        v.addPassengers(passenger2Label.getText());
        v.addPassengers(passenger3Label.getText());
        v.setIsACC(isACC);
        v.setIsCC(isCC);
    }
    
    /**
     * batchVehcileSet(Vehicle v) gets bumperNumber, callSign, driver and all
     *  passengers according from v 
     * @param v the vehicle object that will be receiving the values from the 
     *  various JLabels associated with this class
     */
    public void batchVehicleSet(Vehicle v) {
        isACC = v.getIsACC();
        isCC = v.getIsCC();
        bumperNumberLabel.setText(v.getBumperNumber());
        callSignLabel.setText(v.getCallSign());
        driverLabel.setText(v.getDriverName());
        imageLabel.setIcon(v.getVehicleIcon());
        additionalInfoField.setText(v.getAdditionalInfo());
        iconPath = v.getIconPath();
        
        if (v.getPassengers().size() >= 1)
            passenger1Label.setText(v.getPassengers().get(0).getName());
        
        if (v.getPassengers().size() >= 2)
            passenger2Label.setText(v.getPassengers().get(1).getName());
        
        if (v.getPassengers().size() >= 3)
            passenger3Label.setText(v.getPassengers().get(2).getName());
    } 

    private void doMainMenuFont() {
        try {

            Font woodCutter = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/convoy/resources/fonts/lucidaGrande.ttf"));
            woodCutter = woodCutter.deriveFont(Font.TRUETYPE_FONT, 12);

            driverLabel.setFont(woodCutter);
            passenger1Label.setFont(woodCutter);
            passenger2Label.setFont(woodCutter);
            passenger3Label.setFont(woodCutter);
            bumperNumberLabel.setFont(woodCutter);
            callSignLabel.setFont(woodCutter);

        } catch (Exception ex) {
            ex.printStackTrace();;
        }
    }
    
    public void setPassenger1Layout() {
        passenger1Label.setForeground(Color.red);
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void setPassenger2Layout() {
        passenger2Label.setForeground(Color.red);
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public void setPassenger3Layout() {
        passenger3Label.setForeground(Color.red);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setPassenger1LayoutToBlack() {
        passenger1Label.setForeground(Color.black);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setPassenger2LayoutToBlack() {
        passenger2Label.setForeground(Color.black);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
      void setPassenger3LayoutToBlack() {
        passenger3Label.setForeground(Color.black);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }  
      
      public void setSelections(int one, int two, int three) {
        addVehiclePopUpJComboBox1Selection = one;
        addVehiclePopUpJComboBox2Selection = two;
        addVehiclePopUpJComboBox3Selection = three;
    }
    
    public int getSelection1() {
        return addVehiclePopUpJComboBox1Selection;
    }
    
    public int getSelection2() {
        return addVehiclePopUpJComboBox2Selection;
    }
    
    public int getSelection3() {
        return addVehiclePopUpJComboBox3Selection;
    }
    
    public void setIsCC(boolean truth) {
        isCC = truth;
    }
    
    public void setIsACC(boolean truth) {
        isACC = truth;
    }
    
    public boolean getIsCC() {
        return isCC;
    }
    
    public boolean getIsACC() {
        return isACC;
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
        jPanel2 = new javax.swing.JPanel();
        componentPanel = new javax.swing.JPanel();
        passenger1Label = new javax.swing.JLabel();
        passenger3Label = new javax.swing.JLabel();
        bumperNumberLabel = new javax.swing.JLabel();
        driverLabel = new javax.swing.JLabel();
        passenger2Label = new javax.swing.JLabel();
        callSignLabel = new javax.swing.JLabel();
        picturePanel = new javax.swing.JPanel();
        imageLabel = new javax.swing.JLabel();
        driverWheelLabel = new javax.swing.JLabel();
        iconLabel1 = new javax.swing.JLabel();
        iconLabel2 = new javax.swing.JLabel();
        iconLabel3 = new javax.swing.JLabel();
        additionalInfoField1 = new javax.swing.JLabel();
        additionalInfoField = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        ccOrACC = new javax.swing.JLabel();

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setName(""); // NOI18N

        componentPanel.setBackground(new java.awt.Color(255, 255, 255));

        passenger1Label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        passenger1Label.setText("Passenger");
        passenger1Label.setMaximumSize(new java.awt.Dimension(50, 11));
        passenger1Label.setMinimumSize(new java.awt.Dimension(50, 11));
        passenger1Label.setName(""); // NOI18N
        passenger1Label.setPreferredSize(new java.awt.Dimension(50, 11));

        passenger3Label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        passenger3Label.setText("Passenger");
        passenger3Label.setMaximumSize(new java.awt.Dimension(50, 11));
        passenger3Label.setMinimumSize(new java.awt.Dimension(50, 11));
        passenger3Label.setName(""); // NOI18N
        passenger3Label.setPreferredSize(new java.awt.Dimension(50, 11));

        bumperNumberLabel.setBackground(new java.awt.Color(102, 102, 255));
        bumperNumberLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        bumperNumberLabel.setText("Bumper Number");
        bumperNumberLabel.setMaximumSize(new java.awt.Dimension(50, 11));
        bumperNumberLabel.setMinimumSize(new java.awt.Dimension(50, 11));
        bumperNumberLabel.setName(""); // NOI18N
        bumperNumberLabel.setPreferredSize(new java.awt.Dimension(50, 11));

        driverLabel.setBackground(new java.awt.Color(102, 102, 255));
        driverLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        driverLabel.setForeground(new java.awt.Color(0, 204, 0));
        driverLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        driverLabel.setText("Driver");
        driverLabel.setMaximumSize(new java.awt.Dimension(50, 11));
        driverLabel.setMinimumSize(new java.awt.Dimension(50, 11));
        driverLabel.setName(""); // NOI18N
        driverLabel.setPreferredSize(new java.awt.Dimension(50, 11));

        passenger2Label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        passenger2Label.setText("Passenger");
        passenger2Label.setMaximumSize(new java.awt.Dimension(50, 11));
        passenger2Label.setMinimumSize(new java.awt.Dimension(50, 11));
        passenger2Label.setName(""); // NOI18N
        passenger2Label.setPreferredSize(new java.awt.Dimension(50, 11));

        callSignLabel.setBackground(new java.awt.Color(102, 102, 255));
        callSignLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        callSignLabel.setText("Call Sign");
        callSignLabel.setMaximumSize(new java.awt.Dimension(50, 11));
        callSignLabel.setMinimumSize(new java.awt.Dimension(50, 11));
        callSignLabel.setName(""); // NOI18N
        callSignLabel.setPreferredSize(new java.awt.Dimension(50, 11));

        picturePanel.setBackground(new java.awt.Color(255, 255, 255));

        imageLabel.setBackground(new java.awt.Color(255, 255, 255));
        imageLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/resources/images/humveeIconLarge.png"))); // NOI18N

        javax.swing.GroupLayout picturePanelLayout = new javax.swing.GroupLayout(picturePanel);
        picturePanel.setLayout(picturePanelLayout);
        picturePanelLayout.setHorizontalGroup(
            picturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(picturePanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(imageLabel)
                .addGap(6, 6, 6))
        );
        picturePanelLayout.setVerticalGroup(
            picturePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, picturePanelLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(imageLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(6, 6, 6))
        );

        additionalInfoField1.setBackground(new java.awt.Color(102, 102, 255));
        additionalInfoField1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        additionalInfoField1.setText("Additional Info");
        additionalInfoField1.setMaximumSize(new java.awt.Dimension(50, 11));
        additionalInfoField1.setMinimumSize(new java.awt.Dimension(50, 11));
        additionalInfoField1.setName(""); // NOI18N
        additionalInfoField1.setPreferredSize(new java.awt.Dimension(50, 11));

        additionalInfoField.setBackground(new java.awt.Color(102, 102, 255));
        additionalInfoField.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        additionalInfoField.setText("Additional Info");
        additionalInfoField.setMaximumSize(new java.awt.Dimension(50, 11));
        additionalInfoField.setMinimumSize(new java.awt.Dimension(50, 11));
        additionalInfoField.setName(""); // NOI18N
        additionalInfoField.setPreferredSize(new java.awt.Dimension(50, 11));

        javax.swing.GroupLayout componentPanelLayout = new javax.swing.GroupLayout(componentPanel);
        componentPanel.setLayout(componentPanelLayout);
        componentPanelLayout.setHorizontalGroup(
            componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(picturePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(componentPanelLayout.createSequentialGroup()
                .addGroup(componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(componentPanelLayout.createSequentialGroup()
                        .addGroup(componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(passenger2Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passenger1Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(driverLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passenger3Label, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16)
                        .addGroup(componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(driverWheelLabel)
                            .addComponent(iconLabel1)
                            .addComponent(iconLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(iconLabel3)))
                    .addGroup(componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(callSignLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bumperNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(additionalInfoField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        componentPanelLayout.setVerticalGroup(
            componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(componentPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(driverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(driverWheelLabel))
                .addGap(5, 5, 5)
                .addGroup(componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passenger1Label, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconLabel1))
                .addGap(1, 1, 1)
                .addGroup(componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passenger2Label, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iconLabel2))
                .addGap(5, 5, 5)
                .addGroup(componentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iconLabel3)
                    .addComponent(passenger3Label, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(picturePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(bumperNumberLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(callSignLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(additionalInfoField, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        driverLabel.getAccessibleContext().setAccessibleName("driver");
        driverLabel.getAccessibleContext().setAccessibleDescription("driver");

        deleteButton.setBackground(new java.awt.Color(204, 0, 0));
        deleteButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/resources/images/deleteIcon.png"))); // NOI18N
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setPreferredSize(new java.awt.Dimension(22, 22));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(componentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(ccOrACC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ccOrACC, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(componentPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel additionalInfoField;
    private javax.swing.JLabel additionalInfoField1;
    private javax.swing.JLabel bumperNumberLabel;
    private javax.swing.JLabel callSignLabel;
    private javax.swing.JLabel ccOrACC;
    private javax.swing.JPanel componentPanel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel driverLabel;
    private javax.swing.JLabel driverWheelLabel;
    private javax.swing.JLabel iconLabel1;
    private javax.swing.JLabel iconLabel2;
    private javax.swing.JLabel iconLabel3;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel passenger1Label;
    private javax.swing.JLabel passenger2Label;
    private javax.swing.JLabel passenger3Label;
    private javax.swing.JPanel picturePanel;
    // End of variables declaration//GEN-END:variables
    
}
