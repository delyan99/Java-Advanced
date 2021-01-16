package workingWithAbstraction.greedyTimes;

import java.util.HashMap;
import java.util.Map;

public class CashContainer {
    private Map<String, Long> cash;

    public CashContainer() {
        this.cash = new HashMap<>();
    }

    public Long getCashSum() {
        return cash.values().stream().mapToLong(e -> e).sum();
    }

    public void addToCashContainer(String name,Long quantity) {
        this.cash.putIfAbsent(name, 0L);
        Long newValue = this.cash.get(name) + quantity;
        this.cash.put(name, newValue);
    }

    public Map<String, Long> getCash() {
        return cash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.cash.entrySet().stream().sorted((l, r) -> {
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

}
