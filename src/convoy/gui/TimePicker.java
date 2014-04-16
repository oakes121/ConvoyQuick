/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package convoy.gui;

import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Mike Moye <mtm5313@psu.edu>
 */
public class TimePicker extends JPanel{
    
    public TimePicker(){
        this.add(buildTimePicker());
        this.setBorder(new EmptyBorder(0, 0, 0, 0) );
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }
    
    private JSpinner buildTimePicker(){        
        JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
        JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date());
        
        return timeSpinner;
        
    }   
    
}
