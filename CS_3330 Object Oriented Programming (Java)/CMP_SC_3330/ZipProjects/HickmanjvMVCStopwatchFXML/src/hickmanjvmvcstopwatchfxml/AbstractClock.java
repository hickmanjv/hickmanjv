/******************************************************************************
 Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: MVCStopwatchFXML
 *      -- Use the techniques of MVC to redo the Stopwatch FXML assignment
 *****************************************************************************/
package hickmanjvmvcstopwatchfxml;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;


public abstract class AbstractClock {
    
    protected PropertyChangeSupport propertyChangeSupport;
    
    protected Timeline timeline;
    protected KeyFrame keyFrame;
    protected double tickTimeInSeconds;
    protected double secondsElapsed = 0.0;
    
    
    public AbstractClock(){
        propertyChangeSupport = new PropertyChangeSupport(this); 
    }
    
    // register event listener for property
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    // deregister event listener for property
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
        propertyChangeSupport.firePropertyChange(propertyName, oldValue, newValue);
    }
    
    public void setupTimer(){
        
        if(isRunning())
        {
            timeline.stop();
        }
        
        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000),
                (ActionEvent actionEvent) -> {                                      
                
                   update(); 
                   
                });
        
        timeline = new Timeline(keyFrame);
                
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }
    
    public void update()
    {
        secondsElapsed += tickTimeInSeconds;
    }
    
     public void setTickTimeInSeconds(double tickTimeInSeconds)
    {
        this.tickTimeInSeconds = tickTimeInSeconds;
        setupTimer();
        
        if(!isRunning())
        {
            timeline.play();
        }
    }
    
    
    public boolean isRunning()
    {
        if(timeline != null)
        {
            if(timeline.getStatus() == Animation.Status.RUNNING)
            {
                return true;
            }
        }
        return false;
    }
    
    public void start() {
        timeline.play();
    }
    
    public void stop() {
        timeline.stop();
    }
    
    public void reset(){
        timeline.stop();
        secondsElapsed = 0.0;
    }
    
}
