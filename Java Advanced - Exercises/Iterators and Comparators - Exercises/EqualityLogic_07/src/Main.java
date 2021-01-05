import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Person> firstPeopleSet = new TreeSet<>( new ComparePersonByName());
        Set<Person> secondPeopleSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            Person person = new Person();
            person.setName(tokens[0]);
            person.setAge(Integer.parseInt(tokens[1]));
            boolean equal = false;
            for (Person person1 : secondPeopleSet) {
                if(person1.equals(person)){
                    equal = true;
                }
            }
            if(!equal) {
                secondPeopleSet.add(person);
                firstPeopleSet.add(person);
            }


        }
        System.out.println(firstPeopleSet.size());
        System.out.println(secondPeopleSet.size());
    }
}
