import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class VoinaNumberGame_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        Set<Integer> secondPlayer = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));


        for (int rounds = 0; rounds < 50; rounds++) {
            if(firstPlayer.isEmpty() || secondPlayer.isEmpty()){
                break;
            }

            int firstCard = firstPlayer.iterator().next();
            firstPlayer.remove(firstCard);
            int secondCard = secondPlayer.iterator().next();
            secondPlayer.remove(secondCard);

            if(firstCard > secondCard){
                firstPlayer.add(firstCard);
                firstPlayer.add(secondCard);
            }else if(secondCard > firstCard){
                secondPlayer.add(firstCard);
                secondPlayer.add(secondCard);
            }

        }

        if(firstPlayer.size() < secondPlayer.size()){
            System.out.println("Second player win!");
        }else if(firstPlayer.size() > secondPlayer.size()){
            System.out.println("First player win!");
        }else{
            System.out.println("Draw!");
        }
    }
}
