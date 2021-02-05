package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Fight implements Executable {


    @Override
    public String execute() {
        return "fight";
    }
}
