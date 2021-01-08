import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        String output = Arrays.stream(input).mapToInt(Integer::parseInt)
                .filter(num -> num % 2 == 0).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(output);
        output = Arrays.stream(input).mapToInt(Integer::parseInt)
                .filter(num -> num % 2 == 0)
                .sorted()
                .mapToObj(String::valueOf).collect(Collectors.joining(", "));
        System.out.println(output);
    }
}
