package barracksWars.core.commands;

import barracksWars.interfaces.*;
import jdk.jshell.spi.ExecutionControl;

public class Retire implements Executable {
    @Inject
    private String[] data;
    @Inject
    private Repository repository;

    public Retire() {
    }

    @Override
    public String execute() {
        String unitType = data[1];
        String output;
        try {
           this.repository.removeUnit(unitType);
            output = unitType + " retired!";
        } catch (ExecutionControl.NotImplementedException e) {
           output = e.getMessage();
        }

        return output;
    }
}
