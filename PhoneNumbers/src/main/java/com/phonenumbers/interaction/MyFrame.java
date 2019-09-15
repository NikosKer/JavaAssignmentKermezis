/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonenumbers.interaction;

import com.phonenumbers.generators.NumberGenerator;
import com.phonenumbers.validation.InputValidator;
import com.phonenumbers.validation.PhoneNumberValidator;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author nikos
 */
public class MyFrame extends JFrame {

    private JTextField textField;//textfield
    private int counter = 0;//counts the number of numbers typed in a row 
    private int spaceCounter = 0;//counts the number of spaces typed in a row
    private char tester;//to keep the last character before the backspace hit
    private JButton okButton;//button

    public MyFrame() {
        super("Type your number");
        setLayout(new FlowLayout());
        textField = new JTextField(10);
        add(textField);//adds textField to JFrame
        okButton = new JButton();
        okButton.setText("OK");
        add(okButton);//adds okButton to JFrame
        TextFieldHandler handler = new TextFieldHandler();
        textField.addActionListener(handler);//add handler as event handler for textField
        okButton.addActionListener(handler);//add handler as event handler for okButton

        //keyListener
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                /*              
                 * counter keeps track of the number of digits-chars  user can type
                 * spaceCounter keeps track of whitespaces
                 * In case of backspace hitting,I am forced to use a loop for counting the chars and spaces backwards.
                 * In case user uses mouse to move around textfield, validateInput method checks for valid input
                 * User is allowed to type 3 digits in a row and no more than 1 whitespace in a row(this condition for whitespace is not required at final validation)
                 * 
                 */
                char input = e.getKeyChar();
                //checking input!='\b' prevents hitting backspace to enter the condition
                //cheking input!='\n' prevents hitting enter to enter the condition
                if (((input < '0' || input > '9') && (input != ' ')) && (input != '\b') && (input != '\n')) {
                    e.consume();
                    JOptionPane.showMessageDialog(null, "Invalid input. Type number");
                } else if (input >= '0' && input <= '9') {//if valid input but not whitespace

                    counter++;//if valid number input, counter increases by 1
                    spaceCounter = 0;//number typed and make spaceCounter again zero
                    tester = input;
                    if (counter >= 4) {

                        e.consume();
                        counter--;//so as last keytyped won't count
                        JOptionPane.showMessageDialog(null, "Type Space to proceed");

                    }
                } else if (input == '\b') {

                    if (tester == ' ') {//if user erased whitespace

                        if (textField.getText().length() > 0) {
                            tester = textField.getText().charAt(textField.getText().length() - 1);//tester takes the value of the last char after hitting backspace
                            // System.out.println("TESTER IS:" + tester);

                            int i = textField.getText().length() - 1;
                            int numberOfChars = 0;
                            while (i >= 0) {
                                if (textField.getText().charAt(i) != ' ') {//count backwards the number of digits until reach whitespace
                                    i--;
                                    numberOfChars++;
                                } else {
                                    break;
                                }

                            }
                            counter = numberOfChars;
                           // System.out.println("NUMBER OF DIGITS AFTER REMOVING SPACE:" + counter);
                            spaceCounter = 0;
                           // System.out.println("NUMBER OF SPACES AFTER REMOVING SPACE:" + spaceCounter);
                        } else {
                            counter = 0;
                            spaceCounter = 0;
                        }

                    } else if (tester >= '0' && tester <= '9') {//if user erased digit

                        if (textField.getText().length() > 0) {//if textField is not empty
                            tester = textField.getText().charAt(textField.getText().length() - 1);//tester takes the value of the last char after hitting backspace
                            // System.out.println("TESTER IS:" + tester);

                            int i = textField.getText().length() - 1;
                            int numberOfChars = 0;
                            while (i >= 0) {
                                if (textField.getText().charAt(i) != ' ') {//count backwards the number of digits until reach whitespace
                                    i--;
                                    numberOfChars++;
                                } else {
                                    break;
                                }

                            }
                            counter = numberOfChars;
                           // System.out.println("NUMBER OF DIGITS:" + counter);
                        } else {
                            counter = 0;//counter becomes 0 if there are no characters in the textfield
                        }

                    }
                } else { //user typed whitespace
                    spaceCounter++;//spaceCounter increases by one
                    tester = input;
                    if (spaceCounter >= 2) {
                        e.consume();
                        spaceCounter--;//so that last keytyped wont count
                        JOptionPane.showMessageDialog(null, "You have already typed space");
                    } 

                    counter = 0;//space typed counter is made zero again
                }

            }

        });
        //end of keyListener
    }
    //class for event handling

    private class TextFieldHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            String string = "";

            if (event.getSource() == textField || event.getSource() == okButton) {//user pressed enter or okButton

                string = textField.getText();

                String stringA = string;
                String[] words = stringA.split(" ");
                ArrayList<String> wordList = new ArrayList<String>(Arrays.asList(words));//wordList will hold input data that were separated with gaps in different cells so as to help me check if i have 3-digit,2-digit,1-digit case
                boolean valid = InputValidator.validateInput(wordList);//input validation in case user used mouse click and counters did not catch the invalid input

                if (valid == false) {//if input is invalid and contains more than 3 characters in a row show warning message and a new textField

                    dispose();//close window
                    JOptionPane.showMessageDialog(null, "Number input invalid.More than 3 digits in a row");
                    MyFrame textFieldFrame = new MyFrame();
                    textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    textFieldFrame.setSize(450, 100);
                    textFieldFrame.setLocationRelativeTo(null);//places the frame at the center
                    textFieldFrame.setVisible(true);

                } else {//if input is valid continue the process
                    NumberGenerator ng = new NumberGenerator();//create object to call inputHandler
                    LinkedList<String> combinations = new LinkedList<String>();//create LinkedList combinations to hold all combinations inputHandler will return
                    combinations = ng.inputHandler(wordList, 0);//pass the arraylist and the index want to check, here i want to start from the beginning so pass 0
                    string = string.replaceAll("\\s+", "");
                    dispose();//close first dialog box
                    //----------------------------FIRST MESSAGE----------------------------------
                    String firstOutput = "";
                    if (PhoneNumberValidator.checkIfNumberIsValidGreekPhoneNumber(string)) {//checking string Valid or Not greek phone number
                        firstOutput = "[phone number:VALID]";
                    } else {
                        firstOutput = "[phone number:INVALID]";
                    }
                    JOptionPane.showMessageDialog(null, string + " " + firstOutput);//first message after input
                    //----------------------------FINAL MESSAGE-----------------------------------
                    String output = "";
                    String validOrNot = "";
                    for (int i = 0; i < combinations.size(); i++) {
                        if (PhoneNumberValidator.checkIfNumberIsValidGreekPhoneNumber(combinations.get(i))) {
                            validOrNot = "VALID";
                        } else {
                            validOrNot = "INVALID";
                        }
                        output += "Intepretation " + (i + 1) + ":" + combinations.get(i) + "   [phone number: " + validOrNot + "]" + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "COMBINATIONS\n" + output);

                }

            }

        }
    }
}
