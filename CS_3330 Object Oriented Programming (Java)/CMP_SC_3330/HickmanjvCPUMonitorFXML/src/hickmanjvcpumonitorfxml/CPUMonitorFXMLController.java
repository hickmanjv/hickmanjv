/*******************************************************************************
 *Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: CPUMonitorFXML
 *      - Create a user interface that has both an analog and digital readout
 *      of the current percentage usage of the computer's CPU. Also includes
 *      a record board of most recent 3 CPU readings.
 ******************************************************************************/

package hickmanjvcpumonitorfxml;

import static java.lang.Double.isNaN;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


 
public class CPUMonitorFXMLController implements Initializable {

    private double cpu = 0;
    private Timeline timeline;
    private int count = 1;
    
    
    @FXML
    private Button startButton = new Button();
    
    @FXML
    private Button recordButton = new Button();
    
    @FXML
    private ImageView handImageView = new ImageView();
    
    @FXML
    private Label digitalCPU = new Label();
    
    @FXML
    private Label label1 = new Label();
    
    @FXML
    private Label label2 = new Label();
    
    @FXML
    private Label label3 = new Label();
    
    @FXML
    public void start(ActionEvent event)
    {
        //timeline.setRate(1.5);
        
        if(!isRunning())
        {
            System.out.println("" + calcPercent(cpu));
            setupTimer();
            timeline.setRate(1.25);
            startButton.setText("Stop");
            startButton.setTooltip(new Tooltip("stops the CPU Monitor"));
            startButton.setStyle("-fx-background-color: red");
            recordButton.setText("Record");
            
        }
        else
        {
                timeline.pause();
                startButton.setText("Start");
                startButton.setTooltip(new Tooltip("starts the CPU Monitor again"));
                startButton.setStyle("-fx-background-color: green");
                recordButton.setText("Reset");
        }
    }
    
    @FXML
    public void record(ActionEvent event)
    {   
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");
        LocalDateTime now = LocalDateTime.now();
        
        if(isRunning())
        {   
            if(count == 1 || count % 3 == 1)
            {
                label1.setText("Record " + count + ": " + getMessage() + " at " + dtf.format(now));
                count++;
            }
            else if(count == 2 || count % 3 == 2)
            {
                label2.setText("Record " + count + ": " + getMessage() + " at " + dtf.format(now));
                count++;
            }
            else if(count % 3 == 0)
            {
                label3.setText("Record " + count + ": " + getMessage() + " at " + dtf.format(now));
                count++;
            }
        }
        else
        {
            label1.setText("--.--%  idle");
            label2.setText("--.--%  idle");
            label3.setText("--.--%  idle");
            recordButton.setText("Record");
            count = 1;
        }
        
    }
    
    private static double getCPUUsage() 
    {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();
        
        double value = 0;
        
        for (Method method : operatingSystemMXBean.getClass().getDeclaredMethods()) 
        {
            method.setAccessible(true);
            
            if (method.getName().startsWith("getSystemCpuLoad") && Modifier.isPublic(method.getModifiers())) 
            {
                try 
                {
                    value = (double) method.invoke(operatingSystemMXBean);
                } 
                catch (Exception e) 
                {
                    value = 0.00;
                }
      
                return value;
            }
        }
        
        return value;
    }
    
    public boolean isRunning()
    {
        if(timeline != null){
            if(timeline.getStatus() == Animation.Status.RUNNING){
                return true;
            }
        }
        return false;
    }
    
    private double calcAngle(double cpu)
    {
        if(!isNaN(cpu))
        {
            return (225 + (cpu * 271));   // 271 degrees of rotation on dial instead of 360;
            //return (225 + (1.0 * 271));   Testing 100% CPU rotation
        }
        else
        {
            return 225;
        }
        
    }
    
    public void setupTimer()
    {
        timeline = new Timeline(new KeyFrame(Duration.millis(200), (ActionEvent) -> {
            cpu = getCPUUsage();
            update();
            System.out.printf("CPU: %.2f\n", cpu); //calcAngle(cpu));
        }));    
        
        timeline.setCycleCount(500);
        timeline.play();
    }
    
    private void update()
    {
        handImageView.setRotate(calcAngle(cpu));  
        digitalCPU.setText("CPU : " + String.format("%.2f", calcPercent(cpu)) + "%");
    }
   
    private double calcPercent(double cpu)
    {
        if(!isNaN(cpu))
        {
            return  cpu * 100;
        }
        else
        {
            return 0.00;
        }
    }
   
    public String getMessage()
    {
        String cpuInfo = (String.format("%.2f", calcPercent(cpu)) + "%");
        
        return cpuInfo;
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
    }    
    
}
