/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvccpumonitorfxml;

import java.text.DecimalFormat;

/**
 *
 * @author harrietgrevers
 */
public class AnalogModel extends AbstractModel{ 
    
    private double tickTimeInSeconds; 
    private double secondsElapsed;
    private double cpu;
    private double angle; 

    private double angleDeltaPerSeconds = 0.006;
    private double oldAngle = 0;
    
    public AnalogModel(){
        tickTimeInSeconds = 0.1;
        cpu = 0;
    }
    
    @Override
    public void setupMonitor(){
        super.setupMonitor();
    }
    
    public void updateMonitor(){
        secondsElapsed += tickTimeInSeconds * 100;
        updateAnalog(secondsElapsed);
    }
     
    public void updateAnalog(double secondsElapsed){
        angle = calculateRotation(secondsElapsed);  
        firePropertyChange("Analog", oldAngle,angle);
        oldAngle = angle;   
    }
       
    public String getCPUString(double cpu) {
        DecimalFormat formatter = new DecimalFormat("00.00");
        return formatter.format(cpu * 100);
    }
    
    public double calculateRotation(double secondsElapsed){ 
        double rotation = secondsElapsed * angleDeltaPerSeconds;
        return rotation;
    }
    
}