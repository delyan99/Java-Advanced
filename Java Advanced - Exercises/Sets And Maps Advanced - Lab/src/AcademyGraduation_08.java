import java.util.*;

public class AcademyGraduation_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<Double>> map = new TreeMap<>();
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            map.putIfAbsent(name, new ArrayList<>());
            List<Double> currentList = new ArrayList<>();
            currentList = map.get(name);
            for (int j = 0; j < scores.length; j++) {
                currentList.add(scores[j]);
            }
            map.put(name, currentList);
        }

        map
                .entrySet()
                .stream()
                .forEach(p->{
                    double sum = 0;
                    for (int i = 0; i < p.getValue().size(); i++) {
                        sum += p.getValue().get(i);
                    }
                    sum = sum / p.getValue().size();
                    System.out.println(String.format("%s is graduated with %s", p.getKey(), sum));
                });
    }
}
