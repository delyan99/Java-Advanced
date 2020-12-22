public class StreetExtraordinaire extends Cat{

    private double decibelsOfMeows;

    public StreetExtraordinaire(String name, double decibelsOfMeows) {
        super(name);
        this.decibelsOfMeows = decibelsOfMeows;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public String toString() {
        return String.format("%s %.2f", super.toString(), this.decibelsOfMeows);
    }
}
