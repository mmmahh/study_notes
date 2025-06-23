package c03.s01;

public interface ST<K, V> {
    void put(K key, V value);
    void get(K key);
    void delete(K key);
    boolean contains(K key);
    boolean isEmpty();
    int size();
    Iterable<K> keys();
}
