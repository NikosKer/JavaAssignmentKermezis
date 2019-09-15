package com.phonenumbers.interaction;

import javax.swing.JFrame;

/**
 * 
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        MyFrame   textFieldFrame=new MyFrame();
        textFieldFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textFieldFrame.setSize(450,100);
        textFieldFrame.setLocationRelativeTo(null);//places the frame at the center
        textFieldFrame.setVisible(true);
    }
}
