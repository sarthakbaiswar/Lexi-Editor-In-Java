/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import java.util.List;
import structure.Glyph;

/**
 *  For arguments when there is a change in structure arguments
 * @author Sarthak
 */
public class ChangeArgs {
    private List<Glyph> glyphs;	
	
    public ChangeArgs(List<Glyph> glyphs){
            this.glyphs = glyphs;
    }

    public List<Glyph> getGlyphs(){
            return this.glyphs;
    }
}
