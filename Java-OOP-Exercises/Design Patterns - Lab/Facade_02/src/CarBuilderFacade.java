public class CarBuilderFacade {
    protected Car car;

    public CarBuilderFacade(){
        this.car = new Car();
    }

    public Car build() {
        return car;
    }

    public CarInfoBuilder info(){
        return new CarInfoBuilder(car);
    }

    public CarAddressFacade built(){
        return new CarAddressFacade(car);
    }

}
