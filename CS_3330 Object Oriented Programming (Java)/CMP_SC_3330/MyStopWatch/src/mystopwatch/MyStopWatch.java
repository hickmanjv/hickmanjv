/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author dalemusser
 */
public class MyStopWatch extends Application {
    
    int x = 0;
    Timeline timeline;
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("StopWatch");
        
        StackPane root = new StackPane();
        ImageView dialImageView = new ImageView();
        ImageView handImageView = new ImageView();
        root.getChildren().addAll(dialImageView, handImageView);
        //Image test = new Image(getClass().getResourceAsStream("giphy.gif"));
       Image dialImage = new Image(getClass().getResourceAsStream("clockface.png"));
       Image handImage = new Image(getClass().getResourceAsStream("hand.png"));
       
      //  dialImageView.setImage(test);
      dialImageView.setImage(dialImage);
      handImageView.setImage(handImage);  
      
      HBox controls = new HBox();
      Button start = new Button("Start");
      Button stop = new Button("Stop");
        controls.setAlignment(Pos.BOTTOM_CENTER);
        controls.setSpacing(10);
        controls.setPadding(new Insets(25,25,25,25));
        controls.getChildren().addAll(stop, start);
      root.getChildren().add(controls);
      
      start.setOnAction((ActionEvent e) -> {
          timeline.play();
          
      });
      
      stop.setOnAction((ActionEvent e) -> { 
          timeline.pause();
      });
      
      double height = dialImage.getHeight();
      double width  = dialImage.getWidth();
      
        Scene scene = new Scene(root, width, height + 100);
        primaryStage.setScene(scene);
        
        primaryStage.show();
        
        
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), 
                (ActionEvent actionEvent) -> {
                    
                    System.out.println("Hello");
                    
                    handImageView.setRotate(x+=6);
                }));
       
        timeline.setCycleCount(Animation.INDEFINITE);
        //timeline.play();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }   
}