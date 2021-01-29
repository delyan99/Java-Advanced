import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer{
    private List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new ArrayList<>();
    }


    @Override
    public void addRepair(Repair repair){
        repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs(){
        return repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f",
                super.getFirstName(), super.getLastName(), super.getId(), super.getSalary())).append(System.lineSeparator());
        sb.append("Corps: ").append(super.getCorp().getName()).append(System.lineSeparator());
        sb.append("Repairs:");
        for (Repair repair : repairs) {
            sb.append(System.lineSeparator());
            sb.append("  ");
            sb.append(repair.toString());
        }
        return sb.toString();
    }
}
