import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(findFactorial(n));
    }

    private static int findFactorial(int n) {
        if(n == 1){
            return n;
        }

        return n * findFactorial(n - 1);
    }
}
