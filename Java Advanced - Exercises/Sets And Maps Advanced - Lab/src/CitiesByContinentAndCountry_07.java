import java.util.*;

public class CitiesByContinentAndCountry_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continents = input[0];
            String countries = input[1];
            String cities = input[2];
            map.putIfAbsent(continents, new LinkedHashMap<>());
            Map<String, List<String>> currentMap = map.get(continents);
            currentMap.putIfAbsent(countries, new ArrayList<>());
            List<String> list = new ArrayList<>();
            if(map.get(continents).get(countries) != null){
                list = map.get(continents).get(countries);
            }
            list.add(cities);
            currentMap.put(countries, list);
            map.put(continents, currentMap);
        }

        map
                .entrySet()
                .stream()
                .forEach(p->{
                    System.out.println(p.getKey() + ":");
                    p.getValue().entrySet().stream().forEach(e->{
                        System.out.print(String.format("  %s -> ", e.getKey()));
                        System.out.print(e.getValue().toString().replaceAll("[\\[\\]]", ""));
                        System.out.println();
                    });
                });
    }
}
