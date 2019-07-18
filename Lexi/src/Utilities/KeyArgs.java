/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

/**
 *
 * @author Sarthak
 */
public class KeyArgs extends ViewArgs{
    private KeyEvent keyEvent;
	private Font font;
	
	public KeyArgs(Graphics graphics, int top, int left, int frameWidth, int frameHeight, KeyEvent keyEvent, Font font) {
		super(graphics, top, left, frameWidth, frameHeight);
		this.keyEvent = keyEvent;
		this.font = font;
	}
	
	public KeyEvent getKeyEvent(){
		return this.keyEvent;
	}
	
	public Font getFont(){
		return this.font;
	}
}
