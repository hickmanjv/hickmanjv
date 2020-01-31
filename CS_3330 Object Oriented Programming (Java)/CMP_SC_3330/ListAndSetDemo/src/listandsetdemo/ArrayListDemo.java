/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listandsetdemo;

import java.util.ArrayList;



/**
 *
 * @author Professor Wergeles
 */
public class ArrayListDemo {
    
    public static void main(String[] args){
        
       ArrayList<String> al = new ArrayList<>();    // do not need the type a second time
       
        
        System.out.println("Initial Size of array list: " + al.size());
        
        
        al.add("Cherry"); 
        al.add("Apple"); 
        al.add("Banana"); 
        al.add("Date"); 
        
        System.out.println("Contents of array list: " + al);
        
        al.add(1, "Apricot");
        
        System.out.println("Contents of array list: " + al);
        
        System.out.println("Size of array list after additions: " + al.size()); 
        
        System.out.println("Iterate through list and print items:"); 
        
        for(String item : al)       // colon here is like "in"  this iterates through
        {
            System.out.println(item);
        }
        
        al.remove("Date");
        
        al.remove(2);
        al.clear();
        System.out.println("Contents of array list: " + al);

//        al.clear();
//        System.out.println(al);
        
        System.out.println("Size of array list after deletions: "+ al.size()); 
        
        
        String first = al.get(0);      
        System.out.println("First: " + first);
        
        // if you don't know what type of ArrayList you are dealing with use...
        System.out.println(al.get(0).getClass());
        
         
    }
}
