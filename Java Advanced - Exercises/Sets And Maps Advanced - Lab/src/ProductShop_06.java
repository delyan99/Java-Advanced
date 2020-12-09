import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> map = new TreeMap<>();
        String input = scanner.nextLine();
        while(!"Revision".equals(input)){
            String[] tokens = input.split(", ");
            String shop = tokens[0];
            String product = tokens[1];
            double price = Double.parseDouble(tokens[2]);
            map.putIfAbsent(shop, new LinkedHashMap<>());
            Map<String, Double> currentMap = map.get(shop);
            currentMap.put(product, price);
            map.put(shop, currentMap);
            input = scanner.nextLine();
        }
        map
                .entrySet()
                .stream()
                .forEach(p->{
                    System.out.println(p.getKey() + "->");
                    p.getValue().entrySet().stream().forEach(e->{
                        System.out.println(String.format("Product: %s, Price: %.1f", e.getKey(), e.getValue()));
                    });
                });

    }
}
