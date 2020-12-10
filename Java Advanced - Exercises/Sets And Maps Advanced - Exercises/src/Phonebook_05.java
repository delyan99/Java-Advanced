import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> map = new HashMap<>();
        String input = scanner.nextLine();
        while (!"search".equals(input)){
            String[] tokens = input.split("-");
            String name = tokens[0];
            String number = tokens[1];
            map.put(name, number);

            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while(!"stop".equals(input)){
            String inputName = input;
            if(map.containsKey(inputName)){
                String currentNumber = map.get(inputName);
                System.out.println(String.format("%s -> %s", inputName, currentNumber));
            }else{
                System.out.println(String.format("Contact %s does not exist.", inputName));
            }
            input = scanner.nextLine();
        }

    }
}
