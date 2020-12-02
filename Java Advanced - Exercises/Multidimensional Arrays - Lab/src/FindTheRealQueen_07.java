import java.util.Scanner;

public class FindTheRealQueen_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = inputMatrix(scanner);
        boolean bigFlag = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 'q'){
                    boolean flag = false;
                    //System.out.println(i + " " + j);
                    for (int k = 0; k < matrix.length; k++) {
                        if(k == i){
                            k++;
                            if(k == matrix.length){
                                break;
                            }
                        }

                        if(matrix[k][j] == 'q'){
                            flag = true;
                            break;
                        }
                    }

                    for (int k = 0; k < matrix[i].length; k++) {
                        if(flag){
                            break;
                        }
                        if(k == j){
                            k++;
                            if(k == matrix[i].length){
                                break;
                            }
                        }
                        if(matrix[i][k] == 'q'){
                            flag = true;
                            break;
                        }
                    }
                    int currentRow = i - 1;
                    int currentColumn = j - 1;
                    while(currentRow >= 0 && currentColumn >= 0){
                        if(flag){
                            break;
                        }
                        if(matrix[currentRow][currentColumn] == 'q'){
                            flag = true;
                            break;
                        }
                        currentRow--;
                        currentColumn--;
                    }

                    currentRow = i + 1;
                    currentColumn = j + 1;
                    while(currentRow < 8 && currentColumn < 8){
                        if(flag){
                            break;
                        }
                        if(matrix[currentRow][currentColumn] == 'q'){
                            flag = true;
                            break;
                        }
                        currentRow++;
                        currentColumn++;
                    }


                    currentRow = i - 1;
                    currentColumn = j + 1;
                    while(currentRow >= 0 && currentColumn < 8){
                        if(flag){
                            break;
                        }
                        if(matrix[currentRow][currentColumn] == 'q'){
                            flag = true;
                            break;
                        }
                        currentRow--;
                        currentColumn++;
                    }

                    currentRow = i + 1;
                    currentColumn = j - 1;
                    while(currentRow < 8 && currentColumn >= 0){
                        if(flag){
                            break;
                        }
                        if(matrix[currentRow][currentColumn] == 'q'){
                            flag = true;
                            break;
                        }
                        currentRow++;
                        currentColumn--;
                    }

                    if(!flag){
                        System.out.println(i + " " + j);
                        bigFlag = true;
                        break;
                    }
                }
            }
            if(bigFlag){
                break;
            }
        }

    }


    private static char[][] inputMatrix(Scanner scanner) {
        char[][] matrix = new char[8][8];
        for (int i = 0; i < 8; i++) {
            String[] array = scanner.nextLine().split("\\s+");
            for (int j = 0; j < 8; j++) {
                matrix[i][j] = array[j].charAt(0);
            }
        }
        return matrix;
    }
}
