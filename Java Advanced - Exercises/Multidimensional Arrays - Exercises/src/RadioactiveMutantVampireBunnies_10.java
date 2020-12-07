import java.util.Scanner;

public class RadioactiveMutantVampireBunnies_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(array[0]);
        int columns = Integer.parseInt(array[1]);
        char[][] matrix = new char[rows][columns];
        int playerRow = -1;
        int playerCol = -1;

        for (int i = 0; i < rows; i++) {
            String input = scanner.nextLine();
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = input.charAt(j);
                if(input.charAt(j) == 'P'){
                    playerRow = i;
                    playerCol = j;
                }
            }
        }

        String commands = scanner.nextLine();
        boolean flag = false, flagOutOfField = false;
        for (int i = 0; i < commands.length(); i++) {
            if(flag){
                break;
            }
            if(flagOutOfField){
                break;
            }
            char command = commands.charAt(i);
            switch(command){
                case 'L':
                    matrix = fillMatrixWithBunnies(matrix, rows, columns);
                    if(isColValid(matrix, playerCol - 1, rows, columns)){
                        if(matrix[playerRow][playerCol - 1] == 'B'){
                            playerCol = playerCol - 1;
                            flag = true;
                        }else{
                            if(matrix[playerRow][playerCol] == 'P'){
                                matrix[playerRow][playerCol] = '.';
                            }
                            matrix[playerRow][playerCol - 1] = 'P';
                            playerCol = playerCol - 1;
                        }
                    }else{
                        flagOutOfField = true;
                    }
                    break;
                case 'R':
                    matrix = fillMatrixWithBunnies(matrix, rows, columns);
                    if(isColValid(matrix, playerCol + 1, rows, columns)){
                        if(matrix[playerRow][playerCol + 1] == 'B'){
                            playerCol = playerCol + 1;
                            flag = true;
                        }else{
                            if(matrix[playerRow][playerCol] == 'P'){
                                matrix[playerRow][playerCol] = '.';
                            }
                            matrix[playerRow][playerCol + 1] = 'P';
                            playerCol = playerCol + 1;
                        }
                    }else{
                        flagOutOfField = true;
                    }
                    break;
                case 'U':
                    matrix = fillMatrixWithBunnies(matrix, rows, columns);
                    if(isRowValid(matrix, playerRow - 1, rows, columns)){
                        if(matrix[playerRow - 1][playerCol] == 'B'){
                            playerRow = playerRow - 1;
                            flag = true;
                        }else{
                            if(matrix[playerRow][playerCol] == 'P'){
                                matrix[playerRow][playerCol] = '.';
                            }
                            matrix[playerRow - 1][playerCol] = 'P';
                            playerRow = playerRow - 1;
                        }
                    }else{
                        flagOutOfField = true;
                    }
                    break;
                case 'D':
                    matrix = fillMatrixWithBunnies(matrix, rows, columns);
                    if(isRowValid(matrix, playerRow + 1, rows, columns)){
                        if(matrix[playerRow + 1][playerCol] == 'B'){
                            playerRow = playerRow + 1;
                            flag = true;
                        }else{
                            if(matrix[playerRow][playerCol] == 'P'){
                                matrix[playerRow][playerCol] = '.';
                            }
                            matrix[playerRow + 1][playerCol] = 'P';
                            playerRow = playerRow + 1;
                        }
                    }else{
                        flagOutOfField = true;
                    }
                    break;
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        if(!flagOutOfField) {
            if (flag) {
                System.out.println("dead: " + playerRow + " " + playerCol);
            } else {
                System.out.println("won: " + playerRow + " " + playerCol);
            }
        }else{
            System.out.println("won: " + playerRow + " " + playerCol);
        }

    }

    private static char[][] fillMatrixWithBunnies(char[][] matrix, int rows, int cols) {
        char[][] newMatrix = new char[rows][cols];

        for (int i = 0; i < newMatrix.length; i++) {
            for (int j = 0; j <newMatrix[i].length; j++) {
                newMatrix[i][j] = '.';
            }
        }
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[j].length; k++) {
                if(matrix[j][k] == 'B'){
                    newMatrix[j][k] = 'B';
                    if(isColValid(matrix, k - 1, matrix.length, matrix[j].length)){
                        newMatrix[j][k - 1] = 'B';
                    }
                    if(isColValid(matrix, k + 1, matrix.length, matrix[j].length)){
                        newMatrix[j][k + 1] = 'B';
                    }
                    if(isRowValid(matrix, j - 1, matrix.length, matrix[j].length)){
                        newMatrix[j - 1][k] = 'B';
                    }
                    if(isRowValid(matrix, j + 1, matrix.length, matrix[j].length)){
                        newMatrix[j + 1][k] = 'B';
                    }
                }
            }
        }
        return newMatrix;
    }


    private static boolean isRowValid(char[][] matrix, int playerRow, int rows, int columns) {
        if(playerRow >= 0 && playerRow < rows){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isColValid(char[][] matrix, int playerCol, int rows, int columns) {
        if(playerCol >= 0 && playerCol < columns){
            return true;
        }else{
            return false;
        }
    }
}