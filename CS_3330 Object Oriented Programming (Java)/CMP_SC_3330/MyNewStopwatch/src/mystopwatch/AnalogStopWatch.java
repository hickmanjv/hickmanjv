/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mystopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author josh
 */
public class AnalogStopWatch {
    
    private StackPane root;
    private ImageView dialImageView;
    private ImageView handImageView;
    private Image dialImage;
    private Image handImage;
    private String dialImageName = "clockface.png";
    private String handImageName = "hand.png";
    
    private Timeline timeline;
    private KeyFrame keyFrame;
    
    private double secondsElapsed = 0.0;
    private double tickTimeInSeconds = 1;
    private double angleDeltaPerSeconds = 6.0;
    
    public AnalogStopWatch(){   //no arg constructor
        setupUI();
        setupTimer();
    }
    
    public void setupUI(){
        root = new StackPane();     //create the root
        dialImageView = new ImageView();    //create the picture frame
        handImageView = new ImageView();
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));  //here is the pictures
        handImage = new Image(getClass().getResourceAsStream(handImageName));
        dialImageView.setImage(dialImage);  //put the pictures in the pictureframe
        handImageView.setImage(handImage);
        root.getChildren().addAll(dialImageView, handImageView);
        
        HBox buttonBox = new HBox();
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        Button tickButton = new Button("Tick");
        buttonBox.getChildren().add(tickButton);
        root.getChildren().add(buttonBox);
        
        tickButton.setOnAction((ActionEvent event) -> {
            if(tickTimeInSeconds == 1.0)
            {
                setTickTimeInSeconds(0.01);
                tickButton.setText("Set Tick 1.0");
                // stopButton();
                
            }
            else
            {
                setTickTimeInSeconds(1.0);  
                tickButton.setText("Set Tick 0.01");
                // startButton();
            }
        });
        
        // z index to layer
        
       // buttonBox.toFront();    // if you have a bunch of buttons, just do the box
        tickButton.toFront();
        
    }
    
    public void setupTimer(){
        
        if(isRunning()){
            timeline.stop();
        }
        
        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000),        //keyframe is a constructor, takes a duration and a function call
                (ActionEvent actionEvent) -> {                                      
                
                   update();
                   
                });
        
        timeline = new Timeline(keyFrame);
                
        timeline.setCycleCount(Animation.INDEFINITE);
//        timeline.play();      //this was commented out when the start button was put into play because we don't need
                                //the stopwatch to start automatically.
    }
    
    private void update(){
        secondsElapsed += tickTimeInSeconds;
        double rotation = secondsElapsed * angleDeltaPerSeconds;
        handImageView.setRotate(rotation);       
    }
    
    public Parent getRootContainer(){
        return root;
    }
    
    public double getWidth(){                       //whats the start of a javafx program?  its the start method
        if(dialImage != null)                       //
            return dialImage.getWidth();
        
        else return 0.0;
    }
    
    public double getHeight(){
        if(dialImage != null)
            return dialImage.getHeight();
        
        else return 0.0;
    }
    
    public void start(){
        timeline.play();
    }
    
    public void setTickTimeInSeconds(double tickTimeInSeconds){
        this.tickTimeInSeconds = tickTimeInSeconds;
        setupTimer();
        
        if(!isRunning()){
            timeline.play();
        }
    }
    
    public boolean isRunning(){
        if(timeline != null){
            if(timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        return false;
    }
}


