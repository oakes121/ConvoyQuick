package convoy.gui;

import convoy.objects.MaximumSizeFilter;
import java.awt.Insets;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.AbstractDocument;

/**
 * @author Mike Moye <mtm5313@psu.edu>
 * @version 1.0
 * @since 2014-02-27
 *
 * <p>
 * This class is to create the text area at the bottom of the main window. It
 * gets and sets the text.
 * </p>
 */
public class AdditionalTextPanel extends javax.swing.JPanel {

    /**
     * Creates new form AdditionalTextPanel
     */
    public AdditionalTextPanel() {
        initComponents();
    }

    /**
     * Return the text that is in the additionalText text area.
     * @return addtionalText.getText()
     */
    public String getAdditionalText() {
        return this.addtionalText.getText();
    }

    /**
     * Sets the text for the additionalText text area.
     * @param text The text to be set in the additionalText text area.
     */
    public void setAdditionalText(String text) {
        this.addtionalText.setText(text);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        addtionalText = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(194, 178, 128));

        addtionalText.setColumns(20);
        addtionalText.setRows(5);
        addtionalText.setText("Additional Information Goes Here");
        jScrollPane1.setViewportView(addtionalText);
        jScrollPane1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        AbstractDocument pDoc=(AbstractDocument)addtionalText.getDocument();

        pDoc.setDocumentFilter(new MaximumSizeFilter(2, 250));
        addtionalText.setMargin(new Insets(5,5,5,5));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea addtionalText;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
