
package convoy.gui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import javax.swing.JLabel;

/**
 *
 * @author Oakes Isaac
 * This class is the JPanel representation of the radio frequencies that will
 *  appear in the FreqGrid
 */
public class FreqInfo extends javax.swing.JPanel {
    
    private static int freqInfoCount = 0;

    /**
     * Creates new form FreqInfo
     */
    public FreqInfo() {
        initComponents();
        this.removeFreq1.setToolTipText("Click here to delete frequency.");
        freqInfoCount++;
        
        String channelOneLabelText = channelOneLabel.getText().substring(0,2) + "" + freqInfoCount + ":";
        channelOneLabel.setText(channelOneLabelText);        
    }
    
    /**
     * decrementFreqInfoCount() decrements 
     */
    public static void decrementFreqInfoCount() {
        freqInfoCount--;
    }

    /**
     * getRemoveFreq1() returns removeFreq1
     * @return removeFreq1
     */
    public JLabel getRemoveFreq1() {
        return removeFreq1;
    }
    
    /**
     * setChannelOneFreq(String txt) sets channelOneFreq's text to txt
     * @param txt the text that will appear in channelOneFreq's textfield
     */
    public void setChannelOneFreq(String txt) {
        this.channelOneFreq.setText(txt);
    }
    
    /**
     * setChannelOneName(String txt) sets channelOneName's text to txt
     * @param txt the text that will appear in channelOneName's textfield
     */
    public void setChannelOneName(String txt) {
        this.channelOneName.setText(txt);
    }
    
    /**
     * getFreqName() returns channelOneName.getText()
     * @return channelOneName.getText()
     */
    public String getFreqName() {
        return channelOneName.getText();
    }
    
    /**
     * getFreq() returns Integer.parseInt(channelOneFreq.getText())
     * @return Integer.parseInt(channelOneFreq.getText())
     */
    public float getFreq() {
        return Float.parseFloat(channelOneFreq.getText());
    }
    
    /**
     * Sets and formats the fonts on the right mission information panel
     */
    private void doFonts() {
        try {
            Font captureItFont = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/convoy/resources/fonts/lucidaGrande.ttf"));
            captureItFont = captureItFont.deriveFont(Font.PLAIN, 10f);

            this.channelOneFreq.setFont(captureItFont);
            this.channelOneName.setFont(captureItFont);
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

        removeFreq1 = new javax.swing.JLabel();
        channelOneLabel = new javax.swing.JLabel();
        channelOneName = new javax.swing.JTextField();
        channelOneFreq = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(176, 20));

        removeFreq1.setBackground(new java.awt.Color(255, 255, 255));
        removeFreq1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/convoy/resources/images/deleteIcon.png"))); // NOI18N
        removeFreq1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                removeFreq1MousePressed(evt);
            }
        });

        channelOneLabel.setBackground(new java.awt.Color(255, 255, 255));
        channelOneLabel.setText("CH ");

        channelOneName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                channelOneNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(removeFreq1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(channelOneLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(channelOneName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(channelOneFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(channelOneName, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(channelOneFreq, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(channelOneLabel))
                    .addComponent(removeFreq1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void removeFreq1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_removeFreq1MousePressed
       
    }//GEN-LAST:event_removeFreq1MousePressed

    private void channelOneNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_channelOneNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_channelOneNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField channelOneFreq;
    private javax.swing.JLabel channelOneLabel;
    private javax.swing.JTextField channelOneName;
    private javax.swing.JLabel removeFreq1;
    // End of variables declaration//GEN-END:variables
}