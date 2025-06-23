package c01.s05;

public class QuickFindUF implements UF {
    private int[] id;
    private int count;

    public QuickFindUF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if (pid == qid) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
        count--;
    }

    @Override
    public int find(int p) {
        validate(p);
        return id[p];
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
        int n = id.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException(String.format("p (%s) is not between 0 and %s", p, n - 1));
        }
    }
}
