import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BiPredicate<String, String> startsWith = String::startsWith;
        BiPredicate<String, String> endWith = String::endsWith;
        BiPredicate<String, Integer> lengthPredicate = (name, length) -> name.length() == length;
        BiPredicate<String, String> containsPredicate = String::contains;
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String input = scanner.nextLine();
        List<String> commands = new ArrayList<>();
        List<String> finalCommands = new ArrayList<>(commands);
        while (!"Print".equals(input)) {
            String[] tokens = input.split(";");
            String command = tokens[1];
            String parameter = tokens[2];
            switch (tokens[0]) {
                case "Add filter":
                    switch (command) {
                        case "Starts with":
                            commands.add("Add filter;Starts with;" + parameter);
                            finalCommands.add("Add filter;Starts with;" + parameter);
                            break;
                        case "Ends with":
                            commands.add("Add filter;Ends with;" + parameter);
                            finalCommands.add("Add filter;Ends with;" + parameter);
                            break;
                        case "Length":
                            commands.add("Add filter;Length;" + parameter);
                            finalCommands.add("Add filter;Length;" + parameter);
                            break;
                        case "Contains":
                            commands.add("Add filter;Contains;" + parameter);
                            finalCommands.add("Add filter;Contains;" + parameter);
                            break;
                    }
                    break;
                case "Remove filter":
                    switch (command) {
                        case "Starts with":
                            commands.add("Remove filter;Starts with;" + parameter);
                            finalCommands.add("Remove filter;Starts with;" + parameter);
                            break;
                        case "Ends with":
                            commands.add("Remove filter;Ends with;" + parameter);
                            finalCommands.add("Remove filter;Ends with;" + parameter);
                            break;
                        case "Length":
                            commands.add("Remove filter;Length;" + parameter);
                            finalCommands.add("Remove filter;Length;" + parameter);
                            break;
                        case "Contains":
                            commands.add("Remove filter;Contains;" + parameter);
                            finalCommands.add("Remove filter;Contains;" + parameter);
                            break;
                    }
                    break;
            }


            input = scanner.nextLine();
        }
        for (String com : commands) {
            String[] t = com.split(";");
            String addOrRemove = t[0];
            String c = t[1];
            String predicate = t[2];
            for (String nestedCom : commands) {
                String[] nestedT = nestedCom.split(";");
                String nestedAddOrRemove = nestedT[0];
                String nestedC = nestedT[1];
                String nestedPredicate = nestedT[2];


                if ((!addOrRemove.equals(nestedAddOrRemove)) && predicate.equals(nestedPredicate) && c.equals(nestedC)) {
                    finalCommands.remove(com);
                }
            }
        }
        for (String finalCommand : finalCommands) {
            String[] t = finalCommand.split(";");
            String command = t[1];
            String predicate = t[2];
            switch (command) {
                case "Starts with":
                    names.removeIf(name -> startsWith.test(name, predicate));
                    break;
                case "Ends with":
                    names.removeIf(name -> endWith.test(name, predicate));
                    break;
                case "Length":
                    names.removeIf(name -> lengthPredicate.test(name, Integer.parseInt(predicate)));
                    break;
                case "Contains":
                    names.removeIf(name -> containsPredicate.test(name, predicate));
            }
        }
        names.forEach(e -> System.out.print(e + " "));
    }
}
