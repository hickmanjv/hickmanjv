/******************************************************************************
 Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: MVCStopwatchFXML
 *      -- Use the techniques of MVC to redo the Stopwatch FXML assignment
 *****************************************************************************/
package hickmanjvmvcstopwatchfxml;


public class DigitalClock extends AbstractClock{
    
    String digitalString = null;
    
    public DigitalClock(){
        
    }
    
    @Override
    public void update(){
        super.update();
        updateDigital();
    }
    
    public void updateDigital(){
        String oldString = digitalString;
        digitalString = getMessage();
        firePropertyChange("Digital", oldString, digitalString);
    }
    
    public String getMessage()
    {
        String timeInfo = (String.format("%02d:", (int)(secondsElapsed/60)) +
                    String.format("%02d.", (int)secondsElapsed%60) +
                    String.format("%02d", (int)(secondsElapsed*100%100)));
        
        return timeInfo;
    }
}
