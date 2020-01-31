/***************************************************************
 * Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: AudioViz
 *      - Adding a class to an existing project that uses the
 *        built in interface to create new visualizer for
 *        music.
 **************************************************************/

package audioviz;

import static java.lang.Integer.min;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Rectangle;


public class HickmanjvSuperVisual implements Visualizer 
{
    
    private final String name = "Hickmanjv Super Visual";
    
    private Integer numBands;
    private AnchorPane vizPane;
    
    private Double width = 0.0;
    private Double height = 0.0;
    
    private final Double bandHeightPercentage = 1.2;
    private final Double minCylinderRadius = 25.0;
    private final Double rotatePhase = 400.0;
    
    private Double bandWidth = 0.0;
    private Double bandHeight = 0.0;
    
    private final Double startHue = 160.0;
    
    private Cylinder[] cylinders;
    
    public HickmanjvSuperVisual()
    {
        
    }
    
    @Override
    public String getName()
    {
        return name;
    }
    
    @Override
    public void start(Integer numBands, AnchorPane vizPane)
    {
        end();
        
        this.numBands = numBands;
        this.vizPane = vizPane;
        
        height = vizPane.getHeight();
        width = vizPane.getWidth();
        
        Rectangle clip = new Rectangle(width, height);
        clip.setLayoutX(0);
        clip.setLayoutY(0);
        vizPane.setClip(clip);
        
        bandWidth = width / numBands;
        bandHeight = height * bandHeightPercentage;
      
        cylinders = new Cylinder[numBands];
        
        for (int i = 0; i < numBands; i++) 
        {
            Cylinder cyl = new Cylinder();
            
            cyl.toBack();
            cyl.setScaleY(1);
            cyl.setScaleX(1);
            cyl.setTranslateY(183);
            cyl.setTranslateX(287);
            cyl.setRadius(bandWidth * 45);
            cyl.setMaterial(new PhongMaterial(Color.hsb(startHue, 1.0, 1.0, 1.0)));
            vizPane.getChildren().add(cyl);
            cylinders[i] = cyl;
        }
    }
    
    @Override
    public void end()
    {
       if (cylinders != null) 
       {
            for (Cylinder cylinder : cylinders)
            {
                vizPane.getChildren().remove(cylinder);
            }
            
            cylinders = null;
            vizPane.setClip(null);
        } 
    }
    
    @Override
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases)
    {
        if (cylinders == null)
        {
            return;
        }
        
        Integer num = min(cylinders.length, magnitudes.length);
        
        for (int i = 0; i < num; i++) 
        {
            cylinders[i].toBack();
            cylinders[i].setRadius(((55.0 + magnitudes[i])/70.0) * (bandHeight/2) + minCylinderRadius);
            cylinders[i].setMaterial(new PhongMaterial(Color.hsb(startHue + (magnitudes[i] * 100.0), 1.0, 1.0, 1.0)));
            cylinders[i].setRotate(phases[i] * rotatePhase);
        }
    }
    
}
