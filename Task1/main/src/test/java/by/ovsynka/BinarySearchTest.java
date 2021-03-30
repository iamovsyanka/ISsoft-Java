package by.ovsynka;

import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest extends Assert {
    int[] arrayToTest = new int[]{1, 2, 3, 5, 8, 13, 21, 44, 65, 99};

    @Test
    public void testEquals() {
        int index = BinarySearch.recursiveBinarySearch(arrayToTest, 0, arrayToTest.length, 3);
        Assert.assertEquals(2, index);
    }

    @Test
    public void testNotEquals() {
        int index = BinarySearch.recursiveBinarySearch(arrayToTest, 0, arrayToTest.length, 3);
        Assert.assertNotEquals(-1, index);
    }

    @Test
    public void testNotFound() {
        int index = BinarySearch.recursiveBinarySearch(arrayToTest, 0, arrayToTest.length, 10);
        Assert.assertEquals(-1, index);
    }
}
