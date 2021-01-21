import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings){
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if(name.trim().isEmpty() || name.length() > 15){
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        if(numberOfToppings < 0 || numberOfToppings > 10){
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    public void addTopping (Topping topping){
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        List<Double> toppingsList = this.toppings.stream().map(Topping::calculateCalories).collect(Collectors.toList());
        double allToppingsCalories = 0;
        for (Double t : toppingsList) {
            allToppingsCalories += t;
        }
        return this.dough.calculateCalories() + allToppingsCalories;
    }
    @Override
    public String toString(){
        return String.format("%s - %.2f", this.name, this.getOverallCalories());
    }
}
