/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convoy.gui;

/**
 *
 * @author Oakes
 */
public class Boolean {
    
    private boolean truthValue;
    
    Boolean(boolean value) {
        truthValue = value;        
    }
    
    public void setTruthValue(boolean value) {
        truthValue = value;
    }
    
    public boolean getTruthValue() {
        return truthValue;
    }
    
}
