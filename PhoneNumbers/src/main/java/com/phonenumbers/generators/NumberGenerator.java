/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phonenumbers.generators;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 *
 * @author nikos
 *  
 * 
 */

public class NumberGenerator {
     private LinkedList<String> combinations=new LinkedList<String>();

    public LinkedList<String> getCombinations() {
        return combinations;
    }
     
     public void updateList(String str1){
            for(int num=0;num<combinations.size();num++){
                      
                combinations.set(num, combinations.get(num)+str1);//replaces the element with the expanded string
            
            }
     }
     public void updateList(String str1,String str2){
            LinkedList<String> helper=new LinkedList<String>();//create linkedlist helper to hold the new combinations in order to add them to combinations-linkedlist after clear()
             for(int num=0;num<combinations.size();num++){
                  helper.add(combinations.get(num)+str1);
                  helper.add(combinations.get(num)+str2);
            
            }
             combinations.clear();//empties linkedlist in order to add the new generated combinations from helper
             for(int num=0;num<helper.size();num++){
                    combinations.add(helper.get(num));
             }
     }
     public void updateList(String str1,String str2,String str3){
              
          LinkedList<String> helper=new LinkedList<String>();//create linkelist helper to hold the new combinations in order to add them to combinations-linkedlist after clear()
             for(int num=0;num<combinations.size();num++){
                  helper.add(combinations.get(num)+str1);
                  helper.add(combinations.get(num)+str2);
                  helper.add(combinations.get(num)+str3);
            }
             combinations.clear();//empties linkedlist in order to add the new generated combinations from helper
             for(int num=0;num<helper.size();num++){
                    combinations.add(helper.get(num));
             }
     
     }
     public void updateList(String str1,String str2,String str3,String str4){
         
             LinkedList<String> helper=new LinkedList<String>();//create linkedlist helper to hold the new combinations in order to add them to combinations-linkedlist after clear()
             for(int num=0;num<combinations.size();num++){
                  helper.add(combinations.get(num)+str1);
                  helper.add(combinations.get(num)+str2);
                  helper.add(combinations.get(num)+str3);
                  helper.add(combinations.get(num)+str4);
            }
             combinations.clear();//empties linkedlist in order to add the new generated combinations from helper
             for(int num=0;num<helper.size();num++){
                    combinations.add(helper.get(num));
             }
     
     }

     
    public void combinationsGenerate(ArrayList<String> number, int i) {// creates new combinations and invokes updateList overloaded methods.Also,invokes input handler passing arraylist and next index to check

        String currentBox = number.get(i);//use currentBox string in order not to search every time 

        if (currentBox.length() == 3) {//means has three characters

            if (currentBox.charAt(0) == '0') {//025,010,020,015,005,000
               
                if (currentBox.charAt(1) == '0' || currentBox.charAt(1) == '1') {//005,000,010,015
                    String str1 = currentBox;
                   //checked System.out.println(str1);
                   updateList(str1);
                   inputHandler(number,i+1);
                } else {//025,020
                    
                    if (currentBox.charAt(2) == '0') {//020
                        
                        if (i < number.size() - 1) {//if exists next element
                             
                            if (number.get(i + 1).length() == 1) {//020 5,020 0
                                if (number.get(i + 1).charAt(0) == '0') {//020 0
                                    String str1 = currentBox;//020
                                    
                                   //checked System.out.println(str1);
                                   updateList(str1);
                                   inputHandler(number,i+1);
                                } else {//020 5

                                    String str1 = currentBox + number.get(i + 1);//0205
                                    String str2 = ""+currentBox.charAt(0) + currentBox.charAt(1) + number.get(i + 1);//025
                                    
                                   //checked System.out.println(str1);
                                   //checked System.out.println(str2);
                                    //JUMP call inputHandler with i+2 next box has already been handled
                                    updateList(str1,str2);
                                    inputHandler(number,i+2);
                                }
                            }

                        } else {//current last element
                            String str1 = currentBox;//020
                           //checked System.out.println(str1);
                           
                           updateList(str1);
                           inputHandler(number,i+1);
                        }
                    } else {//025
                        String str1 = currentBox;//025
                        String str2 = "0" + currentBox.charAt(1) + "0" + currentBox.charAt(2);//0205
                        
                        //checked System.out.println(str1);
                        //checked System.out.println(str2);
                        updateList(str1,str2);
                        inputHandler(number,i+1);
                    }

                }

            } else {//100 101 110 725 720
                if (currentBox.charAt(1) == '0') {//100 101 205
                    if (currentBox.charAt(2) == '0') {//100 200
                        if (i < number.size() - 1) {//if next element exists
                            if (number.get(i + 1).length() == 3) {//100 100,700 725
                                String str1 = currentBox;
                                
                               //checked System.out.println(str1);
                               updateList(str1);
                               inputHandler(number,i+1);
                            } else if (number.get(i + 1).length() == 2) {//100 20,100 25,100 01,100 05
                                if (number.get(i + 1).charAt(0) == '0') {//100 05
                                    String str1 = currentBox + number.get(i + 1);//10005
                                    
                                //CHECKED    System.out.println(str1);
                                    //JUMP call inputHandler with i+2 next box has already been handled
                                    updateList(str1);
                                    inputHandler(number,i+2);
                                } else if (number.get(i + 1).charAt(0) == '1') {//100 15,100 10
                                    String str1 = currentBox + number.get(i + 1);//10010,10015
                                    String str2 = currentBox.charAt(0) + number.get(i + 1);//115,110
                                  
                                 //Checked   System.out.println("1) "+str1); 
                                 //Checked    System.out.println("2) "+str2); 
                                  //JUMP call inputHandler with i+2 next box has already been handled
                                      updateList(str1,str2);
                                      inputHandler(number,i+2);
                                } else {//100 20, 100 25,
                                    if (number.get(i + 1).charAt(1) == '0') {//100 20
                                        if ((i + 1) < number.size() - 1) {//if element i+2 exists

                                            if (number.get(i + 2).length() == 1) {//100 20 5,100 20 0
                                                if (number.get(i + 2).charAt(0) == '0') {//100 20 0

                                                    String str1 = currentBox + number.get(i + 1);//10020
                                                    String str2 = currentBox.charAt(0) + number.get(i + 1);//120
                                   //Checked  System.out.println("1) "+str1); 
                                    //Checked System.out.println("2) "+str2);
                                                    //JUMP call inputHandler with i+2 next box has already been handled
                                                    updateList(str1,str2);
                                                    inputHandler(number,i+2);
                                                } else {//100 20 5
                                                    String str1 = currentBox + number.get(i + 1) + number.get(i + 2);//100205
                                                    String str2 = currentBox + number.get(i + 1).charAt(0) + number.get(i + 2);//10025
                                                    String str3 = currentBox.charAt(0) + number.get(i + 1) + number.get(i + 2);//1205
                                                    String str4 = ""+currentBox.charAt(0) + number.get(i + 1).charAt(0) + number.get(i + 2);//125  ,"" required to take the wanted string
                                                    //Checked   System.out.println("1) "+str1); 
                                                    //Checked  System.out.println("2) "+str2);
                                                    //Checked  System.out.println("3) "+str3); 
                                                    //Checked  System.out.println("4) "+str4);
                                                    //JUMP_2 call inputHandler with i+3 next 2 boxes have already been handled
                                                    updateList(str1,str2,str3,str4);
                                                    inputHandler(number,i+3);
                                                }
                                            }

                                        } else {//i+1 last element

                                            String str1 = currentBox + number.get(i + 1);//10020
                                            String str2 = currentBox.charAt(0) + number.get(i + 1);//120
                                            
                                           //Checked System.out.println(str1);
                                           //Checked System.out.println(str2);
                                            //JUMP call inputHandler with i+2 next box has already been handled
                                              updateList(str1,str2);
                                              inputHandler(number,i+2);
                                        }

                                    } else {//100 25
                                        String str1 = currentBox + number.get(i + 1);//10025
                                        String str2 = currentBox.charAt(0) + number.get(i + 1);//125
                                        String str3 = currentBox + number.get(i + 1).charAt(0) + "0" + number.get(i + 1).charAt(1);//100205
                                        String str4=""+ currentBox.charAt(0)+number.get(i + 1).charAt(0)+"0"+number.get(i + 1).charAt(1);//1205 ,"" required to take the wanted string
                                        //checked   System.out.println(str1);
                                        //checked   System.out.println(str2);
                                        //checked   System.out.println(str3);
                                        //checked   System.out.println(str4);
                                        //JUMP call inputHandler with i+2 next box has already been handled
                                        updateList(str1,str2,str3,str4);
                                        inputHandler(number,i+2);
                                    }

                                }

                            } else {//100 0,100 5

                                if (number.get(i + 1).charAt(0) == '0') {//100 0
                                    String str1 = currentBox + "0";//1000
                                    
                                   // System.out.println(str1);
                                    //JUMP call inputHandler with i+2 next box has already been handled
                                    updateList(str1);
                                    inputHandler(number,i+2);
                                } else {//100 9,100 5
                                    String str1 = currentBox + number.get(i + 1);//1009
                                    String str2 = ""+currentBox.charAt(0) + currentBox.charAt(1) + number.get(i + 1);//109 , "" required to take the wanted string
                                    
                                   //checked System.out.println(str1);
                                   //checked System.out.println(str2);
                                    //JUMP call inputHandler with i+2 next box has already been handled
                                    updateList(str1,str2);
                                    inputHandler(number,i+2);
                                }
                            }
                        } else {//currentBox is last element
                            String str1 = currentBox;
                           //checked System.out.println(str1);
                           updateList(str1);
                           inputHandler(number,i+1);
                        }
                    } else {//101, 205

                        String str1 = currentBox;//101
                        String str2 = currentBox.charAt(0) + "00" + currentBox.charAt(2);//1001
                        
                        //checked System.out.println(str1);
                       //checked System.out.println(str2);
                       updateList(str1,str2);
                       inputHandler(number,i+1);
                    }

                } else {//110 725 720
                    if (number.get(i).charAt(1) == '1') {//111 110
                        String str1 = currentBox;//110
                        String str2 = currentBox.charAt(0) + "00" + currentBox.charAt(1) + currentBox.charAt(2);//10010
                      //checked  System.out.println(str1);
                      //checked  System.out.println(str2);
                      updateList(str1,str2);
                      inputHandler(number,i+1);
                    } else if (number.get(i).charAt(2) == '0') {//720
                        if (i < number.size() - 1) {//if next element exists

                            if (number.get(i + 1).length() == 1 && number.get(i + 1).charAt(0) != '0') {//720 5
                                String str1 = currentBox + number.get(i + 1);//7205
                                String str2 = ""+currentBox.charAt(0) + currentBox.charAt(1) + number.get(i + 1);//725 ,"" required to take the wanted string
                                String str3 = currentBox.charAt(0) + "00" + currentBox.charAt(1) + number.get(i + 1);//70025
                                String str4 = currentBox.charAt(0) + "00" + currentBox.charAt(1) + currentBox.charAt(2) + number.get(i + 1);//700205
                               //checked System.out.println(str1);
                               //checked System.out.println(str2);
                               //checked System.out.println(str3);
                               //checked System.out.println(str4);
                                //JUMP call inputHandler with i+2 next box has already been handled
                                updateList(str1,str2,str3,str4);
                                inputHandler(number,i+2);
                            } else {//720 25,720 0 asxoloumai me to prwto mono
                                String str1 = currentBox;//720
                                String str2 = currentBox.charAt(0) + "00" + currentBox.charAt(1) + currentBox.charAt(2);//70020
                                
                               //checked System.out.println(str1);
                               //checked System.out.println(str2);
                               updateList(str1,str2);
                               inputHandler(number,i+1);
                            }

                        } else {//current is the last element
                            String str1 = currentBox;//720
                            String str2 = currentBox.charAt(0) + "00" + currentBox.charAt(1) + currentBox.charAt(2);//70020
                           //checked System.out.println(str1);
                           //checked System.out.println(str2);
                           updateList(str1,str2);
                           inputHandler(number,i+1);
                        }
                    } else {//725
                        String str1 = currentBox;//725
                        String str2 = currentBox.charAt(0) + "00" + currentBox.charAt(1) + currentBox.charAt(2);//70025
                        String str3 = currentBox.charAt(0) + "00" + currentBox.charAt(1) + "0" + currentBox.charAt(2);//700205
                        String str4 = ""+currentBox.charAt(0) + currentBox.charAt(1) + "0" + currentBox.charAt(2);//7205 ,"" required to take the wanted string
                      //checked  System.out.println(str1);
                      //checked  System.out.println(str2);
                      //checked  System.out.println(str3);
                      //checked  System.out.println(str4);
                      updateList(str1,str2,str3,str4);
                      inputHandler(number,i+1);
                    }

                }

            }

        } else if (currentBox.length() == 2) {//means has two characters

            if (currentBox.charAt(0) == '0' || currentBox.charAt(0) == '1') {//00,01,05,10,11,12,15

                String str1 = currentBox;
                //checked System.out.println(str1);
                updateList(str1);
                inputHandler(number,i+1);
            } else {//20 25
                if (currentBox.charAt(1) == '0') {//20 ,30 
                    if (i < number.size() - 1) {
                        if (number.get(i + 1).length() == 1) {//20 5,30 6 ,20 0
                            if(number.get(i+1).charAt(0)!='0'){//20 5 ,30 6
                             String str1 = currentBox + number.get(i + 1);//205
                            String str2 = currentBox.charAt(0) + number.get(i + 1);//25
                           //checked System.out.println(str1);
                           //checked System.out.println(str2);
                            //JUMP call inputHandler with i+2 next box has already been handled
                            updateList(str1,str2);
                            inputHandler(number,i+2);
                            
                            }else{//20 0
                              String str1 = currentBox + number.get(i + 1);//200
                               // System.out.println(str1);
                              //JUMP call inputHandler with i+2 next box has already been handled
                               updateList(str1);
                               inputHandler(number,i+2);
                            }
                           
                        } else {//20 20,20 01
                            String str1 = currentBox;
                          //checked  System.out.println(str1);
                          updateList(str1);
                          inputHandler(number,i+1);
                        }

                    } else {//last element
                       
                        String str1 = currentBox;//20,30
                       //checked System.out.println(str1);
                       updateList(str1);
                       inputHandler(number,i+1);
                    }
                } else {//25
                    String str1 = currentBox;//25
                    String str2 = currentBox.charAt(0) + "0" + currentBox.charAt(1);//205
                    
                    //checked System.out.println(str1);
                    //checked System.out.println(str2);
                    updateList(str1,str2);
                    inputHandler(number,i+1);
                }

            }

        } else {//means has one character

            String str1 = currentBox;
           //checked System.out.println(str1);
           updateList(str1);
           inputHandler(number,i+1);
        }

    }
    public  LinkedList inputHandler(ArrayList<String> a,int x){
       
        if(x==0){//add first element at first call of inputHandler
           combinations.add("");
        }      
        if(x<a.size()){//if exists x index element
          combinationsGenerate(a,x);//call combinationsGenerate 
        }

        return combinations;
   }
}
