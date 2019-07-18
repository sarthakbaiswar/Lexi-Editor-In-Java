/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.awt.Point;

/**
 *
 * @author Sarthak
 */
public class GlyphDetails {
    
    private Glyph glyph;
    private Point pos;
    private int index;
    
    public GlyphDetails(Glyph glyph, Point pos, int index){
        this.glyph = glyph;
        this.pos = pos;
	this.index = index;
    }
    
    public Glyph getGlyph(){
        return this.glyph;
    }
	
    public Point getPosition(){
        return this.pos;
    }

    public void setPosition(Point pos){
        this.pos = pos;
    }

    public int getIndex(){
        return this.index;
    }
}
