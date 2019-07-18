/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import structure.Composition;

/**
 *
 * @author Sarthak
 */
public class Save implements Command {

    private String filePath;
    private Composition document;

    public Save(Composition document, String filePath) {
        this.document = document;
        this.filePath = filePath;
    }
        
    @Override
    public boolean execute() {
        Boolean val = true;
        try {			
            this.document.saveToFile(filePath);			
        } catch (Exception ex) {
            ex.printStackTrace();
            val = false;
        }		

        return val;
    }

    @Override
    public void unExecute() {
    }

    @Override
    public boolean canUndo() {
        return false;
    }
    
}
