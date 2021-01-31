import java.text.DecimalFormat;

public abstract class Vehicle {
    private Double fuelQuantity;
    private Double fuelConsumptionInLitersPerKm;

    protected Vehicle(Double fuelQuantity, Double fuelConsumptionInLitersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionInLitersPerKm = fuelConsumptionInLitersPerKm;
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
        this.fuelQuantity = this.fuelQuantity + liters;
    }

    protected double getFuelQuantity(){
        return this.fuelQuantity;
    }

    protected double getFuelConsumptionInLitersPerKm() {
        return this.fuelConsumptionInLitersPerKm;
    }

    protected void setFuelQuantity(double fuelQuantity){
        this.fuelQuantity = fuelQuantity;
    }
}
