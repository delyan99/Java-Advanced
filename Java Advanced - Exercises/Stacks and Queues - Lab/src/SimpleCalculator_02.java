import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleCalculator_02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		ArrayDeque<String> stack = new ArrayDeque<>();
		String[] array = input.split(" ");
		for (String element : array) {
			stack.push(element);
		}

		while (stack.size() != 1) {
			int lastNumber = Integer.parseInt(stack.pop());
			String operator = stack.pop();
			int firstNumber = Integer.parseInt(stack.pop());

			if (stack.size() > 0) {
				String secondOpetator = stack.pop();
				if (secondOpetator.equals("+")) {
					switch (operator) {
					case "+":
						int numberAddition = lastNumber + firstNumber;
						if (numberAddition >= 0) {
							stack.push("+");
						} else {
							stack.push("-");
						}
						stack.push(String.valueOf(lastNumber + firstNumber));
						break;
					case "-":
						int numberSubstraction = firstNumber - lastNumber;
						if (numberSubstraction >= 0) {
							stack.push("+");
						} else {
							stack.push("-");
						}
						stack.push(String.valueOf(firstNumber - lastNumber));
						break;
					}
				} else {
					switch (operator) {
					case "+":
						stack.push("+");
						stack.push(String.valueOf(lastNumber - firstNumber));
						break;
					case "-":
						stack.push("-");
						stack.push(String.valueOf(lastNumber + firstNumber));
						break;
					}
				}
			} else {
				switch (operator) {
				case "+":
					stack.push(String.valueOf(lastNumber + firstNumber));
					break;
				case "-":
					stack.push(String.valueOf(firstNumber - lastNumber));
					break;
				}
			}
		}
		System.out.println(stack.pop());

	}

}
