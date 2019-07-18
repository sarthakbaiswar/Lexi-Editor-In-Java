/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package structuerview;

import Utilities.ViewArgs;
import java.util.ArrayList;
import java.util.List;
import structure.Row;

/**
 *
 * @author Sarthak
 */
public abstract class Document {
    private List<Row> rows;
	
	public Document(){
		this.rows = new ArrayList<Row>();
	}
	
	public Document(List<Row> rows){
		this.rows = rows;
	}
	
	public List<Row> getRows(){
		return this.rows;
	}
	
	public void setRows(List<Row> rows){
		this.rows = rows;
	}
	
	public abstract void draw(List<Row> rows, ViewArgs args, int from);
	
	public abstract Boolean needScrolling(ViewArgs args);
}
