/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animal;

/**
 *
 * @author josh
 */
public class Animal {

    public void sound(){
      System.out.println("Animal is making a sound");   
   }
     /* @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Animal obj = new Horse();
obj.sound();
    }
    
}
