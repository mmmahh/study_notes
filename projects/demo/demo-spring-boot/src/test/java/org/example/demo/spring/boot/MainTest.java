package org.example.demo.spring.boot;


import org.junit.jupiter.api.Test;

public class MainTest {
    enum A {

    }

    enum B {

    }

    @interface C {

    }

    interface D {

    }

    @Test
    public void test() {
        Class<int[]> c1 = int[].class;
        Class<Integer[]> c2 = Integer[].class;

        Object[] arr = new Integer[1];
        arr[0] = 3;



        System.out.println();
    }
}