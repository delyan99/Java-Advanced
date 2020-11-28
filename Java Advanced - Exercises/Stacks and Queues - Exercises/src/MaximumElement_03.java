import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement_03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		ArrayDeque<Integer> numbers = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			String input = scan.nextLine();
			String[] array = input.split("\\s+");
			String command = array[0];			
			switch(command) {
			case "1":				
				int inputNumber = Integer.parseInt(array[1]);
				numbers.push(inputNumber); 
				break;
			case "2":
				numbers.pop();
				break;
			case "3":
				System.out.println(maxNumber(numbers)); 
				break;
			}
		}
		System.out.println();
	}

	private static int maxNumber(ArrayDeque<Integer> numbers) {
		ArrayDeque<Integer> curentStack = new ArrayDeque<>();
		int max = Integer.MIN_VALUE;
		while(!numbers.isEmpty()) {
			int curretNumber = numbers.pop();
			if(max < curretNumber) {
				max = curretNumber;
			}
			curentStack.push(curretNumber);
		}
		while(!curentStack.isEmpty()) {
			numbers.push(curentStack.pop());
		}
		return max;
	}

	

}
