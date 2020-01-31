/******************************************************************************
 Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: MVCStopwatchFXML
 *      -- Use the techniques of MVC to redo the Stopwatch FXML assignment
 *****************************************************************************/
package hickmanjvmvcstopwatchfxml;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;


public class MVCStopwatchController implements Initializable, PropertyChangeListener {
   
    private int count = 1;
    
    @FXML
    private Button startButton = new Button();
    
    @FXML
    private Button recordButton = new Button();
    
    @FXML
    private ImageView handImageView = new ImageView();
    
    @FXML
    private Label digitalClockLabel = new Label();
    
    @FXML
    private Label recordLabel1 = new Label();
    
    @FXML
    private Label recordLabel2 = new Label();
    
    @FXML
    private Label recordLabel3 = new Label();
    
    
    
    @FXML
    public void start(ActionEvent event)
    {
        
        
        if(!(analog.isRunning()) && !(digital.isRunning()))
        {
            analog.start();
            digital.start();
            updateController();
            analog.setTickTimeInSeconds(0.01);
            analog.setupTimer();
            digital.setupTimer();
            startButton.setText("Stop");
            startButton.setStyle("-fx-background-color: red");
            recordButton.setText("Record");
            
        }
        else
        {
            analog.stop();
            digital.stop();
            startButton.setText("Start");
            startButton.setStyle("-fx-background-color: green");
            recordButton.setText("Reset");
        }
    }
    
    @FXML
    public void record(ActionEvent event)
    {   
        
        if((analog.isRunning()) && (digital.isRunning()))
        {   
            if(count == 1 || count % 3 == 1)
            {
                recordLabel1.setText("Lap " + count + ": " + digital.getMessage());
                count++;
            }
            else if(count == 2 || count % 3 == 2)
            {
                recordLabel2.setText("Lap " + count + ": " + digital.getMessage());
                count++;
            }
            else if(count % 3 == 0)
            {
                recordLabel3.setText("Lap " + count + ": " + digital.getMessage());
                count++;
            }
        }
        else if(!(analog.isRunning()) && !(digital.isRunning()))
        {
            analog.reset();
            digital.reset();
            recordLabel1.setText("--:--.--");
            recordLabel2.setText("--:--.--");
            recordLabel3.setText("--:--.--");
            recordButton.setText("Record");
            handImageView.setRotate(0);
            
            digitalClockLabel.setText("--:--.--");
            count = 1;
        }
    }
    

    
    // split into 3 - Abstract, Digital, Analog

    public void updateController()
    {
        digitalClockLabel.setText(digital.getMessage());
        handImageView.setRotate(analog.calcRotation());

    }

    
    AnalogClock analog;
    DigitalClock digital;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        analog = new AnalogClock();
        digital = new DigitalClock();
        
        analog.setupTimer();
        digital.setupTimer();
        
        handImageView.setRotate(0);
        digitalClockLabel.setText("--:--.--");
        
        analog.addPropertyChangeListener(this);
        digital.addPropertyChangeListener(this);
        
    }    

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        
        if(evt.getPropertyName().equals("Analog")){
            handImageView.setRotate((double) evt.getNewValue());
        }
        else if(evt.getPropertyName().equals("Digital")){
            digitalClockLabel.setText(evt.getNewValue().toString());
          
        }
        //else if(evt.getPropertyName().equals("Label"))
        
        // do Analog
        // do Digital 
        // do Lap
        
        // only has 
        
    }
    
}
