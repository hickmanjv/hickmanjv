/*
 * Student: @author Josh Hickman - hickmanjv
 * Student ID: 10236503
 * Assignment: - HickmanjvMaintenanceTracker
 *      Program that will keep track of maintenance requests entered into a table
 */
package hickmanjvmaintenancetracker;

import java.io.Serializable;


public class Requests implements Serializable{
    
    private String floor;
    private String room;
    private String department;
    private String description;
    
   public Requests(String floor, String room, String department, String description){
        
        
        this.floor = new String(floor);
        this.room = new String(room);
        this.department = new String(department);
        this.description = new String(description);
    
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFloor() {
        return floor;
    }

    public String getRoom() {
        return room;
    }

    public String getDepartment() {
        return department;
    }

    public String getDescription() {
        return description;
    }
            
}
