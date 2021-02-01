import animanls.*;
import foods.Food;
import foods.Meat;
import foods.Vegetable;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();
        while (!input.equals("End")){
            String[] animalInfo = input.split("\\s+");
            String[] foodInfo = scanner.nextLine().split("\\s+");
            Food food;

            if(foodInfo[0].equals("Vegetable")){
                food = new Vegetable(Integer.parseInt(foodInfo[1]));
            }else{
                food = new Meat(Integer.parseInt(foodInfo[1]));
            }
            switch (animalInfo[0]){
                case "Cat":
                    Cat cat = new Cat(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]), animalInfo[3], animalInfo[4]);
                    cat.makeSound();
                    cat.eat(food);
                    animals.add(cat);
                    break;
                case "Tiger":
                    Tiger tiger = new Tiger(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]), animalInfo[3]);
                    tiger.makeSound();
                    tiger.eat(food);
                    animals.add(tiger);
                    break;
                case "Zebra":
                    Zebra zebra = new Zebra(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]), animalInfo[3]);
                    zebra.makeSound();
                    zebra.eat(food);
                    animals.add(zebra);
                    break;
                case "Mouse":
                    Mouse mouse = new Mouse(animalInfo[1], animalInfo[0], Double.parseDouble(animalInfo[2]), animalInfo[3]);
                    mouse.makeSound();
                    mouse.eat(food);
                    animals.add(mouse);
                    break;
            }
            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal.toString());
        }
    }
}
