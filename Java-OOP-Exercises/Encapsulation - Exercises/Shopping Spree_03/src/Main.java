import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        String[] inputPeopleData = scanner.nextLine().split(";");
        for (String p : inputPeopleData) {
            String[] tokens = p.split("=");
            String personName = tokens[0];
            double personMoney = Double.parseDouble(tokens[1]);
            try{
                Person person = new Person(personName, personMoney);
                people.add(person);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                return;
            }
        }
        String[] inputProductsData = scanner.nextLine().split(";");
        for (String p : inputProductsData) {
            String[] tokens = p.split("=");
            String productName = tokens[0];
            double productMoney = Double.parseDouble(tokens[1]);
            try{
                Product product = new Product(productName, productMoney);
                products.add(product);
            } catch (IllegalArgumentException exception) {
                System.out.println(exception.getMessage());
                return;
            }
        }
        String input = scanner.nextLine();
        while (!"END".equals(input)){
            String[] tokens = input.split("\\s+");
            String personName = tokens[0];
            String productName = tokens[1];
            Person currentPerson = people.get(0);
            for (Person person : people) {
                if(person.getName().equals(personName)){
                    currentPerson = person;
                    break;
                }
            }
            Product currentProduct = products.get(0);
            for (Product product : products) {
                if(product.getName().equals(productName)){
                    currentProduct = product;
                    break;
                }
            }
            try {
            currentPerson.buyProduct(currentProduct);
            System.out.println(currentPerson.getName() + " bought " + currentProduct.getName());
            } catch (IllegalArgumentException exception){
                System.out.println(exception.toString());
            }

            input = scanner.nextLine();
        }
        for (Person person : people) {
            System.out.println(person);
        }
    }
}
