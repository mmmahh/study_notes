package c02.s04;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Heap<K  extends Comparable<K>> implements MaxPQ<K> {
    private K[] pq;
    private int n;

    public Heap(int initialCapacity) {
        pq = (K[]) new Comparable[initialCapacity + 1];
        n = 0;
    }

    @Override
    public void insert(K k) {
        if (k == null) {
            throw new IllegalArgumentException("k is null");
        }
        pq[++n] = k;
        swim(n);
    }

    @Override
    public K max() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }
        return pq[1];
    }

    @Override
    public K delMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        K max = pq[1];
        pq[1] = pq[n];
        pq[n--] = null;
        sink(1);
        return max;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    private void swim(int k) {
        while (k > 1 && pq[k / 2].compareTo(pq[k]) < 0) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    private void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && pq[j].compareTo(pq[j + 1]) < 0) {
                j += 1;
            }
            if (pq[j].compareTo(pq[k]) <= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void swap(int i, int j) {
        K temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

}
