/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import java.awt.EventQueue;
import structure.Composition;

/**
 *
 * @author Sarthak Baiswar
 */
public class DemoApp {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {			
                   //tried multiple views of same app like you can open 2 instances of the app
                   //used observer
                    Composition composed = new Composition();
                    Composition composed1 = new Composition();
                    Controls c1 = new Controls(composed);
                    new mainframe_swing(composed, c1);
//                    
                    Controls c2 = new Controls(composed1);
                    new mainframe_swing(composed1, c2);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
