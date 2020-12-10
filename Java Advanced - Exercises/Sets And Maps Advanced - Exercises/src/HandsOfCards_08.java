import java.util.*;

public class HandsOfCards_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> map = new LinkedHashMap<>();
        Map<String, Integer> outputMap = new LinkedHashMap<>();
        while(!"JOKER".equals(input)) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cards = tokens[1].split(", ");
            int sum = 0;
            for (int i = 0; i < cards.length; i++) {

                map.putIfAbsent(name, new HashSet<>());
                Set<String> set = map.get(name);
                set.add(cards[i]);
            }
            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : map.entrySet()) {
            String name = entry.getKey();
            Set<String> values = entry.getValue();
            int sum = 0;
            for (String set : values) {
                String powerOfString = set.substring(0, set.length() - 1);
                String typeOfString = set.substring(set.length()- 1);

                if (powerOfString.equals("J")) {
                    powerOfString = "11";
                } else if (powerOfString.equals("Q")) {
                    powerOfString = "12";
                } else if (powerOfString.equals("K")) {
                    powerOfString = "13";
                } else if (powerOfString.equals("A")) {
                    powerOfString = "14";
                }
                int power = Integer.parseInt(powerOfString);

                if (typeOfString.equals("S")) {
                    typeOfString = "4";
                } else if (typeOfString.equals("H")) {
                    typeOfString = "3";
                } else if (typeOfString.equals("D")) {
                    typeOfString = "2";
                } else if (typeOfString.equals("C")) {
                    typeOfString = "1";
                }
                int type = Integer.parseInt(typeOfString);
                sum += power * type;
            }
            outputMap.put(name, sum);
        }
        outputMap.entrySet().forEach(p-> System.out.println(String.format("%s: %d", p.getKey(), p.getValue())));
    }
}
