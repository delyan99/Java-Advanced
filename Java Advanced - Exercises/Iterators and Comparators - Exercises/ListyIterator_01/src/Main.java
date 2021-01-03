import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] tokens = input.split("\\s+");
        List<String> data = new ArrayList<>();
        for (int i = 1; i < tokens.length; i++) {
            data.add(tokens[i]);
        }
        ListyIterator list = new ListyIterator(data);
        while (!"END".equals(input)){

            String command = input;
            switch (command){
                case "Move":
                    System.out.println(list.move());
                    break;
                case "Print":
                    System.out.println(list.print());
                    break;
                case "HasNext":
                    System.out.println(list.hasNext());
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
