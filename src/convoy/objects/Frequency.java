/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convoy.objects;

import java.io.Serializable;

public class Frequency implements Serializable {

    private String freqName;
    private float freq;

    /**
     * 
     * @param freqName name of the frequency
     * @param freq number of frequency
     */
    public Frequency(String freqName, float freq) {
        this.freqName = freqName;
        this.freq = freq;
    }

    /**
     * setFreqName(String freqName) will set this.freqName to freqName;
     * @param freqName what this.freqName will be set to
     */
    public void setFreqName(String freqName) {
        this.freqName = freqName;
    }

    /**
     * setFreq(int freq) will set this.freq to freq
     * @param freqName what this.freq will be set to
     */
    public void setFreq(float freq) {
        this.freq = freq;
    }

    /**
     * getFreqName() will return freqName
     * @return freqName
     */
    public String getFreqName() {
        return freqName;
    }

    /**
     * getFreqName() will return freq
     * @return freq
     */
    public float getFreq() {
        return freq;
    }

}
