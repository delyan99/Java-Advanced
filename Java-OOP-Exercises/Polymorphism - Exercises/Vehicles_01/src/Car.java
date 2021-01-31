import java.text.DecimalFormat;

public class Car extends Vehicle{

    protected Car(Double fuelQuantity, Double fuelConsumptionInLitersPerKm) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm);
    }

    @Override
    public String drive(Double km, Double increasing) {
        return "Car" + super.drive(km, increasing);
    }

    @Override
    public void refuel(Double liters) {
        super.refuel(liters);
    }


}
