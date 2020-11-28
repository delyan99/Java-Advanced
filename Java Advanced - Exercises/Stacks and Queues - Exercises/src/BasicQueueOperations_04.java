import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations_04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] array = scan.nextLine().split("\\s+");
		int N = Integer.parseInt(array[0]);
		int S = Integer.parseInt(array[1]);
		int X = Integer.parseInt(array[2]);
		String[] input = scan.nextLine().split("\\s+");
		int[] numbers = new int[input.length];
		
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = Integer.parseInt(input[i]);
		}
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		int counter = 0;
		
		if(N == 0) {
			System.out.println("0");
			return;
		}
		
		for (int i = 0; i < numbers.length; i++) {
			queue.offer(numbers[i]);
			counter++;
			if(counter == N) {
				break;
			}
		}
		
		for (int i = 0; i < S; i++) {
			queue.poll();
		}
		
		if(queue.isEmpty()) {
			System.out.println("0");
			return;
		}
		
		if(queue.contains(X)) {
			System.out.println("true");
			return;
		}
		int min = Integer.MAX_VALUE;
		while(!queue.isEmpty()) {
			int currentPoll = queue.poll();
			if(currentPoll < min) {
				min = currentPoll;
			}
		}
		System.out.println(min);

	}

}
