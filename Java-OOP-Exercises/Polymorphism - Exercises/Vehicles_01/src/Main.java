import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carInfo = scanner.nextLine().split("\\s+");
        String[] truckInfo = scanner.nextLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carInfo[1]), Double.parseDouble(carInfo[2]));
        Vehicle truck = new Truck(Double.parseDouble(truckInfo[1]), Double.parseDouble(truckInfo[2]));
        List<Vehicle> vehicles = List.of(car, truck);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split("\\s+");
            if(command[0].equals("Drive")){
                if(command[1].equals("Car")){
                    System.out.println(car.drive(Double.parseDouble(command[2]), 0.9));
                }else if(command[1].equals("Truck")){
                    System.out.println(truck.drive(Double.parseDouble(command[2]), 1.6));
                }
            }else if(command[0].equals("Refuel")){
                if(command[1].equals("Car")){
                    car.refuel(Double.parseDouble(command[2]));
                }else if(command[1].equals("Truck")){
                    truck.refuel(Double.parseDouble(command[2]));
                }
            }
        }
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%s: %.2f%n",vehicle.getClass().getName(), vehicle.getFuelQuantity());
        }
    }
}
