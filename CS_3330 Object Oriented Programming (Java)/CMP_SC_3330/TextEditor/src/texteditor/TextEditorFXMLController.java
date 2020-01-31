/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author josh
 */
public class TextEditorFXMLController implements Initializable {

    /*
        The @FXML annotation is used to tag 'nonpublic' controller member fields
        and handler methods for use by FXML markup
    
        @FXML binds/connects the controller code and the view code
    */
    
    @FXML
    private VBox root;
    
    @FXML
    private TextArea textArea;
    
    @FXML
    public void handleOpen(ActionEvent event){
        
        FileChooser fileChooser = new FileChooser();
        
        Stage stage = (Stage) root.getScene().getWindow();  // explicit cast of Stage...all stages are windows, but not all windows are stages
        
        fileChooser.showOpenDialog(stage);
    }
    
    @FXML
    public void handleSave(ActionEvent event){
     
        System.out.println(textArea.getText());
    }
    
    /*
        Model View Controller (MVC)
    
        * FXML File (UI Code)  -> View
    
        * Java Class handle the event for UI -> Controller
    
        * Data -> Domain Objects, on java side, that connect to the view
                  but only through the controller -> model
    */
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
