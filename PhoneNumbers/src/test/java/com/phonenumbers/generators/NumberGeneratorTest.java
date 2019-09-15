/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonenumbers.generators;

import java.util.ArrayList;
import java.util.LinkedList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nikos
 */
public class NumberGeneratorTest {
    
    public NumberGeneratorTest() {
    }
    
   
 /**
     * Test of updateList method, of class NumberGenerator.
     */
    @Test
    public void testUpdateList_String() {
         LinkedList expected=new LinkedList<>();
        expected.add("1");
        String str1 = "1";
        NumberGenerator instance = new NumberGenerator();
        instance.getCombinations().add("");
        
        instance.updateList(str1);
       assertArrayEquals(expected.toArray(),instance.getCombinations().toArray());
    }

    /**
     * Test of updateList method, of class NumberGenerator.
     */
    @Test
    public void testUpdateList_String_String() {
        LinkedList expected=new LinkedList<>();
        expected.add("1");
        expected.add("2");
        String str1 = "1";
        String str2 = "2";
        NumberGenerator instance = new NumberGenerator();
        instance.getCombinations().add("");
        instance.updateList(str1, str2);
        assertArrayEquals(expected.toArray(),instance.getCombinations().toArray());
    }

    /**
     * Test of updateList method, of class NumberGenerator.
     */
    @Test
    public void testUpdateList_3args() {
        LinkedList expected=new LinkedList<>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        
        String str1 = "1";
        String str2 = "2";
        String str3 = "3";
        NumberGenerator instance = new NumberGenerator();
        instance.getCombinations().add("");
        instance.updateList(str1, str2, str3);
       assertArrayEquals(expected.toArray(),instance.getCombinations().toArray());
        
    }

    /**
     * Test of updateList method, of class NumberGenerator.
     */
    @Test
    public void testUpdateList_4args() {
        LinkedList expected=new LinkedList<>();
        expected.add("1");
        expected.add("2");
        expected.add("3");
        expected.add("4");
        
        String str1 = "1";
        String str2 = "2";
        String str3 = "3";
        String str4 = "4";
        NumberGenerator instance = new NumberGenerator();
        instance.getCombinations().add("");
        instance.updateList(str1, str2, str3, str4);
        assertArrayEquals(expected.toArray(),instance.getCombinations().toArray());
    }

    /**
     * Overloaded methods tested
     */


    /**
     * Test of inputHandler method, of class NumberGenerator.
     */
    @Test
    public void testInputHandler() {

    ArrayList<String> a=new ArrayList<>();
    LinkedList<String> expected=new LinkedList<>();
    LinkedList<String> result=new LinkedList<>();
    NumberGenerator instance = new NumberGenerator();

       
      //case: 1-digit 5
      a.add("5");
      expected.add("5");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 1-digit 5 and next 1-digit 5
      a.clear();
      result.clear();
      expected.clear();
      a.add("5");
      a.add("5");
      expected.add("55");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
       //case: 1-digit 5 and next 2-digit 25
      a.clear();
      result.clear();
      expected.clear();
      a.add("5");
      a.add("25");
      expected.add("525");
      expected.add("5205");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case 1-digit 5 and next 3-digit 100
      a.clear();
      result.clear();
      expected.clear();
      a.add("5");
      a.add("100");
      expected.add("5100");
     
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 2-digit 05
      a.clear();
      result.clear();
      expected.clear();
      a.add("05");
      expected.add("05");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 2-digit 12
       a.clear();
      result.clear();
      expected.clear();
      a.add("12");
      expected.add("12");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case 2-digit 10 and next 1-digit 0
       a.clear();
      result.clear();
      expected.clear();
      a.add("10");
      a.add("0");
      expected.add("100");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case 2-digit 10 and next 1-digit 5
       a.clear();
      result.clear();
      expected.clear();
      a.add("10");
      a.add("5");
      expected.add("105");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case 2-digit 20 and next 1-digit 0
      a.clear();
      result.clear();
      expected.clear();
      a.add("20");
      a.add("0");
      expected.add("200");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 2-digit 20 and next 1-digit 5
      a.clear();
      result.clear();
      expected.clear();
      a.add("20");
      a.add("5");
      expected.add("205");
      expected.add("25");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case 3-digit 020 and next 1-digit 0
      a.clear();
      result.clear();
      expected.clear();
      a.add("020");
      a.add("0");
      expected.add("0200");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case 3 digit 020 and next 1-digit 5
       a.clear();
      result.clear();
      expected.clear();
      a.add("020");
      a.add("5");
      expected.add("0205");
      expected.add("025");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 3-digit 015 
       a.clear();
      result.clear();
      expected.clear();
      a.add("015");
      expected.add("015");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 3-digit 005
      a.clear();
      result.clear();
      expected.clear();
      a.add("005");
      expected.add("005");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());

      //case: 3-digit 020 last element
      a.clear();
      result.clear();
      expected.clear();
      a.add("020");
      expected.add("020");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 3-digit 025
      a.clear();
      result.clear();
      expected.clear();
      a.add("025");
      expected.add("025");
      expected.add("0205");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 3-digit 725
      a.clear();
      result.clear();
      expected.clear();
      a.add("725");
      expected.add("725");
      expected.add("70025");
      expected.add("700205");
      expected.add("7205");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 3-digit 110
       a.clear();
      result.clear();
      expected.clear();
      a.add("110");
      expected.add("110");
      expected.add("10010");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 3-digit 205
      a.clear();
      result.clear();
      expected.clear();
      a.add("205");
      expected.add("205");
      expected.add("2005");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 3-digit 700 and next 2-digit 10
      a.clear();
      result.clear();
      expected.clear();
      a.add("700");
      a.add("10");
      expected.add("70010");
      expected.add("710");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 3-digit 700 and next 2-digit 10 and next 1-digit 5
       a.clear();
      result.clear();
      expected.clear();
      a.add("700");
      a.add("10");
      a.add("5");
      expected.add("700105");
      expected.add("7105");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 3-digit 700 and next 2-digit 05
      a.clear();
      result.clear();
      expected.clear();
      a.add("700");
      a.add("05");
      expected.add("70005");
      
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 3-digit 700 and next 2-digit 15
      a.clear();
      result.clear();
      expected.clear();
      a.add("700");
      a.add("15");
      expected.add("70015");
      expected.add("715");
      
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case: 3-digit 700 and next 2-digit 25
      a.clear();
      result.clear();
      expected.clear();
      a.add("700");
      a.add("25");
      expected.add("70025");
      expected.add("725");
      expected.add("700205");
      expected.add("7205");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      
      //case: 3-digit 100 and next 3-digit 222
      a.clear();
      result.clear();
      expected.clear();
      a.add("100");
      a.add("222");
      expected.add("100222");
      expected.add("10020022");
      expected.add("100200202");
      expected.add("1002202");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
      //case 3-digit 700 ,2-digit 20 ,1-digit 5--> 700 20 5
       a.clear();
      result.clear();
      expected.clear();
      a.add("700");
      a.add("20");
      a.add("5");
      expected.add("700205");
      expected.add("70025");
      expected.add("7205");
      expected.add("725");
      result=instance.inputHandler(a, 0);
      assertArrayEquals(expected.toArray(),result.toArray());
    }
    
    /*
    inputHandler method tested.
    Simultaneously combinationsGenerate method tested for different paths,as it has been invoked by inputHandler.
    Overloaded methods have been invoked too.Results were the expected.
    */
}
