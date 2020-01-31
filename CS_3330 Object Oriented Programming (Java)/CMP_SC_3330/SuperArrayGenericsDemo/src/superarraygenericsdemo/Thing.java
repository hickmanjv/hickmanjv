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
public class Thing {
    
    private String name = ""; 
    private String type = ""; 
    
    public Thing(String name, String type){
        this.name = name; 
        this.type = type; 
    }
    
    public void setName(String name){
        this.name = name; 
    }
    
    public String getName(){
        return name; 
    }
    
    public void setType(String type){
        this.type = type; 
    }
    
    public String getType(){
        return type; 
    }
    
    @Override 
    public String toString(){
        return name + "(" + type + ")"; 
    }
}
