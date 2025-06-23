package util;

import java.util.function.Supplier;

public class TimeCostUtils {

    public static <T> T exe(Supplier<T> supplier) {
        long t1 = System.currentTimeMillis();
        T t = supplier.get();
        long t2 = System.currentTimeMillis();

        System.out.printf("cost %fs\n", (t2 - t1) / 1000.0);
        return t;
    }
}
