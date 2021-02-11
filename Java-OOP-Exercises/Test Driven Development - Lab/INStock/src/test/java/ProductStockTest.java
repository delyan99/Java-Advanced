import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class ProductStockTest {
    private ProductStock products;
    private Product product;

    @Before
    public void setUp() {
        products = new Instock();
        product = new Product("Label", 0.2, 2);
    }

    @Test
    public void testGetCountWithCorrectNumbersOfProducts() {
        Assert.assertEquals(0, products.getCount());
        products.add(product);
        Assert.assertEquals(1, products.getCount());
    }

    @Test
    public void testContainsCorrectProducts() {
        Assert.assertFalse(products.contains(product));

        products.add(product);
        Assert.assertTrue(products.contains(product));

        Product p = new Product("Invalid_Label", 0.2, 2);
        Assert.assertFalse(products.contains(p));
    }

    @Test
    public void testAddWithValidProduct() {
        products.add(product);
        Assert.assertTrue(products.contains(product));
    }

    @Test
    public void testFindWithValidFirstIndex() {
        products.add(product);
        Product expected = products.find(0);
        Assert.assertNotNull(expected);
        Assert.assertEquals(this.product.getLabel(), expected.getLabel());
    }

    @Test
    public void testFindWithValidMiddleIndex() {
        products.add(product);
        Product p = new Product("Label_Find", 1.2, 1);
        products.add(p);
        products.add(product);
        Product expected = products.find(1);
        Assert.assertNotNull(expected);
        Assert.assertEquals(p.getLabel(), expected.getLabel());
    }

    @Test
    public void testFindWithValidLastIndex() {
        products.add(product);
        products.add(product);
        Product p = new Product("Label_Find", 1.2, 1);
        products.add(p);
        Product expected = products.find(products.getCount() - 1);
        Assert.assertNotNull(expected);
        Assert.assertEquals(p.getLabel(), expected.getLabel());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithInvalidIndexBiggerThanProductsCount() {
        products.find(2);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithInvalidIndexEqualsToProductsCount() {
        products.add(product);
        products.add(product);
        products.find(products.getCount());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testFindWithInvalidNegativeIndex() {
        products.find(-2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantityWithNotValidProduct() {
        products.changeQuantity("Product_Name", 1);
    }

    @Test
    public void testChangeQuantityWithCorrectData() {
        products.add(product);
        int newQuantity = product.getQuantity() + 1;
        products.changeQuantity("Label", newQuantity);
        Assert.assertEquals(newQuantity, product.getQuantity());
    }

    @Test
    public void testFindByLabelReturnProductWithValidLabel() {
        String expectedLabel = product.getLabel();
        products.add(product);
        Product p = products.findByLabel(expectedLabel);
        Assert.assertNotNull(p);
        Assert.assertEquals(expectedLabel, product.getLabel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabelReturnProductWithInvalidLabel() {
        String expectedLabel = product.getLabel();
        products.findByLabel(expectedLabel);
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnCorrectOrderedCollection() {
        createAndAddProducts(8);
        Iterable<Product> firstByAlphabeticalOrder = products.findFirstByAlphabeticalOrder(3);
        Assert.assertNotNull(firstByAlphabeticalOrder);
        List<Product> products = createListFromIterable(firstByAlphabeticalOrder);
        Set<String> labels = new TreeSet<>();
        for (Product product : products) {
            labels.add(product.getLabel());
        }
        Assert.assertNotNull(products);
        Assert.assertEquals(products.size(), labels.size());
    }

    @Test
    public void testFindFirstByAlphabeticalOrderShouldReturnEmptyCollection() {
        createAndAddProducts(8);
        Iterable<Product> firstByAlphabeticalOrder = products.findFirstByAlphabeticalOrder(9);
        Assert.assertNotNull(firstByAlphabeticalOrder);
        List<Product> listFromIterable = createListFromIterable(firstByAlphabeticalOrder);
        Assert.assertTrue(listFromIterable.isEmpty());
    }

    @Test
    public void testFindAllInPriceRangeWithNoSuchProDuctShouldReturnEmptyCollection() {
        Product product1 = new Product("test_label_1", 1, 1);
        Product product5 = new Product("test_label_5", 5, 1);
        Product product11 = new Product("test_label_11", 11, 1);

        products.add(product1);
        products.add(product5);
        products.add(product11);

        Iterable<Product> allInRange = products.findAllInRange(5, 10);
        Assert.assertNotNull(allInRange);

        List<Product> listFromIterable = createListFromIterable(allInRange);
        Assert.assertTrue(listFromIterable.isEmpty());
    }


    @Test
    public void testFindAllInPriceRangeWithNoSuchProDuctShouldReturnSortedProductsByPriceInDescendingOrder() {
        Product product1 = new Product("test_label_1", 1, 1);
        Product product5 = new Product("test_label_5", 5, 1);
        Product product6 = new Product("test_label_6", 6, 1);
        Product product10 = new Product("test_label_10", 10, 1);
        Product product11 = new Product("test_label_11", 11, 1);

        products.add(product1);
        products.add(product5);
        products.add(product6);
        products.add(product10);
        products.add(product11);

        Iterable<Product> allInRange = products.findAllInRange(5, 10);
        Assert.assertNotNull(allInRange);

        List<Product> listFromIterable = createListFromIterable(allInRange);
        Assert.assertEquals(2, listFromIterable.size());
        Assert.assertEquals(product10.getPrice(), listFromIterable.get(0).getPrice(), 0);
        Assert.assertEquals(product6.getPrice(), listFromIterable.get(1).getPrice(), 0);
    }

    @Test
    public void testFindAllByPriceShouldReturnCorrectProducts() {
        Product product1 = new Product("test_label_1", 5, 1);
        Product product2 = new Product("test_label_2", 5, 1);
        Product product3 = new Product("test_label_3", 6, 1);
        Product product4 = new Product("test_label_4", 5, 1);
        Product product5 = new Product("test_label_5", 11, 1);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        Iterable<Product> allByPrice = products.findAllByPrice(5);
        Assert.assertNotNull(allByPrice);
        List<Product> listFromIterable = createListFromIterable(allByPrice);
        Assert.assertEquals(3, listFromIterable.size());
        for (Product p : listFromIterable) {
            Assert.assertEquals(5, p.getPrice(), 0);
        }
    }

    @Test
    public void testFindAllByPriceShouldReturnReturnEmptyCollection() {
        Product product1 = new Product("test_label_1", 5, 1);
        Product product2 = new Product("test_label_2", 5, 1);
        Product product3 = new Product("test_label_3", 6, 1);
        Product product4 = new Product("test_label_4", 5, 1);
        Product product5 = new Product("test_label_5", 11, 1);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        Iterable<Product> allByPrice = products.findAllByPrice(2);
        Assert.assertNotNull(allByPrice);
        List<Product> listFromIterable = createListFromIterable(allByPrice);
        Assert.assertTrue(listFromIterable.isEmpty());
    }

    @Test
    public void testFindFirstMostExpensiveProductsShouldReturnProductsWithHighestPrice() {
        Product product1 = new Product("test_label_1", 1, 1);
        Product product2 = new Product("test_label_2", 2, 1);
        Product product3 = new Product("test_label_3", 3, 1);
        Product product4 = new Product("test_label_4", 4, 1);
        Product product5 = new Product("test_label_5", 5, 1);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        Iterable<Product> iterable = products.findFirstMostExpensiveProducts(2);
        Assert.assertNotNull(iterable);
        List<Product> products = createListFromIterable(iterable);
        Assert.assertEquals(2, products.size());
        Assert.assertEquals(5, products.get(0).getPrice(), 0);
        Assert.assertEquals(4, products.get(1).getPrice(), 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindFirstMostExpensiveProductsWithProductsLessThanCounter() {
        Product product1 = new Product("test_label_1", 1, 1);
        Product product2 = new Product("test_label_2", 2, 1);
        Product product3 = new Product("test_label_3", 3, 1);
        Product product4 = new Product("test_label_4", 4, 1);
        Product product5 = new Product("test_label_5", 5, 1);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        Iterable<Product> iterable = products.findFirstMostExpensiveProducts(6);
        Assert.assertNotNull(iterable);
        List<Product> products = createListFromIterable(iterable);
        Assert.assertTrue(products.isEmpty());
    }

    @Test
    public void testFindAllByQuantityShouldReturnCorrectProducts() {
        Product product1 = new Product("test_label_1", 1, 1);
        Product product2 = new Product("test_label_2", 2, 4);
        Product product3 = new Product("test_label_3", 3, 3);
        Product product4 = new Product("test_label_4", 4, 4);
        Product product5 = new Product("test_label_5", 5, 5);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        Iterable<Product> iterable = products.findAllByQuantity(4);
        Assert.assertNotNull(iterable);
        List<Product> products = createListFromIterable(iterable);
        Assert.assertEquals(2, products.size());
        for (Product product : products) {
            Assert.assertEquals(4, product.getQuantity());
        }
    }

    @Test
    public void testFindAllByQuantityWithNotIdenticalQuantityShouldReturnEmptyCollection() {
        createAndAddProducts(8);
        Assert.assertNotNull(products);
        Product product = products.find(0);
        Assert.assertNotNull(product);
        Iterable<Product> iterable = products.findAllByQuantity(product.getQuantity() +10);
        Assert.assertNotNull(iterable);
        List<Product> p = createListFromIterable(iterable);
        Assert.assertTrue(p.isEmpty());
    }

    @Test
    public void testGetIterableShouldReturnAllProductsInStock() {
        Product[] expected = createAndAddProducts(10);
        Iterator<Product> iterator = products.iterator();
        Assert.assertNotNull(iterator);
        List<Product> products = createListFromIterator(iterator);
        Assert.assertEquals(10, products.size());
    }

    @Test
    public void testGetIterableShouldReturnEmptyCollection() {
        Iterator<Product> iterator = products.iterator();
        Assert.assertNotNull(iterator);
        List<Product> products = createListFromIterator(iterator);
        Assert.assertTrue(products.isEmpty());
    }

    private <T> List<T> createListFromIterable(Iterable<T> firstByAlphabeticalOrder) {
        List<T> products = new ArrayList<>();
        for (T product : firstByAlphabeticalOrder) {
            products.add(product);
        }
        return products;
    }

    private List<Product> createListFromIterator(Iterator<Product> iterator) {
        List<Product> products = new ArrayList<>();
        while (iterator.hasNext()){
            products.add(iterator.next());
        }
        return products;
    }

    private Product[] createAndAddProducts(int count) {
        Product[] products = new Product[count];
        for (int i = 0; i < count; i++) {
            products[i] = new Product("Label" + i, i, 1);
        }

        for (Product p : products) {
            this.products.add(p);
        }
        return products;
    }


}