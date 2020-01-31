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
import javafx.util.Duration;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class StopwatchModel {
    
    private double tickTimeInSeconds = 0.01;
    private double angleDeltaPerSeconds = 6.0;
    
    private double secondsElapsed = 0.0;
    
    private Timeline timeline;
    private KeyFrame keyFrame;
    
    public void start() {
        timeline.play();
        // not model.getTimeline.play();
    }
    
    public void setTickTimeInSeconds(Double tickTimeInSeconds) {
        this.tickTimeInSeconds = tickTimeInSeconds;
        setupTimer(keyFrame);
    }
    
    public double getTickTimeInSeconds(){
        return tickTimeInSeconds;
    }
    
       // these broke....so they should be in model not model.getTimeline().play();
    public void setupTimer(KeyFrame keyFrame) {
        this.keyFrame = new KeyFrame(Duration.millis(getTickTimeInSeconds() * 1000), (ActionEvent event) -> {
            handImageView.setRotate(calculateRotation());
            //update();
        });
       
        
//        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000), (ActionEvent event) -> {
//            update();
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    public double calculateRotation(){
        // this part should be in model
        secondsElapsed += tickTimeInSeconds;
        return secondsElapsed * angleDeltaPerSeconds;
    }
}
