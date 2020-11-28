import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Robotics_05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] robots = scan.nextLine().split(";");
		Map<String, Integer> map = new LinkedHashMap<>();
		ArrayDeque<String> queue = new ArrayDeque<>();
	
		for (int i = 0; i < robots.length; i++) {
			String[] array = robots[i].split("-");
			String name = array[0];
			int time = Integer.parseInt(array[1]);
			map.put(name, time);
		}
		int[] workingTime = new int[map.size()];
		String currentTime = scan.nextLine();
		
		int hours = Integer.parseInt(currentTime.split(":")[0]);
		int minutes = Integer.parseInt(currentTime.split(":")[1]);
		int seconds = Integer.parseInt(currentTime.split(":")[2]);
		
		long timeInSecounds = 3600 * hours + 60 * minutes + seconds;
		
		String command = scan.nextLine();
		while(!command.equals("End")) {
			queue.offer(command);
			command = scan.nextLine();
		}
		
		while(!queue.isEmpty()) {
			boolean flag = false;
			for (int j = 0; j < workingTime.length; j++) {
				if(workingTime[j] > 0) {
					workingTime[j]--;
				}
			}
			timeInSecounds++;
			String currentProduct = queue.poll();
			for (int i = 0; i < map.size(); i++) {
				if(workingTime[i] == 0) {
					int counter = 0 ;
					for (Map.Entry<String, Integer> element: map.entrySet()) {
						if(i == counter) {
							
							long currentHours = timeInSecounds / 3600 % 24;
							long currentMinutes = timeInSecounds / 60 % 60;
							long currentSeconds = timeInSecounds % 60;
							flag = true;
							workingTime[i] = element.getValue();
							System.out.println(String.format("%s - %s [%02d:%02d:%02d]", element.getKey(), currentProduct, currentHours, currentMinutes, currentSeconds));
							break;
						}
						counter++;
					}
					break;
				}
				
			}
			if(!flag) {
				queue.offer(currentProduct);
				
			}
			
		}
		

	}

}
