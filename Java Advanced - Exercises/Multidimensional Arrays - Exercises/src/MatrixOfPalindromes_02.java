import java.util.Scanner;

public class MatrixOfPalindromes_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][columns];
        char startSymbol = 'a';
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                char firstAndLastLetter = (char)(startSymbol + i);
                char secondLetter = (char)(startSymbol + i + j);
                matrix[i][j] = String.valueOf(firstAndLastLetter) + String.valueOf(secondLetter) + String.valueOf(firstAndLastLetter);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }


    }
}
