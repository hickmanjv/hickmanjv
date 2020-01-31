/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstjavaapp;

/**
 *
 * @author josh
 */
public class MyFirstJavaApp 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        System.out.println("Hello World!");
        
            for(int i = 0; i <100; i++)
            {
                if(i == 99)
                {
                    System.out.print(i);
                }
                else
                {
                    System.out.print(i + ",");
                }
            }
            
        System.out.println();
        System.out.println(weAreSleepy());
       
    }
    
    public static String weAreSleepy()
    {
        String firstString = "Hello";
        String concat = firstString.concat(" we are sleepy");
        
        System.out.println(concat);
        
        String replace = " ladies and gentlemen".replace("and", "/");
        
        return concat.concat(replace); 
    }
}
// OOP 
// an object is a bundle that has states and behaviors
// states in variables/fields
// behaviors in functions/methods
// hiding the internal state - data encapsulation - a fundemental principle
/*
    1. Modularity - code  is written and maintained
    2. Information - hiding
    3. Code re-use - 
    4. Pluggability and debugging ease - "if a bolt breaks you replace it, not the whole engine


    What is a Class?
    Class is a blueprint from which individual objects are created
    Class is the code before created

    A Class is a templete for objects, and object is an instance of a Class
    
    Memorize the Access Level Table
    Public, Protected, no modifier, Private
    
    Top Level - can only do public or default
    Member Level - can do all 4
    no modifier - default also known as package-private


    the this keyword
        most commonly seen in constructor 
        
    this refers to the the current object (current class)
        instead of putting the class name you put the this keyword

    when in a constructor you would have to create new variables but can use this.x = x;  instead of x = a;

    Three parts of creating an object **** for test
    1. Declaration - associate a variable name with object type
    2. Instantiation - new keyword
    3. Initialization - passing parameters to constructor
*/