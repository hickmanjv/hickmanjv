/******************************************************************************
 Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: MVCStopwatchFXML
 *      -- Use the techniques of MVC to redo the Stopwatch FXML assignment
 *****************************************************************************/
package hickmanjvmvcstopwatchfxml;

import static java.lang.Double.NaN;

public class AnalogClock extends AbstractClock{
    
    private double angleDeltaPerSeconds = 6.0;
    private double angle = NaN;
    
    public AnalogClock(){
        
    }
    
    
    @Override
    public void update() 
    {
        super.update();
        updateAnalog(); 
    }
    
    public void updateAnalog(){
        double oldAngle = angle;
        angle = calcRotation();
        firePropertyChange("Analog", oldAngle, angle);
        
    }
    
    public double calcRotation(){
        
        return secondsElapsed * angleDeltaPerSeconds;
        
    }
}
