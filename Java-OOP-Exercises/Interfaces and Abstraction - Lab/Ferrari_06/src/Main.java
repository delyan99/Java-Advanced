import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String driverName = scanner.nextLine();
        Ferrari ferrari = new Ferrari(driverName);
        System.out.println(String.format("%s/%s/%s/%s",
                ferrari.getModel(), ferrari.brakes(), ferrari.gas(), ferrari.getDriverName()));
    }
}
