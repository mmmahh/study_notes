package c01.s01;

import util.Utils;

public class CardShuffle {

    public static void bad(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int rand = (int) (Math.random() * a.length);
            Utils.swap(a, i, rand);
        }
    }

    public static void shuffle1(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int rand = (int) (i + Math.random() * (a.length - i));
            Utils.swap(a, i, rand);
        }
    }

    public static void shuffle2(int[] a) {
        double[] r = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            r[i] = Math.random();
        }

        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (r[j] < r[j - 1]) {
                    Utils.swap(a, j, j - 1);
                    Utils.swap(r, j, j - 1);
                }
            }
        }

        assert Utils.sorted(r);
    }
}
