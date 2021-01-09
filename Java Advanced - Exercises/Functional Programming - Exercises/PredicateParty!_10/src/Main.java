import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BiPredicate<String, String> startWith = String::startsWith;
        BiPredicate<String, String> endWith = String::endsWith;
        BiPredicate<String, Integer> lengthPredicate = (name, length) -> name.length() == length;

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        List<String> copyPeople = new ArrayList<>(people);
        String input = scanner.nextLine();
        while (!"Party!".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String nestedCommand = tokens[1];
            switch (command){
                case "Double":
                    switch (nestedCommand){
                        case "StartsWith":
                            for (String person : people) {
                                if(startWith.test(person, tokens[2])){
                                    int index = people.indexOf(person);
                                    copyPeople.add(index, person);
                                }
                            }
                            people = new ArrayList<>(copyPeople);
                            break;
                        case "EndsWith":
                            for (String person : people) {
                                if(endWith.test(person, tokens[2])){
                                    int index = people.indexOf(person);
                                    copyPeople.add(index, person);
                                }
                            }
                            people = new ArrayList<>(copyPeople);
                            break;
                        case "Length":
                            for (String person : people) {
                                if(lengthPredicate.test(person, Integer.parseInt(tokens[2]))){
                                    int index = people.indexOf(person);
                                    copyPeople.add(index, person);
                                }
                            }
                            people = new ArrayList<>(copyPeople);
                            break;
                    }
                    break;
                case "Remove":
                    switch (nestedCommand){
                        case "StartsWith":
                            people.removeIf(person -> startWith.test(person, tokens[2]));
                            copyPeople.removeIf(person -> startWith.test(person, tokens[2]));
                            break;
                        case "EndsWith":
                            people.removeIf(person -> endWith.test(person, tokens[2]));
                            copyPeople.removeIf(person -> endWith.test(person, tokens[2]));
                            break;
                        case "Length":
                            people.removeIf(person -> lengthPredicate.test(person, Integer.parseInt(tokens[2])));
                            copyPeople.removeIf(person -> lengthPredicate.test(person, Integer.parseInt(tokens[2])));
                            break;
                    }
                    break;
            }

            input = scanner.nextLine();
        }
        Collections.sort(people);
        if(people.size() == 0){
            System.out.println("Nobody is going to the party!");
        }else{
            System.out.print(String.join(", ", people) + " are going to the party!");


        }
    }
}
