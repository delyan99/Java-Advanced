import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(sumOfArray(array, array.length - 1));

    }

    private static int sumOfArray(int[] array, int index) {
        if(index == 0){
            return array[index];
        }
        return array[index] + sumOfArray(array, index - 1);
    }
}
