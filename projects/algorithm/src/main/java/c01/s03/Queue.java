package c01.s03;

public interface Queue<E> extends Iterable<E> {
    void enqueue(E e);
    E dequeue();
    boolean isEmpty();
    int size();
}
