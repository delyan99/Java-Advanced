import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato_06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> queue = new ArrayDeque<>();
		String input = scan.nextLine();
		int n = Integer.parseInt(scan.nextLine());
		String[] childrens = input.split("\\s+");
		for (String child : childrens) {
			queue.offer(child);
		}
		while (queue.size() > 1) {
			for (int i = 1; i < n; i++) {
				queue.offer(queue.poll());		
			}
			System.out.println("Removed " + queue.poll());
		}
		System.out.println("Last is " + queue.poll());
	}

}
