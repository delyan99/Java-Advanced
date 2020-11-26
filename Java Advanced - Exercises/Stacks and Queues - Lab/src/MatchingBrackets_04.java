import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		for (int i = 0; i < input.length(); i++) {
			char symbol = input.charAt(i);
			if(symbol == '(') {
				stack.push(i);
			}else if(symbol == ')'){
				int startIndex = stack.pop();
				int endindex = i;
				System.out.println(input.substring(startIndex, endindex + 1));
			}
		}

	}

}
