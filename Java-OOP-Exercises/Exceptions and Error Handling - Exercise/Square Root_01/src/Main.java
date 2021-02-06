import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        try{
            int n = Integer.parseInt(number);
            System.out.println(squareRootCalculation(n));
        } catch (IllegalArgumentException exception ) {
            System.out.println("Invalid number");
        }
        finally {
            System.out.println("Good bye");
        }
    }

    public static double squareRootCalculation(int n){
        if(n < 0){
            throw new IllegalArgumentException("Negative number");
        }
        return Math.sqrt(n);
    }
}
