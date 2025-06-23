package c04.s01;

/**
 * 无向图
 */
public interface UndirectedGraph {
    /**
     * 顶点数
     * @return
     */
    int vertexCount();

    /**
     * 边数
     * @return
     */
    int edgeCount();

    /**
     * 添加边v-w
     * @param v
     * @param w
     */
    void addEdge(int v, int w);

    /**
     * 连接v的所有顶点
     * @param v
     * @return
     */
    Iterable<Integer> adj(int v);

    String toString();
}
