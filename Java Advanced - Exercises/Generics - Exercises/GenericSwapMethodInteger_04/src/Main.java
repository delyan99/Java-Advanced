import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ListOfElements<Integer> list = new ListOfElements<>();
        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(scanner.nextLine());
            list.add(input);
        }
        String[] tokens = scanner.nextLine().split("\\s+");
        int firstNumber = Integer.parseInt(tokens[0]);
        int secondNumber = Integer.parseInt(tokens[1]);
        list.swap(firstNumber, secondNumber);
        System.out.println(list);
    }
}
