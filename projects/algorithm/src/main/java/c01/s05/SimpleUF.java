package c01.s05;

public class SimpleUF implements UF {
    private int count;
    private int[] parent;
    /**
     * rank[i] = i为根节点的子树的深度（0~31）
     */
    private byte[] rank;

    public SimpleUF(int n) {
        this.count = n;
        this.parent = new int[n];
        this.rank = new byte[n];
        for (int i = 0; i < this.parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    @Override
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        if (rank[rootP] < rank[rootQ]) {
            parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]){
            parent[rootQ] = rootP;
        } else {
            parent[rootP] = rootQ;
            rank[rootQ]++;
        }
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
