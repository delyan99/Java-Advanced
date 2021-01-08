import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.*;

public class Main {
    public static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String[] tokens = input.split(", ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            Person person = new Person(name, age);
            people.add(person);

        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Person> filter = filterData(condition, age);
        Function<Person, String> formatter = formatOutput(format);
        people.stream().filter(filter).map(formatter).forEach(System.out::println);
    }

    private static Function<Person, String> formatOutput(String format) {
        if(format.equals("name")){
            return p -> p.name;
        }else if(format.equals("age")){
            return p -> String.valueOf(p.age);
        }
        return p -> String.format("%s - %d", p.name, p.age);
    }

    private static Predicate<Person> filterData(String condition, int age) {
        if(condition.equals("older")){
            return p -> p.age >= age;
        }
        return p -> p.age <= age;

    }
}
