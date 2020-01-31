/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcstopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class StopwatchController {
    // ***********************************
//    private double tickTimeInSeconds = 0.01;
//    private double angleDeltaPerSeconds = 6.0;
//    
//    private double secondsElapsed = 0.0;
//    
//    private Timeline timeline;
//    private KeyFrame keyFrame;
    //  *****   all data for stopwatch so should be in Model
    
    // **********  dealing with view...stay in controller *********
    private StackPane rootContainer;
    private ImageView dialImageView;
    private ImageView handImageView;
    private Image dialImage;
    private Image handImage;
    private String dialImageName = "clockface.png";
    private String handImageName = "hand.png";
    
    // anything that has anything to do with the view will stay in controller....mostly @fxml is in controller 
    
    StopwatchModel model;
    
    public StopwatchController() {
        model = new StopwatchModel();
        setupUI();
        model.setupTimer(new KeyFrame(Duration.millis(model.getTickTimeInSeconds() * 1000), (ActionEvent event) -> {
            handImageView.setRotate(model.calculateRotation());
            //update();
        }));
        
        // could do this to start from main with regular code
        model.start();
    }
    
    // or could do this to start from main with regular code
    public void start(){
        model.start();
    }
    
    private void setupUI() {
        rootContainer = new StackPane();
        dialImageView = new ImageView();
        handImageView = new ImageView();    
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        handImage = new Image(getClass().getResourceAsStream(handImageName));
        dialImageView.setImage(dialImage);
        handImageView.setImage(handImage);
        rootContainer.getChildren().addAll(dialImageView, handImageView);
    }
    
//    // these broke....so they should be in model not model.getTimeline().play();
//    public void setupTimer() {
//        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000), (ActionEvent event) -> {
//            update();
//        });
//        
//        timeline = new Timeline(keyFrame);
//        timeline.setCycleCount(Animation.INDEFINITE);
//    }
    
    private void update() {
//        // this part should be in model
//        secondsElapsed += tickTimeInSeconds;
//        double rotation = secondsElapsed * angleDeltaPerSeconds;
        
        // this line would break mvc if put in model
        handImageView.setRotate(model.calculateRotation());
    }

    public Parent getRootContainer() {
        return rootContainer;
    }
    
    public Double getWidth() {
        if (dialImage != null) return dialImage.getWidth();
        else return 0.0;
    }
    
    public Double getHeight() {
        if (dialImage != null) return dialImage.getHeight();
        else return 0.0;       
    }
    
//    public void start() {
//        timeline.play();
//        // not model.getTimeline.play();
//    }
//    
//    public void setTickTimeInSeconds(Double tickTimeInSeconds) {
//        this.tickTimeInSeconds = tickTimeInSeconds;
//        setupTimer();
//    }
}
