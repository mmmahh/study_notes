package c03.s01;

import java.util.NoSuchElementException;

public class BST<K extends Comparable<K>, V> implements OrderedST<K, V> {
    private Node root;

    public BST() {

    }

    private class Node {
        K key;
        V value;
        // 子树大小
        int size;
        Node left;
        Node right;

        public Node(K key, V value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }

        public Node(K key, V value, int size, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.size = size;
            this.left = left;
            this.right = right;
        }
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }

        // 设置value=null即删除这个key
        if (value == null) {
            delete(key);
        }

        root = put(root, key, value);
    }

    private Node put(Node x, K key, V value) {
        if (x == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        x.size = 1 + size(x.left) + size(x.right);

        return x;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }

        return x.size;
    }

    @Override
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }

        Node find = get(root, key);
        if (find == null) {
            return null;
        }

        return find.value;
    }

    private Node get(Node x, K key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x;
        }
    }

    @Override
    public void delete(K key) {
        if (key == null) {
            throw new IllegalArgumentException("key is null");
        }
        root = delete(root, key);
    }

    /**
     * 删除x为根节点的子树的key，返回删除后的根节点
     * @param x
     * @param key
     * @return
     */
    private Node delete(Node x, K key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = delete(x.left, key);
        } else if (cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if (x.right == null) {
                return x.left;
            } else if (x.left == null) {
                return x.right;
            } else {
                Node rightMin = min(x.right);
                Node rightRoot = deleteMin(x.right);
                rightMin.left = x.left;
                rightMin.right = rightRoot;
                x = rightMin;
            }
        }

        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public boolean contains(K key) {
        return get(root, key) != null;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return size(root);
    }

    @Override
    public K min() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty");
        }

        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }

        return min(x.left);
    }

    @Override
    public K max() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty");
        }
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x.right);
    }

    @Override
    public K floor(K key) {
        return null;
    }

    @Override
    public K ceiling(K key) {
        return null;
    }

    @Override
    public int rank(K key) {
        return 0;
    }

    @Override
    public K select(int k) {
        return null;
    }

    @Override
    public void deleteMin() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty");
        }
        deleteMin(root);
    }

    /**
     * 删除x为根节点的子树的最小节点，返回删除后的根节点
     * @param x
     * @return
     */
    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public void deleteMax() {
        if (isEmpty()) {
            throw new NoSuchElementException("empty");
        }
        deleteMax(root);
    }

    private Node deleteMax(Node x) {
        if (x.right == null) {
            return x.left;
        }

        x.right = deleteMax(x.right);
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    @Override
    public int size(K lo, K hi) {
        return 0;
    }

    @Override
    public Iterable<K> keys(K lo, K hi) {
        return null;
    }

    @Override
    public Iterable<V> keys() {
        return null;
    }
}
