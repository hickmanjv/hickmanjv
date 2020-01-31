/********************************************************
 * Student: @author Josh Hickman - hickmajv
 * StudentID: 10236503
 * Date: 9/6/18
 * Assignment: Challenge 4 - Books
 *      - Assignment is to create multiple different
 *        book objects that chain constructors
 *******************************************************/

package hickmanjvbook;

import static hickmanjvbook.Category.*;

public class HickmanjvBook 
{
    
    /*********************************************************
     * Function: main
     *      - Function where book objects are created and
     *        their data is printed to the screen in a 
     *        formatted fashion
     * 
     ********************************************************/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        
        Book book1 = new Book("Grant", "Ron Chernow");
        
        
            book1.setPrice(20.00);
            book1.setCategory(HISTORY);
        
        Book book2 = new Book("Goodnight Moon", "Margaret", 8.94, CHILDREN);
        
        Book book3 = new Book();
            
            book3.setName("The Martian");
            book3.setAuthor("Andy Weir");
            book3.setPrice(15.63);
            book3.setCategory(SCI_FI);
            
        // Extra books    
        Book book4 = new Book("1984", "George Orwell", 14.98, OTHER);
        
        Book book5 = new Book();
        
            book5.setName("Alice in Wonderland");
            book5.setAuthor("Lewis Carroll");
            book5.setPrice(11.76);
            book5.setCategory(FANTASY);
          
        // Book 1     
        System.out.println("Book 1:");
        System.out.println("Name: " + book1.getName());
        System.out.println("Author: " + book1.getAuthor());
        System.out.printf("Price: $%.2f\n", book1.getPrice());
        System.out.println("Category: " + book1.getCategory());
        System.out.println("Version: " + book1.getVersion() + "\n");
        
        // Book 2
        System.out.println("Book 2:");
        System.out.println("Name: " + book2.getName());
        System.out.println("Author: " + book2.getAuthor());
        System.out.printf("Price: $%.2f\n", book2.getPrice());
        System.out.println("Category: " + book2.getCategory());
        System.out.println("Version: " + book2.getVersion() + "\n");
        
        // Book 3
        System.out.println("Book 3:");
        System.out.println("Name: " + book3.getName());
        System.out.println("Author: " + book3.getAuthor());
        System.out.printf("Price: $%.2f\n", book3.getPrice());
        System.out.println("Category: " + book3.getCategory());
        System.out.println("Version: " + book3.getVersion() + "\n");
        
        // Book 4
        System.out.println("Book 4:");
        System.out.println("Name: " + book4.getName());
        System.out.println("Author: " + book4.getAuthor());
        System.out.printf("Price: $%.2f\n", book4.getPrice());
        System.out.println("Category: " + book4.getCategory());
        System.out.println("Version: " + book4.getVersion() + "\n");
        
        // Book 5
        System.out.println("Book 5:");
        System.out.println("Name: " + book5.getName());
        System.out.println("Author: " + book5.getAuthor());
        System.out.printf("Price: $%.2f\n", book5.getPrice());
        System.out.println("Category: " + book5.getCategory());
        System.out.println("Version: " + book5.getVersion() + "\n");
        
        // Number of Object Created
        System.out.println("\nNumber of Books: " + Book.numberOfBooks + "\n");
    }
    
}
