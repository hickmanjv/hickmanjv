/*****************************************
 Challenge 2 
 Josh Hickman - hickmanjv
 CMP SC 3330-1
 08/21/18 
 ****************************************/

package hickmanjvhelloworld;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


public class HickmanjvHelloWorld {

    public static void main(String[] args) 
    {
        System.out.println("Hello World!\n");
        
        String myPawPrint = "hickmanjv";
        
        invokeMe(myPawPrint);
    }
    static void invokeMe(String PawPrint)
    {
        System.out.println("My PawPrint is \"" + PawPrint + "\"\n");
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm");
        LocalDateTime now = LocalDateTime.now();
        
        System.out.println("Today's date is " + dtf.format(now));
    }
}
