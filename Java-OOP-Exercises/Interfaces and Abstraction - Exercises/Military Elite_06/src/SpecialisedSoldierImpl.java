public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private Corps corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        setCorp(corp);
    }

    private void setCorp(String corp) {
        if(!corp.equals("Airforces") && !corp.equals("Marines")){
            throw new IllegalArgumentException("Invalid state!");
        }
        this.corp = Corps.valueOf(corp.toUpperCase());
    }


    @Override
    public Corps getCorp() {
        return corp;
    }
}
