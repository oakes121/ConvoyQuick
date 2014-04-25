/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convoy.gui;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Oakes
 */
public class FreqGrid extends javax.swing.JPanel implements MouseListener {

    private GridBagConstraints gbc = new GridBagConstraints ();    // constraints used to control the layout of the grid
    private ArrayList<JPanel> panelHolder;                 // array used to create a grid of blank jPanels
    private ArrayList<FreqInfo> freqInfoArray;
    private JLabel addNewFreq;
    private int freqCount = 0;

    
    /**
     * Creates new form FreqGrid
     */
    public FreqGrid() {
        panelHolder = new ArrayList<>();
        freqInfoArray = new ArrayList<>();
        addNewFreq = new JLabel("+ Add New Freq");
        addNewFreq.setForeground((new java.awt.Color(0,0,255)));
        addNewFreq.setToolTipText("Click here to add new frequency.");
        
        initComponents();        
        setLayout(new GridBagLayout());
        createPlaceHolderPanelGrid();
        doFonts();
        
        
        addNewFreq.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addNewFreq.addMouseListener(this);
        panelHolder.get(0).removeAll();
        panelHolder.get(0).add(addNewFreq);
    }
    
    private void addFreqInfo(FreqInfo fi) {
        
        if (freqCount < 6) {
            fi.addMouseListener(this);
            fi.getRemoveFreq1().addMouseListener(this);
            fi.getRemoveFreq1().setCursor(new Cursor(Cursor.HAND_CURSOR));
            panelHolder.get(freqCount).removeAll();
            
            freqInfoArray.add(fi);
            
            panelHolder.get(freqCount).add(freqInfoArray.get(freqCount));
            
            ++freqCount;
            
            if (freqCount < 6)
                panelHolder.get(freqCount).add(addNewFreq);
        }
        
        revalidate();
        repaint();
        
        
    }
    
        /**
     * createPlaceHolderPanelGrid() method uses panelHolder to create a 2 x 16 grid of blank panels that 
     *  will dynamically increase as vehiclePanels are added to each blank panel
     */
    private void createPlaceHolderPanelGrid() {
        
        for(int m = 0; m < 6; m++) {
            if (m >= 3) {
                gbc.gridx = m - 3;
                gbc.gridy = 1; 
            }
            else {  
                gbc.gridx = m;  
                gbc.gridy = 0;
            }
                panelHolder.add(new JPanel());
                panelHolder.get(m).setBackground((new java.awt.Color(255,255,255)));
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
        
        for(int m = 0; m < 6; m++) {
            if (m >= 3) {
                gbc.gridx = m - 3;
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
     * deletePanel() removes panelHolder.get(indicator), vehiclePanelArray.get(indicator)
     *  vehiclePanelClickedFlags.get(indicator), decrements vehicleCount, trueCount and 
     *  expNumberOfVehicles
     */
    private void deletePanel(int count) {
        int answer = JOptionPane.showConfirmDialog(this, "Are you sure that you want to delete this frequency?", "Confirmation", JOptionPane.WARNING_MESSAGE);
        if (answer == 0) {  
            
            freqInfoArray.get(count).removeMouseListener(this);
            panelHolder.remove(count);
            freqInfoArray.remove(count);    
            --freqCount;
            FreqInfo.decrementFreqInfoCount();
            
            panelHolder.add(new JPanel());
            panelHolder.get(5).setBackground((new java.awt.Color(255,255,255)));
            
            if (freqCount == 5)
                    panelHolder.get(5).add(addNewFreq);
            
            reDraw();
            
                    
            revalidate();
            repaint();
        }  
    }
    
    /**
     * Sets and formats the fonts on the right mission information panel
     */
    private void doFonts() {
        try {
            Font captureItFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/convoy/resources/fonts/lucidaGrande.ttf"));
            captureItFont = captureItFont.deriveFont(Font.BOLD, 10f);

            this.addNewFreq.setFont(captureItFont);
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

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setMaximumSize(new java.awt.Dimension(637, 64));
        setPreferredSize(new java.awt.Dimension(637, 64));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 635, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void mousePressed(MouseEvent e) {
        
        if (e.getSource() == addNewFreq){  
            
            try {
                URL imgURL = getClass().getResource("/convoy/resources/images/radioFrequencyIcon.png");
                Icon icon = new ImageIcon(imgURL);
                JTextField freqName = new JTextField();
                JTextField freq = new JTextField();

                Object[] stuff = {"Freq Name: ", freqName, "Frequency:", freq};
                int response;
                response = JOptionPane.showConfirmDialog(this, stuff, "Add New Freq", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
                freqName.setFocusable(true);
                if (response == JOptionPane.CANCEL_OPTION) {
                } else {
                    if (freqName.getText().equalsIgnoreCase("")) {
                        JOptionPane.showMessageDialog(this, "Please provide a frequency name.");
                        e.setSource(addNewFreq);
                        mousePressed(e);
                    } else if(!Float.isNaN(Float.parseFloat(freq.getText()))) {
                        
                        FreqInfo fi = new FreqInfo();
                        fi.setChannelOneFreq(freq.getText());
                        fi.setChannelOneName(freqName.getText());
                        addFreqInfo(fi); 
                    }
                }
            } catch (HeadlessException | NumberFormatException ex) {
                
                JOptionPane.showMessageDialog(this, "The frequency must be a numerical value within a valid range.");
                e.setSource(addNewFreq);
                mousePressed(e);
            }
        }
        
        
        for (int i = 0; i < freqInfoArray.size(); i++) {
            if(e.getSource() == freqInfoArray.get(i).getRemoveFreq1()) {
                deletePanel(i);
            }
        }
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
