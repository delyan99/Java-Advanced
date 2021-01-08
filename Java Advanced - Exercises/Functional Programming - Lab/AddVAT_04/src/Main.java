import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] prices = Arrays.stream(scanner.nextLine().split(", ")).mapToDouble(Double::parseDouble).toArray();
        UnaryOperator<Double> addVAT = p -> p + p * 0.2;
        System.out.println("Prices with VAT:");
        for (double price : prices) {
            System.out.println(String.format("%.2f", addVAT.apply(price)));
        }
    }
}
