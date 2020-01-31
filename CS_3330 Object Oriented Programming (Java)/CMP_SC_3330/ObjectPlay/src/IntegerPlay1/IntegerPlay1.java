/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegerPlay1;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class IntegerPlay1 {
    
    /**
     * @notes 
     */
    public static void main(String[] args) {
       
        // a is reference to this objects location
        Integer a = 1;
        
        System.out.println("a: " + a + " (" + System.identityHashCode(a) + ")");
        
        // immutable object - old object is destroyed a new object is being created since a is immutable
        a++;
        System.out.println("a: " + a + " ("+System.identityHashCode(a)+")");
        
        // 
        a--;
        System.out.println("a: " + a + " ("+System.identityHashCode(a)+")");
    }
}
