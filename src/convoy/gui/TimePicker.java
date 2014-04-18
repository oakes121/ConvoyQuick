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
    
    private JSpinner timeSpinner = new JSpinner( new SpinnerDateModel() );
    private JSpinner.DateEditor timeEditor = new JSpinner.DateEditor(timeSpinner, "HH:mm");
    
    public static void main(String[] args){
        //System.out.print(timeEditor.getTextField().getText());
    }
    
    public TimePicker(){
        this.add(buildTimePicker());
        this.setBorder(new EmptyBorder(0, 0, 0, 0) );
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }
    
    public void setTime(Date time){
        timeEditor.getTextField().setValue(time);
    }
    
    public String getTime(){
        return timeEditor.getTextField().getText();
    }
    
    private JSpinner buildTimePicker(){        
       
        timeSpinner.setEditor(timeEditor);
        timeSpinner.setValue(new Date());
                
        return timeSpinner;
        
    }   
    
}
