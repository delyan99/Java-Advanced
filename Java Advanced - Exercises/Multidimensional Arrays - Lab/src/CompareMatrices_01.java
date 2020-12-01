import java.util.Scanner;

public class CompareMatrices_01 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[][] firstMatrix = completeMatrix(scan);

        int[][] secondMatrix = completeMatrix(scan);

        System.out.println(getEqualOrNot(firstMatrix, secondMatrix));

    }

    private static int[][] completeMatrix(Scanner scan) {
        String[] input = scan.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int columns = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++){
            String[] inputArray = scan.nextLine().split("\\s+");
            for (int j = 0; j < columns; j++){
                matrix[i][j] = Integer.parseInt(inputArray[j]);
            }
        }
        return matrix;
    }

    private static String getEqualOrNot(int[][] firstMatrix, int[][] secondMatrix) {
        boolean flag = false;
        int rowsFirstMatrix = firstMatrix.length;
        int rowsSecondMatrix = secondMatrix.length;

        if(rowsFirstMatrix != rowsSecondMatrix){
            flag = false;
        }else{
            for (int i = 0; i < rowsFirstMatrix; i++){
                int colFirstMatrix = firstMatrix[i].length;
                int colSecondMatrix = secondMatrix[i].length;
                if(colFirstMatrix != colSecondMatrix){
                    flag = false;
                }else{
                    for (int j = 0; j < colFirstMatrix; j++){
                        if(firstMatrix[i][j] != secondMatrix[i][j]){
                            flag = false;
                            break;
                        }else{
                            flag = true;
                        }
                    }
                }

            }
        }


        if(flag){
            return "equal";
        }else{
            return "not equal";
        }
    }
}
