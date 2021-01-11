import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        int[] liliesInput = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        for (int element : liliesInput) {
            lilies.push(element);
        }
        ArrayDeque<Integer> roses = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayDeque::new));

        int flowerWreaths = 0;
        int storedFlowers = 0;
        while (!roses.isEmpty() && !lilies.isEmpty()){
            int sum = roses.peek() + lilies.peek();
            if(sum == 15){
                roses.poll();
                lilies.pop();
                flowerWreaths++;
            }else if(sum > 15){
                int addNewLily = lilies.pop() - 2;
                lilies.push(addNewLily);
            }else if(sum < 15){
                roses.poll();
                lilies.pop();
                storedFlowers += sum;
            }
        }

        while (storedFlowers >= 15){
            flowerWreaths++;
            storedFlowers -= 15;
        }

        if(flowerWreaths >= 5){
            System.out.println(String.format("You made it, you are going to the competition with %d wreaths!", flowerWreaths));
        }else{
            System.out.println(String.format("You didn't make it, you need %d wreaths more!", 5 - flowerWreaths));
        }
    }
}
