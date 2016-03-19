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
public class BlockCipherAlgorithm {
    private byte[] plain;
    private String key;
    private byte[] cipher;

    public byte[] getPlain() {
        return plain;
    }

    public void setPlain(byte[] plain) {
        this.plain = plain;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public byte[] getCipher() {
        return cipher;
    }

    public void setCipher(byte[] cipher) {
        this.cipher = cipher;
    }
}
