package workingWithAbstraction.greedyTimes;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class GemContainer {
    private Map<String, Long> gems;

    public GemContainer() {
        this.gems = new HashMap<>();
    }

    public Long getGemsSum() {
        return this.gems.values().stream().mapToLong(e -> e).sum();
    }

    public void addToGemContainer(String name,Long quantity) {
        this.gems.putIfAbsent(name, 0L);
        Long newValue = this.gems.get(name) + quantity;
        this.gems.put(name, newValue);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.gems.entrySet().stream().sorted((l, r) -> {
            int result = r.getKey().compareTo(l.getKey());
            if(result == 0){
                result = l.getValue().compareTo(r.getValue());
            }
            return result;
        }).forEach(entry -> {
            sb.append(String.format("##%s - %d", entry.getKey(), entry.getValue())).append(System.lineSeparator());
        });
        return sb.toString();
    }

    public Map<String, Long> getGems() {
        return gems;
    }
}
