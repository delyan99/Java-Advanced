import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    private List<PrivateImpl> privates;


    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(PrivateImpl priv){
        privates.add(priv);
    }

    @Override
    public List<PrivateImpl> getPrivates() {
        return privates;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %d Salary: %.2f",
                super.getFirstName(), super.getLastName(), super.getId(), super.getSalary())).append(System.lineSeparator());
        sb.append("Privates:");
        privates.stream().sorted((l, r) -> Integer.compare(r.getId(), l.getId())).forEach(p ->{
            sb.append(System.lineSeparator());
            sb.append("  ");
            sb.append(p.toString());
        });
        return sb.toString();
    }
}
