/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.objects;

public class Radio {
    
    private final String freqName;
    private final String  freq;
    
    public Radio(String name, String freq){
        
        this.freqName = name;
        this.freq = freq;
        
    }
    
    public String getName(){
        return this.freqName;        
    }
    public String getFreq(){
        return this.freq;
    }
}


