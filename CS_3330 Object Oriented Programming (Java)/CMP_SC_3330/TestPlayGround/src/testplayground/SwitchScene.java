/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testplayground;

/**
 *
 * @author josh
 */
public class SwitchScene{
    private boolean switched;
    public SwitchScene(){
        switched = false;
    }
    public SwitchScene(boolean switched){
        this.switched = switched;
    }
    public boolean isSwitched(){
        return switched;
    }
    public void mySwitch(){
        switched = !switched;
    }
    
    
    
}
