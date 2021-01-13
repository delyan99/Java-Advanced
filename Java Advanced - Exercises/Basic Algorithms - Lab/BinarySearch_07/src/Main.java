import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int key = Integer.parseInt(scanner.nextLine());
        System.out.println(getIndex(array, key));
    }

    public static int getIndex(int[] array, int key){
        int start = 0;
        int end = array.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;
            if(array[mid] < key){
                start = mid + 1;
            }else if(array[mid] > key){
                end = mid - 1;
            }else{
                return mid;
            }
        }
        return  -1;
    }
}
