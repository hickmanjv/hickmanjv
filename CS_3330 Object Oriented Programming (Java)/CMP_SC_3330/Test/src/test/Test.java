/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author josh
 */
public class Test {

    private int num;
    
    public Test(int num){
        
        this.num = num;
    }
    
    public int getNum(){
        return num;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Test test1 = new Test(5); 

        Test test2 = new Test(); 

        System.out.println(test1.getNum()); 

        System.out.println(test2.getNum()); 
    }
    
}
