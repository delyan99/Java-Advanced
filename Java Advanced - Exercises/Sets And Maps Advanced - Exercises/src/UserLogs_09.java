import java.util.*;

public class UserLogs_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> map = new TreeMap<>();
        String command = scanner.nextLine();
        while(!"end".equals(command)){
            String[] tokens = command.split("\\s+");
            String ip = tokens[0].substring(3);
            //String message = tokens[1].substring(9, tokens[1].length() - 2);
            String user = tokens[2].substring(5);
            map.putIfAbsent(user, new LinkedHashMap<>());
            Map<String, Integer> nestedMap = map.get(user);
            nestedMap.putIfAbsent(ip, 0);
            Integer counter = nestedMap.get(ip) + 1;
            nestedMap.put(ip, counter);
            map.put(user, nestedMap);
            command = scanner.nextLine();
        }
        for (Map.Entry<String, Map<String, Integer>> entry : map.entrySet()) {
            String user = entry.getKey();
            String currentValue = "";
            System.out.println(user + ":");
            List<String> currentElements = new ArrayList<>();
            for (Map.Entry<String, Integer> nestedEntry : entry.getValue().entrySet()) {
                String currentElement = nestedEntry.getKey() + " => " + nestedEntry.getValue();
                currentElements.add(currentElement);
            }
            System.out.print(String.join(", ", currentElements));
            System.out.println(".");


        }
    }
}
