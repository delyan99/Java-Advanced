import java.util.Collection;

public interface Engineer {
    Collection<Repair> getRepairs();

    void addRepair(Repair repair);
}
