package barracksWars.core.commands;

import barracksWars.interfaces.Executable;
import barracksWars.interfaces.Inject;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Report implements Executable {
    @Inject
    private String[] data;
    @Inject
    private Repository repository;


    public Report() {
    }

    @Override
    public String execute() {
        String output = this.repository.getStatistics();
        return output;
    }
}
