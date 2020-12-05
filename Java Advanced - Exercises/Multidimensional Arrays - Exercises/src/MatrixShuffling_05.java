import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] array = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = array[j];
            }
        }

        String command = scanner.nextLine();
        while(!"END".equals(command)){
            String[] tokens = command.split("\\s+");

            if(tokens[0].equals("swap") && tokens.length == 5){
                int firstNumber = Integer.parseInt(tokens[1]);
                int secondNumber = Integer.parseInt(tokens[2]);
                int thirdNumber = Integer.parseInt(tokens[3]);
                int fourthNumber = Integer.parseInt(tokens[4]);
                if(firstNumber >=0 && firstNumber < rows && secondNumber >=0 && secondNumber < cols && thirdNumber >=0 && thirdNumber < rows && fourthNumber >=0 && fourthNumber < cols){
                    String currentElement = matrix[firstNumber][secondNumber];
                    matrix[firstNumber][secondNumber] = matrix[thirdNumber][fourthNumber];
                    matrix[thirdNumber][fourthNumber] = currentElement;
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }

                }else{
                    System.out.println("Invalid input!");
                }

            }else{
                System.out.println("Invalid input!");
            }
            command = scanner.nextLine();
        }
    }
}
