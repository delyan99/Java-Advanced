import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            double fuelAmount = Double.parseDouble(tokens[1]);
            double fuelCostForOneKilometer = Double.parseDouble(tokens[2]);
            Car car = new Car(model, fuelAmount, fuelCostForOneKilometer);
            cars.put(model, car);
        }

        String input = scanner.nextLine();
        while (!"End".equals(input)){
            String[] tokens = input.split("\\s+");
            String carModel = tokens[1];
            int amountOfKm = Integer.parseInt(tokens[2]);

            Car car = cars.get(carModel);
            double fuelAmount = car.getFuelAmount();
            double fuelCostForOneKilometer = car.getFuelCostForOneKilometer();
            int distanceTraveled = car.getDistanceTraveled();

           if(!car.distanceTraveled(fuelAmount, fuelCostForOneKilometer, amountOfKm)){
                System.out.println("Insufficient fuel for the drive");
            }else{
                car.setDistanceTraveled(distanceTraveled + amountOfKm);
                double usedFuel = amountOfKm * fuelCostForOneKilometer;
                car.setFuelAmount(fuelAmount - usedFuel);
            }

            input = scanner.nextLine();
        }
        for (Car car : cars.values()) {
            System.out.println(car);
        }
    }
}
