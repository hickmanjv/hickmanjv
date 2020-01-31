/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysecondjavafxapplication;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author josh
 */
public class MySecondJavaFXApplication extends Application {
    
    public String appName = "My Second App";
    public int width = 600;
    public int height = 400;
    
    
    @Override
    public void start(Stage primaryStage) { // passing in the stage
       
        GridPane grid = new GridPane();    //root
        grid.setAlignment(Pos.CENTER);      // have to do before adding to the scene
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        
        Text sceneTitle = new Text("Welcome");  // create
        sceneTitle.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 20)); // change settings
        //sceneTitle.setTextAlignment(TextAlignment.CENTER);
        grid.add(sceneTitle, 0,0, 2, 1);  // add to root node
        
        Label infoLabel = new Label(); // what I'm adding  creating new object
        grid.add(infoLabel, 0, 1);      // what I'm adding it to
        
        Button button = new Button("Hello World");  // creating new object
            button.setOnAction((ActionEvent action) -> {        // on click listener
                infoLabel.setText("Hello World from Button Click");
            });
            grid.add(button, 1, 1);     // adding button to grid pane
        
        //grid.setGridLinesVisible(true);    dont want to see grid in at production, for testing only
        
        Scene scene = new Scene(grid, width, height);   // 3 lines essential and in this order
        
        primaryStage.setScene(scene);                   //
        primaryStage.show();                            //  
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
