import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        System.out.println(input[0] + " " + input[1] + ":");
        CardSuits cardSuits;
        for(CardSuits card : CardSuits.values()){
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card.name());
        }


    }
}
