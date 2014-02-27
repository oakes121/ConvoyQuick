/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.gui;

import convoy.objects.Radio;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author MTM5313
 */
public class RightMissionInfoPanel extends javax.swing.JPanel {

    private int addFreqCount = 1;

    /**
     * Creates new form rightMissionInfoPanel
     */
    public RightMissionInfoPanel() {

        initComponents();
        doFonts();
        doFreqs();

    }

    public String getCC() {
        return this.ccTextField.getText();
    }

    public String getACC() {
        return this.accTextField.getText();
    }

    public String getStagingArea() {
        return this.stagingAreaTextField.getText();
    }

    public String getFrom() {
        return this.fromTextField.getText();
    }

    public String getTo() {
        return this.toTextField.getText();
    }

    public String getFromLU() {
        return this.fromLinkUpTextField.getText();
    }

    public String getToLU() {
        return this.toTextField.getText();
    }

    public String getFromSP() {
        return this.fromSPTextField.getText();
    }

    public String getToSP() {
        return this.toSPTextField.getText();
    }

    public ArrayList<Radio> getFreqs() {

        ArrayList<Radio> freqs = new ArrayList();
        
        try{

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
        }catch(Exception ex){
            ex.printStackTrace();
            freqs.add(new Radio("", ""));
        }

        return freqs;
    }
    
    public String getAdditionalText(){
        return this.jTextArea1.getText();        
    }

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

    private void doFonts() {

        try {

            Font captureItFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/convoy/resources/fonts/captureIt.ttf"));
            captureItFont = captureItFont.deriveFont(Font.ITALIC, 12f);

            accLabel.setFont(captureItFont);
            ccLabel.setFont(captureItFont);
            fromLabel.setFont(captureItFont);
            fromSPLabel.setFont(captureItFont);
            fromLinkUpLabel.setFont(captureItFont);
            toLabel.setFont(captureItFont);
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

        ccLabel = new javax.swing.JLabel();
        ccTextField = new javax.swing.JTextField();
        accLabel = new javax.swing.JLabel();
        accTextField = new javax.swing.JTextField();
        stagingAreaLabel = new javax.swing.JLabel();
        stagingAreaTextField = new javax.swing.JTextField();
        fromLabel = new javax.swing.JLabel();
        toSPTextField = new javax.swing.JTextField();
        fromLinkUpLabel = new javax.swing.JLabel();
        toTextField = new javax.swing.JTextField();
        fromSPLabel = new javax.swing.JLabel();
        fromLinkUpTextField = new javax.swing.JTextField();
        toLabel = new javax.swing.JLabel();
        fromTextField = new javax.swing.JTextField();
        toLinkUpLabel = new javax.swing.JLabel();
        toLinkUpTextField = new javax.swing.JTextField();
        toSPLabel = new javax.swing.JLabel();
        fromSPTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
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

        ccLabel.setText("CC - ");

        accLabel.setText("ACC - ");

        stagingAreaLabel.setText("Staging Area - ");

        fromLabel.setText("From - ");

        fromLinkUpLabel.setText("L/U -");

        fromSPLabel.setText("SP -");

        toLabel.setText("To -");

        toLinkUpLabel.setText("L/U -");

        toSPLabel.setText("SP -");

        jTextArea1.setColumns(50);
        jTextArea1.setRows(5);
        jTextArea1.setText("Additional Information Goes Here");
        jScrollPane1.setViewportView(jTextArea1);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        freqPanel.setBackground(new java.awt.Color(255, 255, 255));

        freqLabel.setText("Frequencys - ");

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
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(freqPanelLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, freqPanelLayout.createSequentialGroup()
                                .addComponent(channelOneLabel)
                                .addGap(18, 18, 18)
                                .addComponent(channelOneName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(freqPanelLayout.createSequentialGroup()
                                .addComponent(channelFourLabel)
                                .addGap(18, 18, 18)
                                .addComponent(channelFourName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)))
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(channelFourFreq, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                            .addComponent(channelOneFreq))
                        .addGap(18, 18, 18)
                        .addGroup(freqPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(freqPanelLayout.createSequentialGroup()
                                .addComponent(channelTwoLabel)
                                .addGap(18, 18, 18)
                                .addComponent(channelTwoName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(channelTwoFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(channelThreeLabel)
                                .addGap(18, 18, 18)
                                .addComponent(channelThreeName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(channelThreeFreq))
                            .addGroup(freqPanelLayout.createSequentialGroup()
                                .addComponent(channelFiveLabel)
                                .addGap(18, 18, 18)
                                .addComponent(channelFiveName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(channelFiveFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(channelSixLabel)
                                .addGap(18, 18, 18)
                                .addComponent(channelSixName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(channelSixFreq))))))
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(toLabel)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(fromLabel)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fromTextField)
                            .addComponent(toTextField))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(toLinkUpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fromLinkUpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fromLinkUpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(toLinkUpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(toSPLabel)
                            .addComponent(fromSPLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(toSPTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                            .addComponent(fromSPTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ccLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ccTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(accLabel)
                                .addGap(10, 10, 10)
                                .addComponent(accTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(stagingAreaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stagingAreaTextField))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(freqPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
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
                    .addComponent(fromLabel)
                    .addComponent(fromSPLabel)
                    .addComponent(fromLinkUpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromLinkUpLabel)
                    .addComponent(fromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fromSPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(toLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toLinkUpLabel)
                    .addComponent(toLinkUpTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toSPLabel)
                    .addComponent(toSPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(freqPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

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
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "The frequency must be within a valid range.");
        }
    }//GEN-LAST:event_addFreqLabelMouseClicked

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
    private javax.swing.JLabel fromLabel;
    private javax.swing.JLabel fromLinkUpLabel;
    private javax.swing.JTextField fromLinkUpTextField;
    private javax.swing.JLabel fromSPLabel;
    private javax.swing.JTextField fromSPTextField;
    private javax.swing.JTextField fromTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel stagingAreaLabel;
    private javax.swing.JTextField stagingAreaTextField;
    private javax.swing.JLabel toLabel;
    private javax.swing.JLabel toLinkUpLabel;
    private javax.swing.JTextField toLinkUpTextField;
    private javax.swing.JLabel toSPLabel;
    private javax.swing.JTextField toSPTextField;
    private javax.swing.JTextField toTextField;
    // End of variables declaration//GEN-END:variables
}
