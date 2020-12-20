import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            double tire1Pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2Pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3Pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4Pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            Car car = new Car(model, engine, cargo, tire);
            cars.add(car);
        }

        String cargoType = scanner.nextLine();
        if(cargoType.equals("fragile")){
            for (Car car : cars) {
                Tire tire = car.getTire();
                if(tire.getTire1Pressure()  < 1 || tire.getTire2Pressure()  < 1 || tire.getTire3Pressure()  < 1 || tire.getTire4Pressure()  < 1){
                    System.out.println(car.getModel());
                }
            }
        }else if(cargoType.equals("flamable")){
            for (Car car : cars) {
                Engine engine = car.getEngine();
                if(engine.getEnginePower() > 250){
                    System.out.println(car.getModel());
                }
            }
        }
    }
}
