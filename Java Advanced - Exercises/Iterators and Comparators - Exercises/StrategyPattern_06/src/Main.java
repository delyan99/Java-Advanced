import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Person> peopleSortedByName = new TreeSet<>(new ComparePersonByName());
        Set<Person> peopleSortedByAge = new TreeSet<>(new ComparePersonByAge());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person();
            person.setName(tokens[0]);
            person.setAge(Integer.parseInt(tokens[1]));
            peopleSortedByName.add(person);
            peopleSortedByAge.add(person);
        }
        for (Person person : peopleSortedByName) {
            System.out.println(person.getName() + " " + person.getAge());
        }
        for (Person person : peopleSortedByAge) {
            System.out.println(person.getName() + " " + person.getAge());
        }
    }
}
