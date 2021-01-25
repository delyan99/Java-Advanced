import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Identifiable> identifiables = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split("\\s+");
            if (tokens.length == 2) {
                Robot robot = new Robot(tokens[0], tokens[1]);
                identifiables.add(robot);
            } else if (tokens.length == 3) {
                Citizen citizen = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                identifiables.add(citizen);
            }
            input = scanner.nextLine();
        }
        String idEnds = scanner.nextLine();

        for (Identifiable identifiable : identifiables) {
            if (identifiable.getId().endsWith(idEnds)) {
                System.out.println(identifiable.getId());
            }
        }
    }
}
