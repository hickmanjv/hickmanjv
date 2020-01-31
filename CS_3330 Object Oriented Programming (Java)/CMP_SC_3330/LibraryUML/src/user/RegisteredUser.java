/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.ArrayList;

/**
 *
 * @author Junlin Wang, TA at cs3330@missouri.edu
 */
public class RegisteredUser extends User implements RegisteredUserAction {
    
    String password;
    private ArrayList<Record> recordList = new ArrayList();
    public static final double DISCOUNT = 0.9;
    
    public RegisteredUser(UserType userType, String username, String password){
        super(genUserId(), userType); 
        this.username = username;
        this.password = password;
    }
    
    public RegisteredUser(String userId, UserType userType, String username, String password){
        super(userId, userType);
        this.username = username;
        this.password = password;
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

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(ArrayList<Record> recordList) {
        this.recordList = recordList;
    }
    
    @Override
    public void borrowBook(String userId, String bookId) {
        Record record = new Record(userId, bookId);
        recordList.add(record);
    }

    @Override
    public void resetPassword(String password) {
        this.password = password;
    }    

    @Override
    public void returnBook(String recordId) {
        for(Record record : recordList){
            if(record.getRecordId().equals(recordId)){
                record.setState(RecordState.RETURNED);
            }       
        }
    }

    @Override
    public void bookPurchase(double bookPrice) {
        System.out.println("Book Price: " + bookPrice * DISCOUNT);
    }

    @Override
    public void foodPurchase(double foodPrice) {
        System.out.println("Food Price " + foodPrice * DISCOUNT);
    }
    
    @Override
    public String getUserInfo(){
        return String.format("User ID: %s, Username: %s, Password: %s , User Type: " + userType, userId, username, password);
    }
}