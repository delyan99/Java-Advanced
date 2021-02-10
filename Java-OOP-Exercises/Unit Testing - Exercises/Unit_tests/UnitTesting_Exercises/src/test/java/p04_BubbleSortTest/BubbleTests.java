package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

public class BubbleTests {
    @Test
    public void testBubbleSortWithArrayWithZeroElements(){
        int[] array = new int[0];
        Bubble.sort(array);
        Assert.assertEquals(0, array.length);
    }

    @Test
    public void testBubbleSortWithArrayWithOneElements(){
        int[] array = new int[]{2};
        Bubble.sort(array);
        boolean flag = true;
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] <= array[i + 1]){
                flag = true;
            }else{
                flag = false;
            }
            Assert.assertTrue(flag);
        }
    }

    @Test
    public void testBubbleSortWithArrayWithCorrectData(){
        int[] array = new int[]{2, 2, 5, 7, 2, 3, 23, 65, 5, 233, 2, 32, 3, 6, -56, 0};
        Bubble.sort(array);
        boolean flag = true;
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] <= array[i + 1]){
                flag = true;
            }else{
                flag = false;
            }
            Assert.assertTrue(flag);
        }
    }
}
