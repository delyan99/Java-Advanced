package p05_CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CustomLinkedListTests {
    private static CustomLinkedList<Integer> list;

    @Before
    public void setUp(){
        list = new CustomLinkedList<>();
    }

    @Test
    public void testConstructorWorkProperly(){
        list.add(1);
        Integer expected = 1;
        Assert.assertEquals(expected, list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetElementFromEmptyCustomLinkedList(){
        list.get(1);
    }

    @Test
    public void testGetElementFromCustomLinkedList(){
        list.add(1);
        Integer expected = 1;
        Assert.assertEquals(expected, list.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementWithNegativeNumberInCustomLinkedList(){
        list.set(-1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetElementWithNumberGreaterThenCounterInCustomLinkedList(){
        list.set(10, 1);
    }

    @Test
    public void testSetElementWithInvalidElementInCustomLinkedList(){
        list.add(100);
        Integer expected = null;
        list.set(0, expected);
        Assert.assertEquals(expected, list.get(0));
    }

    @Test
    public void testSetValidElementInCustomLinkedList(){
        list.add(10);
        list.add(100);
        Integer expected = 1;
        list.set(1, expected);
        Assert.assertEquals(expected, list.get(1));
    }

    @Test
    public void testAddOneValidElementInCustomLinkedList(){
        Integer expected = 1;
        list.add(expected);
        Assert.assertEquals(expected, list.get(0));
    }

    @Test
    public void testAddTwoValidElementsInCustomLinkedList(){
        Integer expected = 1;
        list.add(0);
        list.add(expected);
        Assert.assertEquals(expected, list.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtElementWithNegativeNumberInCustomLinkedList(){
        list.removeAt(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveAtElementWithNumberGreaterThenCounterInCustomLinkedList(){
        list.removeAt(10);
    }

    @Test
    public void testRemoveAtElementWithOneValidElementInCustomLinkedList(){
        Integer expected = 100;
        list.add(expected);
        Integer integer = list.removeAt(0);
        Assert.assertEquals(expected, integer);
    }

    @Test
    public void testRemoveAtElementWithGreaterThanZeroIndexInCustomLinkedList(){
        Integer expected = 100;
        list.add(expected);
        list.add(expected);
        Integer integer = list.removeAt(1);
        Assert.assertEquals(expected, integer);
    }

    @Test
    public void testRemoveWithNullItemInCustomLinkedList(){
        list.add(100);
        int remove = list.remove(null);
        Assert.assertEquals(-1, remove);
    }

    @Test
    public void testRemoveWithValidItemInCustomLinkedList(){
        list.add(100);
        int remove = list.remove(100);
        Assert.assertEquals(0, remove);
    }

    @Test
    public void testIndexOfWithNullItemInCustomLinkedList(){
        int index = list.indexOf(null);
        Assert.assertEquals(-1, index);
    }

    @Test
    public void testIndexOfWithValidItemInCustomLinkedList(){
        list.add(100);
        int index = list.indexOf(100);
        Assert.assertEquals(0, index);
    }

    @Test
    public void testContainsWithNullNotContainedItemInCustomLinkedList(){
        list.add(100);
        boolean contains = list.contains(null);
        Assert.assertFalse(contains);
    }

    @Test
    public void testContainsWithValidContainedItemInCustomLinkedList(){
        list.add(100);
        boolean contains = list.contains(100);
        Assert.assertTrue(contains);
    }
}
