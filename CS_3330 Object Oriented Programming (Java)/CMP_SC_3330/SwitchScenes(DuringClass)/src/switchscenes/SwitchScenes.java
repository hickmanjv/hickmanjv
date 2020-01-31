/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package switchscenes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Professor Wergeles
 */
public class SwitchScenes extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
//        Parent root = FXMLLoader.load(getClass().getResource("Page1.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Page1.fxml"));  // save an instance of the loader
        Parent root = loader.load();
        Page1Controller controller = loader.getController();  // loading the Controller, allows you to pass the stage as a parameter
        
        Scene scene = new Scene(root, 800, 400, Color.STEELBLUE);
        
        stage.setScene(scene);
        stage.show(); 
        
        // passing the stage
        controller.start(stage);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
