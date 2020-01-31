/***************************************************************
 * Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: AudioViz
 *      - Adding a class to an existing project that uses the
 *        built in interface to create new visualizer for
 *        music.
 **************************************************************/

package audioviz;

import javafx.scene.layout.AnchorPane;


public interface Visualizer {
    public void start(Integer numBands, AnchorPane vizPane);
    public void end();
    public String getName();
    public void update(double timestamp, double duration, float[] magnitudes, float[] phases);
}
