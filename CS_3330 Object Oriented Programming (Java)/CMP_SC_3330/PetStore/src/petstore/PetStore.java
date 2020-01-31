/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petstore;

import static petstore.Gender.*; // could use * to use all from Gender but be careful of filesize when importing 

/**
 *
 * @author josh
 */
public class PetStore 
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Pet pet = new Pet();
        
        pet.setName("Maggie");
        pet.age = 3;
        pet.gender = MALE;
        pet.type = "Dog";
        
        String name = pet.getName();
        
        System.out.println("name = " + name);
        
        Pet pet2 = new Pet("Cat", "Kitty", 2, FEMALE);  // can do Gender.FEMALE instead, call class directly
        
        System.out.println("pet2 name = " + pet2.getName());
        
        // all objects are independent of each other
        
        Dog dog = new Dog("Fido", 2, Gender.MALE);
        
        dog.birthday();
        
        System.out.println("Fido's birthday: " + dog.getAge());
        
        Dog dog2 = new Dog("Halo", 11, Gender.FEMALE);
        
        System.out.println(dog.getName() + " is " + dog2.getAge() + " years old");
        
        dog2.birthday();
        
        System.out.println(dog.getName() + " is " + dog2.getAge() + " years old");
        
        System.out.println("Fido's birthday: " + dog.getAge());
        
        Cat cat = new Cat("Susan", 2, FEMALE);
        
        //implicit cast
        Pet pet3 = cat;     //now all you have access to is pet methods, not the cat stuff - going more generic
        
        Object obj = cat;   // now you don't even have access the Pet methods - gonig more generic
        
        
        Cat cat2 = (Cat)pet3;   // explicit casting you promised that pet3 is a Cat - will have Cat methods back
        
        cat2.meow();
        
        System.out.println("Yawn");
        
        cat2.meow(3);
        
      /* Pet test = new Pet();      // showing it doesn't work the other way
       
       if(test instanceof Cat)
       {
           Cat test2 = (Cat)test;       // won't work because test is a pet not a cat
       }
       else
       {
           System.out.println("test is not instance of cat");
       }*/
      
        // when you cast you have to go up the heirarchy because subclasses have more methods and if you go from top down they are never defined
        
        Dog dog3 = new Dog("Duke", 5, Gender.MALE);
        
        //Dog.numberOfDogsCreated = 1;    // have to use Class since it is a class variable/field  would need public
        
        
    }// end of main
    
}

// constructors do not get inherited from superclass **super keyword
// private members do not get inherited form the superclass

