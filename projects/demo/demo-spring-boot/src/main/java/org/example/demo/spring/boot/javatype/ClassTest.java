package org.example.demo.spring.boot.javatype;

import java.lang.reflect.*;
import java.util.Arrays;

public class ClassTest {

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Class<ClassA> clsA = ClassA.class;
        Field t = clsA.getField("t");
        Field tList = clsA.getField("tList");
        Field strList = clsA.getField("strList");

        Field tArr = clsA.getField("tArr");
        Field tListArr = clsA.getField("tListArr");
        Field strListArr = clsA.getField("strListArr");

        Field c1 = clsA.getField("c1");
        Field c2 = clsA.getField("c2");
        Field c3 = clsA.getField("c3");
        Field c4 = clsA.getField("c4");
        Field c5 = clsA.getField("c5");

        System.out.println(t.getGenericType() + " " + t.getGenericType().getClass());
        System.out.println(tList.getGenericType() + " " + tList.getGenericType().getClass());
        System.out.println(strList.getGenericType() + " " + strList.getGenericType().getClass());

        System.out.println(tArr.getGenericType() + " " + tArr.getGenericType().getClass());
        System.out.println(tListArr.getGenericType() + " " + tListArr.getGenericType().getClass());
        System.out.println(strListArr.getGenericType() + " " + strListArr.getGenericType().getClass());

        System.out.println(c1.getGenericType() + " " + c1.getGenericType().getClass());
        System.out.println(c2.getGenericType() + " " + c2.getGenericType().getClass());
        System.out.println(c3.getGenericType() + " " + c3.getGenericType().getClass());
        System.out.println(c4.getGenericType() + " " + c4.getGenericType().getClass());
        System.out.println(c5.getGenericType() + " " + c5.getGenericType().getClass());

        if (c1.getGenericType() instanceof ParameterizedType pt) {
            for (Type actualTypeArgument : pt.getActualTypeArguments()) {
                System.out.println(actualTypeArgument + " " + actualTypeArgument.getClass());
            }
        }

        // for (Method method : clsA.getMethods()) {
        //     for (Parameter parameter : method.getParameters()) {
        //         Type parameterizedType = parameter.getParameterizedType();
        //         System.out.println(parameterizedType);
        //     }
        // }
    }
}
