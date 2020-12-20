public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostForOneKilometer;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCostForOneKilometer){
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForOneKilometer = fuelCostForOneKilometer;
        this.distanceTraveled = 0;
    }

    public double getFuelCostForOneKilometer() {
        return fuelCostForOneKilometer;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public boolean distanceTraveled(double fuelAmount, double fuelCostForOneKilometer, int distanceTraveled){
        return ((((fuelAmount/fuelCostForOneKilometer) - distanceTraveled) * fuelAmount) >= 0) && fuelAmount > 0;
    }

    @Override
    public String toString(){
        return String.format("%s %.2f %d", this.model, this.fuelAmount, this.distanceTraveled);
    }
}
