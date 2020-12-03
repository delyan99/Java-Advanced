import java.util.Scanner;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int rowsAndColumns = Integer.parseInt(input[0]);
        String AOrB = input[1];
        int[][] matrix = new int[rowsAndColumns][rowsAndColumns];
        switch(AOrB){
            case "A":
                matrix = patternA(rowsAndColumns);
                break;
            case "B":
                matrix = patternB(rowsAndColumns);
                break;
        }
        printMatrix(matrix);

    }

    private static int[][] patternB(int rowsAndColumns) {
        int[][] matrix = new int[rowsAndColumns][rowsAndColumns];
        int counter = 1;
        for (int i = 0; i < rowsAndColumns; i++) {
            if(i % 2 == 1){
                for (int j = rowsAndColumns - 1; j >= 0; j--) {
                    matrix[j][i] = counter;
                    counter++;
                }
            }else {
                for (int j = 0; j < rowsAndColumns; j++) {
                    matrix[j][i] = counter;
                    counter++;
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] patternA(int rowsAndColumns) {
        int[][] matrix = new int[rowsAndColumns][rowsAndColumns];
        int counter = 1;
        for (int i = 0; i < rowsAndColumns; i++) {
            for (int j = 0; j < rowsAndColumns; j++) {
                matrix[j][i] = counter;
                counter++;
            }
        }
        return matrix;
    }


}
