public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight){
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        if(!toppingType.equals("Meat") && !toppingType.equals("Veggies") && !toppingType.equals("Cheese") && !toppingType.equals("Sauce")){
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 50){
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double toppingTypeCalories = 0;
        if(this.toppingType.equals("Meat")){
            toppingTypeCalories = 1.2;
        }else if(this.toppingType.equals("Veggies")){
            toppingTypeCalories = 0.8;
        }else if(this.toppingType.equals("Cheese")){
            toppingTypeCalories = 1.1;
        }else if(this.toppingType.equals("Sauce")){
            toppingTypeCalories = 0.9;
        }
        return 2 * this.weight * toppingTypeCalories;
    }
}
