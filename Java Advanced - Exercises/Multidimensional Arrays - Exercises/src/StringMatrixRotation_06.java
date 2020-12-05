import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int degree = Integer.parseInt(scanner.nextLine().substring(7).replace(")", ""));
        String input = scanner.nextLine();
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();
        int rows = 0, maxSize = 0;
        while (!"END".equals(input)){
            queue.offer(input);
            stack.push(input);
            rows++;
            if(maxSize < input.length()){
                maxSize = input.length();
            }
            input = scanner.nextLine();
        }
        char[][] matrix = new char[rows][maxSize];



        while(degree >= 360){
            degree -= 360;
        }
        switch(degree){
            case 0:
                for (int i = 0; i < rows; i++) {
                    if(!queue.isEmpty()) {
                    String current = queue.poll();
                        for (int j = 0; j < current.length(); j++) {
                            matrix[i][j] = current.charAt(j);
                        }
                    }
                }

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        System.out.print(matrix[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                for (int i = 0; i < rows; i++) {
                    String current = stack.pop();
                    for (int j = 0; j < current.length(); j++) {
                        matrix[i][j] = current.charAt(j);
                    }
                    for (int j = current.length(); j < maxSize; j++) {
                        matrix[i][j] = ' ';
                    }
                }

                for (int i = 0; i < maxSize; i++) {
                    for (int j = 0; j < rows; j++) {
                        System.out.print(matrix[j][i]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int i = 0; i < rows; i++) {
                    if(!stack.isEmpty()) {
                        StringBuilder current = new StringBuilder(stack.pop());
                        current.reverse();
                        int size = current.length();
                        int counter = 0;
                        for (int j = 0; j < maxSize - size; j++) {
                            matrix[i][j] = ' ';
                        }
                        for (int j = maxSize - size; j < maxSize; j++) {
                            matrix[i][j] = current.charAt(counter++);
                        }
                    }
                }

                for (int i = 0; i < matrix.length; i++) {
                    for (int j = 0; j < matrix[i].length; j++) {
                        System.out.print(matrix[i][j]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                for (int i = 0; i < rows; i++) {
                    StringBuilder current = new StringBuilder(queue.poll());
                    current.reverse();
                    int counter = 0;
                    for (int j = 0; j < maxSize - current.length(); j++) {
                        matrix[i][j] = ' ';
                    }
                    for (int j = maxSize - current.length(); j < maxSize; j++) {
                        matrix[i][j] = current.charAt(counter++);
                    }
                }

                for (int i = 0; i < maxSize; i++) {
                    for (int j = 0; j < rows; j++) {
                        System.out.print(matrix[j][i]);
                    }
                    System.out.println();
                }

                break;
        }


    }
}
