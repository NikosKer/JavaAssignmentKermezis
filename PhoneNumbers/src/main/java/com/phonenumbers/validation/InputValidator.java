/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonenumbers.validation;

import java.util.ArrayList;

/**
 *
 * @author nikos
 */
public class InputValidator {
    public static boolean validateInput(ArrayList<String> wordList){
      
        for (int x = 0; x < wordList.size(); x++) {
                    if(wordList.get(x).length()>3){//check if more than 3 digits typed in a row
                    return false;
                    }
                   // System.out.println("Data :" + wordList.get(x));//check input data
                }//wordList holds input data that were separated with gaps in different cells so as to help me check if i have 3-digit,2-digit,1-digit case
      return true;
    }
}
