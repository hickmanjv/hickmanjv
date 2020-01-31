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
public interface RegisteredUserAction {
    void borrowBook(String userId, String bookId);
    void resetPassword(String password);
    void returnBook(String recordId);
}
