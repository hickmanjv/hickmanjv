/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IntegerPlay2;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class IntegerPlay2 {
    
    /**
     * @notes 
     */
    public static void main(String[] args) {
        // a holds an address to the Integer object created
        Integer a = 5;
        
        // copy a's address to b but b is still independent of a
        // now both a and b point to the same object
        Integer b = a;  
        
        // c holds an address to the Integer object created
        Integer c = 8;
        
        //  ^^ 3 pointers 2 objects
        
        
        System.out.println("a " + System.identityHashCode(a) + " " + a.toString());
        System.out.println("b " + System.identityHashCode(b) + " " + b.toString());
        System.out.println("c " + System.identityHashCode(c) + " " + c.toString());
        
        // whenever any manipulation is done, a new object is created, immutable object
        // because immutable the old object is destroyed so b will not be pointed to the new a, c and a will point to same object
        a = a + 3;  
        
        // ^^ still 2 objects because a is now pointing to the object that c is pointing to
  
        System.out.println("a " + System.identityHashCode(a) + " " + a.toString());
        System.out.println("b " + System.identityHashCode(b) + " " + b.toString());
        System.out.println("c " + System.identityHashCode(c) + " " + c.toString());
  
               
        // use this because dealing with objects, when comparing 2 objects use the .equals() method, never use ==
        if (a.equals(b)) 
        {
            
            System.out.println("a equals b"); 
            
        } else {

            System.out.println("a DOES NOT b"); 
            
        }
    }
}
