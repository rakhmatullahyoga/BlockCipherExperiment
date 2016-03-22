/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blockcipherexperiment;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rakhmatullah Yoga S
 */
public class ModeSelection {
    private String plain;
    private String key;
    private String cipher;

    public String getPlain() {
        return plain;
    }

    public void setPlain(String plain) {
        this.plain = plain;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) throws Exception {
        if(key.length()!=16)
            throw new Exception("Key must be 16 bytes length!");
        this.key = key;
    }

    public String getCipher() {
        return cipher;
    }

    public void setCipher(String cipher) {
        this.cipher = cipher;
    }
    
    public void encryptECB() {
        try {
            String[] plainBlocks = plain.split("(?<=\\G.{16})");
            byte[] encrypted = new byte[plain.length()];
            for(int i=0; i<plainBlocks.length; i++) {
                BlockCipherAlgorithm algo = new BlockCipherAlgorithm();
                algo.setPlain(plainBlocks[i].getBytes());
                algo.setKey(key);
                //Encryption (algo.encrypt())
                byte[] enc = algo.getCipher();
                System.arraycopy(enc, 0, encrypted, i*16, enc.length);
            }
            cipher = new String(encrypted,"ISO-8859-1");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ModeSelection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void decryptECB() {
        try {
            String[] cipherBlocks = cipher.split("(?<=\\G.{16})");
            byte[] decrypted = new byte[cipher.length()];
            for(int i=0; i<cipherBlocks.length; i++) {
                BlockCipherAlgorithm algo = new BlockCipherAlgorithm();
                algo.setCipher(cipherBlocks[i].getBytes());
                algo.setKey(key);
                //Encryption (algo.decrypt())
                byte[] dec = algo.getPlain();
                System.arraycopy(dec, 0, decrypted, i*16, dec.length);
            }
            plain = new String(decrypted,"ISO-8859-1");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ModeSelection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public byte[] XOR(byte[] plainCurrent, byte[] prevCipher) {
        byte[] res = new byte[plainCurrent.length];
        for(int i=0; i<res.length; i++) {
            res[i] = (byte) (((int)plainCurrent[i]^(int)prevCipher[i])&0xff);
        }
        return res;
    }
    
    public byte[] generateInitVector(int seed) {
        byte[] initVector = new byte[16];
        Random rand = new Random(seed);
        for(int i=0; i<initVector.length; i++) {
            initVector[i] = (byte) rand.nextInt(256);
        }
        return initVector;
    }
    
    public int getSeedFromKey(String key) {
        int seed = 0;
        for(int i=0; i<key.length(); i++)
            seed += (int) key.charAt(i);
        return seed;
    }
    
    public void encryptCBC() {
        try {
            String[] plainBlocks = plain.split("(?<=\\G.{16})");
            byte[] encrypted = new byte[plain.length()];
            byte[] enc = null;
            for(int i=0; i<plainBlocks.length; i++) {
                BlockCipherAlgorithm algo = new BlockCipherAlgorithm();
                byte[] inputPlain;
                if(i==0) {
                    inputPlain = XOR(plainBlocks[i].getBytes(), generateInitVector(getSeedFromKey(key)));
                }
                else {
                    inputPlain = XOR(plainBlocks[i].getBytes(), enc);
                }
                algo.setPlain(inputPlain);
                algo.setKey(key);
                //Encryption (algo.encrypt())
                enc = algo.getCipher();
                System.arraycopy(enc, 0, encrypted, i*16, enc.length);
            }
            cipher = new String(encrypted,"ISO-8859-1");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ModeSelection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void decryptCBC() {
        try {
            String[] cipherBlocks = cipher.split("(?<=\\G.{16})");
            byte[] decrypted = new byte[cipher.length()];
            byte[] dec = null;
            for(int i=0; i<cipherBlocks.length; i++) {
                BlockCipherAlgorithm algo = new BlockCipherAlgorithm();
                algo.setCipher(cipherBlocks[i].getBytes());
                algo.setKey(key);
                //Encryption (algo.encrypt())
                dec = algo.getPlain();
                if(i==0) {
                    dec = XOR(dec, generateInitVector(getSeedFromKey(key)));
                }
                else {
                    dec = XOR(cipherBlocks[i-1].getBytes(), dec);
                }
                System.arraycopy(dec, 0, decrypted, i*16, dec.length);
            }
            plain = new String(decrypted,"ISO-8859-1");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ModeSelection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public byte[] shiftLeftBytes(byte[] input, byte LSB) {
        byte[] newBytes = new byte[input.length];
        for(int i=0; i<newBytes.length; i++) {
            if(i+1==newBytes.length)
                newBytes[i] = LSB;
            else
                newBytes[i] = input[i+1];
        }
        return newBytes;
    }
    
    public void encryptCFB() {
        try {
            byte[] plainBytes = plain.getBytes();
            byte[] cipherBytes = new byte[plainBytes.length];
            byte[] inputEnc = generateInitVector(getSeedFromKey(key));
            BlockCipherAlgorithm algo = new BlockCipherAlgorithm();
            algo.setKey(key);
            for(int i=0; i<plainBytes.length; i++) {
                algo.setPlain(inputEnc);
                //Encryption (algo.encrypt());
                cipherBytes[i] = (byte) (((int)plainBytes[i]^(int)algo.getCipher()[0])&0xff);
                inputEnc = shiftLeftBytes(inputEnc, cipherBytes[i]);
            }
            cipher = new String(cipherBytes,"ISO-8859-1");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ModeSelection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void decryptCFB() {
        try {
            byte[] cipherBytes = cipher.getBytes();
            byte[] plainBytes = new byte[cipherBytes.length];
            byte[] inputEnc = generateInitVector(getSeedFromKey(key));
            BlockCipherAlgorithm algo = new BlockCipherAlgorithm();
            algo.setKey(key);
            for(int i=0; i<plainBytes.length; i++) {
                algo.setPlain(inputEnc);
                //Encryption (algo.encrypt());
                plainBytes[i] = (byte) (((int)cipherBytes[i]^(int)algo.getCipher()[0])&0xff);
                inputEnc = shiftLeftBytes(inputEnc, cipherBytes[i]);
            }
            plain = new String(plainBytes,"ISO-8859-1");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ModeSelection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
