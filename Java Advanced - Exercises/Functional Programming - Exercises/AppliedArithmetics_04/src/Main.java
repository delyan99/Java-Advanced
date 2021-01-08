import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        String command = scanner.nextLine();
        Function<Integer, Integer> addConsumer = e -> e + 1;
        Function<Integer, Integer> multiplyConsumer = e -> e * 2;
        Function<Integer, Integer> subtract = e -> e - 1;
        while (!"end".equals(command)){
            switch (command){
                case "add":
                    numbers = numbers.stream().map(addConsumer).collect(Collectors.toList());
                    break;
                case "multiply":
                    numbers = numbers.stream().map(multiplyConsumer).collect(Collectors.toList());
                    break;
                case "subtract":
                    numbers = numbers.stream().map(subtract).collect(Collectors.toList());
                    break;
                case "print":
                    numbers.forEach(p -> System.out.print(p + " "));
                    System.out.println();
                    break;
            }
            command = scanner.nextLine();
        }
    }
}
