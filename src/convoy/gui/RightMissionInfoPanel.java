package convoy.gui;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.AbstractDocument;

import convoy.objects.MaximumSizeFilter;
import convoy.objects.Radio;

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
        doFreqs();
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
    public String getFromLU() {
        return this.fromLinkUpTextField.getText();
    }

    /**
     * Gets the link up time of the destination
     *
     * @return this.toTextField.getText()
     */
    public String getToLU() {
        return this.toLinkUpTextField.getText();
    }

    /**
     * Gets the SP time of the beginning location
     *
     * @return this.fromSPTextField.getText()
     */
    public String getFromSP() {
        return this.fromSPTextField.getText();
    }

    /**
     * Gets the SP time of the destination
     *
     * @return this.toSPTextField.getText()
     */
    public String getToSP() {
        return this.toSPTextField.getText();
    }

    /**
     * Gets the additional information in the right mission information panel
     *
     * @return this.additonalText.getText()
     */
    public String getAdditionalText() {
        return this.additonalText.getText();
    }

    /**
     * Sets the additional information in the right mission information panel
     *
     * @param text text to be set
     */
    public void setAddtionalText(String text) {
        this.additonalText.setText(text);
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
    public void setFromLU(String fromLU) {
        this.fromLinkUpTextField.setText(fromLU);
    }

    /**
     * Sets the link up time of the destination
     *
     * @param toLU
     */
    public void setToLU(String toLU) {
        this.toLinkUpTextField.setText(toLU);
    }

    /**
     * Sets the SP time of the beginning location
     *
     * @param fromSP
     */
    public void setFromSP(String fromSP) {
        this.fromSPTextField.setText(fromSP);
    }

    /**
     * Sets the SP time of the destination
     *
     * @param toSP
     */
    public void setToSP(String toSP) {
        this.toSPTextField.setText(toSP);
    }

    /**
     * Gets the name and frequency of all the channels in the radio
     *
     * @return freqs
     */
    public ArrayList<Radio> getFreqs() {

        ArrayList<Radio> freqs = new ArrayList();

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
        }
        return freqs;
    }

    /**
     * hides the channels
     */
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
    }

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
            freqLabel.setFont(captureItFont);
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
        ccLabel = new javax.swing.JLabel();
        ccTextField = new javax.swing.JTextField();
        accLabel = new javax.swing.JLabel();
        accTextField = new javax.swing.JTextField();
        stagingAreaLabel = new javax.swing.JLabel();
        stagingAreaTextField = new javax.swing.JTextField();
        toSPTextField = new javax.swing.JTextField();
        fromLinkUpLabel = new javax.swing.JLabel();
        fromSPLabel = new javax.swing.JLabel();
        fromLinkUpTextField = new javax.swing.JTextField();
        toLinkUpLabel = new javax.swing.JLabel();
        toLinkUpTextField = new javax.swing.JTextField();
        toSPLabel = new javax.swing.JLabel();
        fromSPTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        additonalText = new javax.swing.JTextArea();
        freqPanel = new javax.swing.JPanel();
        freqLabel = new javax.swing.JLabel();
        addFreqLabel = new javax.swing.JLabel();
        channelOneLabel = new javax.swing.JLabel();
        channelOneFreq = new javax.swing.JTextField();
        channelOneName = new javax.swing.JTextField();
        channelTwoLabel = new javax.swing.JLabel();
        channelTwoName = new javax.swing.JTextField();
        channelTwoFreq = new javax.swing.JTextField();
        channelThreeLabel = new javax.swing.JLabel();
        channelThreeName = new javax.swing.JTextField();
        channelThreeFreq = new javax.swing.JTextField();
        channelFourLabel = new javax.swing.JLabel();
        channelFourName = new javax.swing.JTextField();
        channelFourFreq = new javax.swing.JTextField();
        channelFiveLabel = new javax.swing.JLabel();
        channelFiveName = new javax.swing.JTextField();
        channelFiveFreq = new javax.swing.JTextField();
        channelSixLabel = new javax.swing.JLabel();
        channelSixName = new javax.swing.JTextField();
        channelSixFreq = new javax.swing.JTextField();

        setBackground(new java.awt.Color(194, 178, 128));

        ccLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ccLabel.setText("CC : ");

        accLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        accLabel.setText("ACC: ");

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

        additonalText.setColumns(50);
        additonalText.setRows(5);
        additonalText.setText("Additional Information Goes Here");
        jScrollPane1.setViewportView(additonalText);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        AbstractDocument pDoc=(AbstractDocument)additonalText.getDocument();

        pDoc.setDocumentFilter(new MaximumSizeFilter(5, 60));

        additonalText.setMargin(new Insets(5,5,5,5));

        freqPanel.setBackground(new java.awt.Color(255, 255, 255));

        freqLabel.setText("Frequencies - ");

        addFreqLabel.setForeground(new java.awt.Color(0, 51, 255));
        addFreqLabel.setText("<HTML><U>+ Add Freq</U></HTML>");
        addFreqLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addFreqLabelMouseClicked(evt);
            }
        });

        channelOneLabel.setText("CH1: ");

        channelTwoLabel.setText("CH2: ");

        channelThreeLabel.setText("CH3: ");

        channelFourLabel.setText("CH4: ");

        channelFiveLabel.setText("CH5: ");

        channelSixLabel.setText("CH6: ");

        javax.swing.GroupLayout freqPanelLayout = new javax.swing.GroupLayout(freqPanel);
        freqPanel.setLayout(freqPanelLayout);
        freqPanelLayout.setHorizontalGroup(
            freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(freqPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(freqPanelLayout.createSequentialGroup()
                        .addComponent(freqLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addFreqLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(freqPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, freqPanelLayout.createSequentialGroup()
                                .addComponent(channelOneLabel)
                                .addGap(10, 10, 10)
                                .addComponent(channelOneName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(freqPanelLayout.createSequentialGroup()
                                .addComponent(channelFourLabel)
                                .addGap(10, 10, 10)
                                .addComponent(channelFourName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(channelFourFreq, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(channelOneFreq))
                        .addGap(10, 10, 10)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(freqPanelLayout.createSequentialGroup()
                                .addComponent(channelTwoLabel)
                                .addGap(10, 10, 10)
                                .addComponent(channelTwoName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(channelTwoFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(channelThreeLabel)
                                .addGap(10, 10, 10)
                                .addComponent(channelThreeName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(freqPanelLayout.createSequentialGroup()
                                .addComponent(channelFiveLabel)
                                .addGap(10, 10, 10)
                                .addComponent(channelFiveName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(channelFiveFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(channelSixLabel)
                                .addGap(10, 10, 10)
                                .addComponent(channelSixName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(channelSixFreq, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                            .addComponent(channelThreeFreq))
                        .addGap(78, 78, 78)))
                .addContainerGap())
        );
        freqPanelLayout.setVerticalGroup(
            freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(freqPanelLayout.createSequentialGroup()
                .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(freqLabel)
                    .addComponent(addFreqLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(channelOneLabel)
                    .addComponent(channelOneFreq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(channelOneName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(channelTwoLabel)
                    .addComponent(channelTwoName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(channelTwoFreq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(channelThreeLabel)
                    .addComponent(channelThreeName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(channelThreeFreq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(channelFourLabel)
                    .addComponent(channelFourName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(channelFourFreq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(channelFiveLabel)
                    .addComponent(channelFiveName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(channelFiveFreq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(channelSixLabel)
                    .addComponent(channelSixName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(channelSixFreq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(ccLabel)
                        .addGap(20, 20, 20)
                        .addComponent(ccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(accLabel)
                        .addGap(20, 20, 20)
                        .addComponent(accTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(stagingAreaLabel)
                        .addGap(20, 20, 20)
                        .addComponent(stagingAreaTextField))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(toLinkUpLabel)
                                .addGap(20, 20, 20)
                                .addComponent(toLinkUpTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fromLinkUpLabel)
                                .addGap(20, 20, 20)
                                .addComponent(fromLinkUpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromSPLabel)
                            .addComponent(toSPLabel))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toSPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fromSPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)
                    .addComponent(freqPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(10, 10, 10))
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
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stagingAreaLabel)
                    .addComponent(stagingAreaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fromSPLabel)
                    .addComponent(fromLinkUpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromLinkUpLabel)
                    .addComponent(fromSPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toLinkUpLabel)
                    .addComponent(toLinkUpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toSPLabel)
                    .addComponent(toSPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(freqPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    /**
     * <p>
     * Adds channels to the freqs table. The user must enter a frequency name
     * and the frequency entered must be a float.
     * </p>
     *
     * @param evt click add freq label
     */
    private void addFreqLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addFreqLabelMouseClicked
        try {
            java.net.URL imgURL = getClass().getResource("/convoy/resources/images/radioFrequencyIcon.png");

            Icon icon = new ImageIcon(imgURL);

            JTextField freqName = new JTextField();
            JTextField freq = new JTextField();

            Object[] stuff = {"Freq Name: ", freqName, "Frequency:", freq};
            int response;
            response = JOptionPane.showConfirmDialog(this, stuff, "Add New Freq", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, icon);
            freqName.requestFocus();
            if (response == JOptionPane.CANCEL_OPTION) {
            } else {
                if (freqName.getText().equalsIgnoreCase("")) {
                    JOptionPane.showMessageDialog(this, "Please provide a frequency name.");
                } else if (!Float.isNaN(Float.parseFloat(freq.getText()))) {
                    if (response == JOptionPane.OK_OPTION && addFreqCount == 1) {
                        channelOneLabel.setVisible(true);
                        channelOneName.setVisible(true);
                        channelOneFreq.setVisible(true);

                        channelOneName.setText(freqName.getText());
                        channelOneFreq.setText(freq.getText());

                        addFreqCount++;

                        repaint();
                        revalidate();
                    } else if (response == JOptionPane.OK_OPTION && addFreqCount == 2) {
                        channelTwoLabel.setVisible(true);
                        channelTwoName.setVisible(true);
                        channelTwoFreq.setVisible(true);

                        channelTwoName.setText(freqName.getText());
                        channelTwoFreq.setText(freq.getText());

                        addFreqCount++;
                    } else if (response == JOptionPane.OK_OPTION && addFreqCount == 3) {
                        channelThreeLabel.setVisible(true);
                        channelThreeName.setVisible(true);
                        channelThreeFreq.setVisible(true);

                        channelThreeName.setText(freqName.getText());
                        channelThreeFreq.setText(freq.getText());

                        addFreqCount++;

                        repaint();
                        revalidate();
                    } else if (response == JOptionPane.OK_OPTION && addFreqCount == 4) {
                        channelFourLabel.setVisible(true);
                        channelFourName.setVisible(true);
                        channelFourFreq.setVisible(true);

                        channelFourName.setText(freqName.getText());
                        channelFourFreq.setText(freq.getText());

                        addFreqCount++;

                        repaint();
                        revalidate();
                    } else if (response == JOptionPane.OK_OPTION && addFreqCount == 5) {
                        channelFiveLabel.setVisible(true);
                        channelFiveName.setVisible(true);
                        channelFiveFreq.setVisible(true);

                        channelFiveName.setText(freqName.getText());
                        channelFiveFreq.setText(freq.getText());

                        addFreqCount++;

                        repaint();
                        revalidate();
                    } else if (response == JOptionPane.OK_OPTION && addFreqCount == 6) {
                        channelSixLabel.setVisible(true);
                        channelSixName.setVisible(true);
                        channelSixFreq.setVisible(true);

                        channelSixName.setText(freqName.getText());
                        channelSixFreq.setText(freq.getText());

                        addFreqLabel.setVisible(false);

                        addFreqCount++;

                        repaint();
                        revalidate();
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException ex) {
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "The frequency must be within a valid range.");
        }
    }//GEN-LAST:event_addFreqLabelMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accLabel;
    private javax.swing.JTextField accTextField;
    private javax.swing.JLabel addFreqLabel;
    private javax.swing.JTextArea additonalText;
    private javax.swing.JLabel ccLabel;
    private javax.swing.JTextField ccTextField;
    private javax.swing.JTextField channelFiveFreq;
    private javax.swing.JLabel channelFiveLabel;
    private javax.swing.JTextField channelFiveName;
    private javax.swing.JTextField channelFourFreq;
    private javax.swing.JLabel channelFourLabel;
    private javax.swing.JTextField channelFourName;
    private javax.swing.JTextField channelOneFreq;
    private javax.swing.JLabel channelOneLabel;
    private javax.swing.JTextField channelOneName;
    private javax.swing.JTextField channelSixFreq;
    private javax.swing.JLabel channelSixLabel;
    private javax.swing.JTextField channelSixName;
    private javax.swing.JTextField channelThreeFreq;
    private javax.swing.JLabel channelThreeLabel;
    private javax.swing.JTextField channelThreeName;
    private javax.swing.JTextField channelTwoFreq;
    private javax.swing.JLabel channelTwoLabel;
    private javax.swing.JTextField channelTwoName;
    private javax.swing.JLabel freqLabel;
    private javax.swing.JPanel freqPanel;
    private javax.swing.JLabel fromLinkUpLabel;
    private javax.swing.JTextField fromLinkUpTextField;
    private javax.swing.JLabel fromSPLabel;
    private javax.swing.JTextField fromSPTextField;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel stagingAreaLabel;
    private javax.swing.JTextField stagingAreaTextField;
    private javax.swing.JLabel toLinkUpLabel;
    private javax.swing.JTextField toLinkUpTextField;
    private javax.swing.JLabel toSPLabel;
    private javax.swing.JTextField toSPTextField;
    // End of variables declaration//GEN-END:variables
}
