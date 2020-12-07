import java.util.Scanner;

public class TheHeiganDance_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double damageToHeigam = Double.parseDouble(scanner.nextLine());
        int playerHealth = 18500;
        double HeigamHealth = 3000000.00;

        int playerRow = 7;
        int playerColumn = 7;
        String lastCommand = "";
        boolean flag = false;
        while(true){
            HeigamHealth -= damageToHeigam;
            if(HeigamHealth <= 0){
                if(lastCommand.equals("Cloud") && flag == true){
                    playerHealth -= 3500;
                    flag = false;
                }
                break;
            }
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            int row = Integer.parseInt(input[1]);
            int column = Integer.parseInt(input[2]);

            if(lastCommand.equals("Cloud") && flag == true){
                playerHealth -= 3500;
                flag = false;
            }

            if(playerHealth <= 0){
                break;
            }
            int[][] matrix = new int[15][15];
            for (int i = row - 1; i <= row + 1; i++) {
                if(i >=0 && i < matrix.length){
                    for (int j = column - 1; j <= column + 1; j++) {
                        if(j >= 0 && j < matrix[i].length){
                            matrix[i][j] = 1;
                        }
                    }
                }
            }

            if(matrix[playerRow][playerColumn] == 1){
                if(isRowValid(matrix, playerRow - 1) && matrix[playerRow - 1][playerColumn] == 0){
                    playerRow -= 1;
                }else if(isColumnValid(matrix, playerColumn + 1) && matrix[playerRow][playerColumn + 1] == 0){
                    playerColumn += 1;
                }else if(isRowValid(matrix, playerRow + 1) && matrix[playerRow + 1][playerColumn] == 0){
                    playerRow += 1;
                }else if(isColumnValid(matrix, playerColumn - 1) && matrix[playerRow][playerColumn - 1] == 0){
                    playerColumn -= 1;
                }
            }

            if(matrix[playerRow][playerColumn] == 1) {
                switch (command) {
                    case "Cloud":
                        playerHealth -= 3500;
                        flag = true;
                        lastCommand = "Cloud";
                        break;
                    case "Eruption":
                        playerHealth -= 6000;
                        lastCommand = "Eruption";
                        break;
                }
            }
            if(playerHealth <= 0){
                break;
            }
        }
        if(lastCommand.equals("Cloud")){
            lastCommand = "Plague Cloud";
        }
        if(HeigamHealth <= 0){
            System.out.println("Heigan: Defeated!");
        }else{
            System.out.printf("Heigan: %.2f%n", HeigamHealth);
        }
        if(playerHealth <= 0){
            System.out.println("Player: Killed by " + lastCommand);
        }else{
            System.out.println("Player: " + playerHealth);
        }
        System.out.println("Final position: " + playerRow + ", " + playerColumn);
    }

    private static boolean isColumnValid(int[][] matrix, int column) {
        if(column >= 0 && column < matrix.length){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isRowValid(int[][] matrix, int row) {
        if(row >= 0 && row < matrix[row].length){
            return true;
        }else{
            return false;
        }
    }
}
