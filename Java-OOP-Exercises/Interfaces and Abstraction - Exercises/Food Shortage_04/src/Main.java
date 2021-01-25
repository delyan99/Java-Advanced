import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        List<Buyer> buyers = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] information = scanner.nextLine().split("\\s+");
            if(information.length == 4){
                Citizen citizen = new Citizen(information[0], Integer.parseInt(information[1]), information[2], information[3]);
                people.add(citizen);
                buyers.add(citizen);
            }else  if(information.length == 3){
                Rebel rebel = new Rebel(information[0], Integer.parseInt(information[1]), information[2]);
                people.add(rebel);
                buyers.add(rebel);
            }
        }
        String input = scanner.nextLine();
        while (!"End".equals(input)){
            for (Person person : people) {
                if(person.getName().equals(input)){
                    buyers.get(people.indexOf(person)).buyFood();
                }
            }
            input = scanner.nextLine();
        }
        int totalAmountOfFoodPurchased = 0;
        for (Buyer buyer : buyers) {
            totalAmountOfFoodPurchased += buyer.getFood();
        }
        System.out.println(totalAmountOfFoodPurchased);
    }
}
