public class Car extends Vehicle{

    protected Car(Double fuelQuantity, Double fuelConsumptionInLitersPerKm, Double tankCapacity) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm, tankCapacity);
    }

    @Override
    public String drive(Double km, Double increasing) {
        return super.drive(km, increasing);
    }

    @Override
    public void refuel(Double liters) {
        super.refuel(liters);
    }


}
