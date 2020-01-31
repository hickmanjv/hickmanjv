/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import user.GuestUser;
import user.RegisteredUser;
import user.UserType;
import user.VipUser;

/**
 *
 * @author Junlin Wang, TA at cs3330@missouri.edu
 */
public class LibraryUML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GuestUser user1 = new GuestUser(UserType.GUEST); 
        user1.foodPurchase(1.50);
        System.out.println(user1.getUserInfo()); 
        
        
        System.out.println("\n\n\n"); 
        
        
        RegisteredUser user2 = new RegisteredUser(UserType.REGISTERED, "abc123", "abc123");
        user2.bookPurchase(10.50);
        System.out.println(user2.getUsername()); 
        user2.setUsername("xyz987"); 
        System.out.println(user2.getUsername()); 
        System.out.println(user2.getUserInfo()); 
        
        
        System.out.println("\n\n\n"); 
        
        
        VipUser user3 = new VipUser("a1b2c3", "12345", 10); 
        user3.bookPurchase(10.00);
        int level = user3.getVipLevel(); 
        user3.setVipLevel(++level);
        System.out.println(user3.getUserInfo()); 
     
    }
}