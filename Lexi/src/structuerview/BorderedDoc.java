/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structuerview;

import Utilities.ViewArgs;
import java.util.List;
import structure.Row;

/**
 *
 * @author Sarthak
 */
public class BorderedDoc extends Document{

    private Document document;	
	
    public BorderedDoc(Document document){
            this.document = document;		
    }
    
    @Override
    public void draw(List<Row> rows, ViewArgs args, int from) {
        this.setRows(rows);
        args.getGraphics().drawRect(args.getLeft() - 10, args.getTop() - 20, args.getFrameWidth() - 20, args.getFrameHeight() - 10);
        this.document.draw(rows, args, from);
    }

    @Override
    public Boolean needScrolling(ViewArgs args) {
        return this.document.needScrolling(args);
    }
    
}
