import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] trafficLightSignals = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < trafficLightSignals.length; j++) {
                trafficLightSignals[j] = TrafficLightSignals.valueOf(trafficLightSignals[j]).getNewValue();

            }
            for (String trafficLightSignal : trafficLightSignals) {
                System.out.print(trafficLightSignal + " ");
            }
            System.out.println();
        }
    }
}
