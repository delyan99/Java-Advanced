import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            persons.add(person);
        }
        persons
                .stream()
                .filter(person -> person.getAge() > 30)
                .sorted((l, r)->l.getName().compareTo(r.getName()))
                .forEach(p-> System.out.println(p.getName() + " - " + p.getAge()));
    }
}
