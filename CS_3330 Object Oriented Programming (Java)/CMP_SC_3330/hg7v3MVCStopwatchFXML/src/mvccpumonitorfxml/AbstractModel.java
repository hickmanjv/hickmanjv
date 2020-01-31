package mvccpumonitorfxml;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author harrietgrevers
 */


    public class AbstractModel {
        private Timeline timeline;
        private KeyFrame keyFrame;
        
        public Double tickTimeInSeconds = 0.1;
        
        AnalogModel analogModel; 
        DigitalModel digitalModel;
        
        protected PropertyChangeSupport propertyChangeSupport;
   
    public AbstractModel()
    {
        propertyChangeSupport = new PropertyChangeSupport(this);
        System.out.println("AbsMod Constr");
    }   
   //reg event list for prop
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    //dereg 
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
    //notify any listners the prop has changed
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }   
    
    public void setupMonitor() {        
        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 100), (ActionEvent event) -> {
                updateMonitor(); 
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    public void updateMonitor(){
        digitalModel.updateMonitor();
        analogModel.updateMonitor();
    }
  
    public void start() {
        timeline.play();
    }
    
    public void stop() {
        timeline.stop();
    }
    
    public Timeline getTimeLine(){
        return timeline; 
    }
    public void setTimeLine(Timeline timeline){
        this.timeline = timeline; 
    }
    public KeyFrame getKeyFrame(){
        return keyFrame; 
    }
    public void setKeyFrame(KeyFrame keyFrame){
        this.keyFrame = keyFrame; 
    }
    public double getTickTimeInSeconds(){
        return tickTimeInSeconds; 
    }

    public void setTickTimeInSeconds(double tickTimeinSeconds){
        this.tickTimeInSeconds = tickTimeInSeconds;
        setupMonitor();

        if (!isRunning()){
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
