/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonenumbers.validation;

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
public class PhoneNumberValidatorTest {
    
    public PhoneNumberValidatorTest() {
    }
    
   

    /**
     * Test of checkIfNumberIsValidGreekPhoneNumber method, of class PhoneNumberValidator.
     */
    @Test
    public void testCheckIfNumberIsValidGreekPhoneNumber() {
           
        String number = "5555";
        boolean expResult = false;
        boolean result = PhoneNumberValidator.checkIfNumberIsValidGreekPhoneNumber(number);
        assertEquals(expResult, result);
        // test 10 digit not starting with 2 or 69
        number = "5102222222";
        expResult = false;
        result = PhoneNumberValidator.checkIfNumberIsValidGreekPhoneNumber(number);
        assertEquals(expResult, result);
        // test 14 digit number not starting with 0030
        number = "51022222220000";
        expResult = false;
        result = PhoneNumberValidator.checkIfNumberIsValidGreekPhoneNumber(number);
        assertEquals(expResult, result);
        // test 14 digit number starting with 0030 but not followed by 2 or 69
        number = "00301222220000";
        expResult = false;
        result = PhoneNumberValidator.checkIfNumberIsValidGreekPhoneNumber(number);
        assertEquals(expResult, result);
        // test valid case
        number = "2102222222";
        expResult = true;
        result = PhoneNumberValidator.checkIfNumberIsValidGreekPhoneNumber(number);
        assertEquals(expResult, result);
        // test valid case
        number = "6987540555";
        expResult = true;
        result = PhoneNumberValidator.checkIfNumberIsValidGreekPhoneNumber(number);
        assertEquals(expResult, result);
        // test valid case
        number = "00302102222222";
        expResult = true;
        result = PhoneNumberValidator.checkIfNumberIsValidGreekPhoneNumber(number);
        assertEquals(expResult, result);
        // test valid case
        number = "00306987540555";
        expResult = true;
        result = PhoneNumberValidator.checkIfNumberIsValidGreekPhoneNumber(number);
        assertEquals(expResult, result);
    }
    
}
