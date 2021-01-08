import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Function<int[], String> outputSize = array -> String.format("Count = " + array.length);

        Function<int[], String> outputSum = array -> String.format("Sum = " + Arrays.stream(Arrays.stream(array).toArray()).sum());

        System.out.println(outputSize.apply(input));
        System.out.println(outputSum.apply(input));
    }
}
