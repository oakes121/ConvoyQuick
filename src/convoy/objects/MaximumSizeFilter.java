
package convoy.objects;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.Element;

/**
 * @author Mike Moye <mtm5313@psu.edu>
 * @version 1.0
 * @since 2014-02-27
 *
 * <p>
 * This class is used to limit the maximum size of the text areas
 * </p>
 */
public class MaximumSizeFilter extends DocumentFilter {  
       
    private final int maxRows;  
    private final int maxCols;  
   
    /** 
     * Creates a new MaximumSizeFilter with a given row/column limit. 
     * This Filter limits the associated JTextComponent to this number of rows and columns. 
     * @param maxRows the maximum number of rows allowed 
     * @param maxCols the maximum number of columns allowed in any line 
     */  
    public MaximumSizeFilter (int maxRows, int maxCols) {  
        this.maxRows = maxRows;  
        this.maxCols = maxCols;  
    }  
   
    /**
     * 
     * @param fb
     * @param offset
     * @param str
     * @param attr
     * @throws BadLocationException 
     */
    @Override
    public void insertString (DocumentFilter.FilterBypass fb, int offset, String str, AttributeSet attr)  
            throws BadLocationException {  
        replace(fb, offset, 0, str, attr);  
    }  
   
    /**
     * 
     * @param fb
     * @param offset
     * @param length
     * @param str
     * @param attrs
     * @throws BadLocationException 
     */      
    @Override
    public void replace (DocumentFilter.FilterBypass fb, int offset, int length, String str, AttributeSet attrs)  
            throws BadLocationException {  
        Document doc = fb.getDocument();
        // Apply the insert/replace first, necessary corrections will be made below  
        fb.replace(offset, length, str, attrs); 
        // Get the root element, meaning the main text element containing the 'line' elements  
        Element root = doc.getDefaultRootElement();
        // Task 1: Find lines longer than maxCols  
        for (int index=0; index<root.getElementCount(); index++) {  
            Element e = root.getElement(index);  
            // "End Offset" is the position AFTER the last character  
            int lineLength = e.getEndOffset() - e.getStartOffset() - 1;  
            if (lineLength > this.maxCols) {  
                fb.remove(e.getStartOffset()+this.maxCols, lineLength-this.maxCols);  
            }  
        }     
        // Task 2: Clip everything after the last permissible row  
        if (root.getElementCount() > this.maxRows) {  
            int offsetInvalidRow = root.getElement(this.maxRows).getStartOffset();  
            // remove the \n of the previous row too  
            fb.remove(offsetInvalidRow - 1, root.getEndOffset() - offsetInvalidRow);  
        }
    }  
}      