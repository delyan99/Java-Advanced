import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Double, Integer> map = new LinkedHashMap<>();
        double[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        for (int i = 0; i < input.length; i++) {
            map.putIfAbsent(input[i], 0);
            map.put(input[i], map.get(input[i]) + 1);
        }
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            System.out.println(String.format("%.1f -> %d", entry.getKey(), entry.getValue()));
        }
    }
}
