/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvccpumonitorfxml;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.DecimalFormat;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 * 
 * The main thing in the model will be the data and the methods that will get,
 *  set, and manipulate the data. Without the controller invoking the model,
 *  the model will just be a object. 
 */
public class Model extends AbstractModel { 
    
    /* All variables should be private to ensure data encapsulation */ 
//    private Timeline timeline;            ** these are for both so put in abstract
//    private KeyFrame keyFrame;
//    private double tickTimeInSeconds; //Change resolution
//    private double cpu;
    private double angle; 
   // private String cpuString;  
    
    /* The constructor is used to set variables */
    public Model(){
        tickTimeInSeconds = 0.1;
        cpu = 0;
    }
    
//    public void setupMonitor() {        
//        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000), (ActionEvent event) -> {
//                updateMonitor(); 
//        });
//        timeline = new Timeline(keyFrame);
//        timeline.setCycleCount(Animation.INDEFINITE);
//    }
     
    @Override
    public void updateMonitor() {
        super.updateMonitor();
        updateAnalog(cpu); 
        //updateDigital(cpu);  only Analog
    }
    
    public void updateAnalog(double cpu){
        double oldAngle = angle;
        angle = calculateRotation(cpu);
        firePropertyChange("Analog", oldAngle, angle);
        
    }
    
//    public void updateDigital(double cpu){          *****  this model is only Analog
//        String oldString = cpuString;
//        cpuString = getCPUString(cpu);
//        firePropertyChange("Digital", oldString, cpuString);
//        
//        
//    }
    
//    public String getCPUString(double cpu){          **** only Analog ****
//        DecimalFormat formatter = new DecimalFormat("00.00");
//        return formatter.format(cpu*100);
//    }
    
//    public double getCpu(){
//        cpu = getCPUUsage(); 
//        return cpu; 
//    }
   
    /*
        Everytime I update analog, I want to fire a property change event which
            will call a method in the controller (tell the controller the angle
            has been updated), then the controller will go and update the view
            (tell the view to rototate the hand)
    */
//    private void updateAngle(){
//        double oldAngle = angle; 
//        angle = calculateRotation(cpu);  
//        firePropertyChange("Analog", oldAngle, angle); 
//    }
    
    private double calculateRotation(double cpu) {
        return cpu * 360;
    }
    
//    public void start() {
//        timeline.play();
//    }
//    
//    public void stop() {
//        timeline.stop();
//    }
//    
//    public void reset(){
//        timeline.stop();
//        cpu = 0.0;
//    }
//    
//    private static double getCPUUsage() {
//        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
//        double value = 0;
//        for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) {
//            method.setAccessible(true);
//            if (method.getName().startsWith("getSystemCpuLoad")
//                    && Modifier.isPublic(method.getModifiers())) {
//                try {
//                    value = (double) method.invoke(operatingSystemMXBean);
//                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//                    value = 0;
//                }
//                
//                if(Double.isNaN(value)) value = Math.random();
//      
//                return value;
//            }
//        }
//        return value;
//    }
//    
//    public boolean isRunnning(){
//        if(timeline != null){
//            if(timeline.getStatus() == Animation.Status.RUNNING){
//                return true;
//            }
//        }
//        return false;
//    }   
}