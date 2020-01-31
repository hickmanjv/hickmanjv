/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package switcherexample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author Professor Wergeles
 */
public class AController extends Switchable implements Initializable {
    // each controller you switch to must extend Switchable
    @FXML
    public TextField textField;
    
    @FXML
    public VBox panel = new VBox();
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        panel.setBackground(new Background(new BackgroundFill(Color.STEELBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    }
    
    @FXML
    private void handleGoToB(ActionEvent event) {
        Switchable.switchTo("B");
    }
    
    @FXML
    private void handleGoToC(ActionEvent event) {
        Switchable.switchTo("C");
    }
}
