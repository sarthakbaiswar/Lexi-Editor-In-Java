/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.awt.Graphics;

/**
 *
 * @author Sarthak
 */
public class ViewArgs {
    private Graphics graphics;
    private int top;
    private int left;
    private int frameWidth;
    private int frameHeight;
	
    public ViewArgs(Graphics graphics, int top, int left, int frameWidth, int frameHeight){
        this.graphics = graphics;
        this.top = top;
        this.left = left;
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
    }

    public Graphics getGraphics(){
        return this.graphics;
    }

    public int getTop(){
        return this.top;
    }

    public int getLeft(){
        return this.left;
    }

    public int getFrameWidth(){
        return this.frameWidth;
    }

    public int getFrameHeight(){
        return this.frameHeight;
    }
}
