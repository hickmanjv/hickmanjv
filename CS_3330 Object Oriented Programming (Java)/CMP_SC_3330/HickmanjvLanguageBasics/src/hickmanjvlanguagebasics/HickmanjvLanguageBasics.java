/*************************************************
Student: Josh Hickman - hickmanjv
Student ID: 10236503
Project: Challenge 3
Date: 08/29/18
@author Josh Hickman - hickmanjv
*************************************************/

package hickmanjvlanguagebasics;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class HickmanjvLanguageBasics {

    /********************************************************
     Method: main()
     *  - A function that demonstrates the basics of the
     *  Java language in reference to variables, control
     *  structures, and repetition.As everything is hard
     *  coded, no exception handling is implemented.
     * 
     * @param args
     *******************************************************/
    public static void main(String[] args) 
    {
        // Declaring and initializing variables
        char c1 = 'A';
        char c2 = (char)65;
        short qualityScore = 70;
        float gravitation = 9.8f;
        float weight = 50f;
        boolean sunny = true;
        boolean warm = false;
        Calendar calendar = new GregorianCalendar();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        String greeting = "Bonjour";
        String myPawPrint = "hickmanjv";
        
        // evaluating c1 and c2
        if(c1 == c2)
        {
            System.out.printf("%c and %c are the same.\n", c1, c2);
        }
        else
        {
            System.out.printf("%c and %c are NOT the same.\n", c1, c2);
        }
        
        // evaluating qualityScore
        if(qualityScore >= 0 && qualityScore <= 60)
        {
            System.out.println("The quality is bad.");
        }
        else
        {
            System.out.println("Good quality.");
        }
        
        // Declaring and initializing force to print decimals
        float force = (float)(weight * gravitation);
            
        System.out.printf("Force = %.3f\n", force);
        
        // testing boolean variables
        if(sunny == true && warm == true)
        {
            System.out.println("Go hiking.");
        }
        else if(sunny == false && warm == true)
        {
            System.out.println("Go barbeque.");
        }
        else
        {
            System.out.println("Stay home.");
        }
         
        // switch to print appropriate statement given time of day
        switch(hour)
        {
            case 5: case 6: case 7: case 8: case 9: case 10:
                System.out.printf("The current time is %02d:%02d in the MORNING.\n", hour, minute);
                break;
                
            case 11: case 12: case 13: case 14: case 15: case 16: 
                System.out.printf("The current time is %02d:%02d in the AFTERNOON.\n", hour, minute);
                break;
                
            case 17: case 18: case 19: case 20: case 21: case 22: 
                System.out.printf("The current time is %02d:%02d in the EVENING.\n", hour, minute);
                break;
                
            case 23: case 0: case 1: case 2: case 3: case 4:
                System.out.printf("The current time is %02d:%02d at NIGHT.\n", hour, minute);
                break;
                
            default: 
                System.out.println("You have the wrong time.");
        }
        
        // loop to iterate and print out multiples of 3
        for(int count = 2; count <= 6; count++ )
        {
            if(count % 3 == 0)
            {
                System.out.printf("Count: %d\n", count);
            }
        }
        
        // declaring and initializing countDown to use in a loop that terminates at a specific value
        int countDown = 5;
        
        while(countDown > 0)
        {
            System.out.printf("Count Down: %d\n", countDown);
                countDown--;
        }
        
        // statement to be printed after while loop terminates @ 0
        System.out.println("Houston, we have lift off!");
        
        // method to print farewell statement
        invokeMe(myPawPrint, greeting);
    }
    
    /**********************************************************
     * Method: invokeMe()
     *      - A method that takes in two String variables and
     *      prints out a simple message including the date
     *      and time.
     *********************************************************/
    static void invokeMe(String pawprint, String greeting)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        
        System.out.printf("%s, my pawprint is %s and today's date is " + dtf.format(now) + "\n", greeting, pawprint);
    }
}
