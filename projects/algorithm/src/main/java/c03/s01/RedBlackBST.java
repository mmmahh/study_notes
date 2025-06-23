package c03.s01;

public class RedBlackBST<K extends Comparable<K>, V> implements OrderedST<K, V> {
    private Node root;

    private enum Color {RED, BLACK};

    private class Node {
        K key;
        V value;
        Node left;
        Node right;
        Color color;
        int size;

        public Node(K key, V value, Color color, int size) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
        }

        public Node(K key, V value, Color color, int size, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.color = color;
            this.size = size;
            this.left = left;
            this.right = right;
        }
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = Color.RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = Color.RED;
        x.size = h.size;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = Color.RED;
        h.left.color = Color.BLACK;
        h.right.color = Color.BLACK;
    }

    /**
     * 向h节点插入key，返回插入后的根节点
     * @param h
     * @param key
     * @param value
     * @return
     */
    private Node insert(Node h, K key, V value) {
        if (h == null) {
            return new Node(key, value, Color.RED, 1);
        }

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = insert(h.left, key, value);
        } else if (cmp > 0) {
            h.right = insert(h.right, key, value);
        } else {
            h.value = value;
        }

        // 维护红黑树性质
        // 树的黑高性质满足，则旋转后，树的黑高性质仍满足，且黑高不变
        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        
        return h;
    }

    private boolean isRed(Node h) {
        if (h == null) {
            return false;
        }
        return h.color == Color.RED;
    }

    private int size(Node h) {
        if (h == null) return 0;
        return h.size;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) throw new NullPointerException("key is null");
        root = insert(root, key, value);
        root.color = Color.BLACK;
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

    }

    @Override
    public boolean contains(K key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public K min() {
        return null;
    }

    @Override
    public K max() {
        return null;
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

    }

    @Override
    public void deleteMax() {

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
