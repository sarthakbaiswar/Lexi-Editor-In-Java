/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import structure.Composition;
import structure.Glyph;

/**
 *
 * @author Sarthak
 */
public class Insert implements Command {

    private int index;
    private Composition document;
    private Glyph glyph;

    public Insert(Composition document, Glyph glyph, int from) {
        this.document = document;
        this.glyph = glyph;
        this.index = from;
    }

    @Override
    public boolean execute() {
        this.document.insert(this.glyph, this.index);
        return true;
    }

    @Override
    public void unExecute() {
        this.document.remove(this.index);
    }

    @Override
    public boolean canUndo() {
        return true;
    }
}
