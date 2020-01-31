/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashmapexample;

import java.util.HashMap;
import java.util.Iterator;



/**
 *
 * @author Professor Wergeles
 */
public class HashMapExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        HashMap hm = new HashMap();
        
        hm.put("name", "Mary Smith"); 
        hm.put("role", "student"); 
        hm.put("age", "20"); 
        hm.put("degree", "CS"); 
        
        System.out.println(hm); 
        
        for(Object key : hm.keySet()){
            System.out.println(key); 
        }
        
        for(Object value : hm.values()){
            System.out.println(value); 
        }
        
        // 2 ways to iterate through a collection
        for(Object entry : hm.entrySet()){
            HashMap.Entry<Object, Object> e = (HashMap.Entry<Object, Object>)entry;  // need to cast this
            
            Object key = e.getKey();
            Object value = e.getValue();
            
            System.out.println(key + " = " + value);
        }
        
        // And ^^^
        Iterator it = hm.entrySet().iterator();
        
        while(it.hasNext()){
            
            HashMap.Entry pair = (HashMap.Entry) it.next();     // casting again
            System.out.println(pair.getKey() + " = " + pair.getValue());
            it.remove();  // remove each iteration
        }
                
        // getting back a particular value
        System.out.println("Value from specifc key: " + hm.get("name"));
        
        System.out.println("Contains key 'degree'? " + hm.containsKey("degree")); 
        System.out.println("Contains key \"Degree\"? " + hm.containsKey("Degree")); 
        System.out.println("Contains value 'student'? " + hm.containsValue("student")); 
        
        System.out.println(); 
        
        System.out.println("Removing 'name' from the map");
        
        hm.remove("name");
         
        System.out.println("Size: " + hm.size()); 
//        
//        
//        
//        
//        System.out.println("Before the iterator"); 
//        
//        
//        
//        System.out.println("After removing from iterator"); 
//        
//       
//        
//        System.out.println("All elements have been removed from first iterator"); 
//        
       
    }   
}