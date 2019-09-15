/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonenumbers.validation;

import java.util.ArrayList;
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
public class InputValidatorTest {
    
    public InputValidatorTest() {
    }
    
   

    /**
     * Test of validateInput method, of class InputValidator.
     */
    @Test
    public void testValidateInput() {
        System.out.println("validateInput");
        ArrayList<String> wordList = new ArrayList<>();
        //invalid input
        wordList.add("1");
        wordList.add("2");
        wordList.add("2345");
        boolean expResult = false;
        boolean result = InputValidator.validateInput(wordList);
        assertEquals(expResult, result);
        //invalid input
        wordList.clear();
        wordList.add("1234");
        expResult = false;
        result = InputValidator.validateInput(wordList);
        assertEquals(expResult, result);
        //valid input
        wordList.clear();
        wordList.add("1");
        wordList.add("2");
        wordList.add("234");
        expResult = true;
        result = InputValidator.validateInput(wordList);
        assertEquals(expResult, result);
        
        
    }
    
}
