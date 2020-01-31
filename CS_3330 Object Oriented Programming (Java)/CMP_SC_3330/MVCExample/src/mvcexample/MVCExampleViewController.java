/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvcexample;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Professor Wergeles
 */
public class MVCExampleViewController implements Initializable {

    @FXML
    private VBox root;
    @FXML
    private MenuItem addPerson;
    @FXML
    private MenuItem getEveryone;
    @FXML
    private MenuItem deleteEveryone;
    @FXML
    private TextArea textArea;
    @FXML
    private TextField textField; 
    
    // instance to model doesn't have @FXML
    MVCExampleModel model;      // do this for MVC Stopwatch
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // this is where you create your variables (model)
        
        model = new MVCExampleModel(); 
    } 
    
    @FXML
    public void addPersonButton(ActionEvent event)
    {
        if(!textField.getText().isEmpty())
        {
            if(model.addPerson(textField.getText())){       // communication to the model
                textArea.setText("Person: " + textField.getText() + " was added successfully!");    // communication coming back
                textField.clear();
            }
            else
            {
                textArea.setText("Could not add person: " + textField.getText());
            }
        }
    }
    
    @FXML
    public void getEveryoneButton(ActionEvent event)
    {
        textArea.setText(model.getEveryone().toString());
    }
    
    @FXML
    public void deleteEveryoneButton(ActionEvent event)
    {
        if(model.deleteEveryone())
        {
            textArea.setText("Everyone was deleted successfully");
        }
        else
        {
            textArea.setText("Could not delete everyone");
        }
    }  
}
