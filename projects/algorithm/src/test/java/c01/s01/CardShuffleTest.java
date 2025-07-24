package c01.s01;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

public class CardShuffleTest {

    @Test
    public void test() {
        int[] a = new int[52];
        for (int i = 0; i < a.length; i++) {
            a[i] = i + 1;
        }

        CardShuffle.bad(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void test2() {
        rate();
    }


    public void rate() {
        int[] a1 = {1, 2, 3};
        int[] a2 = {1, 3, 2};
        int[] a3 = {2, 1, 3};
        int[] a4 = {2, 3, 1};
        int[] a5 = {3, 1, 2};
        int[] a6 = {3, 2, 1};
        int[][] t = {a1, a2, a3, a4, a5, a6};
        int[] f = new int[6];

        int[] a = {1, 2, 3};

        int count = 1000000;
        for (int i = 0; i < count; i++) {
            Arrays.sort(a);
            CardShuffle.bad(a);

            for (int j = 0; j < t.length; j++) {
                if (Arrays.equals(t[j], a)) {
                    f[j] += 1;
                    break;
                }
            }
        }

        for (int i = 0; i < f.length; i++) {
            System.out.printf("%d: %f\n", i, f[i] / ((double) count));
        }

    }

}