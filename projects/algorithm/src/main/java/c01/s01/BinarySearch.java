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

    public static int binarySearch(int[] a, int v, boolean left) {
        return binarySearch(a, v, 0, a.length - 1, left);
    }

    private static int binarySearch(int[] a, int v, int lo, int hi, boolean left) {
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

        // lo + 1 = hi时，mid=lo，会导致mid~hi没有减小
        int mid = lo + (hi - lo) / 2;
        if (!left) {
            mid = lo + (hi - lo + 1) / 2;
        }
        if (a[mid] < v) {
            return binarySearch(a, v, mid + 1, hi, left);
        } else if (a[mid] > v) {
            return binarySearch(a, v, lo, mid - 1, left);
        } else {
            if (left) {
                return binarySearch(a, v, lo, mid, true);
            } else {
                return binarySearch(a, v, mid, hi, false);
            }
        }
    }

}
