import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Function<List<Integer>, Integer> findMinInteger = l -> {
            int result = l.size() - 1;
            for (int i = l.size() - 2; i >= 0; i--) {
                if(l.get(i) < l.get(result)){
                    result = i;
                }
            }
            return result;
        };
        System.out.println(findMinInteger.apply(numbers));
    }
}
