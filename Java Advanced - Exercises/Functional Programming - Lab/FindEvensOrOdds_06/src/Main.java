import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");
        int lowerBound = Integer.parseInt(tokens[0]);
        int upperBound = Integer.parseInt(tokens[1]);
        String evenOrOdd = scanner.nextLine();
        Predicate<Integer> oddNumbers = number -> {
            if (Math.abs(number) % 2 == 1) {
                return true;
            }
            return false;
        };

        Predicate<Integer> evenNumbers = number -> {
            if (Math.abs(number) % 2 == 0) {
                return true;
            }
            return false;
        };

        findEvenOrOdds(evenOrOdd, lowerBound, upperBound, oddNumbers, evenNumbers);
    }

    public static void findEvenOrOdds(String evenOrOdd, int lowerBound, int upperBound, Predicate<Integer> oddNumbers, Predicate<Integer> evenNumbers) {
        if (evenOrOdd.equals("even")) {
            for (int i = lowerBound; i <= upperBound; i++) {
                if(evenNumbers.test(i)){
                    System.out.print(i + " ");
                }
            }
        } else if (evenOrOdd.equals("odd")) {
            for (int i = lowerBound; i <= upperBound; i++) {
                if (oddNumbers.test(i)) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
