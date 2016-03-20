/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blockcipherexperiment;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rakhmatullah Yoga S
 */
public class Main {
    public static void main(String[] args) {
        try {
            KeyHandler tools = new KeyHandler();
            System.out.println("Eksternal key: ABCDEFGHIJKLMNOP");
            System.out.println("Internal key");
            tools.setExternalKey("ABCDEFGHIJKLMNOP");
            for(int i=0; i<8; i++)
                System.out.println(tools.getInternalKey(i));
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
