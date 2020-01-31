/*
 * Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: - HickmanjvMaintenanceTracker
 *      Program that will keep track of maintenance requests entered into a table
 */
package hickmanjvmaintenancetracker;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;


public abstract class Switcher {
    
    public static Scene scene;      // only have 1 copy of a scene
    public static final HashMap<String, Switcher> CONTROLLERS = new HashMap<>();
    
    private Parent root;
    
    
    public static Switcher add(String name)
    {
        Switcher controller = CONTROLLERS.get(name);
        
            if(controller == null)
            {
                try{
                    FXMLLoader loader = new FXMLLoader(Switcher.class.getResource(name + ".fxml"));
                    Parent root = (Parent) loader.load();
                    controller = (Switcher) loader.getController();
                
                    controller.setRoot(root);
                
                    CONTROLLERS.put(name, controller);
                
                
                } catch (IOException ex) {
                    Logger.getLogger(Switcher.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
                    controller = null; 
                } catch (Exception ex){
                    System.out.println("Error loading " + name + ".fxml \n\n " + ex); 
                    controller = null;
            }
        }
        
        return controller;
    }
    
    public static void switchTo(String name)
    {
        Switcher controller = CONTROLLERS.get(name);
        
        if(controller == null)
        {           
            controller = add(name);
        }
        
        if(controller != null)
        {
            if(scene != null)
            {
                scene.setRoot(controller.getRoot());
            }
        }
    }
    
    // getters and setters
    public void setRoot(Parent root)
    {
        this.root = root;
    }
    
    public Parent getRoot()
    {
        return root;
    }
    
    public static Switcher getControllerByName(String name)
    {
        return CONTROLLERS.get(name);
    }
    
}
