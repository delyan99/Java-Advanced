import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> stack = new ArrayDeque<>();
		ArrayDeque<String> queue = new ArrayDeque<>();
		String input = scan.nextLine();
		while (!"Home".equals(input)) {
			if (input.equals("back")) {
				if (stack.size() < 2) {
					System.out.println("no previous URLs");
				} else {
					queue.push(stack.pop());
					System.out.println(stack.peek());
				}

			} else if (input.equals("forward")) {
				if (queue.size() < 1) {
					System.out.println("no next URLs");
				} else {
					String poll = queue.poll();
					stack.push(poll);
					System.out.println(poll);
				}
			} else {
				stack.push(input);
				System.out.println(stack.peek());
				queue.clear();
			}

			input = scan.nextLine();
		}

	}

}
