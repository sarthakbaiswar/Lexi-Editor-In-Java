/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * Structural Element : Row
 * @author Sarthak
 */
public class Row extends Glyph {

    private int start;
    private int end;
    private int left;
    private int top;
    private List<GlyphDetails> glyphDetails;

    public Row() {
        this.glyphDetails = new ArrayList<GlyphDetails>();
    }

    public List<GlyphDetails> getGlyphDetails() {
        return this.glyphDetails;
    }

    @Override
    public int getHeight() {
        int height = 0;
        for (GlyphDetails gd : this.glyphDetails) {
            if (height < gd.getGlyph().getHeight()) {
                height = gd.getGlyph().getHeight();
            }
        }

        return height + Utilities.Constants.newLineGap;
    }

    @Override
    public int getWidth() {
        int width = 2;
        for (GlyphDetails gd : this.glyphDetails) {
            width += gd.getGlyph().getWidth();
        }

        return width;
    }

    @Override
    public void draw(Graphics graphics, int x, int y) {
        int currentLeft = x;
        for (GlyphDetails gd : this.glyphDetails) {
            gd.getGlyph().draw(graphics, currentLeft, y);
            currentLeft += gd.getGlyph().getWidth() + 2;
        }
    }


    @Override
    public void setFont(Font font) {
    }

    @Override
    public Font getFont() {
        return null;
    }

    public int getStartIndex() {
        return start;
    }

    public void setStartIndex(int startIndex) {
        this.start = start;
    }

    public int getEndIndex() {
        return end;
    }

    public void setEndIndex(int end) {
        this.end = end;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    @Override
    public Element toXmlElement(Document document) {
        return null;
    }

}
