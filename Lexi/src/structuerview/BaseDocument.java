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
public class BaseDocument extends Document{
    @Override
    public void draw(List<Row> rows, ViewArgs args, int from){		
        this.setRows(rows);
        if (this.getRows() != null && this.getRows().size() > 0){
            int currentTop = args.getTop();
            for (int i = from; i < this.getRows().size(); i++){				
                Row row = this.getRows().get(i);
                row.draw(args.getGraphics(), args.getLeft(), currentTop);				
                currentTop += row.getHeight();
            }
        }
    }
	
    @Override
    public Boolean needScrolling(ViewArgs args){
        return false;
    }
}
