import java.util.Scanner;

public class DiagonalDifference_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsAndCols = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rowsAndCols][rowsAndCols];
        for (int i = 0; i < rowsAndCols; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < rowsAndCols; j++) {
                matrix[i][j] = Integer.parseInt(input[j]);
            }
        }
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i == j){
                    primaryDiagonalSum += matrix[i][j];
                }
                if(i ==  matrix.length - 1 - j){
                    secondaryDiagonalSum += matrix[i][j];
                }
            }
        }
        if(primaryDiagonalSum > secondaryDiagonalSum){
            System.out.println(primaryDiagonalSum - secondaryDiagonalSum);
        }else{
            System.out.println(secondaryDiagonalSum - primaryDiagonalSum);
        }
    }
}
