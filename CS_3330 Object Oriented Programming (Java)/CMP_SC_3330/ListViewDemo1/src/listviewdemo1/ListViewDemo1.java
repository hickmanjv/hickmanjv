/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listviewdemo1;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Professor Wergeles
 */
public class ListViewDemo1 extends Application {
    
    public static final ObservableList LISTITEMS = FXCollections.observableArrayList();  // creating the data
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("List View Sample"); 
        
        final ListView<String> listView = new ListView<>();     // like ImageView...this is ListView  this is what shows up on user Interface
        
        listView.setPrefSize(200, 250);
        
        LISTITEMS.addAll("Nick", "Susan", "Jackie", "Dave", "Zach", "Trudy"); 
        
        // connecting the 2  (Observable List then the ListView
        listView.setItems(LISTITEMS);
        
        
        // event listener
        listView.getSelectionModel().selectedItemProperty().addListener(
                // <> is Generic type that will extend String ( has to at least extend String check javadoc of addListener
                (ObservableValue<? extends String> ov, String old_val, String new_val) -> {
                    System.out.println(new_val + " " + old_val); 
                }
        );
        
        StackPane root = new StackPane(); 
        root.getChildren().add(listView);  // adding the ListView to the scene
        primaryStage.setScene(new Scene(root, 200, 250)); 
        primaryStage.show(); 
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
