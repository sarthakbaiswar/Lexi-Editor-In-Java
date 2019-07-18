/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structure;

import Utilities.ViewArgs;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sarthak
 */
public class SimpleCompositor implements Compositor{

    public SimpleCompositor(){		
    }
    
    @Override
    public List<Row> compose(List<Glyph> glyphs, ViewArgs args) {
        List<Row> rows = new ArrayList<>();				
        if (glyphs == null || glyphs.isEmpty()){
                return rows;
        }

        Row currentRow = new Row();
        int currentTop = args.getTop();
        currentRow.setStartIndex(0);
        currentRow.setLeft(args.getLeft());
        currentRow.setTop(currentTop);
        rows.add(currentRow);
        int currentLeft = args.getLeft();		
        for (int i = 0; i < glyphs.size(); i++){
            Glyph glyph = glyphs.get(i);
            Point position = new Point(currentLeft, currentTop);
            GlyphDetails gd = new GlyphDetails(glyph, position, i);
            currentRow.getGlyphDetails().add(gd);			
            if ((currentLeft + 20) >= args.getFrameWidth()){
                currentRow.setEndIndex(i);
                if (i == glyphs.size() - 1){					
                        break;
                }

                currentTop += currentRow.getHeight();
                currentRow = new Row();				
                currentRow.setLeft(args.getLeft());
                currentRow.setTop(currentTop);
                currentRow.setStartIndex(i + 1);
                rows.add(currentRow);
                currentLeft = args.getLeft();												
            }
            else{				
                currentLeft += gd.getGlyph().getWidth() + 2;
            }
        }

        return rows;
    }
    
}
