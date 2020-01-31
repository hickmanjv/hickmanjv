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
 * @author josh
 */
public class DigitalModel extends AbstractModel{
//    ** putting in abstract
//    private Timeline timeline;
//    private KeyFrame keyFrame;
//    private double tickTimeInSeconds; //Change resolution
//    private double cpu;
   // private double angle;    nothing to do with digital so get rid of it
    private String cpuString;
    
    public DigitalModel(){
     
//        tickTimeInSeconds = 0.1;
//        cpu = 0;
        
    }
    
//     public void setupMonitor() {        ** in Abstract **
//        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000), (ActionEvent event) -> {
//                updateMonitor(); 
//        });
//        timeline = new Timeline(keyFrame);
//        timeline.setCycleCount(Animation.INDEFINITE);
//    }
      
    @Override
    public void updateMonitor() {
        //getCpu(); 
        //updateAnalog(cpu);   dont need in digital
        super.updateMonitor();
        updateDigital(cpu);
    }
    
    public void updateDigital(double cpu){
        String oldString = cpuString;
        cpuString = getCPUString(cpu);
        firePropertyChange("Digital", oldString, cpuString);
    }
    
    public String getCPUString(double cpu){
        DecimalFormat formatter = new DecimalFormat("00.00");
        return formatter.format(cpu*100);
    }
}
//      public void start() {
//        timeline.play();
//    }
    
//    public void stop() {
//        timeline.stop();
//    }
//    
//    public void reset(){
//        timeline.stop();
//                cpu = 0.0;
//    }
//    
//    public double getCpu(){
//        cpu = getCPUUsage(); 
//        return cpu; 
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
//    
//    
//}
