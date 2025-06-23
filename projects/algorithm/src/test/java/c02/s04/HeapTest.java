package c02.s04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeapTest {

    @Test
    void test() {
        Heap<Integer> heap = new Heap<>(10);
        heap.insert(5);
        heap.insert(6);
        heap.insert(1);
        heap.insert(5);
        heap.insert(8);
        System.out.println();
    }
}