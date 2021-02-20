package store;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StoreTests {
    public Store store;
    public Product product;

    @Before
    public void setUp(){
        store = new Store();
        product = new Product("Name", 10, 5);
    }

    @Test
    public void testConstructor(){
        Assert.assertEquals(0, store.getCount());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetProductsAndTryToModifyCollection(){
        store.getProducts().remove(1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductNullProduct(){
        store.addProduct(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductWithZeroQuantity(){
        product = new Product("Name", 0, 5);
        store.addProduct(product);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddProductWithQuantityLowerThanZero(){
        product = new Product("Name", -1, 5);
        store.addProduct(product);
    }

    @Test
    public void testAddProductValidProduct(){
        Product p = new Product("N", 2, 4);
        Assert.assertEquals(0, store.getCount());
        store.addProduct(product);
        Assert.assertEquals(1, store.getCount());
        store.addProduct(p);
        Assert.assertEquals(2, store.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductWithNullProduct(){
        store.buyProduct("Name", 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testBuyProductWithInvalidQuantity(){
        store.addProduct(product);
        store.buyProduct("Name", 100);
    }

    @Test
    public void testBuyProductWithValidData(){
        store.addProduct(product);
        double expected = store.buyProduct("Name", 9);
        Assert.assertEquals(45, expected, 0);
    }

    @Test
    public void testGetTheMostExpensiveProductFromNotExistingProduct(){
        Product theMostExpensiveProduct = store.getTheMostExpensiveProduct();
        Assert.assertNull(theMostExpensiveProduct);
    }

    @Test
    public void testGetTheMostExpensiveProductWithValidProduct(){
        Product product1 = new Product("Name_01", 10, 522);
        Product product2 = new Product("Name_02", 10, 54);
        Product product3 = new Product("Name_03", 10, 34);
        Product product4 = new Product("Name_04", 10, 2);
        store.addProduct(product);
        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);
        store.addProduct(product4);
        Product theMostExpensiveProduct = store.getTheMostExpensiveProduct();
        Assert.assertEquals(product1,theMostExpensiveProduct);
    }
}