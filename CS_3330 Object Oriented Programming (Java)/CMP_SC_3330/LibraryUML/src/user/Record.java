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
public class Record {
    private String recordId;
    private String bookId;
    private String userId;
    private RecordState state;
    
    public Record(){
        recordId = genRecordId();
        state = RecordState.BORROWING;
    }
    
    public Record(String userId, String bookId){
        this(); 
        this.userId = userId;
        this.bookId = bookId;  
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    String getBookId() {
        return bookId;
    }

    void setBookId(String bookId) {
        this.bookId = bookId;
    }

    protected String getUserId() {
        return userId;
    }

    protected void setUserId(String userId) {
        this.userId = userId;
    }

    public RecordState getState() {
        return state;
    }

    public void setState(RecordState state) {
        this.state = state;
    }
    
    private static String genRecordId(){
        String str="zxcvbnmlkjhgfdsaqwertyuiopQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        
        Random random=new Random();  
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 20; ++i){
          int number = random.nextInt(62);
          sb.append(str.charAt(number));
        }
        
        return sb.toString();
    }
}