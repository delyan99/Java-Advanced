package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTests {
    private Database database;
    private Person[] people;

    @Before
    public void setUp() throws OperationNotSupportedException {
        people = new Person[]{new Person(1, "First"), new Person(2, "Second"), new Person(3, "Third")};
        database = new Database(people);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithZeroPeople() throws OperationNotSupportedException{
        database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithSixteenPeople() throws OperationNotSupportedException{
        people = new Person[17];
        database = new Database(people);
    }

    @Test
    public void testConstructorWithValidCountOfPeople(){
       Assert.assertEquals(people.length, database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddPersonAtTheNextFreeSellWithNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddPersonAtTheNextFreeSellWithValidElements() throws OperationNotSupportedException{
        Person p = new Person(100, "Ivan");
        database.add(p);
        Person[] elements = database.getElements();
        Person element = elements[elements.length - 1];
        Assert.assertEquals(people.length + 1, database.getElements().length);
        Assert.assertEquals(p, element);
    }

    @Test
    public void testRemoveElementAtTheLastIndexOfArray() throws OperationNotSupportedException {
        database.remove();
        Assert.assertEquals(people.length - 1, database.getElements().length);
        Assert.assertEquals(people[people.length - 2], database.getElements()[database.getElements().length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementFromEmptyDatabase() throws OperationNotSupportedException {
        int length = database.getElements().length;
        for (int i = 0; i <= length; i++) {
            database.remove();
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWhenUsernameIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameWhenNoUserIsPresentedWithThisUsername() throws OperationNotSupportedException {
        database.findByUsername("Gosho");
    }

    @Test
    public void testFindByUsernameWithValidUsername() throws OperationNotSupportedException {
        Person first = database.findByUsername("First");
        Assert.assertEquals(database.getElements()[0], first);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByIdWhenNoUserIsPresentedWithThisId() throws OperationNotSupportedException {
        database.findById(7);
    }

    @Test
    public void testFindByIdWithValidId() throws OperationNotSupportedException {
        Person first = database.findById(1);
        Assert.assertEquals(database.getElements()[0], first);
    }
}
