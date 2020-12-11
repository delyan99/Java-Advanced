import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Long>> cityCountryAndPopulation = new LinkedHashMap<>();
        Map<String, Long> countyAndTotalPopulation = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while(!"report".equals(input )){
            String[] tokens = input.split("\\|");
            String city = tokens[0];
            String country = tokens[1];
            long population = Integer.parseInt(tokens[2]);
            //Map<String, Integer> countriesAndTotalPopulation =  new HashMap<>();
            //countriesAndTotalPopulation.putIfAbsent(country, 0);
            //int currentPopulation = countriesAndTotalPopulation.get(country) + population;
            //countriesAndTotalPopulation.put(country, currentPopulation);
            cityCountryAndPopulation.putIfAbsent(country, new LinkedHashMap<>());
            Map<String, Long> citiesAndPopulation = cityCountryAndPopulation.get(country);
            citiesAndPopulation.putIfAbsent(city, 0L);
            long currentCityPopulation = population + citiesAndPopulation.get(city);
            citiesAndPopulation.put(city, currentCityPopulation);
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Long>> entry : cityCountryAndPopulation.entrySet()) {
            Map<String, Long> nestedEntries = entry.getValue();
            long sum = 0;
            for (Map.Entry<String, Long> nestedEntry : nestedEntries.entrySet()) {
                sum += nestedEntry.getValue();
            }

            countyAndTotalPopulation.put(entry.getKey(), sum);
        }
        countyAndTotalPopulation
                .entrySet()
                .stream()
                .sorted((l, r)->{
                    int currentResult = r.getValue().compareTo(l.getValue());
                    return  currentResult;
                }).forEach(p->{
                    String city = p.getKey();
            System.out.println(String.format("%s (total population: %d)", p.getKey(), p.getValue()));
            Map<String, Long> stringIntegerMap = cityCountryAndPopulation.get(city);
            stringIntegerMap.entrySet()
                    .stream().sorted((l1, r1)->{
                        return r1.getValue().compareTo(l1.getValue());
            })
                    .forEach(e->{
                System.out.println(String.format("=>%s: %d", e.getKey(), e.getValue()));
            });
        });
    }
}
