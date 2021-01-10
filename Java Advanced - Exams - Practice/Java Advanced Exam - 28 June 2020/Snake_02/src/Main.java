import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("");
            matrix[i] = input;
        }
        int foodEatenCounter = 0;
        boolean isGameOver = false;
        while (foodEatenCounter < 10){
            String command = scanner.nextLine();
            boolean isMoved = false;
            switch(command){
                case "up":
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            if(matrix[i][j].equals("S")){
                                matrix[i][j] = ".";
                                if((i - 1) < 0){
                                    isGameOver = true;
                                    printOutput(matrix, foodEatenCounter, isGameOver);
                                    return;
                                }
                                switch (matrix[--i][j]) {
                                    case "*":
                                        foodEatenCounter++;
                                        matrix[i][j] = "S";
                                        break;
                                    case "-":
                                        matrix[i][j] = "S";
                                        break;
                                    case "B":
                                        matrix[i][j] = ".";
                                        for (int k = 0; k < matrix.length; k++) {
                                            for (int l = 0; l < matrix[k].length; l++) {
                                                if (matrix[k][l].equals("B")) {
                                                    matrix[k][l] = "S";
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                }
                                isMoved = true;
                                break;
                            }
                        }
                        if(isMoved){
                            break;
                        }
                    }
                    break;
                case "down":
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            if(matrix[i][j].equals("S")){
                                matrix[i][j] = ".";
                                if((i + 1) > matrix.length - 1){
                                    isGameOver = true;
                                    printOutput(matrix, foodEatenCounter, isGameOver);
                                    return;
                                }
                                switch (matrix[++i][j]) {
                                    case "*":
                                        foodEatenCounter++;
                                        matrix[i][j] = "S";
                                        break;
                                    case "-":
                                        matrix[i][j] = "S";
                                        break;
                                    case "B":
                                        matrix[i][j] = ".";
                                        for (int k = 0; k < matrix.length; k++) {
                                            for (int l = 0; l < matrix[k].length; l++) {
                                                if (matrix[k][l].equals("B")) {
                                                    matrix[k][l] = "S";
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                }
                                isMoved = true;
                                break;
                            }
                        }
                        if(isMoved){
                            break;
                        }
                    }
                    break;
                case "left":
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            if(matrix[i][j].equals("S")){
                                matrix[i][j] = ".";
                                if((j - 1) < 0){
                                    isGameOver = true;
                                    printOutput(matrix, foodEatenCounter, isGameOver);
                                    return;
                                }
                                switch (matrix[i][--j]) {
                                    case "*":
                                        foodEatenCounter++;
                                        matrix[i][j] = "S";
                                        break;
                                    case "-":
                                        matrix[i][j] = "S";
                                        break;
                                    case "B":
                                        matrix[i][j] = ".";
                                        for (int k = 0; k < matrix.length; k++) {
                                            for (int l = 0; l < matrix[k].length; l++) {
                                                if (matrix[k][l].equals("B")) {
                                                    matrix[k][l] = "S";
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                }
                                isMoved = true;
                                break;
                            }
                        }
                        if(isMoved){
                            break;
                        }
                    }
                    break;
                case "right":
                    for (int i = 0; i < matrix.length; i++) {
                        for (int j = 0; j < matrix[i].length; j++) {
                            if(matrix[i][j].equals("S")){
                                matrix[i][j] = ".";
                                if((j + 1) > matrix.length - 1){
                                    isGameOver = true;
                                    printOutput(matrix, foodEatenCounter, isGameOver);
                                    return;
                                }
                                switch (matrix[i][++j]) {
                                    case "*":
                                        foodEatenCounter++;
                                        matrix[i][j] = "S";
                                        break;
                                    case "-":
                                        matrix[i][j] = "S";
                                        break;
                                    case "B":
                                        matrix[i][j] = ".";
                                        for (int k = 0; k < matrix.length; k++) {
                                            for (int l = 0; l < matrix[k].length; l++) {
                                                if (matrix[k][l].equals("B")) {
                                                    matrix[k][l] = "S";
                                                    break;
                                                }
                                            }
                                        }
                                        break;
                                }
                                isMoved = true;
                                break;
                            }
                        }
                        if(isMoved){
                            break;
                        }
                    }
                    break;
            }
        }
        printOutput(matrix, foodEatenCounter, isGameOver);
    }

    private static void printOutput(String[][] matrix, int foodEatenCounter, boolean isGameOver) {
        if(isGameOver) {
            System.out.println("Game over!");
        }else{
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Food eaten: " + foodEatenCounter);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
