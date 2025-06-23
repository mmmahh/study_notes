package c01.s05;

/**
 * 并查集
 */
public interface UF {
    void union(int p, int q);
    int find(int p);
    boolean connected(int p, int q);

    /**
     * 联通分量的个数
     * @return
     */
    int count();
}
