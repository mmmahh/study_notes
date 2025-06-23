package c01.s05;


import org.junit.jupiter.api.Test;

public class SimpleUFTest {

    @Test
    public void test() {
        UF simpleUF = new SimpleUF(10);
        simpleUF.union(1, 2);
        simpleUF.union(2, 6);
        simpleUF.union(4, 9);

        System.out.println();
    }
}