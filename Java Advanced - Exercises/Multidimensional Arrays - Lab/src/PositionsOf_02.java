import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = inputMatrix(scanner);
        int number =Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        for (int i = 0; i < matrix.length; i++) {
            int columnLength = matrix[i].length;
            for (int j = 0; j < columnLength; j++) {
                if(number == matrix[i][j]){
                    flag = true;
                    System.out.println(i + " " + j);
                }
            }
        }
        if(flag == false){
            System.out.println("not found");
        }

    }

    private static int[][] inputMatrix(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            String[] array = scanner.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = Integer.parseInt(array[j]);
            }
        }
        return matrix;
    }
}
