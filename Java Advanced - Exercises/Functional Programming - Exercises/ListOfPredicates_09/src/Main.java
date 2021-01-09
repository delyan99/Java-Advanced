import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> divisibleByNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        BiPredicate<Integer, Integer> filterNumber = (numFromList, num) -> num % numFromList == 0;
        BiPredicate<Integer, List<Integer>> filterNumbers = (num, list) -> {
            boolean isNumberValid = false;
            for (Integer number : list) {
                if(num % number == 0){
                    isNumberValid = true;
                }else{
                    return false;
                }
            }
            return isNumberValid;
        };
        for (int i = 1; i <= n; i++) {
            if(filterNumbers.test(i, divisibleByNumbers)){
                System.out.print(i + " ");
            }
        }
    }
}
