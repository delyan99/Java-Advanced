import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstInput = scanner.nextLine().split("\\s+");
        String address = firstInput[2];
        String firstAndLastName = firstInput[0] + " " + firstInput[1];
        Tuple<String, String> firstTuple = new Tuple<>(firstAndLastName, address);
        System.out.println(firstTuple);

        String[] secondInput = scanner.nextLine().split("\\s+");
        String name = secondInput[0];
        int litersOfBeer = Integer.parseInt(secondInput[1]);
        Tuple<String, Integer> secondTuple = new Tuple<>(name, litersOfBeer);
        System.out.println(secondTuple);

        String[] thirdInput = scanner.nextLine().split("\\s+");
        int integerInput = Integer.parseInt(thirdInput[0]);
        double doubleInput = Double.parseDouble(thirdInput[1]);
        Tuple<Integer, Double> thirdTuple = new Tuple<>(integerInput, doubleInput);
        System.out.println(thirdTuple);

    }
}
