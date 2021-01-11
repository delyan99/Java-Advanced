import java.util.Scanner;

public class Main {

    public static int playerRow = -1, playerCol = -1;
    public static boolean isPlayerWon = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int countOfCommands = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        for (int i = 0; i < matrix.length; i++) {
            String line = scanner.nextLine();
            char[] characters = line.toCharArray();
            matrix[i] = characters;
            if(line.contains("f")){
                playerRow = i;
                for (int j = 0; j < characters.length; j++) {
                    if(characters[j] == 'f'){
                        playerCol = j;
                        break;
                    }
                }
            }
        }

        while (countOfCommands > 0){
            String command = scanner.nextLine();
            if(command.equals("up")){
                String direction = "up";
                movePlayer(playerCol, playerRow, playerCol, playerRow - 1, matrix, direction);
            }else if(command.equals("down")){
                String direction = "down";
                movePlayer(playerCol, playerRow, playerCol, playerRow + 1, matrix, direction);
            }else if(command.equals("left")){
                String direction = "left";
                movePlayer(playerCol, playerRow, playerCol - 1, playerRow, matrix, direction);
            }else if(command.equals("right")){
                String direction = "right";
                movePlayer(playerCol, playerRow, playerCol + 1, playerRow, matrix, direction);
            }
            if(isPlayerWon){
                break;
            }
            countOfCommands--;
        }
        if(isPlayerWon){
            System.out.println("Player won!");
        }else{
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static void movePlayer(int oldCol, int oldRow,int newCol, int newRow, char[][] matrix, String direction) {
        if(!isNewColsAndRowsValid(newCol, newRow, matrix)){
            if(newRow < 0){
                newRow = matrix.length - 1;
            }else if(newRow > matrix.length - 1){
                newRow = 0;
            }else if(newCol < 0){
                newCol = matrix[newRow].length - 1;
            }else if(newCol > matrix[newRow].length - 1){
                newCol = 0;
            }
        }
        if(matrix[newRow][newCol] == 'T'){
            playerRow = oldRow;
            playerCol = oldCol;
        }else if(matrix[newRow][newCol] == '-'){
            matrix[playerRow][playerCol] = '-';
            playerRow = newRow;
            playerCol = newCol;
        }else if(matrix[newRow][newCol] == 'F'){
            matrix[playerRow][playerCol] = '-';
            playerRow = newRow;
            playerCol = newCol;
            isPlayerWon = true;
        }else if(matrix[newRow][newCol] == 'B'){
            matrix[playerRow][playerCol] = '-';
            switch(direction){
                case "up":
                    movePlayer(oldCol, oldRow, newCol,  newRow - 1, matrix, direction);
                    break;
                case "down":
                    movePlayer(oldCol, oldRow, newCol,  newRow + 1, matrix, direction);
                    break;
                case "left":
                    movePlayer(oldCol, oldRow, newCol - 1, newRow, matrix, direction);
                    break;
                case "right":
                    movePlayer(oldCol, oldRow, newCol + 1,  newRow, matrix, direction);
                    break;
            }
        }

        matrix[playerRow][playerCol] = 'f';
    }

    private static boolean isNewColsAndRowsValid(int newCol, int newRow, char[][] matrix) {
        return newRow >= 0  && newRow < matrix.length && newCol >= 0  && newCol < matrix[newRow].length ;
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
