/***************************************************************
 * Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: AudioViz
 *      - Adding a class to an existing project that uses the
 *        built in interface to create new visualizer for
 *        music.
 **************************************************************/

package audioviz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AudioViz extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Player.fxml"));
        
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
