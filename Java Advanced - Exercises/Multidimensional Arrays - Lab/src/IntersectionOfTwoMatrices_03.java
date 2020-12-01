import java.util.Scanner;

public class IntersectionOfTwoMatrices_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        char[][] firstMatrix = inputMatrix(scanner, rows, columns);
        char[][] secondMatrix = inputMatrix(scanner, rows, columns);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(firstMatrix[i][j] != secondMatrix[i][j]){
                    firstMatrix[i][j] = '*';
                }
                System.out.print(firstMatrix[i][j] +" ");
            }
            System.out.println();
        }

    }

    private static char[][] inputMatrix(Scanner scanner, int rows, int columns) {
        char[][] matrix = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] array = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = array[j].charAt(0);
            }
        }
        return matrix;
    }
}
