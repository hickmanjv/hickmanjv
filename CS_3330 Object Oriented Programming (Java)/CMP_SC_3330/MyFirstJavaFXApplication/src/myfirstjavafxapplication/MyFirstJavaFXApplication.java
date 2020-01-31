/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myfirstjavafxapplication;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author josh
 */
public class MyFirstJavaFXApplication extends Application {
    
    // start method is main entry point for all javaFX applications  - consider this as a main
    @Override
    public void start(Stage primaryStage) {
        // a JavaFX application defines the user interface container by means of a stage and scene
        
        /*
        
            The JavaFX stage is top-level JavaFX container
            
            the javaFX scene is the container for all content
        
            This example, we create a stage and a scene and make the scene
                visible in a given pixel size
        
        */
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        //FlowPane root = new FlowPane();
        //TilePane root = new TilePane();
        //HBox root = new HBox();
        //VBox root = new VBox();
        //AnchorPane root = new AnchorPane();
        //GridPane root = new GridPane();
        StackPane root = new StackPane();      // stackpane is the root on scene graph
        root.getChildren().add(btn);            // puts on a button
        
        /*
            The root node contains one child node, a button control with text,
                plus an event handler to print a message when the button is pressed
        */
        
        Scene scene = new Scene(root, 300, 250);    // creating scene & pixel size
        
        /*
            Create a scene for a specific root node w/ a specific size
            
            Parameters: 
                root - The root node of the scene graph
                width - the width of the scene
                height - the height of the scene
        */
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);   // all main does, is launch
    }
    
}
