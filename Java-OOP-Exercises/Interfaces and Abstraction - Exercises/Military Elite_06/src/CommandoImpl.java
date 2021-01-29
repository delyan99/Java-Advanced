import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando{
    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String state) {
        super(id, firstName, lastName, salary, state);
        this.missions = new ArrayList<>();
    }


    @Override
    public void addMission(Mission mission){
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions(){
        return missions;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f",
                super.getFirstName(), super.getLastName(), super.getId(), super.getSalary())).append(System.lineSeparator());
        sb.append("Corps: ").append(super.getCorp().getName()).append(System.lineSeparator());
        sb.append("Missions:");
        for (Mission mission : missions) {
            sb.append(System.lineSeparator());
            sb.append("  ");
            sb.append(mission.toString());
        }

        return sb.toString();
    }
}
