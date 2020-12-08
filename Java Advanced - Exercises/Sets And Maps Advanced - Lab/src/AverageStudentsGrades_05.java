import java.util.*;

public class AverageStudentsGrades_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String , ArrayList<Double>> map = new TreeMap<>();
        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double grade = Double.parseDouble(tokens[1]);
            map.putIfAbsent(name, new ArrayList<>());
            ArrayList<Double> list = map.get(name);
            list.add(grade);
            map.put(name, list);
        }
        map
                .entrySet()
                .stream()
                .forEach(p->{
                    double averageSum = 0;
                    for (int i = 0; i < p.getValue().size(); i++) {
                        averageSum += p.getValue().get(i);
                    }
                    averageSum = averageSum / p.getValue().size();
                    System.out.print(p.getKey() + " -> " );
                    p.getValue().forEach(k-> System.out.print(String.format("%.2f ", k)));

                    System.out.println(String.format("(avg: %.2f)", averageSum));
                });

    }
}
