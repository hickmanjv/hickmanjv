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
public class SuperArrayGenericsDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Integer[] integerArray = {5, 4, 3, 2, 1 }; 
        
        SuperArray<Integer> sIntegerArray = new SuperArray<>(integerArray);
        sIntegerArray.displayArray();
        
        
        Double[] doubleArray = { 2.3, 4.3, 6.3, 7.3, 8.5 }; 
        
        SuperArray<Double> sDoubleArray = new SuperArray<>(doubleArray);
        sDoubleArray.displayArray();
 
        
        Character[] characterArray = { 'I', 'N', 'F', 'O', 'T', 'E', 'C', 'H' }; 
        
        SuperArray<Character> sCharacterArray = new SuperArray<>(characterArray);
        sCharacterArray.displayArray();
 
        
        String[] stringArray = {"one", "two", "three", "four" }; 
        
        SuperArray<String> sStringArray = new SuperArray<>(stringArray);
        sStringArray.displayArray();
        
        
        
        
        
        
        
        
        
        
        
    }
    
}
