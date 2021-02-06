import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            try {
                validation(scanner);
                flag = false;
            } catch (InvalidNumberInputException ex) {
                System.out.println(ex.getMessage());
            }

        }
    }

    private static void validation(Scanner scanner) {
        try {
            int[] numbers = parseTwoIntegers(scanner);
            printNumbers(numbers[0], numbers[1]);
        } catch (NumberFormatException ex){
            throw new IllegalArgumentException("Invalid numbers");
        }
    }

    public static int[] parseTwoIntegers(Scanner scanner){
        int[] result = new int[2];
        result[0] = parseInteger(scanner);
        result[1] = parseInteger(scanner);
        return result;
    }

    public static int parseInteger(Scanner scanner){
        int result = 0;
        try {
           result = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception){
            throw new InvalidNumberInputException("Input valid integer number");
        }
        return result;
    }

    public static void printNumbers(int start, int end){
        if(start < 0 || start > 100 || end < 1 || end <= start){
            throw new InvalidNumberInputException("The number is not in valid range");
        }
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }
}
