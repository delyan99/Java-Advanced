import java.text.DecimalFormat;

public class Truck extends Vehicle{

    protected Truck(Double fuelQuantity, Double fuelConsumptionInLitersPerKm) {
        super(fuelQuantity, fuelConsumptionInLitersPerKm);
    }

    @Override
    public String drive(Double km, Double increasing) {
        return "Truck" + super.drive(km, increasing);
    }

    @Override
    public void refuel(Double liters) {
        super.refuel(liters * 0.95);
    }
}
