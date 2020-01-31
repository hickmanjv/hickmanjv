/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package documenteditor2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 *
 * @author Professor Wergeles <Professor Wergeles at cs3330@missouri.edu>
 */
public class DocumentEditor2 extends Application {
     
    public String title = "Document Editor 2";
    public int width = 800; 
    public int height = 700; 
    
    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle(title);
        
        VBox root = new VBox(20); 
        
        GridPane grid = new GridPane(); 
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(20);
        
        Label titleLabel = new Label("Title:");
        TextField titleField = new TextField(); 
        titleField.setPrefColumnCount(45);
        HBox titleFieldBox = new HBox(10); 
        titleFieldBox.setAlignment(Pos.CENTER_LEFT);
        titleFieldBox.getChildren().addAll(titleLabel, titleField); 
        grid.add(titleFieldBox, 0, 0);
        
//        HTMLEditor editor = new HTMLEditor(); 
//        editor.setPrefSize(600, 500);
//        grid.add(editor, 0, 1);

        TextArea editor = new TextArea();
            editor.setPrefColumnCount(45);
            editor.setPrefRowCount(25);
            grid.add(editor,0,1);
            
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);
        MenuItem saveItem = new MenuItem("Save");
        fileMenu.getItems().add(saveItem);
        
        saveItem.setOnAction((ActionEvent e) ->{
            FileChooser chooser = new FileChooser();
            
            File file = chooser.showSaveDialog(primaryStage); // also showOpenDialog
            
                if(file != null)
                {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                    writer.write(editor.getText());
                    writer.close();
                }
                
            
        });

        
        root.getChildren().addAll(menuBar, grid); 
        
        Scene scene = new Scene(root, width, height); 
        primaryStage.setScene(scene);
        
        primaryStage.show(); 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    } 
}