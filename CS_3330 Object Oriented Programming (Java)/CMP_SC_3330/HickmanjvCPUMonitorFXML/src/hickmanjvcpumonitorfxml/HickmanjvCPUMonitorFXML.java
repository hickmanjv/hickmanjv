/*******************************************************************************
 *Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: CPUMonitorFXML
 *      - Create a user interface that has both an analog and digital readout
 *      of the current percentage usage of the computer's CPU. Also includes
 *      a record board of most recent 3 CPU readings.
 ******************************************************************************/
package hickmanjvcpumonitorfxml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HickmanjvCPUMonitorFXML extends Application {
    
    private static String appName = "CPU Monitor";
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("CPUMonitorFXML.fxml"));
        

        Scene scene = new Scene(root);
        
        stage.setTitle(appName);
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
