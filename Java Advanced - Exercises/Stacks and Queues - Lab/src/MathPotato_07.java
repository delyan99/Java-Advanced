import java.util.ArrayDeque;
import java.util.Scanner;

public class MathPotato_07 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayDeque<String> queue = new ArrayDeque<>();
		String input = scan.nextLine();
		int n = Integer.parseInt(scan.nextLine());
		int primeNubmer = 1;
		String[] childrens = input.split("\\s+");
		for (String child : childrens) {
			queue.offer(child);
		}
		while (queue.size() > 1) {
			for (int i = 1; i < n; i++) {
				queue.offer(queue.poll());
			}
			if(!isPrime(primeNubmer)) {
				System.out.println("Removed " + queue.poll());
			}else {
				System.out.println("Prime " + queue.peek());
			}
			primeNubmer++;
		}
		System.out.println("Last is " + queue.poll());
	}

	private static boolean isPrime(int primeNubmer) {
		if(primeNubmer == 1) {
			return false;
		}
		for (int i = 2; i < primeNubmer; i++) {
			if(primeNubmer % 2 == 0) {
				return false;
			}
		}
		return true;
	}



}
