import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+")).map(String::valueOf).collect(Collectors.toList());
        Predicate<String> upperCasePredicate = word -> Character.isUpperCase(word.charAt(0));
        List<String> output = new ArrayList<>();
        for (String word : words) {
            if(upperCasePredicate.test(word)){
                output.add(word);
            }
        }
        System.out.println(output.size());
        for (String string : output) {
            System.out.println(string);
        }
    }
}
