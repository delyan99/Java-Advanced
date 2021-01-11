import java.util.Scanner;

public class Main {
    public static int beeRow = -1, beeCol = -1, pollinatedFlowers = 0;
    public static boolean isBeeLost = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int i = 0; i < matrix.length; i++) {
            String input = scanner.nextLine();
            char[] charArray = input.toCharArray();
            matrix[i] = charArray;
            if(input.contains("B")){
                for (int j = 0; j < charArray.length; j++) {
                    if(charArray[j] == 'B'){
                        beeRow = i;
                        beeCol = j;
                    }
                }

            }
        }

        String command = scanner.nextLine();
        while (!"End".equals(command)){
            if(command.equals("up")){
                if(isOutOfField(beeRow - 1, beeCol, matrix)){
                    isBeeLost = true;
                    break;
                }
                String direction= "up";
                beeMoving(beeRow - 1, beeCol, beeRow, beeCol, matrix, direction);
            }else if(command.equals("down")){
                if(isOutOfField(beeRow + 1, beeCol, matrix)){
                    isBeeLost = true;
                    break;
                }
                String direction= "down";
                beeMoving(beeRow + 1, beeCol, beeRow, beeCol, matrix, direction);
            } else if(command.equals("left")){
                if(isOutOfField(beeRow, beeCol - 1, matrix)){
                    isBeeLost = true;
                    break;
                }
                String direction= "left";
                beeMoving(beeRow, beeCol - 1, beeRow, beeCol, matrix, direction);
            }else if(command.equals("right")){
                if(isOutOfField(beeRow, beeCol + 1, matrix)){
                    isBeeLost = true;
                    break;
                }
                String direction= "right";
                beeMoving(beeRow, beeCol + 1, beeRow, beeCol, matrix, direction);
            }

            command = scanner.nextLine();
        }

        if(isBeeLost){
            matrix[beeRow][beeCol] = '.';
            System.out.println("The bee got lost!");
        }
        if(pollinatedFlowers >= 5){
            System.out.println(String.format("Great job, the bee manage to pollinate %d flowers!", pollinatedFlowers));
        }else{
            System.out.println(String.format("The bee couldn't pollinate the flowers, she needed %d flowers more", 5 - pollinatedFlowers));
        }
        printMatrix(matrix);
    }

    private static void beeMoving(int newRow, int newCol, int oldRow, int oldCol, char[][] matrix, String direction) {
        if(matrix[newRow][newCol] == '.'){
            matrix[oldRow][oldCol] = '.';
            beeRow = newRow;
            beeCol = newCol;
        }else if(matrix[newRow][newCol] == 'f'){
            pollinatedFlowers++;
            matrix[oldRow][oldCol] = '.';
            beeRow = newRow;
            beeCol = newCol;
        }else if(matrix[newRow][newCol] == 'O'){
            matrix[oldRow][oldCol] = '.';
            switch(direction){
                case "up":
                    if(isOutOfField(newRow - 1, newCol, matrix)){
                        isBeeLost = true;
                        return;
                    }
                    matrix[oldRow - 1][oldCol] = '.';
                    beeMoving(newRow - 1, newCol, oldRow, oldCol, matrix, direction);
                    break;
                case "down":
                    if(isOutOfField(newRow + 1, newCol, matrix)){
                        isBeeLost = true;
                        return;
                    }
                    matrix[oldRow + 1][oldCol] = '.';
                    beeMoving(newRow + 1, newCol, oldRow, oldCol, matrix, direction);
                    break;
                case "left":
                    if(isOutOfField(newRow, newCol - 1, matrix)){
                        isBeeLost = true;
                        return;
                    }
                    matrix[oldRow][oldCol - 1] = '.';
                    beeMoving(newRow, newCol - 1, oldRow, oldCol, matrix, direction);
                    break;
                case "right":
                    if(isOutOfField(newRow, newCol + 1, matrix)){
                        isBeeLost = true;
                        return;
                    }
                    matrix[oldRow][oldCol + 1] = '.';
                    beeMoving(newRow, newCol + 1, oldRow, oldCol, matrix, direction);
                    break;
            }
        }
        matrix[beeRow][beeCol] = 'B';
    }

    private static boolean isOutOfField(int beeRow, int beeCol, char[][] matrix) {
        return beeRow < 0 || beeRow > matrix.length - 1 || beeCol < 0 || beeCol > matrix[beeRow].length - 1;
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
