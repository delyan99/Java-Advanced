package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity){
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if(this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        if(this.data.isEmpty()){
            return false;
        }
        for (Car car : this.data) {
            if(car.getModel().equals(model) && car.getManufacturer().equals(manufacturer)){
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar(){
        if(this.data.isEmpty()){
            return null;
        }
        Car result;
        int youngestCar = this.data.get(0).getYear();
        result = this.data.get(0);
        for (Car car : this.data) {
            if(car.getYear() > youngestCar){
                result = car;
            }
        }
        return result;
    }

    public Car getCar(String manufacturer, String model){
        if(this.data.isEmpty()){
            return null;
        }
        Car result = null;
        for (Car car : this.data) {
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                result = car;
                break;
            }
        }
        return result;
    }

    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder result = new StringBuilder("The cars are parked in " + this.type + ":" + System.lineSeparator());
        for (Car car : data) {
            result.append(car.toString()).append(System.lineSeparator());
        }
        return result.toString();
    }
}
