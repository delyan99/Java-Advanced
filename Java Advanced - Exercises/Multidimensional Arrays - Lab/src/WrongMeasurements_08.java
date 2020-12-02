import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
             matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int columns = matrix[0].length;
        int[][] newMatrix = new int[rows][columns];
        String[] array = scanner.nextLine().split("\\s+");
        int positionRow = Integer.parseInt(array[0]);
        int positionColumn = Integer.parseInt(array[1]);
        int number = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(positionRow == i && positionColumn == j){
                    number = matrix[i][j];
                    break;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == number){
                    int upperNumber = 0, downNumber = 0, leftNumber = 0, rightNumber = 0;

                    if(i - 1 >= 0){
                        upperNumber = matrix[i - 1][j];
                    }
                    if(i + 1 < matrix.length){
                        downNumber = matrix[i + 1][j];
                    }
                    if(j - 1 >= 0){
                        leftNumber = matrix[i][j - 1];
                    }
                    if(j + 1 < matrix[i].length){
                        rightNumber = matrix[i][j + 1];
                    }
                    if(upperNumber == number){
                        upperNumber = 0;
                    }
                    if(downNumber == number){
                        downNumber = 0;
                    }
                    if(leftNumber == number){
                        leftNumber = 0;
                    }
                    if(rightNumber == number){
                        rightNumber = 0;
                    }
                    int sum = upperNumber + downNumber + leftNumber + rightNumber;

                    newMatrix[i][j] = sum;
                }else{
                    newMatrix[i][j] = matrix[i][j];
                }
            }
        }

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j < newMatrix[i].length; j++) {
                System.out.print(newMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
