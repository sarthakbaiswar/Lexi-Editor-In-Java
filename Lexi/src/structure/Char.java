/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import Utilities.Constants;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


/**
 * Graphical Element character
 * @author Sarthak Baiswar
 */
public class Char extends Glyph {

	private char ch;
	private Font font;
	private FontMetrics fm;

	public Char(char ch, Font font) {
            this.ch = ch;
            this.font = font;
	}

	@Override
	public void draw(Graphics graphics, int x, int y) {
            this.fm = graphics.getFontMetrics(this.font);
            graphics.setFont(this.font);
            graphics.drawString(Character.toString(ch), x, y);
	}


	@Override
	public int getWidth() {
            int wi = 0;
            if (this.fm != null) {
                wi = this.fm.stringWidth(Character.toString(this.ch));
            }

            return wi;
	}

	@Override
	public int getHeight() {
            int ht = 0;
            if (this.fm != null) {
                ht = this.fm.getHeight();
            }

            return ht;
	}

	@Override
	public String toString() {
            return "Character Glyph: [" + this.ch + "]";
	}


	@Override
	public void setFont(Font font) {
            this.font = font;
	}

	@Override
	public Font getFont() {
            return this.font;
	}

	@Override
	public Element toXmlElement(Document document) {
            Element charElement = document.createElement(Constants.CharNodeName);
            Element contentElement = document.createElement(Constants.ContentString);
            contentElement.appendChild(document.createTextNode(Character.toString(this.getChar())));
            charElement.appendChild(contentElement);

            Element fontNameElement = document.createElement(Constants.FontNodeName);

            Attr name = document.createAttribute(Constants.FontNameAttributeName);
            name.setValue(this.font.getName());
            fontNameElement.setAttributeNode(name);

            Attr style = document.createAttribute(Constants.FontStyleAttributeName);
            style.setValue(Integer.toString(this.font.getStyle()));
            fontNameElement.setAttributeNode(style);

            Attr size = document.createAttribute(Constants.FontSizeAttributeName);
            size.setValue(Integer.toString(this.font.getSize()));
            fontNameElement.setAttributeNode(size);

            charElement.appendChild(fontNameElement);
            return charElement;
	}

	public int getCharacterCode() {
            return (int) this.ch;
	}

	public char getChar() {
            return this.ch;
	}

	private FontMetrics getFontrMetrics(Graphics graphics) {
            return graphics.getFontMetrics();
	}

}
