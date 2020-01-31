/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clickpointanim;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 *
 * @author Professor Wergeles
 */

public class Animation implements Runnable{  //extends Thread{    more flexible because you can extends something else

    public Boolean stop = false;
    
    private AnchorPane anchorPane;
    private Double xPosn;
    private Double yPosn;
    private Double minRadius = 1.0;
    private Double maxRadius = 30.0;
    private Double currentRadius = 10.0;
    private Ellipse ellipse;
    private Long sleepTime = 20L;
    private Random random;
    private Double hue;
    
    public Animation(AnchorPane anchorPane, Double xPosn, Double yPosn) {
        this.anchorPane = anchorPane;
        this.xPosn = xPosn;
        this.yPosn = yPosn;
        random = new Random(System.currentTimeMillis()); // use time for seed
        //System.out.println("Random: " + random.nextDouble()); 
        hue = random.nextDouble() * 360.0;
        ellipse = new Ellipse();
        ellipse.setRadiusX(10);
        ellipse.setRadiusY(10);
        ellipse.setStrokeWidth(5);
        ellipse.setStroke(Color.hsb(hue, 1.0, 1.0, 0.5));
        ellipse.setFill(Color.hsb(hue, 1.0, 1.0, 0.0));
        ellipse.setCenterX(xPosn);
        ellipse.setCenterY(yPosn);
        anchorPane.getChildren().add(ellipse);
    }
    
    // this is if you extends the Thread class, need to write your own run
    @Override
    public void run()
    {
        // do all of this for extra on challenge 10, infinite while loop followed by what you were going to do
        while(!stop)
        {
            currentRadius++;
            
            if(currentRadius > maxRadius)
            {
                currentRadius = minRadius;
            }
            
            // each band do this
            Platform.runLater(() -> {
                ellipse.setRadiusX(currentRadius);
                ellipse.setRadiusY(currentRadius);
            });
            
            // have to try/catch to make this happen w/o errors
            try {
                // need to do this to slow it down
                Thread.sleep(sleepTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(Animation.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        }
    }

    public void end() {
        stop = true; 
    }
}
