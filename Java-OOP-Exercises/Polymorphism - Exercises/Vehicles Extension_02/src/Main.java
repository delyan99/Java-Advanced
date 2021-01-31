import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");
        String[] busInfo = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]), Double.parseDouble(carInfo[3]));
        Truck truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]), Double.parseDouble(truckInfo[3]));
        Bus bus = new Bus(Double.parseDouble(busInfo[1]), Double.parseDouble(busInfo[2]), Double.parseDouble(busInfo[3]));
        List<Vehicle> vehicles = List.of(car, truck, bus);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            if (command[0].equals("Drive")) {
                if (command[1].equals("Car")) {
                    System.out.println(car.drive(Double.parseDouble(command[2]), 0.9));
                } else if (command[1].equals("Truck")) {
                    System.out.println(truck.drive(Double.parseDouble(command[2]), 1.6));
                } else if (command[1].equals("Bus")) {
                    System.out.println(bus.drive(Double.parseDouble(command[2]), 1.4));
                }
            } else if (command[0].equals("Refuel")) {
                if (Double.parseDouble(command[2]) <= 0) {
                    System.out.println("Fuel must be a positive number");
                } else {
                    if (command[1].equals("Car")) {
                        try {
                            car.refuel(Double.parseDouble(command[2]));
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else if (command[1].equals("Truck")) {
                        try {
                            truck.refuel(Double.parseDouble(command[2]));
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                    } else if (command[1].equals("Bus")) {
                        try {
                            bus.refuel(Double.parseDouble(command[2]));
                        } catch (IllegalArgumentException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                }
            } else if (command[0].equals("DriveEmpty")) {
                if (command[1].equals("Bus")) {
                    System.out.println(bus.drive(Double.parseDouble(command[2])));
                }
            }
        }
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%s: %.2f%n", vehicle.getClass().getName(), vehicle.getFuelQuantity());
        }
    }
}
