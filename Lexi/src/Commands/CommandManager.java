/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import Commands.Command;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sarthak
 */
public class CommandManager {
    private volatile static CommandManager instance;
    private List<Command> commands = new ArrayList<>();
    private int current = -1;

    private CommandManager(){}

    /*Only one instance made*/
    public static CommandManager getInstance(){
        if (instance == null){
            synchronized (CommandManager.class) {
                if (instance == null){
                    instance = new CommandManager();
                }
            }
        }

        return instance;
    }

    public Boolean execute(Command cmd){
        Boolean val = cmd.execute() && cmd.canUndo();
        if (val){
            int size = this.commands.size();
            for (int i = size - 1; i >= current + 1; i--){
                    this.commands.remove(i);
            }

            this.commands.add(cmd);
            this.current++;
        }

        return val;
    }

    public void undo(){
        if (this.canUndo()){
            this.commands.get(current).unExecute();
            current--;
        }
    }

    public void redo(){
        if (this.canRedo()){
            current++;
            this.commands.get(current).execute();
        }
    }

    public Boolean canUndo(){
        return this.current > -1;
    }

    public Boolean canRedo(){
        return this.current < (this.commands.size() - 1);
    }
}
