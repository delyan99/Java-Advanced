import java.util.*;

public class LogsAggregator_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> usernameAndIp = new TreeMap<>();
        Map<String, Integer> usernameAndTime = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String ip = input[0];
            String username = input[1];
            int duration = Integer.parseInt(input[2]);
            usernameAndTime.putIfAbsent(username, 0);
            Integer currentTime = usernameAndTime.get(username) + duration;
            usernameAndTime.put(username, currentTime);

            usernameAndIp.putIfAbsent(username, new TreeSet<>());
            Set<String> currentIp = usernameAndIp.get(username);
            currentIp.add(ip);
            usernameAndIp.put(username, currentIp);

        }
        usernameAndTime
                .entrySet()
                .forEach(p->{
                    System.out.println(p.getKey() + ": " + p.getValue() + " "
                                    + usernameAndIp.get(p.getKey()));
                });
    }
}
