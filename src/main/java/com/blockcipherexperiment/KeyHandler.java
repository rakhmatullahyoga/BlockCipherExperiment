/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blockcipherexperiment;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rakhmatullah Yoga S
 */
public class KeyHandler {
    private String externalKey;
    
    public void setExternalKey(String key) {
        externalKey = key;
    }
    
    public String getKey() {
        return externalKey;
    }
    
    public List<Boolean> swapKey(List<Boolean> key) {
        List<Boolean> newKey = key.subList(key.size()/2, key.size());
        newKey.addAll(key.subList(0, key.size()/2));
        return newKey;
    }
    
    public List<Boolean> getSpecifiedKey(int level, List<Boolean> key) {
        if(level==0)
            return key;
        else if(level==1) {
            List<Boolean> left = new ArrayList<>(key.subList(0, key.size()/2));
            List<Boolean> right = new ArrayList<>(key.subList(key.size()/2, key.size()));
            
            List<Boolean> temp = right;
            temp.addAll(left);
            return temp;
        }
        else {
            List<Boolean> left = new ArrayList<>(key.subList(0, key.size()/2));
            List<Boolean> right = new ArrayList<>(key.subList(key.size()/2, key.size()));
            
            List<Boolean> temp1 = new ArrayList<>(getSpecifiedKey(level-1, right));
            List<Boolean> temp2 = new ArrayList<>(getSpecifiedKey(level-1, left));
            temp1.addAll(temp2);
            return temp1;
        }
    }
    
    public List<Boolean> strToBool(String key) {
        List<Boolean> bList = new ArrayList<>();
        for(int x=0; x<key.length(); x++) {
            boolean bit;
            char c= key.charAt(x);
            for(int i=0; i<8; i++) {
                bit = (c & (1 << 7-i))!=0;
                bList.add(bit);
            }
        }
        return bList;
    }
    
    public String boolToString(List<Boolean> bool) throws UnsupportedEncodingException {
        byte[] data = new byte[(int)bool.size()/8];
        for(int i=0; i<data.length; i++) {
            data[i] = 0;
            for(int j=0; j<8; j++)
                data[i] += ((bool.get(i*8+j)? 1:0) << (7-j));
        }
        return new String(data, "ISO-8859-1");
    }
    
    /**
     * Get Internal key on specified level of Feistel network
     * @param level 0-8
     * @return Internal key on specified level
     */
    public String getInternalKey(int level) throws UnsupportedEncodingException {
        String internalKey = externalKey;
        return boolToString(getSpecifiedKey(level, strToBool(internalKey)));
    }
}
