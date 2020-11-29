import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci_07 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		//System.out.println(getFibonacci(n));
		int firstNumber = 1;
		int secondNumber = 1;
		if(n == 0) {
			System.out.println("1");
		}
		ArrayDeque<Integer> stack = new ArrayDeque<>();	
		stack.push(firstNumber);
		stack.push(secondNumber);
		while(stack.size() != n + 1) {
			int first = stack.pop();
			int second = stack.peek();
			stack.push(first);
			stack.push(first+second);
		}
		System.out.println(stack.peek());
		
	}

	private static int getFibonacci(int n) {
			if(n <= 1) {
				return 1;
			} else {
			return getFibonacci(n-1) + getFibonacci(n-2);
			}
	}

}
