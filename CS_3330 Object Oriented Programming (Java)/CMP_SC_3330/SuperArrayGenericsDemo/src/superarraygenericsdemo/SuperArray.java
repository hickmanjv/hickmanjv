/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package superarraygenericsdemo;

/**
 *
 * @author Professor Wergeles
 */
public class SuperArray<E> {
    
    private E[] theArray;
    
    public SuperArray(E[] theArray){
        this.theArray = theArray;
    }
    
    public void displayArray(){
        String outString = ""; 
        
        for(E item : theArray){
            outString += item + "\n";
        }
        
        System.out.printf("%s", outString); 
    }
}
