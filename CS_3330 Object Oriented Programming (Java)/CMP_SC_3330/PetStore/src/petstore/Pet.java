/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

/**
 *
 * @author josh
 */
public class Pet 
{
    public String type; 
    private String name;
    public int age;
    public Gender gender;
    
 
   /* public Pet()
    {
        // default constructor
        //constructor - used for initializing variables
        // no return type 
        
        // old example
    }*/
    
    public Pet()
    {
        this.age = 0;
    }
    
    public Pet(String type, String name)    // constructor chaining
    {
        this();     // this line calls the first constructor (no args) which will set the age to zero
        this.type = type;
        this.name = name;
    }
    
    /*public Pet(String type, String name, int age, Gender gender)
    {
        //constructor - cannot have to of the exact same type 
        this.type = type;       // just like saying Pet.type  - this references class
        this.name = name;
        this.age = age;
        this.gender = gender;
        
        // old example
    }*/
    
    public Pet(String type, String name, int age, Gender gender)
    {
        this(type, name);       // examples of constructor chaining
        this.age = age;
        this.gender = gender;
    }
    
    public void setName(String input)
    {
        this.name = input;
        // or this.name = name with name being the variable passed to function 
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void setType(String type)
    {
        this.type = type;
    }
    
    public String getType()
    {
        return this.type;
    }
    
    public void birthday()
    {
        this.age++;
    }
    
    public int getAge()
    {
        return this.age;
    }
    
    // set Gender when pet is created in this case
    
    // in java, each class is allowed to have one direct superclass and each superclass 
    // has potential for unlimited number of subclasses
    //
    // use keyword extends to inherit from superclass (like copying and pasting from superclass)
}

//  Casting:    public Mountainbike mybike = new MountainBike();
       // can do   Object obj = new MountainBike();
       // generic works on the left but not the right......this is called implicit casting

       // explicit casting is:  MountainBike myBike = (MountainBike)obj;
       // can NOT do :          MountainBike myBike = obj;      like type casting   (float)30;

       // extends keyword also allows casting to happen