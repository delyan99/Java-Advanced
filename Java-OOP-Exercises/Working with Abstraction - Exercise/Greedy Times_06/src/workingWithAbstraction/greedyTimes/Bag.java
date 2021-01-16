package workingWithAbstraction.greedyTimes;

import java.util.*;

public class Bag{
    private long capacity;
    private CashContainer cashContainer;
    private long totalCash;
    private GemContainer gemContainer;
    private long totalGem;
    private Gold gold;
    private long totalGold;
    private Map<String, Long> items;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.cashContainer = new CashContainer();
        this.totalCash = 0;
        this.gemContainer = new GemContainer();
        this.totalGem = 0;
        this.gold = new Gold();
        this.totalGold = 0;
        this.items = new LinkedHashMap<>();
    }

    public long getTotalGold() {
        return totalGold;
    }

    public long getTotalGem() {
        return totalGem;
    }

    public long getTotalCash() {
        return totalCash;
    }

    public void addCash(String name, Long quantity) {
        if(isCapacityNotFull(quantity) && this.getTotalGem() >= this.getTotalCash() + quantity) {
            this.totalCash += quantity;
            this.cashContainer.addToCashContainer(name, quantity);
            this.items.put("Cash", this.totalCash);
        }
    }

    public void addGem(String name, long quantity) {
        if(isCapacityNotFull(quantity) && this.getTotalGold() >= this.getTotalGem() + quantity) {
            this.totalGem += quantity;
            this.gemContainer.addToGemContainer(name, quantity);
            this.items.put("Gem", this.totalGem);
        }
    }

    public void addGold(String name, long quantity) {
        if(isCapacityNotFull(quantity)) {
            this.totalGold += quantity;
            this.gold.setNewValue(quantity);
            this.items.put("Gold", this.totalGold);
        }
    }

    private boolean isCapacityNotFull(long quantity) {
        return this.capacity >= this.gold.getValue() + this.gemContainer.getGemsSum() + this.cashContainer.getCashSum() + quantity;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        this.items.entrySet().stream().sorted((l, r) ->{
            int rez = r.getValue().compareTo(l.getValue());
            if(rez == 0){
                rez = l.getValue().compareTo(r.getValue());
            }
            return rez;
        }).forEach(entry -> {
            if(entry.getKey().equals("Gold")) {
                if(this.gold.getValue() != -1) {
                    result.append(String.format("<%s> $%d", entry.getKey(), entry.getValue())).append(System.lineSeparator());
                    result.append(String.format("##%s - %d", entry.getKey(), entry.getValue())).append(System.lineSeparator());
                }
            }else if(entry.getKey().equals("Gem")){
                if(this.gemContainer.getGems() != null) {
                    result.append(String.format("<%s> $%d", entry.getKey(), entry.getValue())).append(System.lineSeparator());
                    result.append(this.gemContainer.toString());
                }
            }else if(entry.getKey().equals("Cash")){
                if(this.cashContainer.getCash() != null) {
                    result.append(String.format("<%s> $%d", entry.getKey(), entry.getValue())).append(System.lineSeparator());
                    result.append(this.cashContainer.toString());
                }
            }
        });

        return result.toString();
    }

}
