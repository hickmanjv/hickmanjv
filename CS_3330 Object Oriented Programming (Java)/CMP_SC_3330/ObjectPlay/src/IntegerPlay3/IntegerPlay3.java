/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegerPlay3;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class IntegerPlay3 {
    
    /**
     * @notes 
     * 
     * The range is (-128 to 127) then the '==' will work. 
     * 
     * Object interning
     * 
     * Outside of the range, the .equals() method will work,  == will not
     * 
     * With primitive types, say int, a value is stored - not an address so  == will always work
     * 
     * but Integer, String, Boolean, Double, etc; these are classes so == is not comparing values
     * 
     */
    public static void main(String[] args) {
        
        Integer x = -129;
        
        Integer y = -130;
        
        
        System.out.println("x " + System.identityHashCode(x) + " " + x.toString());
        System.out.println("y " + System.identityHashCode(y) + " " + y.toString());

        y = y + 1;
        
        System.out.println("x " + System.identityHashCode(x) + " " + x.toString());
        System.out.println("y " + System.identityHashCode(y) + " " + y.toString());

        
        if (x == y /*x.equals(y)*/) {
            System.out.println("They are the same object"); 
        } else {
            System.out.println("They are different objects"); 
        }
        
        
        if (x.equals(y)) {
            System.out.println("They are the same value"); 
        } else {
            System.out.println("They are the different values");
        }
    }
}
