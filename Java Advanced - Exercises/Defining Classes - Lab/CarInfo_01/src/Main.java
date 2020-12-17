import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String make = tokens[0];
            String model = tokens[1];
            int horsePower = Integer.parseInt(tokens[2]);
            Car car = new Car(make, model, horsePower);
            System.out.println(car.getInfo());
        }
    }
}
