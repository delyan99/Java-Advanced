import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class DragonArmy_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Map<String, int[]>> database = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String type = tokens[0];
            String name = tokens[1];
            int damage = 0;
            int health = 0;
            int armor = 0;
            if(tokens[2].equals("null")){
                damage = 45;
            }else{
                damage = Integer.parseInt(tokens[2]);
            }
            if(tokens[3].equals("null")){
                health = 250;
            }else{
                health = Integer.parseInt(tokens[3]);
            }
            if(tokens[4].equals("null")){
                armor = 10;
            }else{
                armor = Integer.parseInt(tokens[4]);
            }

            int[] dmdHltArm = new int[3];
            dmdHltArm[0] = damage;
            dmdHltArm[1] = health;
            dmdHltArm[2] = armor;
            database.putIfAbsent(type, new TreeMap<>());
            Map<String, int[]> currentDragons = database.get(type);
            currentDragons.put(name, dmdHltArm);
            database.put(type, currentDragons);

        }
        for (Map.Entry<String, Map<String, int[]>> entry : database.entrySet()) {
            Map<String, int[]> nestedMap = entry.getValue();
            double averageDamage = 0;
            double averageHealth = 0;
            double averageArmor = 0;
            for (Map.Entry<String, int[]> nestedEntry : nestedMap.entrySet()) {
                averageDamage += nestedEntry.getValue()[0];
                averageHealth += nestedEntry.getValue()[1];
                averageArmor += nestedEntry.getValue()[2];
            }
            averageDamage /=  nestedMap.size();
            averageHealth /=  nestedMap.size();
            averageArmor /=  nestedMap.size();
            System.out.println(String.format("%s::(%.2f/%.2f/%.2f)", entry.getKey(), averageDamage, averageHealth, averageArmor));
            entry.getValue()
                            .entrySet()
                            .forEach(e->{
                                System.out.println("-" + e.getKey() + " -> " + "damage: " + e.getValue()[0] + ", health: " + e.getValue()[1] + ", armor: " + e.getValue()[2]);
                            });
        }
    }
}
