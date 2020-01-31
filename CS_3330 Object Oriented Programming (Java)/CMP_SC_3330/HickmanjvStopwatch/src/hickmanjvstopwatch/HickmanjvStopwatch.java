/**************************************************************
 * Student: @author - Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: Stopwatch
 *      -  Tasked to create an analog and digital stopwatch
 *          with a time stamp board
 * 
 * Apologizing for the terrible quality of this project,
 * this isn't my usual standard, and I feel out of sorts w/
 * this for some reason, I'll reach out for office ours
 *************************************************************/
package hickmanjvstopwatch;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class HickmanjvStopwatch extends Application {
    
    private String appName = "Stopwatch";
    
    @Override
    public void start(Stage primaryStage) 
    {
        
        AnalogStopwatch analogStopwatch = new AnalogStopwatch();
        
        Scene scene = new Scene(analogStopwatch.getRootContainer(), analogStopwatch.getWidth() +800,
                                analogStopwatch.getHeight() +300);
        
        primaryStage.setTitle(appName);
        primaryStage.setScene(scene);
        primaryStage.show(); 
        

       //analogStopwatch.setTickTimeInSeconds(0.01);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
