import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack stack = new Stack();
        while (!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            switch (command){
                case "Push":
                    for (int i = 1; i < tokens.length - 1; i++) {
                        tokens[i] = tokens[i].replaceAll(",", "");
                    }
                    for (int i = 1; i < tokens.length; i++) {
                        int currentElement = Integer.parseInt(tokens[i]);
                        stack.push(currentElement);
                    }
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }

            input = scanner.nextLine();
        }
        for (Integer element : stack) {
            System.out.println(element);
        }

        for (Integer element : stack) {
            System.out.println(element);
        }

    }
}
