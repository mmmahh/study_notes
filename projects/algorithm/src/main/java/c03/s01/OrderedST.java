package c03.s01;

public interface OrderedST<K extends Comparable<K>, V> {
    void put(K key, V value);
    V get(K key);
    void delete(K key);
    boolean contains(K key);
    boolean isEmpty();
    int size();
    K min();
    K max();
    K floor(K key);
    K ceiling(K key);
    int rank(K key);
    K select(int k);
    void deleteMin();
    void deleteMax();
    int size(K lo, K hi);
    Iterable<K> keys(K lo, K hi);
    Iterable<V> keys();
}
