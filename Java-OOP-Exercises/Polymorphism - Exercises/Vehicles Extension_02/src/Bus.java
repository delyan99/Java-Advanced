public class Bus extends Vehicle{

    protected Bus(Double fuelQuantity, Double fuelConsumptionInLitersPerKm, Double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    @Override
    public String drive(Double km, Double increasing) {
        return "Bus" + super.drive(km, increasing);
    }

    public String drive(Double km) {
        return "Bus" + super.drive(km, 0D);
    }
}
