package convoy.gui;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.text.AbstractDocument;

import convoy.objects.MaximumSizeFilter;
import convoy.objects.Radio;
import convoy.textEditor.com.metaphaseeditor.MetaphaseEditor;

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
        
        removeFreq1.setVisible(false);
        removeFreq2.setVisible(false);
        removeFreq3.setVisible(false);
        removeFreq4.setVisible(false);
        removeFreq5.setVisible(false);
        removeFreq6.setVisible(false);
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
        removeFreq1 = new javax.swing.JLabel();
        removeFreq2 = new javax.swing.JLabel();
        removeFreq3 = new javax.swing.JLabel();
        removeFreq4 = new javax.swing.JLabel();
        removeFreq5 = new javax.swing.JLabel();
        removeFreq6 = new javax.swing.JLabel();
        metaphaseEditor2 = new convoy.textEditor.com.metaphaseeditor.MetaphaseEditor();

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

        fromSPTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fromSPTextFieldActionPerformed(evt);
            }
        });

        freqPanel.setBackground(new java.awt.Color(255, 255, 255));
        freqPanel.setMaximumSize(new java.awt.Dimension(637, 64));

        freqLabel.setText("Frequencies - ");

        addFreqLabel.setForeground(new java.awt.Color(0, 51, 255));
        addFreqLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addFreqLabel.setText("<HTML><U>+ Add Freq</U></HTML>");
        addFreqLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addFreqLabelMouseClicked(evt);
            }
        });

        channelOneLabel.setText("CH1: ");

        channelOneName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                channelOneNameActionPerformed(evt);
            }
        });

        channelTwoLabel.setText("CH2: ");

        channelThreeLabel.setText("CH3: ");

        channelThreeFreq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                channelThreeFreqActionPerformed(evt);
            }
        });

        channelFourLabel.setText("CH4: ");

        channelFiveLabel.setText("CH5: ");

        channelSixLabel.setText("CH6: ");

        removeFreq1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/resources/images/removeFreq.png"))); // NOI18N
        removeFreq1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                removeFreq1MousePressed(evt);
            }
        });

        removeFreq2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/resources/images/removeFreq.png"))); // NOI18N

        removeFreq3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/resources/images/removeFreq.png"))); // NOI18N

        removeFreq4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/resources/images/removeFreq.png"))); // NOI18N

        removeFreq5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/resources/images/removeFreq.png"))); // NOI18N

        removeFreq6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/resources/images/removeFreq.png"))); // NOI18N

        javax.swing.GroupLayout freqPanelLayout = new javax.swing.GroupLayout(freqPanel);
        freqPanel.setLayout(freqPanelLayout);
        freqPanelLayout.setHorizontalGroup(
            freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(freqPanelLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(freqPanelLayout.createSequentialGroup()
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(removeFreq1)
                            .addComponent(removeFreq4))
                        .addGap(5, 5, 5)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(channelFourLabel)
                            .addComponent(channelOneLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(channelOneName, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(channelFourName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(freqPanelLayout.createSequentialGroup()
                                .addComponent(channelFourFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(removeFreq5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(channelFiveLabel))
                            .addGroup(freqPanelLayout.createSequentialGroup()
                                .addComponent(channelOneFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(removeFreq2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(channelTwoLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(channelTwoName, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(channelFiveName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(freqPanelLayout.createSequentialGroup()
                                .addComponent(channelFiveFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(removeFreq6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(channelSixLabel))
                            .addGroup(freqPanelLayout.createSequentialGroup()
                                .addComponent(channelTwoFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(removeFreq3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(channelThreeLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(channelThreeName, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(channelSixName))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(channelSixFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(channelThreeFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(freqPanelLayout.createSequentialGroup()
                        .addComponent(freqLabel)
                        .addGap(1, 1, 1)
                        .addComponent(addFreqLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        freqPanelLayout.setVerticalGroup(
            freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(freqPanelLayout.createSequentialGroup()
                .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(freqLabel)
                    .addComponent(addFreqLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(removeFreq1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(channelOneFreq)
                        .addComponent(channelOneName)
                        .addComponent(channelTwoName)
                        .addComponent(channelTwoFreq)
                        .addComponent(channelThreeName)
                        .addComponent(channelThreeFreq, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(channelTwoLabel)
                        .addComponent(channelThreeLabel)
                        .addComponent(channelOneLabel))
                    .addGroup(freqPanelLayout.createSequentialGroup()
                        .addComponent(removeFreq2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(removeFreq3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(channelFourName)
                        .addComponent(channelFourFreq))
                    .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(channelFiveName)
                        .addComponent(channelFiveLabel)
                        .addComponent(channelFiveFreq))
                    .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(channelSixName)
                        .addComponent(channelSixFreq)
                        .addComponent(channelSixLabel))
                    .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(removeFreq6, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(channelFourLabel)
                            .addComponent(removeFreq4)))
                    .addComponent(removeFreq5))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ccLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(accLabel)
                                .addGap(18, 18, 18)
                                .addComponent(accTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stagingAreaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stagingAreaTextField))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(toLinkUpLabel)
                                .addGap(18, 18, 18)
                                .addComponent(toLinkUpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(toSPLabel)
                                .addGap(18, 18, 18)
                                .addComponent(toSPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fromLinkUpLabel)
                                .addGap(18, 18, 18)
                                .addComponent(fromLinkUpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fromSPLabel)
                                .addGap(18, 18, 18)
                                .addComponent(fromSPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(5, 5, 5))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(freqPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(metaphaseEditor2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
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
                .addComponent(freqPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(metaphaseEditor2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
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
                        
                        removeFreq1.setVisible(true);

                        addFreqCount++;

                        repaint();
                        revalidate();
                    } else if (response == JOptionPane.OK_OPTION && addFreqCount == 2) {
                        channelTwoLabel.setVisible(true);
                        channelTwoName.setVisible(true);
                        channelTwoFreq.setVisible(true);

                        channelTwoName.setText(freqName.getText());
                        channelTwoFreq.setText(freq.getText());
                        removeFreq2.setVisible(true);

                        addFreqCount++;
                    } else if (response == JOptionPane.OK_OPTION && addFreqCount == 3) {
                        channelThreeLabel.setVisible(true);
                        channelThreeName.setVisible(true);
                        channelThreeFreq.setVisible(true);

                        channelThreeName.setText(freqName.getText());
                        channelThreeFreq.setText(freq.getText());
                        
                        removeFreq3.setVisible(true);

                        addFreqCount++;

                        repaint();
                        revalidate();
                    } else if (response == JOptionPane.OK_OPTION && addFreqCount == 4) {
                        channelFourLabel.setVisible(true);
                        channelFourName.setVisible(true);
                        channelFourFreq.setVisible(true);

                        channelFourName.setText(freqName.getText());
                        channelFourFreq.setText(freq.getText());
                        
                        removeFreq4.setVisible(true);

                        addFreqCount++;

                        repaint();
                        revalidate();
                    } else if (response == JOptionPane.OK_OPTION && addFreqCount == 5) {
                        channelFiveLabel.setVisible(true);
                        channelFiveName.setVisible(true);
                        channelFiveFreq.setVisible(true);

                        channelFiveName.setText(freqName.getText());
                        channelFiveFreq.setText(freq.getText());
                        
                        removeFreq5.setVisible(true);

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
                        
                        removeFreq6.setVisible(true);

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

    private void removeFreq1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeFreq1MousePressed
                        channelOneLabel.setVisible(false);
                        channelOneName.setVisible(false);
                        channelOneFreq.setVisible(false);
                        removeFreq1.setVisible(false);
                        addFreqCount--;
    }//GEN-LAST:event_removeFreq1MousePressed

    private void fromSPTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fromSPTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fromSPTextFieldActionPerformed

    private void channelOneNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_channelOneNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_channelOneNameActionPerformed

    private void channelThreeFreqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_channelThreeFreqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_channelThreeFreqActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel accLabel;
    private javax.swing.JTextField accTextField;
    private javax.swing.JLabel addFreqLabel;
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
    private convoy.textEditor.com.metaphaseeditor.MetaphaseEditor metaphaseEditor2;
    private javax.swing.JLabel removeFreq1;
    private javax.swing.JLabel removeFreq2;
    private javax.swing.JLabel removeFreq3;
    private javax.swing.JLabel removeFreq4;
    private javax.swing.JLabel removeFreq5;
    private javax.swing.JLabel removeFreq6;
    private javax.swing.JLabel stagingAreaLabel;
    private javax.swing.JTextField stagingAreaTextField;
    private javax.swing.JLabel toLinkUpLabel;
    private javax.swing.JTextField toLinkUpTextField;
    private javax.swing.JLabel toSPLabel;
    private javax.swing.JTextField toSPTextField;
    // End of variables declaration//GEN-END:variables
}
