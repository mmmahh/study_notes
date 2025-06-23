package c02.s04;

public interface MaxPQ<K extends Comparable<K>> {
    void insert(K k);
    K max();
    K delMax();
    boolean isEmpty();
    int size();
}
