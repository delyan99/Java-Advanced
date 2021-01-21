import java.util.Scanner;

public class Main {
    private static Pizza pizza;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pizzaData = scanner.nextLine().split("\\s+");
        String pizzaName = pizzaData[1];
        int numberOfToppings = Integer.parseInt(pizzaData[2]);
        try {
            pizza = new Pizza(pizzaName, numberOfToppings);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        String[] doughData = scanner.nextLine().split("\\s+");
        String flourType = doughData[1];
        String bakingTechnique = doughData[2];
        double weightInGrams = Double.parseDouble(doughData[3]);
        try {
            Dough dough = new Dough(flourType, bakingTechnique, weightInGrams);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] toppingData = input.split("\\s+");
            String toppingType = toppingData[1];
            double weight = Double.parseDouble(toppingData[2]);
            try {
                Topping topping = new Topping(toppingType, weight);
                pizza.addTopping(topping);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }

            input = scanner.nextLine();
        }
        System.out.println(pizza);
    }
}
