package util;

public class Utils {

    public static int[] random(int size, int min, int max) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * (max - min + 1)) + min;
        }
        return arr;
    }
}
