/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvccpumonitorfxml;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public abstract class AbstractModel {
    
    /* Here is how to create property change support so when the value of a 
        variable changes, you can fire an event. There should be three methods:
        add, remove, and fire defined. The constructor is used to set the 
        variables 
    */
    
    protected PropertyChangeSupport propertyChangeSupport; 
    
    protected Timeline timeline;
    protected KeyFrame keyFrame;
    protected double tickTimeInSeconds; //Change resolution
    protected double cpu;
    
    
    
    public AbstractModel(){
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
    
    public void setupMonitor() {        
        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000), (ActionEvent event) -> {
                updateMonitor(); 
        });
        timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
    }
        
    public void updateMonitor() {
        getCpu(); 
        //updateAnalog(cpu);   dont need in digital
        //updateDigital(cpu);
    }
    
    public void start() {
        timeline.play();
    }
    
    public void stop() {
        timeline.stop();
    }
    
    public void reset(){
        timeline.stop();
                cpu = 0.0;
    }
    
    public double getCpu(){
        cpu = getCPUUsage(); 
        return cpu; 
    }
    
    private static double getCPUUsage() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        double value = 0;
        for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
            method.setAccessible(true);
            if (method.getName().startsWith("getSystemCpuLoad")
                    && Modifier.isPublic(method.getModifiers())) {
                try {
                    value = (double) method.invoke(operatingSystemMXBean);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    value = 0;
                }
                
                if(Double.isNaN(value)) value = Math.random();
      
                return value;
            }
        }
        return value;
    }
    
    public boolean isRunnning(){
        if(timeline != null){
            if(timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        return false;
    }
    
    
}


