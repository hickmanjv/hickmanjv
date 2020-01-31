/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package switchscenes;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Professor Wergeles
 */
public class Page1Controller implements Initializable {
    private Stage stage;        // so you can pass the stage
    private Scene page1Scene;   // current scene, and to be able to come back from scene 2
    private Scene page2Scene;   // so we can go forward from scene 1 to scene 2
    private Page2Controller page2Controller;    // need controller to pass the stage
    
    @FXML
    private Label label;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void start(Stage stage) {
        System.out.println("Page 1 has started");
        this.stage = stage; 
        page1Scene = stage.getScene();
           
    }
    
    @FXML
    private void goToPage2(ActionEvent event) 
    {
        System.out.println("Going to page 2.");
        String result = getDataToTransfer();
        
         if (page2Scene == null)
         {
            try {
                System.out.println("page2scene is null");
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Page2.fxml"));
                Parent page2Root = loader.load(); 
                page2Controller = loader.getController();
                
                page2Controller.page1Scene = page1Scene;  // allows you to come back from scene 2
                page2Controller.page1Controller = this;
                
                page2Scene = new Scene(page2Root);
                
            } catch (IOException ex) {
                Logger.getLogger(Page1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
         stage.setScene(page2Scene);
         //page2Controller.info = "Hello World";  // this changes when the scene first starts
         page2Controller.start(stage);
         
         page2Controller.changeSomething(result);   // this changes it later with added info

    }
    
    public void doThisThing(String info) {
        label.setText(info);
    }
    
    private String getDataToTransfer(){
        TextInputDialog dialog = new TextInputDialog("Enter something");
        dialog.setTitle("Text Input Dialog");
        dialog.setHeaderText("Look, a Text Input Dialog");
        dialog.setContentText("Please enter the data to send:");

        // Traditional way to get the response value.
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            System.out.println("Your name: " + result.get());
            return result.get(); 
        }
     
        return null; 
    }   
}