import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String rankOfTheCard = scanner.nextLine();
        String suitOfTheCard = scanner.nextLine();
        int cardPower = Card.RankPowers.valueOf(rankOfTheCard).getValue() + Card.SuitPowers.valueOf(suitOfTheCard).getValue();
        System.out.println(String.format("Card name: %s of %s; Card power: %d",
                rankOfTheCard, suitOfTheCard, cardPower));
    }
}
