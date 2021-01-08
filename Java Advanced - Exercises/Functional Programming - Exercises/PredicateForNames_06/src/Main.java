import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        Predicate<String> isStringLengthEqualToGivenLength = s -> s.length() <= length;
        Arrays.stream(scanner.nextLine().split("\\s+")).filter(isStringLengthEqualToGivenLength).forEach(System.out::println);
    }
}
