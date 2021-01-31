import java.text.DecimalFormat;

public class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumptionInLitersPerKm;
    private Double tankCapacity;

    protected Vehicle(Double fuelQuantity, Double fuelConsumptionInLitersPerKm, Double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
        this.tankCapacity = tankCapacity;
    }

    public String drive(Double km, Double increasing){
        if(this.fuelConsumptionInLitersPerKm * km + (km * increasing) > this.fuelQuantity){
            return " needs refueling";
        }

        this.fuelQuantity = this.fuelQuantity - (this.fuelConsumptionInLitersPerKm * km + (km * increasing));
        DecimalFormat decimalFormat = new DecimalFormat("0.##");
        return String.format(" travelled %s km", decimalFormat.format(km));
    }

    public void refuel(Double liters){
        if(this.fuelQuantity + liters > tankCapacity){
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }
        this.fuelQuantity = this.fuelQuantity + liters;
    }

    protected double getFuelQuantity(){
        return this.fuelQuantity;
    }

}
