/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvccpumonitorfxml;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 * @author harrietgrevers
 */
public class Controller implements Initializable, PropertyChangeListener{
    //need to implement all abstract methods after adding propertychangelistener
    //goes to bottom of this page

    @FXML
    private ImageView hand;
    @FXML
    private Button startStopButton;
    @FXML
    private Button recordResetButton;
    @FXML
    private Text record0;
    @FXML
    private Text record1; 
    @FXML 
    private Text record2;
    @FXML 
    private Text record3;

    AnalogModel analogModel; 
    DigitalModel digitalModel;
    AbstractModel abstractModel;
    
    private int lapCounter = 0; 
    private int min, sec, milli, hour;
    private int prevMilli, prevSec, prevMin, prevHour;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        analogModel = new AnalogModel(); 
        digitalModel = new DigitalModel();
        analogModel.setupMonitor();
        digitalModel.setupMonitor();
        hand.setRotate(0);
        record0.setText("00.00");
        
        analogModel.addPropertyChangeListener(this);
        digitalModel.addPropertyChangeListener(this);
    }

    @FXML
    public void startStopMonitor(ActionEvent event) {
        //if ( !(isRunnning())) {
        if ( !(analogModel.isRunning())) {
            analogModel.start();
            digitalModel.start();
            startStopButton.setText("Stop");
        } else {
            analogModel.stop();
            digitalModel.stop();
            startStopButton.setText("Start");
            recordResetButton.setText("Reset");
        }
    }
    
    @FXML
    public void recordResetMonitor(ActionEvent event){
        
        if (!(analogModel.isRunning())){
            recordResetButton.setText("Record");
        }
        
        if( (analogModel.isRunning())){
            recordResetButton.setText("Record");
            
            lapCounter += 1;
            
            if(lapCounter %3 == 1){
            record1.setText(digitalModel.calculateLap());
            }
            else if(lapCounter %3 == 2){
            record2.setText(digitalModel.calculateLap());
            }
            else if(lapCounter %3 == 0){
            record3.setText(digitalModel.calculateLap());
            }  
        }
        
        else{
            record0.setText("00:00");
            record1.setText("--:--.--");
            record2.setText("--:--.--");
            record3.setText("--:--.--");          
            
           analogModel.updateAnalog(0.00);
        }
    
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    if(evt.getPropertyName().equals("Analog")){
    hand.setRotate((double)evt.getNewValue());
    }
    else if(evt.getPropertyName().equals("Digital")){
    record0.setText(evt.getNewValue().toString());
    }
}
}
