import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] tokens = input.split(", ");
            int[] tokensInteger = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                tokensInteger[i] = Integer.parseInt(tokens[i]);
            }
            List<Integer> data = new ArrayList<>();
            for (int token : tokensInteger) {
                data.add(token);
            }
            Lake lake = new Lake(data);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < lake.size(); i++) {
                if(i == lake.size() - 1){
                    result.append(lake.iterator().next());
                }else{
                    result.append(lake.iterator().next());
                    result.append(", ");
                }
            }
            System.out.println(result.toString());
            input = scanner.nextLine();
        }

    }
}
