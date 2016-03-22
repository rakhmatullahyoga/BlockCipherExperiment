/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.blockcipherexperiment;

import com.blockcipherexperiment.BlockCipherAlgorithm;
import com.blockcipherexperiment.Tools;
import java.io.UnsupportedEncodingException;

/**
 *
 * @author akhfa
 */
public class Test {
    public static void main(String[] args) throws UnsupportedEncodingException {
        Test.testBlockChiper();
    }
    
    private static void testRandom()
    {
        int [] array = Tools.getShuffledInts("a", 0, 5);
        
        for(int i : array)
        {
            System.err.println(i);
        }
    }
    private static void testBlockChiper() throws UnsupportedEncodingException
    {
        BlockCipherAlgorithm alg = new BlockCipherAlgorithm();
        alg.setKey("ABCDEFGHIJKLMNOP");
        alg.setPlain("ABCDEFGHIJKLMNOP".getBytes());
        alg.encrypt();
        System.err.println(Tools.bytesToString(alg.getCipher()));
        
        BlockCipherAlgorithm alg2 = new BlockCipherAlgorithm("ABCDEFGHIJKLMNOP", alg.getCipher());
        alg2.setKey("ABCDEFGHIJKLMNOP");
        alg2.setCipher(alg.getCipher());
        alg2.decrypt();
        System.err.println(Tools.bytesToString(alg2.getPlain()));
    }
    
    private static void testBitShift()
    {
        byte [] hasil = Tools.shiftLeft("ab".getBytes(), 7);
        Tools.printArray(Tools.convertToBoolArray(("ab".getBytes())));
        Tools.printArray(Tools.convertToBoolArray(hasil));
    }
    
    private static void testRightShift()
    {
        byte [] hasil = Tools.shiftRight("ab".getBytes(), 7);
        Tools.printArray(Tools.convertToBoolArray(("ab".getBytes())));
        Tools.printArray(Tools.convertToBoolArray(hasil));
    }
}
