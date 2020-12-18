public class Car {
    private String make;
    private String model;
    private int housePower;

    Car(String make){
        this.make = make;
        this.model = "unknown";
        this.housePower = -1;
    }

    Car(String make, String model, int housePower){
        this.make = make;
        this.model = model;
        this.housePower = housePower;
    }

    public String getInfo(){
        return String.format("The car is: %s %s - %d HP.", this.make, this.model, this.housePower);
    }
}
