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
public class ScrollingDoc extends Document{

    private Document document;	
	
    public ScrollingDoc(Document document){
            this.document = document;		
    }
    
    @Override
    public void draw(List<Row> rows, ViewArgs args, int from) {
        if (from >= rows.size()){
	    from = 0;
	}
		
        this.setRows(rows);		
        this.document.draw(rows, args, from);
    }

    @Override
    public Boolean needScrolling(ViewArgs args) {
        Boolean needScrolling = false;
        int totalHeight = 0;
        for (Row row : this.document.getRows()){
            totalHeight += row.getHeight();
        }

        if (totalHeight > args.getFrameHeight()){
            needScrolling = true;
        }

        return needScrolling;
    }
    
}
