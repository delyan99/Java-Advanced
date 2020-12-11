import java.util.*;

public class LegendaryFarming_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> legendaryMaterials = new LinkedHashMap<>();
        Map<String, Integer> junkMaterials = new TreeMap<>();
        legendaryMaterials.put("shards", 0);
        legendaryMaterials.put("motes", 0);
        legendaryMaterials.put("fragments", 0);
        String materialReached = "";
        while (true){
            String[] input = scanner.nextLine().split("\\s+");
            boolean isReached = false;
            String material = "";
            int materialSize = 0;
            for (int i = 0; i < input.length; i++) {
                if(i % 2 == 0){
                    materialSize = Integer.parseInt(input[i]);
                }else{
                    material = input[i].toLowerCase();
                    if(material.equals("shards") || material.equals("fragments") || material.equals("motes")) {
                        legendaryMaterials.putIfAbsent(material, 0);
                        int currentSize = legendaryMaterials.get(material) + materialSize;
                        legendaryMaterials.put(material, currentSize);
                        if(legendaryMaterials.get(material) >= 250){
                            legendaryMaterials.put(material, currentSize - 250);
                            materialReached = material;
                            isReached = true;
                            break;
                        }
                    }else{
                        junkMaterials.putIfAbsent(material, 0);
                        int currentSize = junkMaterials.get(material) + materialSize;
                        junkMaterials.put(material, currentSize);
                    }
                }
            }
            if(isReached){
                break;
            }
        }
        if(materialReached.equals("shards")){
            System.out.println("Shadowmourne obtained!");
        }else if(materialReached.equals("fragments")){
            System.out.println("Valanyr obtained!");
        }else if(materialReached.equals("motes")){
            System.out.println("Dragonwrath obtained!");
        }

        legendaryMaterials
                .entrySet()
                .stream()
                .sorted((l, r)->{
                    int result  = r.getValue().compareTo(l.getValue());
                    if(result == 0){
                        result = l.getKey().compareTo(r.getKey());
                    }
                    return result;
                })
                .forEach(p-> System.out.println(p.getKey() + ": " + p.getValue()));

        junkMaterials
                .entrySet()
                .forEach(p-> System.out.println(p.getKey() + ": " + p.getValue()));

    }
}
