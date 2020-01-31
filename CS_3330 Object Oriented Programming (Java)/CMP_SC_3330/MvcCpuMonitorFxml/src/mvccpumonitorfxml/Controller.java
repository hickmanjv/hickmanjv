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
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 * 
 * @references
 *      http://www.oracle.com/technetwork/articles/javase/mvc-136693.html
 * 
 * 
 * The main thing in the controller will either be invoking the model or 
 *  updating the view. The variables in the controller are mainly the variables
 *  linking with the view. The methods in the controller are mainly the event
 *  handler methods which will call some method in the model. The initialize 
 *  method can be used to create an instance of the model(s) and to setup the 
 *  timeline in the model. You can also add the property change listener 
 *  connection between the controller and the model (Two way communication 
 *  coming back from the model to controller). The initialize method is similar
 *  to a constructor, used to initialize variables, etc. The property change method
 *  will be invoked when the property changes and the firePropertyChange() method
 *  is invoked. 
 * 
 */
public class Controller implements Initializable, PropertyChangeListener {
    
    @FXML
    private Text cpuLabel;
    @FXML
    private ImageView hand;
    @FXML
    private Button startStopButton;

    /* Only non-@FXML variable here in the controller is the instance variable 
        created for the model class
    */
    Model model;
    DigitalModel digitalModel;
    
    /**
     * Initializes the controller class.
     * @param url @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new Model();
        digitalModel = new DigitalModel();
        
        model.setupMonitor();
        digitalModel.setupMonitor();
        
        hand.setRotate(0);
        cpuLabel.setText("00.00%");
        
        model.addPropertyChangeListener(this);
        digitalModel.addPropertyChangeListener(this);
        
        
    }

    
    @FXML
    public void startStopMonitor(ActionEvent event) {
        
        if( !(model.isRunnning()) && !(digitalModel.isRunnning())){
            model.start();
            digitalModel.start();
            startStopButton.setText("Stop");
        }
        else
        {
            model.stop();
            digitalModel.start();
            startStopButton.setText("Start");
        }
        
    }
    /* Main thing in the controller is the on-click event listeners */ 
    @FXML
    public void startMonitor(ActionEvent event) {
        model.start();
    }
    @FXML
    public void stopMonitor(ActionEvent event) {
        model.stop();
    }
    
    /* If setup properly, this method is called when the property has been 
        updated and the firePropertyChange() method is invoked. This is called
        from the model. Which will tell the controller to update the view. 
        However, the model will not update the view directly. 
    */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("Analog")){
            hand.setRotate((double) evt.getNewValue());
        }
        else if(evt.getPropertyName().equals("Digital")){
            cpuLabel.setText(evt.getNewValue().toString() + "%");
        }
        
//        System.out.println(evt.getNewValue());
//        hand.setRotate((double) evt.getNewValue());
    }
}
