package org.example.demo.spring.boot;


import org.junit.jupiter.api.Test;

import java.lang.annotation.*;
import java.lang.reflect.TypeVariable;

public class MainTest {
    enum A {

    }

    enum B {

    }

    @Target(ElementType.TYPE_PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
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

    private static class Test2<@C D extends A> {

    }

    @Test
    public void test2() {
        TypeVariable<Class<Test2>>[] typeParameters = Test2.class.getTypeParameters();
        System.out.println();

    }
}