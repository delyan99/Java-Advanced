import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Collections.reverse(numbers);
        int divisibleBy = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> removeNumbersDivisibleByGivenNumber = num -> num % divisibleBy != 0;
        numbers.stream().filter(removeNumbersDivisibleByGivenNumber).forEach(p -> System.out.print(p + " "));
    }
}
