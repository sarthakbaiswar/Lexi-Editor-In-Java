/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Run;

import structuerview.*;
import Commands.CommandManager;
import Commands.*;
import java.awt.Graphics;
import java.util.List;
import Utilities.*;
import java.awt.Point;
import structure.*;

/**
 *
 * @author Sarthak
 */
public class Controls {
    
    private Composition composed;
    private Document logicalDocument;
    private int index;
    private Graphics graphics;

    public Controls(Composition composed){
        this.index = 0;		
        this.composed = composed;
        this.logicalDocument = new BaseDocument();
    }	
    
    public void onSaveMenuItemClick(String filePath){
        Command cmd = new Save(this.composed, filePath);
        CommandManager.getInstance().execute(cmd);
    }
	
    public void onLoadMenuItemClick(String filePath){
        Command cmd = new Load(this.composed, filePath);
        CommandManager.getInstance().execute(cmd);
    }
    
    
    public void onImageInserted(ImageArgs param) {
        Glyph glyph = new Picture(param.getFilePath());
        this.InsertGlyph(glyph);
    }
    
    private void InsertGlyph(Glyph glyph){
        Command cmd = null;
        int physicalIndex = Integer.MIN_VALUE;
                physicalIndex = this.composed.getChildren().size();


        if (physicalIndex != Integer.MIN_VALUE){			
                cmd = new Insert(this.composed, glyph, physicalIndex);				
                CommandManager.getInstance().execute(cmd);
        }
    }
    
    public void onMenuItemPressed(MenuArgs param){
        if (param.getMenuItem().getText() == Constants.ScrollOnText){
            // turn on scrolling
            List<Row> rows = this.logicalDocument.getRows();
//            this.logicalDocument = new ScrollingDoc(this.logicalDocument);
            this.logicalDocument = new BorderedDoc(new ScrollingDoc(this.logicalDocument));
            this.logicalDocument.setRows(rows);			
	}
        else if (param.getMenuItem().getText() == Constants.ScrollOffText) {
            // turn scrolling off
            List<Row> rows = this.logicalDocument.getRows();
            this.logicalDocument = new BaseDocument();
            this.logicalDocument.setRows(rows);
            this.index = 0;
        }
        else if (param.getMenuItem().getText() == Constants.BorderActivated) {
            // put border
            List<Row> rows = this.logicalDocument.getRows();
            this.logicalDocument = new BorderedDoc(this.logicalDocument);
            this.logicalDocument.setRows(rows);
            this.index = 0;
        }
        else if (param.getMenuItem().getText() == Constants.BorderDeactivated) {
            // remove border
            List<Row> rows = this.logicalDocument.getRows();
            this.logicalDocument = new BaseDocument();
            this.logicalDocument.setRows(rows);
            this.index = 0;
        }
        
    }
    
    public void setGraphics(Graphics graphics){
	this.graphics = graphics;
    }
    
    public void onKeyPressed(KeyArgs param) {
        Glyph glyph = null;
        Command cmd = null;		

        if (param.getKeyEvent().isControlDown() && param.getKeyEvent().getKeyChar() != 'z'  && param.getKeyEvent().getKeyCode() == 90){
            CommandManager.getInstance().undo();
        }
        else if (param.getKeyEvent().isControlDown() && param.getKeyEvent().getKeyChar() != 'y'  && param.getKeyEvent().getKeyCode() == 89){
            CommandManager.getInstance().redo();
        }
        else {
            if (!param.getKeyEvent().isControlDown()){				
                glyph = new Char(param.getKeyEvent().getKeyChar(), param.getFont());
                this.InsertGlyph(glyph);
            }
        }
	}
    
    /*Used for showing the input*/
    public void handleDocInput(List<Row> rows, ViewArgs args){
        this.logicalDocument.draw(rows, args, this.index);
        this.updateLocations(args);
    }
    
    public void updateLocations(ViewArgs args){
        int i, j;
        Point dummyPoint = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (i = 0; i < this.index; i++){
            Row currentRow = this.logicalDocument.getRows().get(i);
            currentRow.setTop(Integer.MIN_VALUE);
            currentRow.setLeft(Integer.MIN_VALUE);
            for (GlyphDetails gd : currentRow.getGlyphDetails()){
                    gd.setPosition(dummyPoint);
            }
        }

        /* calculate points exactly like the compositor */
        int currentTop = args.getTop();
        int currentLeft = args.getLeft();
        for (j = i; j < this.logicalDocument.getRows().size(); j++){
            Row currentRow = this.logicalDocument.getRows().get(j);
            currentRow.setTop(currentTop);
            currentRow.setLeft(currentLeft);
            for (GlyphDetails gd : currentRow.getGlyphDetails()){
                Point position = new Point(currentLeft, currentTop);
                gd.setPosition(position);
                currentLeft += gd.getGlyph().getWidth() + 2;
            }

            currentTop += currentRow.getHeight();
            currentLeft = args.getLeft();
        }
}
}
