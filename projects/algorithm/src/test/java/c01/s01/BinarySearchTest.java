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
    public void testBinarySearch2() {
        int[] a = {0, 1};
        Assertions.assertEquals(BinarySearch.binarySearch(a, 0, true), 0);
        Assertions.assertEquals(BinarySearch.binarySearch(a, 1, true), 1);
        Assertions.assertEquals(BinarySearch.binarySearch(a, 2, true), -1);
        Assertions.assertEquals(BinarySearch.binarySearch(a, 0, false), 0);
        Assertions.assertEquals(BinarySearch.binarySearch(a, 1, false), 1);
        Assertions.assertEquals(BinarySearch.binarySearch(a, 2, false), -1);


        int[] a1 = {0};
        Assertions.assertEquals(BinarySearch.binarySearch(a1, 0, true), 0);
        Assertions.assertEquals(BinarySearch.binarySearch(a1, 1, true), -1);
        Assertions.assertEquals(BinarySearch.binarySearch(a1, 0, false), 0);
        Assertions.assertEquals(BinarySearch.binarySearch(a1, 1, false), -1);

        int[] a2 = {0,0,0,1,1,1,3,3,3,3};
        Assertions.assertEquals(BinarySearch.binarySearch(a2, 0, true), 0);
        Assertions.assertEquals(BinarySearch.binarySearch(a2, 1, true), 3);
        Assertions.assertEquals(BinarySearch.binarySearch(a2, 2, true), -1);
        Assertions.assertEquals(BinarySearch.binarySearch(a2, 3, true), 6);
        Assertions.assertEquals(BinarySearch.binarySearch(a2, 0, false), 2);
        Assertions.assertEquals(BinarySearch.binarySearch(a2, 1, false), 5);
        Assertions.assertEquals(BinarySearch.binarySearch(a2, 2, false), -1);
        Assertions.assertEquals(BinarySearch.binarySearch(a2, 3, false), 9);

        int[] a3 = {};
        Assertions.assertEquals(BinarySearch.binarySearch(a3, 0, true), -1);
        Assertions.assertEquals(BinarySearch.binarySearch(a3, 0, false), -1);
    }

}