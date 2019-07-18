/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import java.awt.Font;
import java.awt.Graphics;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author Sarthak
 */
public abstract class Glyph {
    
    public abstract void draw(Graphics graphics, int x, int y);

	public abstract int getWidth();

	public abstract int getHeight();

	public abstract Font getFont();
	
	public abstract void setFont(Font font);
	
	public abstract Element toXmlElement(Document document);
}
