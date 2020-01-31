/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvccpumonitorfxml;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;

/**
 *
 * @author harrietgrevers
 */
public class DigitalModel extends AbstractModel {
   
    private int centi=0, sec=0, min=0, hour=0;
    private int lapCounter = 0;
    private String oldString = "";
    private int prevHour, prevMin, prevSec, prevMilli;
    private int secondsElapsed;
   
    @Override
    public void setupMonitor(){
        super.setupMonitor();
    }
    
    public void updateMonitor(){ 
        secondsElapsed += tickTimeInSeconds * 100;

        centi += 1;    
        if(centi == 99){
           sec += 1;
            centi = 0;
        }
        
        if(sec == 59){
            min += 1;
            sec = 0;
        }
        if(min == 59){
            hour += 1;
            min = 0;
        }

        String secondsElapsed = String.format ("%d.%d:%d.%d",  hour, min, sec, centi);
        updateDigital(secondsElapsed);    
    }
    
    public void updateDigital(String digitalTimeString){ 
        firePropertyChange("Digital", oldString, digitalTimeString);
        oldString = digitalTimeString;
    }

    public String calculateLap(){

                lapCounter += 1;
                int hourDifference = hour - prevHour;   
                int minDifference = min- prevMin;
                int secDifference = sec - prevSec;
                int milliDifference = centi - prevMilli;
                 
                if(milliDifference < 0){
                    milliDifference += 1000;
                }   
                
                prevHour = hour; 
                prevMin = min;
                prevSec = sec;
                prevMilli = centi;
               
                String lapDifference = String.format ("Lap %d: %d.%d:%d.%d", lapCounter, hourDifference, 
                        minDifference, secDifference, milliDifference);
                return lapDifference;
                }   
    
}
