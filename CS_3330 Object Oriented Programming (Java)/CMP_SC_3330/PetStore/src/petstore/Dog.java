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
public class Dog extends Pet {  // inherit from Pet has access to variables and methods in Pet now
    
    // super keyword - references the superclass  //  this accesses current class
    // In Java you can only inherit from up to 1 super class 
    
    // class field
    private static int numberOfDogsCreated = 0;
    
    // instance field
    private int id = 0;
    
    // using static and final to create a CONST  -- CONST variable names should be all caps
    private static final String GENUS = "Canis";
    
    private String position = "standing";
    
    public Dog(String name, int age, Gender gender)
    {
        super("Dog", name, age, gender);
        
        id = ++numberOfDogsCreated;
        
    }
    
    public void sit(){
        position = "seated";
    }
    
    public void standPretty(){
        position = "standing";
    }
    
    public String getPosition()
    {
        return position;
    }
    
    
    // not allowed because id isn't static - it is an instance variable
    /*public static int getID()
    {
        return id;
    }*/
    
    
    /* Can't do this because of final*/
    public static void setGenus()
    {
        //GENUS = "Something";
    }
    
    public static String getGenus()
    {
        return GENUS;
    }
    
    // already set numdogs and id so need getters not setters
    
    public int getID()
    {
        return id;
    }
    
    public static int getNumOFDogs()
    {
        return numberOfDogsCreated;
    }
    
    
    @Override //tells the compiler that the previous method should be ignored, so that Dog's method is used - subclass overrides superclass
    public void birthday()
    {
        age *= 7;
    }
           //@Override
    // or do public int getAge()
    //{
     //   return age *= 7;
    //}
    
    public void bark(int num)
    {
        for(int i =0; i< num; i++)
        {
            System.out.println("Bark!");
        }
    }
    
    public void bark()
    {
        bark(1);
    }
    
    // the method signature of bark are different so they are not the same method 
    // method signature - name, and parameter types (NOT return type)
    
    
}
    
    // when creating an interface you have to use the "implements" keyword in the class name..  Class Schwinn implements Bicycle
    // interfaces creates a contract with the class and the outside world, (sets up rules)
    // if you implement an interface, all methods in the interface must be implemented in the source code to be able to compile
    // interfaces aren't super classes, things get copied from super classes, interfaces are the rules to follow (think API's)
    
    // a package is a folder to group related things
    // a package is a namespace that organizes a set of related classes and interfaces

