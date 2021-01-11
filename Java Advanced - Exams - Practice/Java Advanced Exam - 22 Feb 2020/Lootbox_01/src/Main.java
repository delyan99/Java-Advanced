import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        int[] secondBoxData = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int number : secondBoxData) {
            secondBox.push(number);
        }
        int sumOfClaimedItems = 0;

        while (!firstBox.isEmpty() && !secondBox.isEmpty()){
            int sum = firstBox.peek() + secondBox.peek();
            if(sum % 2 == 0){
                sumOfClaimedItems += sum;
                firstBox.poll();
                secondBox.pop();
            }else{
                firstBox.offer(secondBox.pop());
            }
        }
        if(firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }else{
            System.out.println("Second lootbox is empty");
        }

        if(sumOfClaimedItems > 100){
            System.out.println("Your loot was epic! Value: " + sumOfClaimedItems);
        }else{
            System.out.println("Your loot was poor... Value: " + sumOfClaimedItems);
        }

    }
}
