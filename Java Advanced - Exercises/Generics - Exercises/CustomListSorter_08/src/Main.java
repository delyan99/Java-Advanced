import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        CustomList<String> list = new CustomList<>();
        while (!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Add":
                    String elementAdd = tokens[1];
                    list.add(elementAdd);
                    break;
                case "Remove":
                    int indexRemove = Integer.parseInt(tokens[1]);
                    list.remove(indexRemove);
                    break;
                case "Contains":
                    String elementContains = tokens[1];
                    System.out.println(list.contains(elementContains));
                    break;
                case "Swap":
                    int firstIndexSwap = Integer.parseInt(tokens[1]);
                    int secondIndexSwap = Integer.parseInt(tokens[2]);
                    list.swap(firstIndexSwap, secondIndexSwap);
                    break;
                case "Greater":
                    String elementGreater = tokens[1];
                    System.out.println(list.countGreaterThan(elementGreater));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    List<String> data = list.getData();
                    for (String d : data) {
                        System.out.println(d);
                    }
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
