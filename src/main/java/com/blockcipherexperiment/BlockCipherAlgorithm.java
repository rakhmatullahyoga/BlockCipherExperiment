/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blockcipherexperiment;

import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Rakhmatullah Yoga S
 * 16 byte kunci
 */
public class BlockCipherAlgorithm {
    private byte[] init;
    private String key; // key external dari mode selection
    private byte[] result;
    KeyHandler keyhandler;
    
    /**
     * Menginisialisasi BlockCipherAlgorithm.
     * @param _key Key yang digunakan untuk encrypt maupun decrypt
     * @param _byte Byte [] dari plain maupun chiper, tergantung akan enkripsi atau dekripsi
     * @param encrypt True jika akan encrypt, false jika decrypt
     */
    public BlockCipherAlgorithm(String _key, byte[] _byte){
        this.init = _byte;
        this.key = _key;
        keyhandler = new KeyHandler();
        keyhandler.setExternalKey(this.key);
    }
    
    public byte[] getPlain() {
        return init;
    }

    public void setPlain(byte[] plain) {
        this.init = plain;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public byte[] getCipher() {
        return result;
    }

    public void setCipher(byte[] cipher) {
        this.result = cipher;
    }
    
    /**
     * feistel untuk melakukan feistel setiap 16 byte
     */
    public void feistel()
    {
        // inisialisasi right left
        byte [] Left = new byte[init.length / 2];
        byte [] Right = new byte[init.length / 2];
        System.arraycopy(this.init, 0, Left, 0, init.length / 2);
        System.arraycopy(this.init, init.length / 2 , Right, 0, init.length / 2);
        
        // Mulai feistel per 16 byte
        for(int i = 0; i < 2; i++)
        {
            // simpan initial state
            byte [] LeftTemp = new byte[Left.length];
            System.arraycopy(Left, 0, LeftTemp, 0, Left.length);
            byte [] RightTemp = new byte[Right.length];
            System.arraycopy(Right, 0, RightTemp, 0, Right.length);
            
            // L = R-1
            System.arraycopy(Right, 0, Left, 0, Right.length);
            
            // R = L-1  XOR  R-1
            // Tambahkan fungsi F ke sini
            RightTemp = Tools.getShuffled(this.key, RightTemp);
            for(int idxbyte = 0; idxbyte < Right.length; idxbyte++)
            {
                byte temp = (byte) (LeftTemp[idxbyte] ^ RightTemp[idxbyte]);
                Right[idxbyte] = temp;
            }
        }
        
        // Gabungkan ke array result, dan diswap right left nya
        this.result = new byte[this.init.length];
        System.arraycopy(Right, 0, this.result, 0, Right.length);
        System.arraycopy(Left, 0, this.result, Right.length, Right.length);
        
        System.err.println(Tools.bytesToString(this.result));
    }
}
