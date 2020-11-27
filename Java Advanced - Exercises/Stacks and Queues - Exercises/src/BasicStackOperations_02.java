import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations_02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		String[] firstLine = scan.nextLine().split("\\s+");
		int N = Integer.parseInt(firstLine[0]);
		int S = Integer.parseInt(firstLine[1]);
		int X = Integer.parseInt(firstLine[2]);
		String[] array = scan.nextLine().split("\\s+");
		int[] numbers = new int[array.length];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(array[i]);
		}
		if(N == 0) {
			System.out.println("0");
			return;
		}
		int counter = 0;
		for (int number : numbers) {
			counter++;
			stack.push(number);
			if(counter == N) {
				break;
			}
		}
		for (; S > 0; S--) {
			if(stack.isEmpty()) {
				break;
			}else {
				stack.pop();
			}
		}
		if(stack.isEmpty()) {
			System.out.println("0");
			return;
		}
		int minNumber = Integer.MAX_VALUE;
		while(!stack.isEmpty()) {
			int current = stack.pop();
			if(minNumber > current) {
				minNumber = current;
			}			
			if(current == X) {
				System.out.println("true");
				return;
			}
		}
		System.out.println(minNumber);
	}

}
