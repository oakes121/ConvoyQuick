package convoy.gui;

import convoy.objects.Radio;
import java.awt.*;
import java.beans.PropertyVetoException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @author Mike Moye <mtm5313@psu.edu>
 * @version 1.0
 * @since 2014-02-27
 *
 * <p>
 * This class is used to create right mission information panel.
 * </p>
 */
public class RightMissionInfoPanel extends javax.swing.JPanel {

    private int addFreqCount = 1; //counts the number of channels in the radio

    /**
     * Creates new form rightMissionInfoPanel
     */
    public RightMissionInfoPanel() {
        initComponents();
        doFonts();
        freqGrid1.setToolTipText("Click the blue text to add a new frequency.");
        //doFreqs();
    }

    /**
     * Gets the convoy commander
     *
     * @return this.ccTextField.getText()
     */
    public String getCC() {
        return this.ccTextField.getText();
    }

    /**
     * Gets the convoy assistant commander
     *
     * @return this.accTextField.getText()
     */
    public String getACC() {
        return this.accTextField.getText();
    }

    /**
     * Gets the convoy staging area
     *
     * @return this.stagingAreaTextField.getText()
     */
    public String getStagingArea() {
        return this.stagingAreaTextField.getText();
    }

    /**
     * Gets the beginning location of the convoy in the right mission
     * information panel
     *
     * @return this.fromTextField.getText()
     */
    //public String getFrom() {
    //return this.fromTextField.getText();
    //}
    /**
     * Gets the destination of the convoy in the right mission information panel
     *
     * @return this.toTextField.getText()
     */
    //public String getTo() {
    //return this.toTextField.getText();
    //}
    /**
     * Gets the link up time of the beginning location
     *
     * @return this.fromLinkUpTextField.getText()
     */
    public Date getFromLU() {
        return this.startPointLinkup.getDate();
    }

    /**
     * Gets the link up time of the destination
     *
     * @return this.toTextField.getText()
     */
    public Date getToLU() {
        return this.rallyPointLinkup.getDate();
    }

    /**
     * Gets the SP time of the beginning location
     *
     * @return this.fromSPTextField.getText()
     */
    public Date getFromSP() {
        return this.startPointSP.getDate();
    }

    /**
     * Gets the SP time of the destination
     *
     * @return this.toSPTextField.getText()
     */
    public Date getToSP() {
        return this.rallyPointSP.getDate();
    }

    /**
     * Gets the additional information in the right mission information panel
     *
     * @return this.additonalText.getText()
     */
    public String getAdditionalText() {
        return this.metaphaseEditor2.getDocument();
    }

    /**
     * Sets the additional information in the right mission information panel
     *
     * @param text text to be set
     */
    public void setAddtionalText(String text) {
        this.metaphaseEditor2.setDocument(text);
    }

    /**
     * Set the convoy commander
     *
     * @param cc convoy commander
     */
    public void setCC(String cc) {
        this.ccTextField.setText(cc);
    }

    /**
     * Set the assistant convoy commander
     *
     * @param acc assistant convoy commander
     */
    public void setACC(String acc) {
        this.accTextField.setText(acc);
    }

    /**
     * Sets the convoy staging area
     *
     * @param stagingArea
     */
    public void setStagingArea(String stagingArea) {
        this.stagingAreaTextField.setText(stagingArea);
    }

    /**
     * Sets the beginning location of the right mission information panel
     *
     * @param from
     */
    //public void setFrom(String from) {
    //this.fromTextField.setText(from);
    //}
    /**
     * Sets the destination of the right information panel
     *
     * @param to
     */
    //public void setTo(String to) {
    //this.toTextField.setText(to);
    //}
    /**
     * Sets the link up time of the beginning location
     *
     * @param fromLU
     */
    public void setFromLU(Date fromLU) {
        try {
            this.startPointLinkup.setDate(fromLU);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RightMissionInfoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sets the link up time of the destination
     *
     * @param toLU
     */
    public void setToLU(Date toLU) {
        try {
            this.rallyPointLinkup.setDate(toLU);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RightMissionInfoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sets the SP time of the beginning location
     *
     * @param fromSP
     */
    public void setFromSP(Date fromSP) {
        try {
            this.startPointSP.setDate(fromSP);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RightMissionInfoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Sets the SP time of the destination
     *
     * @param toSP
     */
    public void setToSP(Date toSP) {
        try {
            this.rallyPointSP.setDate(toSP);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(RightMissionInfoPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getStartLinkUpTime() {
        if (startPointLinkUpTimeComoboBox.getSelectedIndex() == 0) {
            return timePicker2.getTime();
        } else {
            return timePicker2.getTime() + "Z";
        }
    }

    public String getStartSPTime() {
        if (this.startPointSPTimeComoboBox.getSelectedIndex() == 0) {
            return timePicker4.getTime();
        } else {
            return timePicker4.getTime() + "Z";
        }
    }

    public String getRallyLinkUpTime() {
        if (this.rallyPointLinkUpTimeComoboBox.getSelectedIndex() == 0) {
            return timePicker3.getTime();
        } else {
            return timePicker3.getTime() + "Z";
        }
    }

    public String getRallySPTime() {
        if (this.rallyPointSPTimeComoboBox.getSelectedIndex() == 0) {
            return timePicker5.getTime();
        } else {
            return timePicker5.getTime() + "Z";
        }
    }
    
    public int getStartLinkupTimeZone(){
        return this.startPointLinkUpTimeComoboBox.getSelectedIndex();
    }
    
    public int getStartSPTimZone(){
        return this.startPointSPTimeComoboBox.getSelectedIndex();
    }
    
    public int getRallyLinkUpTimeZone(){
        return this.rallyPointLinkUpTimeComoboBox.getSelectedIndex();
    }
    
    public int getRallSPTimeZone(){
        return this.rallyPointSPTimeComoboBox.getSelectedIndex();
    }
    
    public FreqGrid getFreqGrid() {
        return freqGrid1;
    }
    
    public void setStartLinkUpTime(String time) {
        timePicker2.setTime(time);
    }

    public void setStartSPTime(String time) {
        timePicker4.setTime(time);       
    }

    public void setRallyLinkUpTime(String time) {
        timePicker3.setTime(time);        
    }

    public void setRallySPTime(String time) {
        timePicker5.setTime(time);
    }
    
    public void setStartLinkupTimeZone(int zone){
        this.startPointLinkUpTimeComoboBox.setSelectedIndex(zone);
    }
    
    public void setStartSPTimZone(int zone){
        this.startPointSPTimeComoboBox.setSelectedIndex(zone);
    }
    
    public void setRallyLinkUpTimeZone(int zone){
        this.rallyPointLinkUpTimeComoboBox.setSelectedIndex(zone);
    }
    
    public void setRallSPTimeZone(int zone){
        this.rallyPointSPTimeComoboBox.setSelectedIndex(zone);
    }
    
    
    /**
     * Gets the name and frequency of all the channels in the radio
     *
     * @return freqs
     */ 
    public ArrayList<Radio> getFreqs() {

        ArrayList<Radio> freqs = new ArrayList();

        /*
        try {
            if (this.channelOneName.getText() != null && this.channelOneFreq.getText() != null) {
                freqs.add(new Radio(this.channelOneName.getText(), this.channelOneFreq.getText()));
            } else {
                freqs.add(new Radio("", ""));
            }
            if (this.channelTwoName.getText() != null && this.channelTwoFreq.getText() != null) {
                freqs.add(new Radio(this.channelTwoName.getText(), this.channelTwoFreq.getText()));
            } else {
                freqs.add(new Radio("", ""));
            }
            if (this.channelThreeName.getText() != null && this.channelThreeFreq.getText() != null) {
                freqs.add(new Radio(this.channelThreeName.getText(), this.channelThreeFreq.getText()));
            } else {
                freqs.add(new Radio("", ""));
            }
            if (this.channelFourName.getText() != null && this.channelFourFreq.getText() != null) {
                freqs.add(new Radio(this.channelFourName.getText(), this.channelFourFreq.getText()));
            } else {
                freqs.add(new Radio("", ""));
            }
            if (this.channelFiveName.getText() != null && this.channelFiveFreq.getText() != null) {
                freqs.add(new Radio(this.channelFiveName.getText(), this.channelFiveFreq.getText()));
            } else {
                freqs.add(new Radio("", ""));
            }
            if (this.channelSixName.getText() != null && this.channelSixFreq.getText() != null) {
                freqs.add(new Radio(this.channelSixName.getText(), this.channelSixFreq.getText()));
            }
        } catch (Exception ex) {
            //ex.printStackTrace();
            freqs.add(new Radio("", ""));
        } */
        return freqs;
    }

    /**
     * hides the channels
     */ /*
    private void doFreqs() {
        channelOneLabel.setVisible(false);
        channelOneName.setVisible(false);
        channelOneFreq.setVisible(false);
        channelTwoLabel.setVisible(false);
        channelTwoName.setVisible(false);
        channelTwoFreq.setVisible(false);
        channelThreeLabel.setVisible(false);
        channelThreeName.setVisible(false);
        channelThreeFreq.setVisible(false);
        channelFourLabel.setVisible(false);
        channelFourName.setVisible(false);
        channelFourFreq.setVisible(false);
        channelFiveLabel.setVisible(false);
        channelFiveName.setVisible(false);
        channelFiveFreq.setVisible(false);
        channelSixLabel.setVisible(false);
        channelSixName.setVisible(false);
        channelSixFreq.setVisible(false);

        removeFreq1.setVisible(false);
        removeFreq2.setVisible(false);
        removeFreq3.setVisible(false);
        removeFreq4.setVisible(false);
        removeFreq5.setVisible(false);
        removeFreq6.setVisible(false);
    } */

    /**
     * Sets and formats the fonts on the right mission information panel
     */
    private void doFonts() {
        try {
            Font captureItFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/convoy/resources/fonts/lucidaGrande.ttf"));
            captureItFont = captureItFont.deriveFont(Font.BOLD, 12f);

            accLabel.setFont(captureItFont);
            ccLabel.setFont(captureItFont);
            //fromLabel.setFont(captureItFont);
            fromSPLabel.setFont(captureItFont);
            fromLinkUpLabel.setFont(captureItFont);
            //toLabel.setFont(captureItFont);
            toSPLabel.setFont(captureItFont);
            toLinkUpLabel.setFont(captureItFont);
            stagingAreaLabel.setFont(captureItFont);
            //freqLabel.setFont(captureItFont);
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        metaphaseEditor1 = new convoy.textEditor.com.metaphaseeditor.MetaphaseEditor();
        metaphaseEditor3 = new convoy.textEditor.com.metaphaseeditor.MetaphaseEditor();
        ccLabel = new javax.swing.JLabel();
        ccTextField = new javax.swing.JTextField();
        accLabel = new javax.swing.JLabel();
        accTextField = new javax.swing.JTextField();
        stagingAreaLabel = new javax.swing.JLabel();
        stagingAreaTextField = new javax.swing.JTextField();
        fromLinkUpLabel = new javax.swing.JLabel();
        fromSPLabel = new javax.swing.JLabel();
        toLinkUpLabel = new javax.swing.JLabel();
        toSPLabel = new javax.swing.JLabel();
        startPointLinkUpTimeComoboBox = new javax.swing.JComboBox();
        rallyPointLinkUpTimeComoboBox = new javax.swing.JComboBox();
        startPointSPTimeComoboBox = new javax.swing.JComboBox();
        rallyPointSPTimeComoboBox = new javax.swing.JComboBox();
        startPointLinkup = new com.michaelbaranov.microba.calendar.DatePicker();
        rallyPointLinkup = new com.michaelbaranov.microba.calendar.DatePicker();
        startPointSP = new com.michaelbaranov.microba.calendar.DatePicker();
        rallyPointSP = new com.michaelbaranov.microba.calendar.DatePicker();
        timePicker2 = new convoy.gui.TimePicker();
        timePicker3 = new convoy.gui.TimePicker();
        timePicker4 = new convoy.gui.TimePicker();
        timePicker5 = new convoy.gui.TimePicker();
        metaphaseEditor2 = new convoy.textEditor.com.metaphaseeditor.MetaphaseEditor();
        freqGrid1 = new convoy.gui.FreqGrid();

        setBackground(new java.awt.Color(194, 178, 128));

        ccLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ccLabel.setText("CC : ");

        ccTextField.setToolTipText("Convoy Commander");

        accLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accLabel.setText("ACC: ");

        accTextField.setToolTipText("Assistant Convoy Commander");

        stagingAreaLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        stagingAreaLabel.setText("Staging Area: ");

        fromLinkUpLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fromLinkUpLabel.setText("Start Point Linkup Time:");

        fromSPLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        fromSPLabel.setText("Start Point SP Time:");

        toLinkUpLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        toLinkUpLabel.setText("Rally Point Linkup Time:");

        toSPLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        toSPLabel.setText("Rally Point SP Time:");

        startPointLinkUpTimeComoboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Local", "Zulu" }));

        rallyPointLinkUpTimeComoboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Local", "Zulu" }));

        startPointSPTimeComoboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Local", "Zulu" }));

        rallyPointSPTimeComoboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Local", "Zulu" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(metaphaseEditor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ccLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(accLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(accTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stagingAreaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stagingAreaTextField))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fromLinkUpLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(startPointLinkup, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(toLinkUpLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rallyPointLinkup, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(timePicker3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(timePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(startPointLinkUpTimeComoboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rallyPointLinkUpTimeComoboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(toSPLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rallyPointSP, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(timePicker5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rallyPointSPTimeComoboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fromSPLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(startPointSP, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(timePicker4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(startPointSPTimeComoboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(freqGrid1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ccLabel)
                    .addComponent(ccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(accLabel)
                    .addComponent(accTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stagingAreaLabel)
                    .addComponent(stagingAreaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fromSPLabel)
                        .addComponent(fromLinkUpLabel)
                        .addComponent(startPointLinkUpTimeComoboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(startPointLinkup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startPointSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timePicker2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startPointSPTimeComoboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timePicker4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rallyPointLinkup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(toLinkUpLabel)
                                .addComponent(rallyPointSPTimeComoboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(timePicker3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rallyPointLinkUpTimeComoboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(toSPLabel))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(rallyPointSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(timePicker5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(freqGrid1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(metaphaseEditor2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accLabel;
    private javax.swing.JTextField accTextField;
    private javax.swing.JLabel ccLabel;
    private javax.swing.JTextField ccTextField;
    private convoy.gui.FreqGrid freqGrid1;
    private javax.swing.JLabel fromLinkUpLabel;
    private javax.swing.JLabel fromSPLabel;
    private javax.swing.JLayeredPane jLayeredPane1;
    private convoy.textEditor.com.metaphaseeditor.MetaphaseEditor metaphaseEditor1;
    private convoy.textEditor.com.metaphaseeditor.MetaphaseEditor metaphaseEditor2;
    private convoy.textEditor.com.metaphaseeditor.MetaphaseEditor metaphaseEditor3;
    private javax.swing.JComboBox rallyPointLinkUpTimeComoboBox;
    private com.michaelbaranov.microba.calendar.DatePicker rallyPointLinkup;
    private com.michaelbaranov.microba.calendar.DatePicker rallyPointSP;
    private javax.swing.JComboBox rallyPointSPTimeComoboBox;
    private javax.swing.JLabel stagingAreaLabel;
    private javax.swing.JTextField stagingAreaTextField;
    private javax.swing.JComboBox startPointLinkUpTimeComoboBox;
    private static com.michaelbaranov.microba.calendar.DatePicker startPointLinkup;
    private com.michaelbaranov.microba.calendar.DatePicker startPointSP;
    private javax.swing.JComboBox startPointSPTimeComoboBox;
    private static convoy.gui.TimePicker timePicker2;
    private convoy.gui.TimePicker timePicker3;
    private convoy.gui.TimePicker timePicker4;
    private convoy.gui.TimePicker timePicker5;
    private javax.swing.JLabel toLinkUpLabel;
    private javax.swing.JLabel toSPLabel;
    // End of variables declaration//GEN-END:variables
}
