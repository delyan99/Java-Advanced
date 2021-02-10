package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DatabaseTests {
    private static final Integer Add_Element_To_Array_Valid = 16;
    private static final Integer Add_Element_To_Array_Not_Valid = null;
    private static final Integer First_Integer = 1;
    private static final Integer Second_Integer = 2;
    private static final Integer Third_Integer = 3;
    private static final Integer Forth_Integer = 4;
    private static final Integer Fifth_Integer = 5;
    private static final Integer Sixth_Integer = 6;
    private static final Integer Seventh_Integer = 7;
    private static final Integer Eight_Integer = 8;
    private static final Integer Ninth_Integer = 9;
    private static final Integer Tenth_Integer = 10;
    private static final Integer Eleventh_Integer = 11;
    private static final Integer Twelfth_Integer = 12;
    private static final Integer Thirteenth_Integer = 13;
    private static final Integer Fourteenth_Integer = 14;
    private static final Integer Fifteenth_Integer = 15;
    private static final Integer Sixteenth_Integer = 16;
    private Database database;
    private Integer[] numbers;

    @Before
    public void SetUp() throws OperationNotSupportedException {
        numbers = new Integer[]{First_Integer, Second_Integer, Third_Integer, Forth_Integer, Fifth_Integer,
                Sixth_Integer, Seventh_Integer, Eight_Integer, Ninth_Integer, Tenth_Integer, Eleventh_Integer,
                Twelfth_Integer, Thirteenth_Integer, Fourteenth_Integer, Fifteenth_Integer, Sixteenth_Integer};
        database = new Database(numbers);
    }

    @Test
    public void testSizeOfTheArrayIsSixteenSymbolsLong() throws OperationNotSupportedException {
        Integer[] array = {First_Integer, Second_Integer, Third_Integer, Forth_Integer, Fifth_Integer,
                Sixth_Integer, Seventh_Integer, Eight_Integer, Ninth_Integer, Tenth_Integer, Eleventh_Integer,
                Twelfth_Integer, Thirteenth_Integer, Fourteenth_Integer, Fifteenth_Integer, Sixteenth_Integer};
        Assert.assertArrayEquals(array, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testSizeOfTheArrayIsZer0SymbolsLong() throws OperationNotSupportedException {
        database = new Database();

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testSizeOfTheArrayIsMoreThanSixteenSymbolsLong() throws OperationNotSupportedException {
        database = new Database(First_Integer, Second_Integer, Third_Integer, Forth_Integer, Fifth_Integer,
                Sixth_Integer, Seventh_Integer, Eight_Integer, Ninth_Integer, Tenth_Integer, Eleventh_Integer,
                Twelfth_Integer, Thirteenth_Integer, Fourteenth_Integer, Fifteenth_Integer, Sixteenth_Integer,
                Add_Element_To_Array_Valid);
    }

    @Test
    public void testAddElementAtTheNextFreeSellWithValidElements() throws OperationNotSupportedException {
        Integer[] numbers = {First_Integer, Second_Integer, Third_Integer, Forth_Integer, Fifth_Integer,
                Sixth_Integer, Seventh_Integer, Eight_Integer, Ninth_Integer, Tenth_Integer, Eleventh_Integer,
                Twelfth_Integer, Thirteenth_Integer, Fourteenth_Integer, Fifteenth_Integer};
        database = new Database(numbers);
        database.add(Add_Element_To_Array_Valid);
        Integer[] elements = database.getElements();
        Integer element = elements[elements.length - 1];
        Assert.assertEquals(numbers.length + 1, database.getElements().length);
        Assert.assertEquals(Add_Element_To_Array_Valid, element);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddElementAtTheNextFreeSellWithNullElement() throws OperationNotSupportedException {
        database.add(Add_Element_To_Array_Not_Valid);
    }

    @Test
    public void testRemoveElementAtTheLastIndexOfArray() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(numbers.length - 1, database.getElements().length);
        Assert.assertEquals(Fifteenth_Integer, database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyDatabase() throws OperationNotSupportedException {
        int length = database.getElements().length;
        for (int i = 0; i <= length; i++) {
            database.remove();
        }
    }

    @Test
    public void testFetchElementsFromArray(){
        Integer[] array = {First_Integer, Second_Integer, Third_Integer, Forth_Integer, Fifth_Integer,
                Sixth_Integer, Seventh_Integer, Eight_Integer, Ninth_Integer, Tenth_Integer, Eleventh_Integer,
                Twelfth_Integer, Thirteenth_Integer, Fourteenth_Integer, Fifteenth_Integer, Sixteenth_Integer};
        Assert.assertArrayEquals(array, database.getElements());
    }

}
