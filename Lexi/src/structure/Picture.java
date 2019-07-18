/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import Utilities.Constants;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Graphical element Picture
 * @author Sarthak
 */


public class Picture extends Glyph {

    private BufferedImage image;
    private String FilePath;


    public Picture(String FilePath) {
        this.FilePath = FilePath;
    }

    @Override
    public void draw(Graphics graphics, int x, int y) {
        graphics.drawImage(this.getImage(), x + 3, y, null);
    }

    @Override
    public Element toXmlElement(Document document) {
        Element picElement = document.createElement(Constants.PictureNodeName);

        Attr path = document.createAttribute(Constants.FilePathAttributeName);
        path.setValue(this.FilePath);
        picElement.setAttributeNode(path);

        return picElement;
    }


    @Override
    public int getWidth() {
        return this.getImage().getWidth() + 2;
    }

    @Override
    public int getHeight() {
        return this.getImage().getHeight() + 15;
    }


    @Override
    public void setFont(Font font) {
    }

    @Override
    public Font getFont() {
        return null;
    }

    private BufferedImage getImage() {
        try {
            if (this.image == null) {
                this.image = ImageIO.read(new File(this.FilePath));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return this.image;
    }

}
