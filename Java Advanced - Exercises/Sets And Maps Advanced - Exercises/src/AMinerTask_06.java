import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        String resource = scanner.nextLine();
        while(!resource.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());
            map.putIfAbsent(resource, 0);
            Integer currentQuantity = map.get(resource) + quantity;
            map.put(resource, currentQuantity);
            resource = scanner.nextLine();

        }

        map.entrySet().forEach(p-> System.out.println(String.format("%s -> %d", p.getKey(), p.getValue())));
    }
}
