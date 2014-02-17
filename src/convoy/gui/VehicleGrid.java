/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Oakes
 */
public class VehicleGrid extends javax.swing.JPanel {
    
    private ArrayList<VehiclePanel> vehiclePanelArray;              // array to hold all vehiclePanels
    private ArrayList<JPanel> panelHolder;                  // array used to create a grid of blank jPanels
    GridBagConstraints gbc = new GridBagConstraints ();    // constraints used to control the layout of the grid
    
    private int vehicleCount = 0;                          // count of vehicles in vehiclePanelArray
    private int columnCount = 0;                           // the column that a vehiclePanel will be added to in the 
                                                           //  placeHolder grid
    private int rowCount = 0;                              // the row that a vehiclePanel will be added to in the 
                                                           //  placeHolder grid
    

    /**
     * Creates new form VehicleGrid
     */
    public VehicleGrid() {
        vehiclePanelArray = new ArrayList<>();
        panelHolder = new ArrayList<>();
        initComponents();
        remove(addNewVehiclePanel1);
        setLayout(new GridBagLayout()); 
        createPlaceHolderPanelGrid();     
        
        panelHolder.get(0).add(addNewVehiclePanel1);       
        
        revalidate();
        repaint();
        
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
            panelHolder.get(vehicleCount).add(vehiclePanelArray.get(vehicleCount));
            ++vehicleCount;
            vehiclePanelMouseListenerUpdate();
            
            
            if (vehicleCount < 16 ) {
                panelHolder.get(vehicleCount).add(addNewVehiclePanel1);
            }
            else 
                repaint();
                revalidate(); 
        }        
    }
    
    /**
     * vehiclePanelMouseListenerUpdate() adds a mouse listener to each vehicle Panel as 
     *  they are created
     */
    private void vehiclePanelMouseListenerUpdate() {
        
        try {
            if (vehicleCount == 1) {
                vehiclePanelArray.get(0).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 0 ");
                        swapPanel(0, 1);
                    }
                });
            }

            if (vehicleCount == 2) {
                vehiclePanelArray.get(1).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 1 ");
                    }
                });
            }

            if (vehicleCount == 3) {
                vehiclePanelArray.get(2).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 2 ");
                    }
                });
            }

            if (vehicleCount == 4) {
                vehiclePanelArray.get(3).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 3 ");
                    }
                });
            }

            if (vehicleCount == 5) {
                vehiclePanelArray.get(4).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 4 ");
                    }
                });
            }

            if (vehicleCount == 6) {
                vehiclePanelArray.get(5).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 5 ");
                    }
                });
            }

            if (vehicleCount == 7) {
                vehiclePanelArray.get(6).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 6 ");
                    }
                });
            }

            if (vehicleCount == 8) {
                vehiclePanelArray.get(7).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 7 ");
                    }
                });
            }

            if (vehicleCount == 9) {
                vehiclePanelArray.get(8).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 8 ");
                    }
                });
            }

            if (vehicleCount == 10) {
                vehiclePanelArray.get(9).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 9 ");
                    }
                });
            }

            if (vehicleCount == 11) {
                vehiclePanelArray.get(10).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 10 ");
                    }
                });
            }

            if (vehicleCount == 12) {
                vehiclePanelArray.get(11).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 11 ");
                    }
                });
            }

            if (vehicleCount == 13) {
                vehiclePanelArray.get(12).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 12 ");
                    }
                });
            }

            if (vehicleCount == 14) {
                vehiclePanelArray.get(13).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 13 ");
                    }
                });
            }

            if (vehicleCount == 15) {
                vehiclePanelArray.get(14).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 14 ");
                    }
                });
            }

            if (vehicleCount == 16) {
                vehiclePanelArray.get(15).addMouseListener(new java.awt.event.MouseAdapter() {
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        System.out.println(" mouseClicked 15 ");
                    }
                });
            } 
            
        } catch(NullPointerException e) {           
        
        }
    }
    
    private void swapPanel(int panelCount1, int panelCount2) {
        
        panelHolder.get(panelCount1).removeAll();
        panelHolder.get(panelCount2).removeAll(); 
        
        panelHolder.get(panelCount1).add(vehiclePanelArray.get(panelCount2));
        panelHolder.get(panelCount2).add(vehiclePanelArray.get(panelCount1));
        
        Collections.swap(vehiclePanelArray, panelCount1, panelCount2);
        
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

        addNewVehiclePanel1 = new convoy.gui.AddNewVehiclePanel();

        setPreferredSize(new java.awt.Dimension(1724, 300));
        setLayout(new java.awt.GridLayout());

        addNewVehiclePanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addNewVehiclePanel1MouseClicked(evt);
            }
        });
        add(addNewVehiclePanel1);
    }// </editor-fold>//GEN-END:initComponents

    private void addNewVehiclePanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addNewVehiclePanel1MouseClicked

        addVehiclePanel(rowCount, columnCount);
        
        columnCount++;
        
        if (columnCount == 8) {
            rowCount = 1;
            columnCount = 0;
        }
        
        revalidate();
        repaint();
        // TODO add your handling code here:
    }//GEN-LAST:event_addNewVehiclePanel1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private convoy.gui.AddNewVehiclePanel addNewVehiclePanel1;
    // End of variables declaration//GEN-END:variables
}
