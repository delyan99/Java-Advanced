import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinary_03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int input = Integer.parseInt(scan.nextLine());
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		if(input == 0) {
			System.out.println("0");
			return;
		}
		while(input != 0) {
			stack.push(input % 2);
			input /= 2;
		}
		while(!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
		

	}

}
