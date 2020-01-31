/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegerPlay5;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class IntegerPlay5 {
    
    /**
     * @notes 
     * 
     *      Primitive types like 'int' are faster, they are for high performance for calculations
     *          'int' cannot store numbers past a certain size limit
     *          primitive data types are mutable (can change their value at any time)
     *          
     *      Objects like Integer have more functionality, can be used as Generic Types
     *          can be used as HashMap keys, etc.
     *          Integer is immutable, if you want to modify the value...the only way is to create a new Integer
     *          and discard the old one. (Garbage Collection will handle it for us in Java)
     */
    public static void main(String[] args) {
        
        Integer a = 100;
      //Integer a = new Integer(100);   is the same as above, new keyword always creates a new different object
        Integer b = new Integer(100);

        System.out.println("a: " + a + " ("+System.identityHashCode(a)+")");
        System.out.println("b: " + b + " ("+System.identityHashCode(b)+")");
        

        if (a == b) System.out.println("a == b");
        else System.out.println("a != b");
        
        // when comparing 2 object always always use .equals()
        if (a.equals(b)) System.out.println("a equals b");
        else System.out.println("a doesn't equal b");
    }
}
