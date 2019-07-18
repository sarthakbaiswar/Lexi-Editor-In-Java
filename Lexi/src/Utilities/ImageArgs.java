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
public class ImageArgs extends ViewArgs{

    private String filePath;

    public ImageArgs(Graphics graphics, int top, int left, int frameWidth, int frameHeight, String filePath){
            super(graphics, top, left, frameWidth, frameHeight);
            this.filePath = filePath;
    }

    public String getFilePath(){
            return this.filePath;
    }
}