package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ComputerManagerTests {
    ComputerManager computerManager;
    Computer computer;

    @Before
    public void setUp() {
        computerManager = new ComputerManager();
        computer = new Computer("Manufacture", "Model", 100.50);
    }

    @Test
    public void testConstructorWithEmptyData(){
        Assert.assertEquals(0, computerManager.getComputers().size());
    }

    @Test
    public void testConstructorWithValidData(){
        computerManager.addComputer(computer);
        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerWithInvalidComputer(){
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddComputerWithSameComputers() {
        for (int i = 0; i < 10; i++) {
            computerManager.addComputer(computer);
        }
    }

    @Test
    public void testAddComputerWithValidComputer() {
        computerManager.addComputer(computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerWithNullManufacturer() {
        computerManager.getComputer(null, "Model");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerWithNullModel() {
        computerManager.getComputer("Manufacture", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputerNotExisting() {
        computerManager.getComputer("Manufacture", "Model");
    }

    @Test
    public void testGetComputerWithValidArguments() {
        computerManager.addComputer(computer);
        computerManager.getComputer("Manufacture", "Model");
        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test
    public void testRemoveComputerWithValidData() {
        Assert.assertEquals(0, computerManager.getCount());
        computerManager.addComputer(computer);
        Assert.assertEquals(1, computerManager.getCount());
        computerManager.removeComputer("Manufacture", "Model");
        Assert.assertEquals(0, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerWithNullManufacture() {
        computerManager.removeComputer(null, "Model");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerWithNullModel() {
        computerManager.removeComputer("Manufacture", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveComputerFromNotExistingComputer() {
        computerManager.removeComputer("Manufacture", "Model");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetComputersByManufacturerWithNullManufacture() {
        computerManager.getComputersByManufacturer(null);
    }

    @Test
    public void testGetComputersByManufacturerWithValidManufacture() {
        computerManager.addComputer(computer);
        List<Computer> manufacture = computerManager.getComputersByManufacturer("Manufacture");
        Assert.assertEquals(1, manufacture.size());
    }
}