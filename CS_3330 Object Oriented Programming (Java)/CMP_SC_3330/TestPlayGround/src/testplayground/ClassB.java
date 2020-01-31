/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testplayground;

/**
 *
 * @author josh
 */
abstract class ClassB extends ClassA implements InterfaceB {
    protected ClassB(){
        
    }
    
    @Override
    public void test(){
        System.out.println("Test from B");
    }
}
