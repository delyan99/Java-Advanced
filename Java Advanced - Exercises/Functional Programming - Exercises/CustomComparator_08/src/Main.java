import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Predicate<Integer> filterEvenNumbers = number -> number % 2 == 0;
        Predicate<Integer> filterOddNumbers = number -> number % 2 == 1;
        Comparator<Integer> comparator = (l, r) -> {
            if(Math.abs(l) % 2 == 1 && Math.abs(r) % 2 == 0){
                return 1;
            }else if(Math.abs(l) % 2 == 0 && Math.abs(r) % 2 == 1){
                return -1;
            }
            return l.compareTo(r);
        };
        Arrays.stream(numbers).boxed().sorted(comparator).forEach(e -> System.out.print(e + " "));
    }
}
