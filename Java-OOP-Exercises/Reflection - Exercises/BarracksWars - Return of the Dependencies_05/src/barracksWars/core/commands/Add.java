package barracksWars.core.commands;

import barracksWars.interfaces.*;
import jdk.jshell.spi.ExecutionControl;

public class Add implements Executable {
    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    public Add() {
    }

    @Override
    public String execute() {
        String unitType = data[1];
        try {
            Unit unitToAdd = this.unitFactory.createUnit(unitType);
            this.repository.addUnit(unitToAdd);

        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        String output = unitType + " added!";
        return output;
    }
}
