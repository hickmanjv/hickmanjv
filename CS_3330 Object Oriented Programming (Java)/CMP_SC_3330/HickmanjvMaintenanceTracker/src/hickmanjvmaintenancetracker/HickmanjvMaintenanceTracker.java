/*
 * Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: - HickmanjvMaintenanceTracker
 *      Program that will keep track of maintenance requests entered into a table
 */
package hickmanjvmaintenancetracker;

import javafx.application.Application;
import static javafx.application.Application.STYLESHEET_MODENA;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class HickmanjvMaintenanceTracker extends Application {
    
    @Override
    public void start(Stage stage) {
        
        HBox root = new HBox();
        root.setPrefSize(600, 400);
        root.setAlignment(Pos.CENTER);
        Text message = new Text("Error occured while switching scenes");
        message.setFont(Font.font(STYLESHEET_MODENA, 32));
        root.getChildren().add(message);
        
        
        Scene scene = new Scene(root);
        
        Switcher.scene = scene;
        Switcher.switchTo("StartWindow");
        
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
