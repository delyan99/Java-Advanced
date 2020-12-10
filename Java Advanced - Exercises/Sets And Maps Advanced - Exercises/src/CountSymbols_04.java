import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            map.putIfAbsent(symbol, 0);
            int currentMatches = map.get(symbol) + 1;
            map.put(symbol, currentMatches);
        }
        map.entrySet().forEach(p-> System.out.println(String.format("%c: %d time/s", p.getKey(), p.getValue())));
    }
}
