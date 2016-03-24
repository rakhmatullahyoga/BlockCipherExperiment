/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blockcipherexperiment;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Rakhmatullah Yoga S
 */
public class ModeSelection {
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

    public void setKey(String key) throws Exception {
        if(key.length()!=16)
            throw new Exception("Key must be 16 bytes length!");
        this.key = key;
    }

    public byte[] getCipher() {
        return cipher;
    }

    public void setCipher(byte[] cipher) {
        this.cipher = cipher;
    }
    
    public byte[] getBlock(byte[] data, int blockNum) {
        byte[] block = new byte[16];
        for(int i=0; i<block.length; i++) {
            block[i] = data[i+blockNum*16];
        }
        return block;
    }
    
    public void encryptECB() {
        byte[] encrypted = new byte[plain.length];
        for(int i=0; i<plain.length/16; i++) {
            BlockCipherAlgorithm algo = new BlockCipherAlgorithm();
            algo.setPlain(getBlock(plain, i));
            algo.setKey(key);
            algo.encrypt();
            byte[] enc = algo.getCipher();
            System.arraycopy(enc, 0, encrypted, i*16, enc.length);
        }
        cipher = encrypted;
    }
    
    public void decryptECB() {
        byte[] decrypted = new byte[cipher.length];
        for(int i=0; i<cipher.length/16; i++) {
            BlockCipherAlgorithm algo = new BlockCipherAlgorithm();
            algo.setCipher(getBlock(cipher, i));
            algo.setKey(key);
            algo.decrypt();
            byte[] dec = algo.getPlain();
            System.arraycopy(dec, 0, decrypted, i*16, dec.length);
        }
        plain = decrypted;
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
        byte[] encrypted = new byte[plain.length];
        byte[] enc = null;
        for(int i=0; i<plain.length/16; i++) {
            BlockCipherAlgorithm algo = new BlockCipherAlgorithm();
            byte[] inputPlain;
            if(i==0) {
                inputPlain = XOR(getBlock(plain, i), generateInitVector(getSeedFromKey(key)));
            }
            else {
                inputPlain = XOR(getBlock(plain, i), enc);
            }
            algo.setPlain(inputPlain);
            algo.setKey(key);
            algo.encrypt();
            enc = algo.getCipher();
            System.arraycopy(enc, 0, encrypted, i*16, enc.length);
        }
        cipher = encrypted;
    }
    
    public void decryptCBC() {
        byte[] decrypted = new byte[cipher.length];
        byte[] dec = null;
        for(int i=0; i<cipher.length/16; i++) {
            BlockCipherAlgorithm algo = new BlockCipherAlgorithm();
            algo.setCipher(getBlock(cipher, i));
            algo.setKey(key);
            algo.decrypt();
            dec = algo.getPlain();
            if(i==0) {
                dec = XOR(dec, generateInitVector(getSeedFromKey(key)));
            }
            else {
                dec = XOR(getBlock(cipher, i-1), dec);
            }
            System.arraycopy(dec, 0, decrypted, i*16, dec.length);
        }
        plain = decrypted;
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
        byte[] plainBytes = plain;
        byte[] cipherBytes = new byte[plainBytes.length];
        byte[] inputEnc = generateInitVector(getSeedFromKey(key));
        BlockCipherAlgorithm algo = new BlockCipherAlgorithm();
        algo.setKey(key);
        for(int i=0; i<plainBytes.length; i++) {
            algo.setPlain(inputEnc);
            algo.encrypt();
            cipherBytes[i] = (byte) (((int)plainBytes[i]^(int)algo.getCipher()[0])&0xff);
            inputEnc = shiftLeftBytes(inputEnc, cipherBytes[i]);
        }
        cipher = cipherBytes;
    }
    
    public void decryptCFB() {
        byte[] cipherBytes = cipher;
        byte[] plainBytes = new byte[cipherBytes.length];
        byte[] inputEnc = generateInitVector(getSeedFromKey(key));
        BlockCipherAlgorithm algo = new BlockCipherAlgorithm();
        algo.setKey(key);
        for(int i=0; i<plainBytes.length; i++) {
            algo.setPlain(inputEnc);
            algo.encrypt();
            plainBytes[i] = (byte) (((int)cipherBytes[i]^(int)algo.getCipher()[0])&0xff);
            inputEnc = shiftLeftBytes(inputEnc, cipherBytes[i]);
        }
        plain = plainBytes;
    }
    
    public void showPlainFrequency() {
        HashMap<Character,Integer> h = new HashMap<>();
        for(int i=0; i<plain.length; i++){
            if(h.containsKey((char)plain[i])){
                h.put((char)plain[i], h.get((char)plain[i]) + 1);
            } else {
                h.put((char)plain[i], 1);
            }
        }
        System.out.println(h);
    }
    
    public void showCipherFrequency() {
        HashMap<Character,Integer> h = new HashMap<>();
        for(int i=0; i<cipher.length; i++){
            if(h.containsKey((char)cipher[i])){
                h.put((char)cipher[i], h.get((char)cipher[i]) + 1);
            } else {
                h.put((char)cipher[i], 1);
            }
        }
        System.out.println(h);
    }
}
