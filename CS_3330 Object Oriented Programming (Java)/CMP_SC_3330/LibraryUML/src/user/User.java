/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.Random;

/**
 *
 * @author Junlin Wang, TA at cs3330@missouri.edu
 */
public abstract class User implements UserAction {
    private static int numOfUsers = 0;
    String userId;
    protected UserType userType;
    String username; 
    protected final int ssn; 
    
    public User() {
        ssn = numOfUsers++;
    }
    
    public User(String userId, UserType userType){
        this(); 
        this.userId   = userId;
        this.userType = userType;
    }

    protected static int getNumOfUsers() {
        return numOfUsers;
    }
    
    public abstract String getUsername(); 
    
    public abstract Boolean setUsername(String username); 

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }
    
    public abstract String getUserInfo();
    
    protected static String genUserId(){
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        
        Random random=new Random();  
        
        StringBuilder sb=new StringBuilder();
        
        for(int i = 0; i < 20; ++i){
          int number = random.nextInt(62);
          sb.append(str.charAt(number));
        }
        
        return sb.toString();
    }
}