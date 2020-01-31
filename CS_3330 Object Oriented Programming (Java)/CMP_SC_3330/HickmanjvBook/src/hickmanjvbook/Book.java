/********************************************************
 * Student: @author Josh Hickman - hickmajv
 * StudentID: 10236503
 * Date: 9/6/18
 * Assignment: Challenge 4 - Books
 *      - Assignment is to create multiple different
 *        book objects that chain constructors
 *******************************************************/

package hickmanjvbook;


public class Book {
    
    // Declaring and initializing variables
    private String name;
    private String author;
    private double price;
    private Category category;
    private int version;
    public static int numberOfBooks = 0;
    
    // no arg constructor
    public Book()
    {
        this.name = "";
        this.author = "";
        numberOfBooks++;
    }
    
    // constructer chain
    public Book(String name, String author)
    {
        this();
        this.name = name;
        this.author = author;
        this.version = 0;
    }
    
    // constrctor chain
    public Book(String name, String author, double price, Category category)
    {
        this(name, author);
        this.price = price;
        this.category = category;
        version = 1;
    }
    
    /*********************************************************
     * Methods - Getters and Setters
     *      - Methods below will set data into our variables
     *        and retrieve their values for use in other
     *        classes.
     * @param name 
     ********************************************************/
    public void setName(String name)
    {
        this.name = name;
        version++;
    }
    
    public void setAuthor(String author)
    {
        this.author = author;
        version++;
    }
    
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    public void setCategory(Category category)
    {
        this.category = category;
        version++;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public String getAuthor()
    {
        return this.author;
    }
    
    public double getPrice()
    {
        return this.price;
    }
    
    public Category getCategory()
    {
        return this.category;
    }
    
    public int getVersion()
    {
        return this.version;
    }
    
    
}
