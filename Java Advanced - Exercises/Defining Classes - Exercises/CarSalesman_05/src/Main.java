import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new LinkedHashMap<>();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            Engine engine = null;
            int power = Integer.parseInt(tokens[1]);
            if (tokens.length == 2) {
                engine = new Engine(model, power);
            } else if (tokens.length == 4) {
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
            } else if (tokens.length == 3) {
                try {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } catch (NumberFormatException e) {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
            }
            engines.put(model, engine);
        }
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String engineName = tokens[1];
            Engine engine = engines.get(engineName);
            Car car = null;
            if (tokens.length == 2) {
                car = new Car(model, engine);
            } else if (tokens.length == 4) {
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
            } else if (tokens.length == 3) {
                try {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                } catch (NumberFormatException e) {
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }
            }
            cars.add(car);
        }

        for (Car car : cars) {
            String carModel = car.getModel();
            String engineModel = car.getEngine().getModel();
            int enginePower = car.getEngine().getPower();
            int engineDisplacementTaken = car.getEngine().getDisplacement();
            String engineDisplacement = "";
            String engineEfficiency = car.getEngine().getEfficiency();
            int carWeightTaken = car.getWeight();
            String carWeight = "";
            String carColor = car.getColor();
            if (engineEfficiency == null) {
                engineEfficiency = "n/a";
            }
            if (carColor == null) {
                carColor = "n/a";
            }
            if (carWeightTaken == 0) {
                carWeight = "n/a";
            }else{
                carWeight = carWeightTaken + "";
            }
            if (engineDisplacementTaken == 0) {
                engineDisplacement = "n/a";
            }else{
                engineDisplacement = engineDisplacementTaken + "";
            }
            System.out.print(String.format("%s:%n" +
                    "%s:%n" +
                    "Power: %d%n" +
                    "Displacement: %s%n" +
                    "Efficiency: %s%n" +
                    "Weight: %s%n" +
                    "Color: %s%n", carModel, engineModel, enginePower, engineDisplacement, engineEfficiency, carWeight, carColor));
        }
    }
}

