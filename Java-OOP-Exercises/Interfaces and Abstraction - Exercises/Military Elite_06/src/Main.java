import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Map<Integer, PrivateImpl> map = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String[] tokens = input.split("\\s+");
            switch (tokens[0]){
                case "Private":
                    PrivateImpl priv = new PrivateImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    map.put(priv.getId(), priv);
                    System.out.println(priv);
                    break;
                case "LeutenantGeneral":
                    List<Integer> privateIds = new ArrayList<>();
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]));
                    for (int i = 5; i < tokens.length; i++) {
                        PrivateImpl p = map.get(Integer.parseInt(tokens[i]));
                        lieutenantGeneral.addPrivate(p);
                    }
                    System.out.println(lieutenantGeneral);
                    break;
                case "Engineer":
                    try {
                        EngineerImpl engineer = new EngineerImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]), tokens[5]);
                        for (int i = 6; i < tokens.length; i+=2) {
                            Repair repair = new Repair(tokens[i], Integer.parseInt(tokens[i + 1]));
                            engineer.addRepair(repair);
                        }
                        System.out.println(engineer);
                    }catch (IllegalArgumentException ex){
                        input = scanner.nextLine();
                        continue;
                    }
                    break;

                case "Commando":
                    try {
                        CommandoImpl commando = new CommandoImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], Double.parseDouble(tokens[4]), tokens[5]);
                        for (int i = 6; i < tokens.length; i += 2) {
                            try {
                                Mission mission = new Mission(tokens[i], tokens[i + 1]);
                                commando.addMission(mission);

                            }catch (IllegalArgumentException ignored){
                            }
                        }
                        System.out.println(commando);
                    }catch (IllegalArgumentException ex){
                        input = scanner.nextLine();
                        continue;
                    }
                    break;
                case "Spy":
                    SpyImpl spy = new SpyImpl(Integer.parseInt(tokens[1]), tokens[2], tokens[3], tokens[4]);
                    System.out.println(spy);
                    break;
            }

            input = scanner.nextLine();
        }
    }
}
