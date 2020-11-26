import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> stack = new ArrayDeque<>();
		String input = scan.nextLine();
		while(!"Home".equals(input)) {
			if(input.equals("back")) {
				if(stack.size() == 1) {
					System.out.println("no previous URLs");
				}else {
					stack.pop();
					System.out.println(stack.peek());
				}
			}else {
				stack.push(input);
				System.out.println(stack.peek());
			}
			
			input = scan.nextLine();
		}

	}

}
