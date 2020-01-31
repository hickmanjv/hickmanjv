/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stk7c9stopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 *
 * @author Skyler
 */
public class AnalogStopWatch {

    private BorderPane root;
    private StackPane stack;

    private ImageView dialImageView;
    private ImageView handImageView;
    private ImageView minuteHandImageView;
    private ImageView hourHandImageView;
    private ImageView startImageView;
    private ImageView stopImageView;

    private Image dialImage;
    private Image handImage;
    private Image minuteHandImage;
    private Image hourHandImage;
    private Image startImage;
    private Image stopImage;

    private String dialImageName = "clockface.png";
    private String handImageName = "image.png";
    private String minuteHandImageName = "image.png";
    private String hourHandImageName = "image.png";
    private String startImageName = "play.png";
    private String stopImageName = "if_Button_Rec_72914.png";

    private Timeline timeline;
    private KeyFrame keyFrame;

    private double secondsElapsed = 0.0;
    private double tickTimeInSeconds = 0.01;
    private double angleDeltaPerSeconds = 6.0;
    private int digitalCentiseconds;
    private int digitalSeconds;
    private int digitalMinutes;
    private int digitalHours;
    private int prevCenti = 0;
    private int prevSecond = 0;
    private int prevMinute = 0;
    private int prevHour = 0;
    
    private VBox digitalVBox;
    private double vboxWidth = 250;
    private double vboxHeight = 250;
    private Label digitalTimer;
    private Label lapOne;
    private Label lapTwo;
    private Label lapThree;
    private HBox buttonBox;
    
    private String font = "Consolas";
    private double fontSize = 18.0;
    
    private int counter = 0;//to determine lap number
    
    public AnalogStopWatch() {
        setupUI();    
        setupTimer();
    }
    
    public void setupUI(){
        root = new BorderPane();
        stack = new StackPane();
        
        dialImageView = new ImageView();//make picture frame
        handImageView = new ImageView();
        minuteHandImageView = new ImageView();
        hourHandImageView = new ImageView();
        startImageView = new ImageView();
        stopImageView = new ImageView();
        
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));
        handImage = new Image(getClass().getResourceAsStream(handImageName));//make pictures
        minuteHandImage = new Image(getClass().getResourceAsStream(minuteHandImageName));
        hourHandImage = new Image(getClass().getResourceAsStream(hourHandImageName));
        startImage = new Image(getClass().getResourceAsStream(startImageName));
        stopImage = new Image(getClass().getResourceAsStream(stopImageName));
        
        dialImageView.setImage(dialImage);//put pictures in picture frame
        handImageView.setImage(handImage);
        minuteHandImageView.setImage(minuteHandImage);
        hourHandImageView.setImage(hourHandImage);
        startImageView.setImage(startImage);
        stopImageView.setImage(stopImage);
        
        stack.getChildren().addAll(dialImageView, handImageView, minuteHandImageView, hourHandImageView);
        root.setLeft(stack);
              
        //making digital display and record board
        digitalTimer = new Label();
        digitalTimer.setFont(Font.font(font, fontSize));
        digitalTimer.setText("Timer: --:--:--.--");
        lapOne = new Label();
        lapOne.setFont(Font.font(font, fontSize));
        lapOne.setText("--:--:--.--");
        lapTwo = new Label();
        lapTwo.setFont(Font.font(font, fontSize));
        lapTwo.setText("--:--:--.--");
        lapThree = new Label();
        lapThree.setFont(Font.font(font, fontSize));
        lapThree.setText("--:--:--.--");
        
        digitalVBox = new VBox();
        digitalVBox.setAlignment(Pos.TOP_CENTER);
        digitalVBox.setMaxSize(vboxWidth, vboxHeight);
               
        digitalVBox.getChildren().addAll(digitalTimer, lapOne, lapTwo, lapThree);
        root.setCenter(digitalVBox);
        
        //making buttons
        buttonBox = new HBox();
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.setPadding(new Insets(0, 0, 15, 0));
        
        Button startStopButton = new Button("Start", startImageView);
        startStopButton.setStyle("-fx-background-color: #00ff00; -fx-font-size: 2em;");
        Button recordResetButton = new Button("Reset");
        recordResetButton.setStyle("-fx-font-size: 2em;");
        buttonBox.getChildren().addAll(startStopButton, recordResetButton);
        root.setBottom(buttonBox);
        
        //button effects
        DropShadow shadow = new DropShadow();
        startStopButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            startStopButton.setEffect(shadow); //shadow effect
        });
        startStopButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            startStopButton.setEffect(null); //remove effect
        });
        
        recordResetButton.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            recordResetButton.setEffect(shadow); //shadow effect
        });
        recordResetButton.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
            recordResetButton.setEffect(null); //remove effect
        });
        
        //button functions
      
        startStopButton.setOnAction((ActionEvent event) -> {
            
            if (!isRunning()){
                startStopButton.setText("Stop");
                startStopButton.setStyle("-fx-background-color: #ff1500; -fx-font-size: 2em;");
                startStopButton.setGraphic(stopImageView);
                recordResetButton.setText("Record");
                startTimer();
            }
            else{
                startStopButton.setText("Start");
                startStopButton.setStyle("-fx-background-color: #00ff00; -fx-font-size: 2em;");
                startStopButton.setGraphic(startImageView);
                recordResetButton.setText("Reset");
                pauseTimer();
            }
        });
        
        recordResetButton.setOnAction((ActionEvent event) -> {
            if (!isRunning()){//reset
                digitalTimer.setText("Timer: --:--:--.--");
                lapOne.setText("--:--:--.--");
                lapTwo.setText("--:--:--.--");
                lapThree.setText("--:--:--.--");
                secondsElapsed = 0.0;
                counter = 0;
                stopTimer();
            }
            else{//record
                if (isRunning()){
                    switch (counter % 3) {
                        case 0:
                            int hourDifference = digitalHours - prevHour;
                            int minuteDifference = digitalMinutes - prevMinute;
                            int secondDifference = digitalSeconds - prevSecond;
                            int centiDifference = digitalCentiseconds - prevCenti;
                            if (centiDifference < 0){
                                centiDifference += 100;
                            }
                            if (secondDifference < 0){
                                secondDifference *= -1;
                            }
                            
                            prevHour = digitalHours;
                            prevMinute = digitalMinutes;
                            prevSecond = digitalSeconds;
                            prevCenti = digitalCentiseconds;
                            
                            String centiseconds = String.format("%02d", centiDifference);
                            String seconds = String.format("%02d", secondDifference);
                            String minutes = String.format("%02d", minuteDifference);
                            String hours = String.format("%02d", hourDifference);
                            
                            lapOne.setText("Lap " + ++counter + ": " + hours + ":" + minutes + ":" + seconds +
                                    "." + centiseconds);
                            break;
                            
                        case 1:
                            hourDifference = digitalHours - prevHour;
                            minuteDifference = digitalMinutes - prevMinute;
                            secondDifference = digitalSeconds - prevSecond;
                            centiDifference = digitalCentiseconds - prevCenti;
                            if (centiDifference < 0){
                                centiDifference += 100;
                            }
                            if (secondDifference < 0){
                                secondDifference *= -1;
                            }
                            
                            prevHour = digitalHours;
                            prevMinute = digitalMinutes;
                            prevSecond = digitalSeconds;
                            prevCenti = digitalCentiseconds;
                            
                            centiseconds = String.format("%02d", centiDifference);
                            seconds = String.format("%02d", secondDifference);
                            minutes = String.format("%02d", minuteDifference);
                            hours = String.format("%02d", hourDifference);
                            
                            lapTwo.setText("Lap " + ++counter + ": " + hours + ":" + minutes + ":" + seconds +
                                    "." + centiseconds);
                            break;
                            
                        default:
                            hourDifference = digitalHours - prevHour;
                            minuteDifference = digitalMinutes - prevMinute;
                            secondDifference = digitalSeconds - prevSecond;
                            centiDifference = digitalCentiseconds - prevCenti;
                            if (centiDifference < 0){
                                centiDifference += 100;
                            }
                            if (secondDifference < 0){
                                secondDifference *= -1;
                            }
                            
                            prevHour = digitalHours;
                            prevMinute = digitalMinutes;
                            prevSecond = digitalSeconds;
                            prevCenti = digitalCentiseconds;
                            
                            centiseconds = String.format("%02d", centiDifference);
                            seconds = String.format("%02d", secondDifference);
                            minutes = String.format("%02d", minuteDifference);
                            hours = String.format("%02d", hourDifference);
                            
                            lapThree.setText("Lap " + ++counter + ": " + hours + ":" + minutes + ":" + seconds +
                                    "." + centiseconds);
                            break;
                    }
                }
            }
        });
        
        buttonBox.toFront();
    }
    
    public void setupTimer(){
        
        if (isRunning()){
            timeline.stop();//stop timeline if running to then update the variable
        }
        
        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000), 
                (ActionEvent actionEvent) -> {
                    
                    update();//cannot change variable while running; check if running before updating
                    
                });
        
        timeline = new Timeline(keyFrame);     
        timeline.setCycleCount(Animation.INDEFINITE);
    }
    
    private void update(){
        secondsElapsed += tickTimeInSeconds;
        double rotationSeconds = secondsElapsed * angleDeltaPerSeconds;
        double rotationMinutes = rotationSeconds / 60;
        double rotationHours = rotationMinutes / 60;
        handImageView.setRotate(rotationSeconds);
        minuteHandImageView.setRotate(rotationMinutes);
        hourHandImageView.setRotate(rotationHours);
        
        digitalCentiseconds = (int)(secondsElapsed * 100) % 100;
        digitalSeconds = (int)secondsElapsed % 60;
        digitalMinutes = (int)(secondsElapsed / 60) % 60;
        digitalHours = (int)(secondsElapsed / 3600) % 24;
        
        String centiseconds = String.format("%02d", digitalCentiseconds);
        String seconds = String.format("%02d", digitalSeconds);
        String minutes = String.format("%02d", digitalMinutes);
        String hours = String.format("%02d", digitalHours);
        
        digitalTimer.setText("Timer: " + hours + ":" + minutes + ":" + seconds + "." + centiseconds);
    }
    
    public Parent getRootContainer(){
        return root;
    }
    
    public double getWidth(){
        if(dialImage != null) return dialImage.getWidth() + 250;
        else return 0.0;
    }
    
    public double getHeight(){
        if(dialImage != null) return dialImage.getHeight() + 100;
        else return 0.0;
    }
    
    public void setTickTimeInSeconds(double tickTimeInSeconds){
        this.tickTimeInSeconds = tickTimeInSeconds;
        setupTimer();
        
        if (!isRunning()){
            timeline.play();
        }
    }

    public boolean isRunning(){
        if (timeline != null){
            if (timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        return false;
    }
    
    public void startTimer(){
        timeline.play();
    }
    
    public void pauseTimer(){
        timeline.pause();
    }
    
    public void stopTimer(){
        timeline.stop();
        handImageView.setRotate(0.0);
        minuteHandImageView.setRotate(0.0);
        hourHandImageView.setRotate(0.0);
    }
}