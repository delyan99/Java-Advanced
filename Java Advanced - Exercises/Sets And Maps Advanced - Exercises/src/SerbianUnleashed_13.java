import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SerbianUnleashed_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> database = new LinkedHashMap<>();
        //String regex = "@(?<venue>[A-Za-z]+\\s[[A-Za-z]+\\s]*[[A-Za-z]+\\s]*)(?<ticketsPrice>[\\d]+)\\s(?<ticketsCount>[\\d]+)";
        //Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        while (!"End".equals(input)){
            //Matcher matcher = pattern.matcher(input);
            //if(matcher.find()) {
                String[] tokens = input.split("@");
                String singerName = tokens[0];
                if(singerName.charAt(singerName.length() - 1) == ' ') {
                    int endIndex = -1;
                    for (int i = 0; i < tokens[1].length(); i++) {
                        if(Character.isDigit(tokens[1].charAt(i))){
                            endIndex = i;
                            break;
                        }
                    }
                    if(endIndex == -1){
                        input = scanner.nextLine();
                        continue;
                    }
                    String venue = tokens[1].substring(0, endIndex);
                    if(venue.charAt(venue.length() - 1) == ' ') {
                        String[] ticketPriceAndCount = tokens[1].substring(endIndex).split("\\s+");
                        if(ticketPriceAndCount.length == 2) {
                            int ticketsPrice = Integer.parseInt(ticketPriceAndCount[0]);
                            int ticketsCount = Integer.parseInt(ticketPriceAndCount[1]);
                            int money = ticketsPrice * ticketsCount;
                            database.putIfAbsent(venue, new LinkedHashMap<>());
                            Map<String, Integer> currentSingerAndMoney = database.get(venue);
                            currentSingerAndMoney.putIfAbsent(singerName, 0);
                            Integer currentMoney = currentSingerAndMoney.get(singerName) + money;
                            currentSingerAndMoney.put(singerName, currentMoney);
                            database.put(venue, currentSingerAndMoney);
                        }
                    }
                }
            //}
            input = scanner.nextLine();
        }
        database
                .entrySet()
                .forEach(p->{
                    System.out.println(p.getKey());
                    p.getValue()
                            .entrySet()
                            .stream()
                            .sorted((l, r)->r.getValue().compareTo(l.getValue()))
                            .forEach(e-> System.out.println(String.format("#  %s-> %d", e.getKey(), e.getValue())));
                });
    }
}
