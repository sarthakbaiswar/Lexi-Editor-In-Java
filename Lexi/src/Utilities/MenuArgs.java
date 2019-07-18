/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import javax.swing.JMenuItem;

/**
 *
 * @author Sarthak
 */
public class MenuArgs {
    private JMenuItem menuItem;
	
    public MenuArgs(JMenuItem item){
        this.menuItem = item;
    }

    public JMenuItem getMenuItem(){
        return this.menuItem;
    }

    public void setJMenuItem(JMenuItem item){
        this.menuItem = item;
    }
}
