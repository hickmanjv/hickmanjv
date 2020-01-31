/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author Junlin Wang, TA at cs3330@missouri.edu
 */
public class GuestUser extends User {
    
    public GuestUser(UserType userType){
        super(genUserId(), userType); 
    }
    
    public GuestUser(String userId, UserType userType){
        super(userId, userType);
    }

    @Override
    public void bookPurchase(double bookPrice) {
        System.out.println("Book Price: " + bookPrice);
    }

    @Override
    public void foodPurchase(double foodPrice) {
        System.out.println("Food Price " + foodPrice);
    }

    @Override
    public String getUserInfo() {
        return String.format("User ID: %s, User Type: " + userType, userId);
    }

    @Override
    public String getUsername() {
        return username; 
    }

    @Override
    public Boolean setUsername(String username) {
        this.username = username; 
        
        return !this.username.isEmpty(); 
    }
}