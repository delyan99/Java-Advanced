import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().length() == 0) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public void buyProduct(Product product) {
        if (product.getCost() > this.money) {
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        } else {
            this.setMoney(this.money -= product.getCost());
            products.add(product);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(this.getName());
        sb.append(" - ");
        if(products.size() == 0){
            sb.append("Nothing bought");
        }else {
            for (int i = 0; i < products.size(); i++) {
                if (i == products.size() - 1) {
                    sb.append(products.get(i).getName());
                } else {
                    sb.append(products.get(i).getName()).append(", ");
                }
            }
        }

        return sb.toString();
    }
}
