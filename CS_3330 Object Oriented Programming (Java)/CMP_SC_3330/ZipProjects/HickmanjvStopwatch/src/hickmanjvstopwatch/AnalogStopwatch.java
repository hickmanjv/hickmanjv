/**************************************************************
 * Student: @author - Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: Stopwatch
 *      -  Tasked to create an analog and digital stopwatch
 *          with a time stamp board
 * 
 * Apologizing for the terrible quality of this project,
 * this isn't my usual standard, and I feel out of sorts w/
 * this for some reason, I'll reach out for office ours
 *************************************************************/

package hickmanjvstopwatch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.util.Duration;

/**
 *
 * @author josh
 * 
 */
public class AnalogStopwatch {
    
    private GridPane root;
    private StackPane stackPane;
    private ImageView dialImageView;
    private ImageView handImageView;
    private Image dialImage;
    private Image handImage;
    private String dialImageName = "clockface.png";
    private String handImageName = "hand.png";
    private Text timer1;
    private Text record1;
    private Text record2;
    private Text record3;
    
    public int width = 800;
    public int height = 600;
    public int milliseconds = 0;
    public int seconds = 0;
    public int minutes = 0;
    public int hours = 0;
    public long endTime = 100;
    
    private Timeline timeline;
    private KeyFrame keyFrame;
    
    private double secondsElapsed = 0.0;
    private double tickTimeInSeconds = 1;
    private double angleDeltaPerSeconds = 6.0;
    
    public AnalogStopwatch(){  //noarg constructor, not a default constructor. using it to initialize variables.
        setupUI();
        setupTimer();
    }
    
    public void setupUI(){
   
        root = new GridPane();
        stackPane = new StackPane(); 
        
        VBox timeBox = new VBox(10);
        timeBox.setAlignment(Pos.CENTER_RIGHT);
        timeBox.setPadding(new Insets(25,25,25,25));
        timer1 = new Text("00:00:00");
            timer1.setFont(Font.font(24));
            timer1.setTextAlignment(TextAlignment.RIGHT);
        record1 = new Text("--:--.--");
            record1.setFont(Font.font(24));
        record2 = new Text("--:--.--");
            record2.setFont(Font.font(24));
        record3 = new Text("--:--.--");
            record3.setFont(Font.font(24));
           
        timeBox.getChildren().addAll(timer1, record1, record2, record3);
        root.getChildren().add(timeBox);
        
        dialImageView = new ImageView();    //create the picture frame
        handImageView = new ImageView();
        dialImage = new Image(getClass().getResourceAsStream(dialImageName));  //here is the pictures
        handImage = new Image(getClass().getResourceAsStream(handImageName));
        dialImageView.setImage(dialImage);  //put the pictures in the pictureframe
        handImageView.setImage(handImage);
        stackPane.getChildren().addAll(dialImageView, handImageView);
        root.getChildren().add(stackPane);
        
        HBox buttonBox = new HBox(15);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);
        buttonBox.setPrefSize(width, height);
        buttonBox.setSpacing(10);
        buttonBox.setPadding(new Insets(500,25,25,25));
        Button recordButton = new Button("Record");
            recordButton.setStyle("-fx-background-color: red;");
        Button startButton = new Button("Start");
        buttonBox.getChildren().addAll(recordButton, startButton);
        root.getChildren().add(buttonBox);
            
        startButton.toFront();
        recordButton.toFront();
        
        
//        AnimationTimer timer = new AnimationTimer() {
//            private long timestamp;
//            private long time = 0;
//            private long fraction = 0;
//
//        @Override
//        public void start() {
//        // current time adjusted by remaining time from last run
//            timestamp = System.currentTimeMillis() - fraction;
//            super.start();
//        }
//
//        @Override
//        public void stop() {
//            super.stop();
//        // save leftover time not handled with the last update
//            fraction = System.currentTimeMillis() - timestamp;
//        }
//
//        @Override
//        public void handle(long now) {
//            long newTime = System.currentTimeMillis();
//                if (timestamp + 1000 <= newTime) {
//                    long deltaT = (newTime - timestamp) / 1000;
//                    time += deltaT;
//                    timestamp += 1000 * deltaT;
//                    timer1.setText(Long.toString(time));
//        }
//    }
//};
//        
        
        startButton.setOnAction((ActionEvent event) -> {
            
            startButton.setText("Stop");
  
            if(!isRunning())
            {
                setTickTimeInSeconds(0.01);
                timeline.play();
                DateFormat timeFormat = new SimpleDateFormat( "mm:ss:SS" );
                final Timeline timeline = new Timeline(
                    new KeyFrame(
                        Duration.millis( 500 ),
                                event1 -> {
                                final long diff = endTime - System.currentTimeMillis();
                        if ( diff < 0 ) {
                        //  timeLabel.setText( "00:00:00" );
                            timer1.setText( timeFormat.format( 0 ) );
                        } 
                        else 
                        {
                            timer1.setText( timeFormat.format( diff ) );
                        }
                        }
                            )
                            );
                startButton.setText("Stop");
            }
            else
            {
                timeline.pause();
                startButton.setText("Start");
                recordButton.setText("Reset");
            }
        });
        
        recordButton.setOnAction((ActionEvent event) -> {
                
            if(recordButton.getText() == "Reset");
            {
                timeline.stop();
                handImageView.setRotate(0);
                secondsElapsed = 0;
                startButton.setText("Start");
                recordButton.setText("Record");
                
                timer1.setText("00:00:00");
                record1.setText("--:--.--");
                record2.setText("--:--.--");
                record3.setText("--:--.--");  
            }
            
        });
        
    }
    
    public void setupTimer(){
        
        if(isRunning()){
            timeline.stop();
        }
        
        keyFrame = new KeyFrame(Duration.millis(tickTimeInSeconds * 1000),
                (ActionEvent actionEvent) -> {                                      
                
                   update(); 
                   
                });
        
        timeline = new Timeline(keyFrame);
                
        timeline.setCycleCount(Animation.INDEFINITE);

    }
    
    private void update(){
        secondsElapsed += tickTimeInSeconds;
        double rotation = secondsElapsed * angleDeltaPerSeconds;
        handImageView.setRotate(rotation);    
//        
//        if(milliseconds > 99)
//        {
//            seconds++;
//            milliseconds = 0;
//        }
//        
//        if(seconds > 59)
//        {
//            minutes++;
//            seconds = 0;
//        }  
        
    }
    
    public Parent getRootContainer(){
        return root;
    }
    
    public double getWidth(){                       
        if(dialImage != null)                   
            return dialImage.getWidth();
        
        else return 0.0;
    }
    
    public double getHeight(){
        if(dialImage != null)
            return dialImage.getHeight();
        
        else return 0.0;
    }
    
    public void start(){
        timeline.play();
    }
    
    public void setTickTimeInSeconds(double tickTimeInSeconds){
        this.tickTimeInSeconds = tickTimeInSeconds;
        setupTimer();
        
        if(!isRunning()){
            timeline.play();
        }
    }
    
    public boolean isRunning(){
        if(timeline != null){
            if(timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        return false;
    }
}


