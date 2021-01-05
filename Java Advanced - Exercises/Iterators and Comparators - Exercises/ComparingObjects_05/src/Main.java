import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Person> people = new ArrayList<>();
        while (!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            Person person = new Person(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            people.add(person);
            input = scanner.nextLine();
        }
        int personNumber = Integer.parseInt(scanner.nextLine());
        Person comparePerson = people.get(personNumber - 1);
        int samePeopleCounter = 1;
        boolean matches = false;
        for (int i = 0; i < people.size(); i++) {
            if(i == personNumber - 1){
                continue;
            }
            if(comparePerson.compareTo(people.get(i)) == 0){
                matches = true;
                samePeopleCounter++;
            }
        }
        if(!matches){
            System.out.println("No matches");
        }else{
            System.out.print(samePeopleCounter + " " + (people.size() - samePeopleCounter) + " " + people.size());
        }
    }
}
