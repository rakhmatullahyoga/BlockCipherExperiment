/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.blockcipherexperiment;

/**
 *
 * @author Rakhmatullah Yoga S
 * 16 byte kunci
 */
public class BlockCipherAlgorithm {
    private byte[] plain;
    private String key;
    private byte[] cipher;

    public BlockCipherAlgorithm()
    {
        plain = Tools.stringToBytes("abcdefghijklmnop");
    }
    
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
    
    public void feistel()
    {
        // inisialisasi right left
        byte [] Left = new byte[plain.length / 2];
        byte [] Right = new byte[plain.length / 2];
        System.arraycopy(this.plain, 0, Left, 0, plain.length / 2);
        System.arraycopy(this.plain, plain.length / 2 , Right, 0, plain.length / 2);
        
        // Mulai feistel
        for(int i = 0; i < 8; i++)
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
            for(int idxbyte = 0; idxbyte < Right.length; idxbyte++)
            {
                byte temp = (byte) (LeftTemp[idxbyte] ^ RightTemp[idxbyte]);
                Right[idxbyte] = temp;
            }
        }
    }
}
