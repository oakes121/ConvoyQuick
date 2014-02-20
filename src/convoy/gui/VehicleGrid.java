/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
public class VehicleGrid extends javax.swing.JPanel implements KeyListener, MouseListener {
    
    private static final int MAX_VEHICLES = 16;
    private int expNumberOfVehicles = MAX_VEHICLES;          
    
    private ArrayList<VehiclePanel> vehiclePanelArray;     // array to hold all vehiclePanels
    private ArrayList<JPanel> panelHolder;                 // array used to create a grid of blank jPanels
    private ArrayList<Boolean> vehiclePanelClickedFlags;   // array used as a flag for each element in vehiclePanelArray
                                                           //  andpanelHolder when a vehiclePanle is clicked
    GridBagConstraints gbc = new GridBagConstraints ();    // constraints used to control the layout of the grid
    private int trueCount = 0;                             // number of vehicle panels selected
    private int vehicleCount = 0;                          // count of vehicles in vehiclePanelArray
    private int columnCount = 0;                           // the column that a vehiclePanel will be added to in the 
                                                           //  placeHolder grid
    private int rowCount = 0;                              // the row that a vehiclePanel will be added to in the 
                                                           //  placeHolder grid
    private final AddNewVehiclePanel addNewVehiclePanel1;
    private int indicator = -1;                            // indicicates what element from the three arrays to remove
                                                           //  when deletePanel is called
    
    private AddVehiclePopUp addVehiclePopUp = new AddVehiclePopUp();
    

    /**
     * Creates new form VehicleGrid
     */
    public VehicleGrid() {
        addKeyListener(this);
        this.setFocusable(true);
        addNewVehiclePanel1 = new AddNewVehiclePanel();
        vehiclePanelArray = new ArrayList<>();
        panelHolder = new ArrayList<>();
        
        addNewVehiclePanel1.addMouseListener(this);
        
        initializeFlags();
        initComponents();
        
        
        remove(addNewVehiclePanel1);
        setLayout(new GridBagLayout()); 
        createPlaceHolderPanelGrid();     
        
        panelHolder.get(0).add(addNewVehiclePanel1);
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
    
    private void setFlag(int counter) {
        
        
        if (trueCount < 2) {            
            if (vehiclePanelClickedFlags.get(counter).getTruthValue() == false) {
                vehiclePanelClickedFlags.get(counter).setTruthValue(true);
                addBorder(counter, 1);  
                trueCount++;
                swapPanel();
                //JOptionPane.showMessageDialog(this, "1 "+ trueCount, "count", JOptionPane.WARNING_MESSAGE);
            }
            else if (vehiclePanelClickedFlags.get(counter).getTruthValue() == true) {
                vehiclePanelClickedFlags.get(counter).setTruthValue(false);
                --trueCount;
                //JOptionPane.showMessageDialog(this, "2 "+ trueCount, "count", JOptionPane.WARNING_MESSAGE);
                addBorder(counter, 0);
            }
        }  else if (trueCount >= 2) {
            if (vehiclePanelClickedFlags.get(counter).getTruthValue() == true) {
                vehiclePanelClickedFlags.get(counter).setTruthValue(false);
                --trueCount;
                //JOptionPane.showMessageDialog(this, "3 "+ trueCount, "count", JOptionPane.WARNING_MESSAGE);
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
                                    5, 5, 5, 5, Color.red));
        
        else if (flag == 0)
            vehiclePanelArray.get(counter).setBorder(BorderFactory.createMatteBorder(
                                    0, 0, 0, 0, Color.red));
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
                panelHolder.get(m).setBackground((new java.awt.Color(255, 255, 255)));
                add(panelHolder.get(m), gbc);
        }
    }
    
    
    /**
     * addVehiclePanel(int row, int column) adds a vehiclePanel to the next available blank panel
     *  in the placeHolder array panel Grid
     * @param row specifies which row in the placeHolder grid to add a vehiclePanel to 
     * @param column specifies which column in the placeHolder grid to add a vehiclePanel to 
     */
    private void addVehiclePanel(int row, int column) {
        if (vehicleCount < 16) {
            panelHolder.get(vehicleCount).remove(addNewVehiclePanel1);
            
            
            
            vehiclePanelArray.add(new VehiclePanel());
            vehiclePanelArray.get(vehicleCount).addMouseListener(this);
            panelHolder.get(vehicleCount).add(vehiclePanelArray.get(vehicleCount));
            ++vehicleCount;
            
            //vehiclePanelMouseListenerUpdate();
            
            
            if (vehicleCount < expNumberOfVehicles ) {
                panelHolder.get(vehicleCount).add(addNewVehiclePanel1);
            }
            else 
                repaint();
                revalidate(); 
        }        
    }    

    /**
     * swapPanel() methods swaps the position of two different panels within the grid
     */
    private void swapPanel() {
        
        int pos1 = -1, pos2 = -1;
                
        for (int i = 0; i < vehiclePanelClickedFlags.size(); i++) {
            if (vehiclePanelClickedFlags.get(i).getTruthValue() == true) {
                pos1 = i; break;
            }
        }
        
        for (int i = 0; i < vehiclePanelClickedFlags.size(); i++) {
            if (vehiclePanelClickedFlags.get(i).getTruthValue() == true) {
                pos2 = i; 
            }
        }
        
        
        if ((pos1 != -1) && (pos2 != -1) && (pos1 != pos2)) {      
            vehiclePanelArray.get(pos1).setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.red));
            vehiclePanelArray.get(pos2).setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.red));
            vehiclePanelClickedFlags.get(pos1).setTruthValue(false);
            vehiclePanelClickedFlags.get(pos2).setTruthValue(false);
            trueCount = 0;
            
            Collections.swap(vehiclePanelClickedFlags, pos1, pos2);
            Collections.swap(vehiclePanelArray, pos1, pos2);
            Collections.swap(panelHolder, pos1, pos2);        
            removeAll();
            reDraw();
            
            
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

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1724, 300));
        setLayout(new java.awt.GridLayout(1, 0));
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

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
                    vehiclePanelClickedFlags.remove(indicator);
                    --vehicleCount;
                    --trueCount;
                    --expNumberOfVehicles;
                    
                    
                    reDraw();
                    
                    revalidate();
                    repaint();
                    
                    break;
                }
            }
        }        
    }
    
    /**
     * reDraw() removes all elements from the panel and draws elements from the 
     *  panelHolder array 
     */
    private void reDraw() {
        
        this.removeAll();
        
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
    
    @Override
    public void keyTyped(KeyEvent e) {
        
        if (e.getKeyChar() == KeyEvent.VK_DELETE) {
            deletePanel();
        }        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        // handles vehiclePanelArray elements
        try {
            for (int i = 0; i < vehiclePanelArray.size() ; i++) {
                if (e.getSource() == vehiclePanelArray.get(i)) {
                    setFlag(i);
                    break;
                }
                
            }
            
        } catch(IndexOutOfBoundsException ioobe) {} catch(NullPointerException npe) {}
         
        // handles addNewVehiclePanel1
        if (e.getSource() == addNewVehiclePanel1) {
            
            //addVehiclePopUp.setVisible(true);
            //addVehiclePopUp.toFront();
            
            addVehiclePanel(rowCount, columnCount);
            columnCount++;
            
            if (columnCount == 8) {
                rowCount = 1;
                columnCount = 0;
            }
            revalidate();
            repaint();
            
        }
    }

    public void keyPressed(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}
