import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private List<Product> products;

    public Instock(){
        this.products = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public boolean contains(Product product) {
        boolean contains = false;
        for (Product p : products) {
            if(p.getLabel().equals(product.getLabel())){
                contains = true;
                break;
            }
        }
        return contains;
    }

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        List<Product> products = this.products.stream().filter(p -> p.getLabel().equals(product)).collect(Collectors.toList());
        if(products.size() == 0){
            throw new IllegalArgumentException("Products do not contain this label: " + product);
        }
        for (Product p : products) {
            p.setQuantity(quantity);
        }
    }

    @Override
    public Product find(int index) {
        return products.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        return products.stream().filter(p -> p.getLabel().equals(label)).findFirst().orElseThrow(() -> new IllegalArgumentException("Products do not contain this label: " + label));
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        if(count >= products.size()){
            return new ArrayList<>();
        }
        return products.stream().sorted(Comparator.comparing(Product::getLabel)).limit(count).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product> products = new ArrayList<>();
        for (Product product : this.products) {
            if(product.getPrice() > lo && product.getPrice() <= hi){
                products.add(product);
            }
        }
        if(products.isEmpty()){
            return products;
        }
        return products.stream().sorted((l, r) -> Double.compare(r.getPrice(), l.getPrice())).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        ArrayList<Product> products = new ArrayList<>();
        for (Product product : this.products) {
            if(product.getPrice() == price){
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        if(count > this.products.size()){
            throw new IllegalArgumentException();
        }
        List<Product> productsResult = new ArrayList<>();
        List<Product> products = new ArrayList<>(this.products);
        products = products.stream().sorted((l, r) -> Double.compare(r.getPrice(), l.getPrice())).collect(Collectors.toList());
        for (int i = 0; i < count; i++) {
            productsResult.add(products.get(i));
        }
        return productsResult;
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        ArrayList<Product> products = new ArrayList<>();
        for (Product product : this.products) {
            if(product.getQuantity() == quantity){
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
