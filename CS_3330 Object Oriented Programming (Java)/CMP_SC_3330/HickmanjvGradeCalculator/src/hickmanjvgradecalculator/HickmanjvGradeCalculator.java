/********************************************************************
* Student: @author Josh Hickman - hickmanjv
* Student ID: 10236503
* Date: 09/13/18
* Assignment: To create a JavaFX program that calculates grades of
*             different weights.
********************************************************************/

package hickmanjvgradecalculator;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author josh
 */
public class HickmanjvGradeCalculator extends Application 
{
    public String title = "Grade Calculator";
    public int width = 500;
    public int height = 400;
    
    public String fontStyle = "Ariel MS";
    
    @Override
    public void start(Stage primaryStage) 
    {
        
        primaryStage.setTitle(title);       // adding the title
        
        GridPane root = new GridPane();     // creating/setting the stage
            root.setHgap(15);
            root.setVgap(15);
            root.setAlignment(Pos.CENTER);
        
        // First Label and corresponding TextField
        Label category1 = new Label("Category 1 (30%):");
            root.add(category1, 0, 0);
        
        TextField score1 = new TextField("");
            score1.setPrefWidth(400);
            root.add(score1, 0, 1);
            
        // Second Label and corresponding TextField
        Label category2 = new Label("Category 2 (70%)");
            root.add(category2, 0, 2);
            
        TextField score2 = new TextField("");
            score2.setPrefWidth(400);
            root.add(score2, 0, 3);    
        
        // Third Label and corresponding TextField
        Label finalScore = new Label("My Final Score");
            root.add(finalScore, 0, 4);
        
        TextField score3 = new TextField("");
            score3.setPrefWidth(400);
            root.add(score3, 0, 5);
        
        Button maximize = new Button("Maximize");
            maximize.setOnAction((ActionEvent e) -> {
                
                score1.setText("100");
                score2.setText("100");
            });
            
        Button calculate = new Button("Calculate");
            calculate.setOnAction((ActionEvent e) -> {
                
                double firstScore = Double.parseDouble(score1.getText());
                double secondScore = Double.parseDouble(score2.getText());
                DecimalFormat decimal = new DecimalFormat("0.00");
                double finalValue = (firstScore * 0.3) + (secondScore * 0.7);
                String finalStringValue = String.valueOf(decimal.format(finalValue));
                score3.setText("My final score should be " + score1.getText() + " * 0.3 + " + score2.getText() + " * 0.7 = " + finalStringValue);
            });
            
        Button clear = new Button("Clear");
            clear.setOnAction((ActionEvent e) -> {
                
                score1.setText("");
                score2.setText("");
                score3.setText("");
            });
            
        Button alert = new Button("Alert");
            alert.setOnAction((ActionEvent e) -> {
                
                Alert alertBox = new Alert(AlertType.INFORMATION, score3.getText());
                    alertBox.setTitle("Alert");
                    alertBox.showAndWait().ifPresent(response -> {

                });
            });
        
        VBox vboxForButtons = new VBox(15);
        vboxForButtons.setPadding(new Insets(0,0,15,0));
        vboxForButtons.setAlignment(Pos.CENTER);
            maximize.setMaxWidth(Double.MAX_VALUE);
            calculate.setMaxWidth(Double.MAX_VALUE);
            clear.setMaxWidth(Double.MAX_VALUE);
            alert.setMaxWidth(Double.MAX_VALUE);
        vboxForButtons.getChildren().addAll(maximize, calculate, clear, alert);
            root.add(vboxForButtons, 0, 6);
        
        Scene scene = new Scene(root, width, height);  // creating the scene
        primaryStage.setScene(scene);       // setting the scene
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
