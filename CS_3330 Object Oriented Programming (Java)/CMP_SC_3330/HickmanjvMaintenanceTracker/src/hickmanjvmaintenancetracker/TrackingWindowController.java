/*
 * Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: - HickmanjvMaintenanceTracker
 *      Program that will keep track of maintenance requests entered into a table
 */
package hickmanjvmaintenancetracker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class TrackingWindowController extends Switcher implements Initializable, Serializable{

    private Requests newRequest;
    private String filename = "requests.ser";
    
    private ArrayList<Requests> fileList = new ArrayList<>();
    
    @FXML
    public TableView<Requests> requestTable;
    
    @FXML
    public TableColumn<Requests, String> floorColumn;
    
    @FXML
    public TableColumn<Requests, String> roomColumn;
    
    @FXML
    public TableColumn<Requests, String> departmentColumn;
    
    @FXML
    public TableColumn<Requests, String> descriptionColumn;
    
    @FXML
    public TextField textFieldFloor;
    
    @FXML
    public TextField textFieldRoom;
    
    @FXML
    public TextField textFieldDepartment;
    
    @FXML
    public TextField textFieldDescription;
    
    
    @FXML
    public VBox panel = new VBox();
    
    @FXML
    public void handleGoToStartWindow(ActionEvent event)
    {
        Switcher.switchTo("StartWindow");
    }
    
    @FXML
    private void deleteRow(ActionEvent event)
    {
        
        // This next line of code I recieved from thenewboston on Youtube, technically in the comments
        // section, was a simpiler method than was implemented in the video
        // "JavaFX Java GUI Tutorial - 20 - Adding and Deleting TableView Rows"
        requestTable.getItems().removeAll(requestTable.getSelectionModel().getSelectedItems());

        fileList.remove(requestTable.getSelectionModel().getSelectedItem());

            try{
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);
            
                out.writeObject(fileList);
            
                out.close();
                file.close();
            } 
            catch(IOException ex){
                System.out.println(ex);
            }
        
    }
    
    @FXML
    private void deleteAllRequests(ActionEvent event){
        
        requestTable.getItems().clear();
        fileList.clear();
   
        
        try{
                FileOutputStream file = new FileOutputStream(filename);
                ObjectOutputStream out = new ObjectOutputStream(file);
            
                out.writeObject(fileList);
                
                out.close();
                file.close();
            } 
            catch(IOException ex){
                System.out.println(ex);
            }
    }
    
    
    @FXML
    public void addNewRequest(ActionEvent event){
     
        newRequest = new Requests(textFieldFloor.getText(), textFieldRoom.getText(),
                                           textFieldDepartment.getText(), textFieldDescription.getText());
        
        requestTable.getItems().add(getRequest());
        
        
        fileList.add(newRequest);
    
        try{
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            
            out.writeObject(fileList);
            
            out.close();
            file.close();
        } 
        catch(IOException ex){
            System.out.println(ex);
        }
        
        textFieldFloor.clear();
        textFieldRoom.clear();
        textFieldDepartment.clear();
        textFieldDescription.clear();
        
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) 
    {
        
        panel.setBackground(new Background(new BackgroundFill(Color.STEELBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
        
        // Had help with the next 4 lines of code from Jaret Wright on his YouTube video
        // "Adding and populating a TableView object using SceneBuilder"
        floorColumn.setCellValueFactory(new PropertyValueFactory<Requests, String>("Floor"));
        roomColumn.setCellValueFactory(new PropertyValueFactory<Requests, String>("Room"));
        departmentColumn.setCellValueFactory(new PropertyValueFactory<Requests, String>("Department"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<Requests, String>("Description"));
        
        try{
         
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            
            try {
                fileList = (ArrayList<Requests>) in.readObject();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TrackingWindowController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            in.close();
            file.close();
            
        } catch(IOException ex){
            
            System.out.println(ex);
            
        }
                
        for(int i = 0; i < fileList.size(); i++){
            newRequest = fileList.get(i);
            requestTable.getItems().add(newRequest);
        }
        
    }
    
    public void setRequest(){
        newRequest = new Requests(textFieldFloor.getText(), textFieldRoom.getText(),
                                  textFieldDepartment.getText(), textFieldDescription.getText());
    }
    
    public Requests getRequest(){
        return newRequest;
    }

    
}
