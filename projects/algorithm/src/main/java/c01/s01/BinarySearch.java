package c01.s01;

import util.TimeCostUtils;
import util.Utils;

import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] a, int v) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid] == v) {
                return mid;
            } else if (a[mid] < v) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static int search(int[] a, int v) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == v) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearchLeft(int[] a, int v) {
        return binarySearchLeft(a, v, 0, a.length - 1);
    }

    private static int binarySearchLeft(int[] a, int v, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }

        if (lo == hi) {
            if (a[lo] == v) {
                return lo;
            } else {
                return -1;
            }
        }

        int mid = lo + (hi - lo) / 2;
        if (a[mid] == v) {
            return binarySearchLeft(a, v, lo, mid);
        }

        if (a[mid] < v) {
            return binarySearchLeft(a, v, mid + 1, hi);
        }

        return binarySearchLeft(a, v, lo, mid -1);
    }

}
