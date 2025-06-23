package c01.s05;

public class QuickUnionUF implements UF {
    private int[] parent;
    private int count;

    public QuickUnionUF(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }

        parent[rootP] = rootQ;
        count--;
    }

    @Override
    public int find(int p) {
        validate(p);
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException(String.format("p (%s) is not between 0 and %s", p, n - 1));
        }
    }
}
