/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stk7c9stopwatch;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Skyler
 */
public class Stk7c9Stopwatch extends Application {
    
    private String appName = "Stk7c9Stopwatch";
    
    @Override
    public void start(Stage primaryStage) {//initial point of javafx program; technically don't need main

        AnalogStopWatch analogStopWatch = new AnalogStopWatch();
        
        Scene scene = new Scene(analogStopWatch.getRootContainer(),
                                analogStopWatch.getWidth(),
                                analogStopWatch.getHeight());
        
        primaryStage.setTitle(appName);
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
