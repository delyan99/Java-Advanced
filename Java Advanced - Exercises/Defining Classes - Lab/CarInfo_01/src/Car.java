public class Car {
    private String make;
    private String model;
    private int horsePower;

    Car(String make, String model, int horsePower){
        this.make = make;
        this.model = model;
        this.horsePower = horsePower;
    }

    public void setMake(String make){
        this.make = make;
    }

    public void setModel(String model){
        this.model = model;
    }

    public void setHorsePower(int horsePower){
        this.horsePower = horsePower;
    }

    public String getMake(){
        return this.make;
    }

    public String getModel(){
        return this.getModel();
    }

    public int getHorsePower(){
        return this.horsePower;
    }

    public String getInfo(){
        return String.format("The car is: %s %s - %d HP.", this.make, this.model, this.horsePower);
    }
}
