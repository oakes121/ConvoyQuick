/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Oakes
 */
public class VehicleGrid extends javax.swing.JPanel implements ActionListener, KeyListener, MouseListener {
    
    private static final int MAX_VEHICLES = 16;
    private int expNumberOfVehicles = MAX_VEHICLES;          
    
    private MainWindow mainWindow;
    private final AddNewVehiclePanel addNewVehiclePanel1;
    private AddVehiclePopUp addVehiclePopUp; 
    private ArrayList<VehiclePanel> vehiclePanelArray;     // array to hold all vehiclePanels
    private ArrayList<JPanel> panelHolder;                 // array used to create a grid of blank jPanels
    private ArrayList<Boolean> vehiclePanelClickedFlags;   // array used as a flag for each element in vehiclePanelArray
                                                           //  andpanelHolder when a vehiclePanle is clicked
    private GridBagConstraints gbc = new GridBagConstraints ();    // constraints used to control the layout of the grid
    private int trueCount = 0;                             // number of vehicle panels selected
    private int vehicleCount = 0;                          // count of vehicles in vehiclePanelArray
    
    private int indicator = -1;                            // indicicates what element from the three arrays to remove
                                                           //  when deletePanel is called
    private int pos1 = -1, pos2 = -1;
    
        

    /**
     * Creates new form VehicleGrid
     */
    public VehicleGrid() {
        this.setToolTipText("Click on the 'Add New Vehicle' panel to create and add vehicles to vehicle grid.");
        addKeyListener(this);
        this.setFocusable(true);
        
        
        addNewVehiclePanel1 = new AddNewVehiclePanel();
        addNewVehiclePanel1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        vehiclePanelArray = new ArrayList<>();
        panelHolder = new ArrayList<>();
        addNewVehiclePanel1.addMouseListener(this);
        addNewVehiclePanel1.setToolTipText("Click this panel to create and add vehicle to vehicle grid.");
        
        initializeFlags();
        initComponents();
        
        
        remove(addNewVehiclePanel1);
        setLayout(new GridBagLayout()); 
        createPlaceHolderPanelGrid();     
        
        panelHolder.get(0).removeAll();
        panelHolder.get(0).add(addNewVehiclePanel1);
        reDraw();
        
    }
    
    /**
     * createPlaceHolderPanelGrid() method uses panelHolder to create a 2 x 16 grid of blank panels that 
     *  will dynamically increase as vehiclePanels are added to each blank panel
     */
    private void createPlaceHolderPanelGrid() {
        
        for(int m = 0; m < 16; m++) {
            if (m >= 8) {
                gbc.gridx = m - 8;
                gbc.gridy = 1; 
            }
            else {  
                gbc.gridx = m;  
                gbc.gridy = 0;
            }
                panelHolder.add(new JPanel());
                panelHolder.get(m).setBackground((new java.awt.Color(194,178,128)));
                add(panelHolder.get(m), gbc);
        }
        
    }
    
   
    /**
     * reDraw() removes all elements from the panel and draws elements from the 
     *  panelHolder array 
     */
    private void reDraw() {
        
        this.removeAll();
        gbc = new GridBagConstraints();
        
        for(int m = 0; m < panelHolder.size(); m++) {
            if (m >= 8) {
                gbc.gridx = m - 8;
                gbc.gridy = 1; 
            }
            else {  
                gbc.gridx = m;  
                gbc.gridy = 0;
            }
            
            add(panelHolder.get(m), gbc);
        }
        
        revalidate();
        repaint();
    }
    
    /**
     * initializeFlags() initializes all boolean elements to false in the 
     */
    private void initializeFlags() {
        vehiclePanelClickedFlags = new ArrayList<>();
        
        for (int i = 0; i < MAX_VEHICLES; i++) {
            vehiclePanelClickedFlags.add(new Boolean(false));            
        }
    }
    
    /**
     * setFlag(int counter) sets the truth value of vehiclePanelClickedFlags.get(counter) 
     *  (which is parallel to vehiclePanelArray.get(counter)) which indicates that the 
     *  VehiclePanel at vehiclePanelArray.get(counter) has been clicked
     * @param counter indicates which VehiclePanel from vehiclePanelArray provoked mouseClicked
     */
    private void setFlag(int counter) {
        
        if (pos1 == -1) 
            clearBorders();
        
        
        if (trueCount < 2) {            
            if (vehiclePanelClickedFlags.get(counter).getTruthValue() == false) {
                vehiclePanelClickedFlags.get(counter).setTruthValue(true);
                addBorder(counter, 1);  
                trueCount++;
                swapPanel();
            }
            else if (vehiclePanelClickedFlags.get(counter).getTruthValue() == true) {
                vehiclePanelClickedFlags.get(counter).setTruthValue(false);
                --trueCount;
                pos1 = pos2 = -1;
                addBorder(counter, 0);
            }
        }  else if (trueCount >= 2) {
            if (vehiclePanelClickedFlags.get(counter).getTruthValue() == true) {
                vehiclePanelClickedFlags.get(counter).setTruthValue(false);
                --trueCount;
                pos1 = pos2 = -1;
                addBorder(counter, 0);
            }            
        }       
    }
    
    /**
     * addBorder(int counter, int flag) adds/removes a red border to a vehiclePanel
     * @param counter used to set indicator value
     * @param flag if 1, will add red border to vehiclePanelArray.get(counter)
     *             if 0, will remove red border to vehiclePanelArray.get(counter)
     */
    private void addBorder(int counter, int flag) {
        
        indicator = counter;
        this.setFocusable(true);
        this.requestFocusInWindow();
        
        if (flag == 1)
            vehiclePanelArray.get(counter).setBorder(BorderFactory.createMatteBorder(
                                    2, 2, 2, 2, Color.red));
        
        else if (flag == 0)
            vehiclePanelArray.get(counter).setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    }
    
    /**
     * clearBorders() method clears the borders of all VehiclePanel's in vehiclePanelArray
     */
    private void clearBorders() {
        
        for (int i = 0; i < vehiclePanelArray.size(); i++) {
            vehiclePanelArray.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        }
        
    }
        
    /**
     * addVehiclePanel() adds a vehiclePanel to the next available blank panel
     *  in the placeHolder array panel Grid
     * @param addVehiclePanel 
     */
    protected void addVehiclePanel(VehiclePanel vp) {
        
        if (vehicleCount < 16) {            
            
            vp.addMouseListener(this);
            vp.getDeleteButton().addActionListener(this);
            panelHolder.get(vehicleCount).removeAll();
            
            vehiclePanelArray.add(vp);
            
            panelHolder.get(vehicleCount).add(vehiclePanelArray.get(vehicleCount));
            
            ++vehicleCount;
            //JOptionPane.showMessageDialog(mainWindow, " " + vehicleCount);
            
            update();
            
        }
        
        revalidate();
        repaint();
    }   
    
    /**
     * update() draws either an addNewVehiclePanel to the grid if vehicleCount < 16
     *  else class mainWindow.showRightArrow
     */
    private void update() {
        if (vehicleCount < 16)
                panelHolder.get(vehicleCount).add(addNewVehiclePanel1);
            else
                mainWindow.showRightArrow();
    }
    
    public void replaceAddNewVehiclePanel(VehiclePanel vp) {
            
        addVehiclePanel(vp);
       
        revalidate();
        repaint();
    }

    /**
     * swapPanel() methods swaps the position of two selected VehiclePanels within the grid
     */
    private void swapPanel() {
                
        // this loop detects the first VehiclePanel selected during the swap process
        for (int i = 0; i < vehiclePanelClickedFlags.size(); i++) {
            if (vehiclePanelClickedFlags.get(i).getTruthValue() == true) {
                if (pos1 == -1) {
                    if (i == pos1)   
                        break;
                    else {
                        pos1 = i; break; 
                    }
                } 
            }
        }
        
        // this loop detects the second VehiclePanel selected during the swap process
        for (int i = 0; i < vehiclePanelClickedFlags.size(); i++) {
            if (vehiclePanelClickedFlags.get(i).getTruthValue() == true) {
                if (i != pos1)
                    pos2 = i; 
            }
        }
        
        if ((pos1 != -1) && (pos2 != -1) && (pos1 != pos2)) {      
            
            vehiclePanelArray.get(pos1).setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GREEN));
            vehiclePanelArray.get(pos2).setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.GREEN));
            vehiclePanelArray.get(pos1).setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.GREEN)); 
            
            vehiclePanelClickedFlags.get(pos1).setTruthValue(false);
            vehiclePanelClickedFlags.get(pos2).setTruthValue(false);
            trueCount = 0;
            
            Collections.swap(vehiclePanelClickedFlags, pos1, pos2);
            Collections.swap(vehiclePanelArray, pos1, pos2);
            Collections.swap(panelHolder, pos1, pos2);    
            removeAll();
            reDraw();
            
            pos1 = pos2 = -1;
        }                
    }
   
    /**
     * getVehiclePanelArray() method returns vehiclePanelArray
     * @return vehiclePanelArray
     */
    public ArrayList<VehiclePanel> getVehiclePanelArray() {
        return vehiclePanelArray;        
    }
    
 
    /**
     * getVehicleCount() method returns vehicleCount
     * @return vehicleCount
     */
    public int getVehicleCount() {
        return vehicleCount;
    }
    
    /**
     * deletePanel() removes panelHolder.get(indicator), vehiclePanelArray.get(indicator)
     *  vehiclePanelClickedFlags.get(indicator), decrements vehicleCount, trueCount and 
     *  expNumberOfVehicles
     */
    private void deletePanel() {
        
        for (int i = 0; i<vehiclePanelClickedFlags.size(); i++ ) {
            if (vehiclePanelClickedFlags.get(i).getTruthValue() == true) {
                int answer = JOptionPane.showConfirmDialog(this, "Are you sure that you want to delete this vehicle?", "Confirmation", JOptionPane.WARNING_MESSAGE);
                if (answer == 0) {                 
                    
                    vehiclePanelArray.get(indicator).removeMouseListener(this);
                    panelHolder.remove(indicator);
                    vehiclePanelArray.remove(indicator);
                    vehiclePanelClickedFlags.get(indicator).setTruthValue(false);
                    
                    --vehicleCount;
                    --trueCount;
                    
                    panelHolder.add(new JPanel());
                    panelHolder.get(15).setBackground((new java.awt.Color(194,178,128)));
                    update();
                    reDraw();
                    
                    revalidate();
                    repaint();
                    
                    break;
                }
            }
        }        
    }
    
    public void setMainWindow(MainWindow mw) {
        mainWindow = mw;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(194, 178, 128));
        setPreferredSize(new java.awt.Dimension(1724, 300));
        setLayout(new java.awt.GridLayout(1, 0));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    
    @Override
    public void keyTyped(KeyEvent e) {
        
        if (e.getKeyChar() == KeyEvent.VK_DELETE) {
            deletePanel();
        }        
    }
    
    @Override    
    public void mousePressed(MouseEvent e) {
         // handles vehiclePanelArray elements
        try {
            for (int i = 0; i < vehiclePanelArray.size() ; i++) {
                if (e.getSource() == vehiclePanelArray.get(i)) {  
                    
                    if (e.getClickCount() == 2) {
                        
                        AddVehiclePopUp avpp = new AddVehiclePopUp();
                        avpp.setObject(this);
                        avpp.setEditVehicleCounter(i); 
                        avpp.setCreateMode(false);
                        avpp.setEditMode(true);                           
                        avpp.getInfoFromVehiclePanel(vehiclePanelArray.get(i));
                        
                        
                                            
                        
                        /*
                        if((vehiclePanelArray.get(i).getSelection1() == 1) ||
                                (vehiclePanelArray.get(i).getSelection2() == 1) || 
                                (vehiclePanelArray.get(i).getSelection3() == 1))
                            MainWindow.setCC(false);
                        
                        
                        if((vehiclePanelArray.get(i).getSelection1() == 2) ||
                                (vehiclePanelArray.get(i).getSelection2() == 2) || 
                                (vehiclePanelArray.get(i).getSelection3() == 2))
                            MainWindow.setACC(false);*/
                        
                        avpp.setSelection1(vehiclePanelArray.get(i).getSelection1());
                        avpp.setSelection2(vehiclePanelArray.get(i).getSelection2());
                        avpp.setSelection3(vehiclePanelArray.get(i).getSelection3());
                        
                        avpp.setVisible(true);
                        
                        if(avpp.ccCheckBox.isSelected()){
                            avpp.accCheckBox.setEnabled(false);
                        }
                        
                        if(avpp.accCheckBox.isSelected()){
                            avpp.ccCheckBox.setEnabled(false);
                        }
                      
                    }
                                             
                    setFlag(i);
                    
                    break;
                }
            }
            
        } catch(IndexOutOfBoundsException ioobe) {} catch(NullPointerException npe) {}
         
        // handles replaceAddNewVehiclePanel
        if (e.getSource() == addNewVehiclePanel1) {
            
            
            addVehiclePopUp = new AddVehiclePopUp();
            addVehiclePopUp.setVisible(true);
            addVehiclePopUp.toFront();
            addVehiclePopUp.setObject(this);
            
            
            //replaceAddNewVehiclePanel(new VehiclePanel());  
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            for (int i = 0; i < vehiclePanelArray.size() ; i++) {
                if (e.getSource() == vehiclePanelArray.get(i).getDeleteButton()) {
                    setFlag(i);
                    deletePanel();
                    pos1 = pos2 = -1;
                    break;
                }
            }
        } catch(IndexOutOfBoundsException ioobe) {} catch(NullPointerException npe) {}
    }
    
    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
