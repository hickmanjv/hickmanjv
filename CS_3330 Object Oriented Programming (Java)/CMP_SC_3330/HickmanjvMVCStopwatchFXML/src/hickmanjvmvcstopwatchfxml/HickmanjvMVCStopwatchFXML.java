/******************************************************************************
 Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: MVCStopwatchFXML
 *      -- Use the techniques of MVC to redo the Stopwatch FXML assignment
 *****************************************************************************/
package hickmanjvmvcstopwatchfxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HickmanjvMVCStopwatchFXML extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MVCStopwatchFXML.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
