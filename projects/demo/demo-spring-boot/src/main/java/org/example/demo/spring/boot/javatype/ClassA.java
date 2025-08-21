package org.example.demo.spring.boot.javatype;

import java.util.List;

public class ClassA<T> {
    public T t;
    public List<T> tList;
    public List<String> strList;

    public T[] tArr;
    public List<T>[] tListArr;
    public List<String>[] strListArr;

    public ClassA<?> c1;
    public ClassA<? extends T> c2;
    public ClassA<? extends Number> c3;
    public ClassA<? super T> c4;
    public ClassA<? super Integer> c5;

    public void f1(T data) {

    }

    public void f2(List<T> tlist) {

    }
}
