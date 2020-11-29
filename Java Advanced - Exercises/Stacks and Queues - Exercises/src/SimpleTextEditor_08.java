import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_08 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String text = "";
		ArrayDeque<String> stack = new ArrayDeque<>();
		for (int i = 0; i < n; i++) {
			String[] array = scan.nextLine().split("\\s+");
			int command = Integer.parseInt(array[0]);
			switch(command) {
			case 1:
				String string = array[1];
				text = text + string;
				stack.push(text);
				break;
			case 2:
				int count = Integer.parseInt(array[1]);
				text = text.substring(0, text.length() - count);
				stack.push(text);
				break;
			case 3:
				int index = Integer.parseInt(array[1]) - 1;
				System.out.println(text.charAt(index));
				break;
			case 4:
				stack.pop();
				text = stack.peek();
				
				break;
			}
		}
	}

}
