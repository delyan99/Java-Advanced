package animanls;

import foods.Food;

import java.text.DecimalFormat;

public abstract class Felime extends Mammal{

    public Felime(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        String name = food.getClass().getName();
        if(food.getClass().getName().equals("foods.Vegetable")){
            System.out.println(super.getAnimalType() + "s are not eating that type of food!");
            super.setFoodEaten(0);
            return;
        }

        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]",
                super.getAnimalType(), super.getAnimalName(), format.format(super.getAnimalWeight()), super.getLivingRegion(), super.getFoodEaten());
    }
}
