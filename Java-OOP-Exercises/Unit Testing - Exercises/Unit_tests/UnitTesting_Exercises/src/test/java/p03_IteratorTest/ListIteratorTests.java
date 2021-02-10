package p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTests {
    private static ListIterator listIterator;

    @Before
    public void setUp() throws OperationNotSupportedException {
        listIterator = new ListIterator("First", "Second", "Third");
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullParam() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator(null);
    }

    @Test
    public void testConstructorWithValidParams() throws OperationNotSupportedException {
        listIterator.move();
        listIterator.move();
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testMoveIndexInTheListAndReturnTrue(){
        boolean move = listIterator.move();
        Assert.assertTrue(move);
    }

    @Test
    public void testMoveIndexInTheListAndReturnFalse(){
        for (int i = 0; i < 3; i++) {
            listIterator.move();
        }
        Assert.assertFalse(listIterator.move());
    }

    @Test
    public void testHasNextIndexInTheListAndReturnTrue(){
        boolean hasNext = listIterator.hasNext();
        Assert.assertTrue(hasNext);
    }

    @Test
    public void testMoveHasNextInTheListAndReturnFalse(){
        for (int i = 0; i < 3; i++) {
            listIterator.move();
        }
        Assert.assertFalse(listIterator.hasNext());
    }

    @Test
    public void testPrintShouldPrintTheElementAtTheCurrentIndex(){
        String result = "First";
        Assert.assertEquals(result, listIterator.print());
    }

    @Test(expected = IllegalStateException.class)
    public void testPrintWithoutElementsShouldReturnException() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }
}
