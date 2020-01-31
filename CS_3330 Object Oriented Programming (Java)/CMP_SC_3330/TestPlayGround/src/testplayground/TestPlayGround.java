/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testplayground;

import static java.awt.Color.blue;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josh
 */
public class TestPlayGround {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int x = 5;
        int y = 3;
        int n = 3;
        int m = 3;
        ClassA obj = new ClassA();
        ClassB obj2 = new ClassB();
        
        obj.test(); 
        obj2.test();
        
        List<String> list = new ArrayList<>();
        list.add("Red");
        
        String a = new String("Dog");
        String b = new String("Dog");
        
        if(a == b)
        {
            System.out.println("They are equal");
        }
        else
        {
            System.out.println("They are not equal");
        }
        
        
        java.util.ArrayList<Object> aa = new ArrayList<>();
        
       
        if(x >= y && n == m){
            System.out.println("works");
        }
        
        
        int[] nums = {1,0,0,0,0};
        
        for(int i = 2; i < nums.length; i++){
            nums[i] = nums[i-1] + nums[i-2];
        }
        
        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);
        System.out.println(nums[3]);
        System.out.println(nums[4]);
      
        
        Person p = new Nick();
        p.speak();
 
        ClassC kk = new ClassC();
        
        Game aaa = new Game();
        Sudoku sss = new Sudoku(10,20);
        
        aaa = sss;
        aaa = new Sudoku(10,20);
       
        Solvable xxx = new Sudoku(10,20);
        
        Z zzz = (X)(new X());
        
        
    }
    
}
