import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> setOfGuests = new TreeSet<>();
        String inputGuestForReservation = scanner.nextLine();
        while (!"PARTY".equals(inputGuestForReservation)){
            setOfGuests.add(inputGuestForReservation);
            inputGuestForReservation = scanner.nextLine();
        }

        String inputGuests = scanner.nextLine();
        while (!"END".equals(inputGuests)){
            setOfGuests.remove(inputGuests);
            inputGuests = scanner.nextLine();
        }
        System.out.println(setOfGuests.size());
        for (String setOfGuest : setOfGuests) {
            System.out.println(setOfGuest);
        }
    }
}
