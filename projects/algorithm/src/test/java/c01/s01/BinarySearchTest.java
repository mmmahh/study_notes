package c01.s01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.TimeCostUtils;
import util.Utils;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTest {

    @Test
    public void testBinarySearch() {
        int size = 10000000;
        int min = -size;
        int[] tmp = Utils.random(size, min, size);
        int[] array = Arrays.stream(tmp).distinct().sorted().toArray();

        int k = (int) (Math.random() * (size - min + 1)) + min;
        System.out.println("k: " + k);

        int i1 = TimeCostUtils.exe(() -> {
            return BinarySearch.binarySearch(array, k);
        });

        int i2 = TimeCostUtils.exe(() -> {
            return BinarySearch.search(array, k);
        });

        System.out.println(i1);
        System.out.println(i2);
    }

    @Test
    public void testBinarySearchLeft() {
        int[] a = {0, 1};
        Assertions.assertEquals(BinarySearch.binarySearchLeft(a, 0), 0);
        Assertions.assertEquals(BinarySearch.binarySearchLeft(a, 1), 1);
        Assertions.assertEquals(BinarySearch.binarySearchLeft(a, 2), -1);

        int[] a1 = {0};
        Assertions.assertEquals(BinarySearch.binarySearchLeft(a1, 0), 0);
        Assertions.assertEquals(BinarySearch.binarySearchLeft(a1, 1), -1);

        int[] a2 = {0,0,0,1,1,1,3,3,3,3};
        Assertions.assertEquals(BinarySearch.binarySearchLeft(a2, 0), 0);
        Assertions.assertEquals(BinarySearch.binarySearchLeft(a2, 1), 3);
        Assertions.assertEquals(BinarySearch.binarySearchLeft(a2, 2), -1);
        Assertions.assertEquals(BinarySearch.binarySearchLeft(a2, 3), 6);
    }

}