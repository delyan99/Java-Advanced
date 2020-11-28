import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		ArrayDeque<Character> stack = new ArrayDeque<>();
		for (int i = 0; i < input.length(); i++) {
			char character = input.charAt(i);
			if(character == '(') {
				stack.push('(');
			}else if(character == '{') {
				stack.push('{');
			}else if(character == '[') {
				stack.push('[');
			}else if(character == ')') {
				if(stack.peek() == '(') {
					stack.pop();
				}
			}else if(character == '}') {
				if(stack.peek() == '{') {
					stack.pop();
				}
			}else if(character == ']') {
				if(stack.peek() == '[') {
					stack.pop();
				}
			}
		}
		if(stack.isEmpty()) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}

	}

}
