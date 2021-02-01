package animanls;

import foods.Food;

public class Mouse extends Mammal{
    public Mouse(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        String name = food.getClass().getName();
        if(food.getClass().getName().equals("foods.Meat")){
            System.out.println("Mice are not eating that type of food!");
            super.setFoodEaten(0);
            return;
        }

        super.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
