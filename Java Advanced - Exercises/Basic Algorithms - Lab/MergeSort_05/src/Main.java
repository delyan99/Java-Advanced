import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        mergeSort(array);
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));

    }
    private static int[]  mergeSort(int[] array){
        if(array.length == 1){
            return array;
        }
        int halfIndex = array.length/2;
        int firstHalf = halfIndex;
        int secondHalt = array.length - halfIndex;
        int[] firstHalfArray = new int[firstHalf];
        int[] secondHalfArray = new int[secondHalt];
        for (int i = 0; i < firstHalf; i++) {
            firstHalfArray[i] = array[i];
        }
        for (int i = firstHalf; i < firstHalf + secondHalt; i++) {
            secondHalfArray[i - firstHalf] = array[i];
        }
        firstHalfArray = mergeSort(firstHalfArray);
        secondHalfArray = mergeSort(secondHalfArray);
        int mainIndex = 0;
        int firstArrayIndex = 0;
        int secondArrayIndex = 0;
        while (firstArrayIndex < firstHalf && secondArrayIndex < secondHalt){
            if(firstHalfArray[firstArrayIndex] < secondHalfArray[secondArrayIndex]){
                array[mainIndex++] = firstHalfArray[firstArrayIndex++];
            }else{
                array[mainIndex++] = secondHalfArray[secondArrayIndex++];
            }
        }
        while (firstArrayIndex < firstHalf){
            array[mainIndex++] = firstHalfArray[firstArrayIndex++];
        }
        while (secondArrayIndex < secondHalt){
            array[mainIndex++] = secondHalfArray[secondArrayIndex++];
        }
        return array;
    }
}
