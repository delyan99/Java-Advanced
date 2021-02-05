package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

public class Retire extends Command{
    protected Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = super.getData()[1];
        String output = null;
        try {
            super.getRepository().removeUnit(unitType);
            output = unitType + " retired!";
        } catch (ExecutionControl.NotImplementedException e) {
           output = e.getMessage();
        }

        return output;
    }
}
