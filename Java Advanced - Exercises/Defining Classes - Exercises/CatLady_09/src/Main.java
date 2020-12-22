import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Siamese> siameseList = new ArrayList<>();
        List<Cymric> cymricList = new ArrayList<>();
        List<StreetExtraordinaire> streetExtraordinaireList = new ArrayList<>();
        while (!"End".equals(input)){
            String[] tokens = input.split("\\s+");
            String breed = tokens[0];
            String name = tokens[1];
            double characteristic = Double.parseDouble(tokens[2]);
            switch(breed){
                case "Siamese":
                    Siamese siamese = new Siamese(name, characteristic);
                    siameseList.add(siamese);
                    break;
                case "Cymric":
                    Cymric cymric = new Cymric(name, characteristic);
                    cymricList.add(cymric);
                    break;
                case "StreetExtraordinaire":
                    StreetExtraordinaire streetExtraordinaire = new StreetExtraordinaire(name,characteristic);
                    streetExtraordinaireList.add(streetExtraordinaire);
                    break;
            }
            input = scanner.nextLine();
        }
        String catName = scanner.nextLine();
        for (Siamese siamese : siameseList) {
            if(siamese.getName().equals(catName)){
                System.out.println("Siamese " + siamese.toString());
                break;
            }
        }

        for (Cymric cymric : cymricList) {
            if(cymric.getName().equals(catName)){
                System.out.println("Cymric " + cymric.toString());
                break;
            }
        }

        for (StreetExtraordinaire streetExtraordinaire : streetExtraordinaireList) {
            if(streetExtraordinaire.getName().equals(catName)){
                System.out.println("StreetExtraordinaire " + streetExtraordinaire.toString());
                break;
            }
        }
    }
}
