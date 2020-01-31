/*
 * Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: - HickmanjvMaintenanceTracker
 *      Program that will keep track of maintenance requests entered into a table
 */
package hickmanjvmaintenancetracker;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class StartWindowController extends Switcher implements Initializable{
    
    @FXML
    public VBox panel = new VBox();
    
    @FXML
    private void handleGoToTrackingWindow(ActionEvent event) {
 
        Switcher.switchTo("TrackingWindow");
    }
    
    @FXML
    private void handleAbout(ActionEvent event){
        
        displayAboutAlert();
    }
    
    private void displayAboutAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("About");
        alert.setHeaderText("MICU Maintenance Tracker");
        alert.setContentText("This application was developed by Josh Hickman as a final project for CS3330 at the University of Missouri.");
        
        TextArea textArea = new TextArea("This program will let the user add a fully customizable maintence request to a table to keep track of various issues that need attention.");
        textArea.appendText("\n\nStudent Pawprint - hickmanjv");
        textArea.setEditable(false);
        textArea.setWrapText(true);
        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
            
        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(textArea, 0, 0);

        alert.getDialogPane().setExpandableContent(expContent);
        
        alert.showAndWait();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        panel.setBackground(new Background(new BackgroundFill(Color.STEELBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        
    }
    
    
    
    
}
