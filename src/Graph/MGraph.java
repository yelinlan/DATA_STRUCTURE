package Graph;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: MGraph
 * @类描述: 图
 * @创建人: 权义翔
 * @创建时间: 2020/3/18 21:47
 **/
public class MGraph {
    //最大值
    private final int INFINITY=65536;
    //最大顶点个数
    private final int MAX_VERTEX_NUM=20;
    //顶点向量
    int[] vexs;
    //邻接矩阵
    ArcCell[][] arcs;
    //图的当前顶点数和弧数
    int vexNum;
    int arcNum;
    //图的种类标志
    String kind; 
}