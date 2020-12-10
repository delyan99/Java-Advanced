import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , String> map = new LinkedHashMap<>();
        Map<String , String> mapCopy = new LinkedHashMap<>();
        String name = scanner.nextLine();
        while(!"stop".equals(name)){
            String email = scanner.nextLine();
            map.put(name, email);
            mapCopy.put(name, email);
            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String[] tokens = entry.getValue().split("\\.");
            String endEmail = tokens[1];
            if(endEmail.equals("uk") || endEmail.equals("us") || endEmail.equals("com")){
                mapCopy.remove(entry.getKey());
            }
        }

        mapCopy.entrySet().forEach(p-> System.out.println(String.format("%s -> %s", p.getKey(), p.getValue())));
    }
}
