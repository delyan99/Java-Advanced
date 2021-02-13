public class CarAddressFacade extends CarBuilderFacade {

    public CarAddressFacade(Car car) {
        this.car = car;
    }

    public CarAddressFacade inCity(String city){
        car.setCity(city);
        return this;
    }

    public CarAddressFacade atAddress(String address){
        car.setAddress(address);
        return this;
    }
}
