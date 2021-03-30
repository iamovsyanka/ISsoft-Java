package by.ovsynka;

import org.testng.Assert;
import org.testng.annotations.*;

public class BinarySearchTest extends Assert {
    int[] arrayToTest = new int[]{1, 2, 3, 5, 8, 13, 21, 44, 65, 99};

    @Test
    public void testBinarySearch() {
        int index = BinarySearch.recursiveBinarySearch(arrayToTest, 0, arrayToTest.length, 3);
        Assert.assertEquals(2, index);
    }

    @Test
    public void testNotFound() {
        int index = BinarySearch.recursiveBinarySearch(arrayToTest, 0, arrayToTest.length, 10);
        Assert.assertEquals(-1, index);
    }
}
