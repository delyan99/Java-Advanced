import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printRhombusOfStars(n);
    }

    private static void printRhombusOfStars(int n) {
        int stars = 1;
        for (int i = 1; i < n; i++) {
            printRow(i, n, stars++);
        }

        for (int i = n ; i >= 0; i--) {
            printRow(i, n, stars--);
        }

    }

    private static void printRow(int current, int size, int stars) {
        for (int j = current - 1; j < size - 1; j++) {
            System.out.print(" ");
        }

        for (int i = 0; i < stars; i++) {
            System.out.print("* ");
        }
        System.out.println();
    }
}
