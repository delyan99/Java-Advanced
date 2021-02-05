package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Add extends Command {

    protected Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        try {
            Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
            super.getRepository().addUnit(unitToAdd);

        } catch (ExecutionControl.NotImplementedException e) {
            e.printStackTrace();
        }
        String output = unitType + " added!";
        return output;
    }
}
