/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.blockcipherexperiment;

import com.blockcipherexperiment.BlockCipherAlgorithm;
import com.blockcipherexperiment.Tools;

/**
 *
 * @author akhfa
 */
public class Test {
    public static void main(String[] args) {
        
        
        
    }
    
    private void testBlockChiper()
    {
        BlockCipherAlgorithm alg = new BlockCipherAlgorithm();
        alg.setPlain(Tools.stringToBytes("abcdefghijklmnop"));
        alg.feistel();
        
        BlockCipherAlgorithm alg2 = new BlockCipherAlgorithm();
        alg2.setPlain(alg.getCipher());
        alg2.feistel();
    }
    
    private void testBitShift()
    {
        byte [] hasil = Tools.shiftLeft("ab".getBytes(), 7);
        Tools.printArray(Tools.convertToBoolArray(("ab".getBytes())));
        Tools.printArray(Tools.convertToBoolArray(hasil));
    }
}
