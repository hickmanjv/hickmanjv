/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listandsetdemo;

import java.util.TreeSet;


/**
 *
 * @author Professor Wergeles
 */
public class TreeSetDemo {
    
    public static void main(String[] args){
     
        TreeSet<String> ts = new TreeSet<>();
        
        ts.add("Last"); 
        ts.add("Cherry"); 
        ts.add("Apricot"); 
        ts.add("Banana"); 
        ts.add("Elderberry"); 
        ts.add("Fig");
        
        System.out.println(ts);
        
        String last = (String)ts.last(); 
        
        System.out.println("Last: "+last); 
        
        
        System.out.println(ts.last().getClass());
        
        for(String item : ts){
            System.out.println(item); 
        }
        
    } 
}
