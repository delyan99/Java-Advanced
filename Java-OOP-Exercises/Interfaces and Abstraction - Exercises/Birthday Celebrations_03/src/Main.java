import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Birthable> birthableList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            switch (tokens[0]){
                case "Citizen":
                    birthableList.add(new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]));
                    break;
                case "Pet":
                    birthableList.add(new Pet(tokens[1], tokens[2]));
                    break;
            }
            input = scanner.nextLine();
        }
        String year = scanner.nextLine();
        for (Birthable birthable : birthableList) {
            if(birthable.getBirthDate().endsWith(year)){
                System.out.println(birthable.getBirthDate());
            }
        }
    }
}
