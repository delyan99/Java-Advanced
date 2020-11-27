import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumberswithaStack_01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		String[] array = scan.nextLine().split("\\s+");
		int[] numbers = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			numbers[i] = Integer.parseInt(array[i]);
		}
		for (int number : numbers) {
			stack.push(number);
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		

	}

}
