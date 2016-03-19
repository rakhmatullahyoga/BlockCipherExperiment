/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blockcipherexperiment;

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
    
    public String swapKey(String key) {
        return key.substring(key.length()/2, key.length())+key.substring(0, key.length()/2);
    }
    
    /**
     * Get Internal key on specified level of Feistel network
     * @param level
     * @return 
     */
    public String getInternalKey(int level) {
        String internalKey = null;
        return internalKey;
    }
}
