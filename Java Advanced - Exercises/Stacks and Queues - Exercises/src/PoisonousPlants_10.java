import java.util.ArrayDeque;
import java.util.Scanner;

public class PoisonousPlants_10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*int n = Integer.parseInt(scan.nextLine());
		String[] input = scan.nextLine().split("\\s+");
		ArrayDeque<Integer> plants = new ArrayDeque<>();
		for (int i = 0; i < input.length; i++) {
			plants.push(Integer.parseInt(input[i]));
		}
		int counter = 0, previousQueueSize = n, currentPlantize = 0;
		while (currentPlantize != previousQueueSize) {
			previousQueueSize = plants.size();
			for (int i = 0; i < previousQueueSize; i++) {
				if (previousQueueSize == 1) {
					break;
				}
				int previousPlant = plants.poll();
				int curret = plants.peek();
				if (curret > previousPlant) {
					plants.pop();

				}
				if (i == previousQueueSize - 1) {
					plants.poll();
				}

			}
			currentPlantize = plants.size();
			if (currentPlantize != previousQueueSize) {
				counter++;
			}
		}
		System.out.println(counter);*/
		
		int n = Integer.parseInt(scan.nextLine());
		String[] input = scan.nextLine().split("\\s+");
		int[] array = new int[input.length];
		int[] days = new int[input.length];
		for (int i = 0; i < array.length; i++) {
			array[i] = Integer.parseInt(input[i]);
		}
		ArrayDeque<Integer> indexes = new ArrayDeque<>();
		indexes.push(0);
		for (int i = 1; i < array.length; i++) {
			int maxDays = 0;
			while(indexes.size() > 0  && array[indexes.peek()] >= array[i]) {
				maxDays = Math.max(maxDays, days[indexes.pop()]);
			}
			if(indexes.size() > 0) {
				days[i] = maxDays + 1;
			}
			indexes.push(i);	
		}
		int maxDaysOutput = 0;
		for (Integer day : days) {
			if(day > maxDaysOutput) {
				maxDaysOutput = day;
			}
		}
		System.out.println(maxDaysOutput);
	}

}
