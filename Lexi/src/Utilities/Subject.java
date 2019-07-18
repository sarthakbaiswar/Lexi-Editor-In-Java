/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

/**
 *
 * @author Sarthak
 */
public interface Subject {
    void attach(Observer o);
    void detach(Observer o);
    void notifyy();
}
