package Tree;

import List.Node;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: TreeNode
 * @类描述:
 * @创建人: 权义翔
 * @创建时间: 2020/3/14 17:43
 **/
public class TreeNode<T> {
    //用于链表
    public TreeNode nextTreeNode = null;
    //数据位
    public T data;
    //用于二叉树
    public TreeNode leftChild = null;
    public TreeNode rightChild = null;
    //父节点
    public TreeNode parent = null;
    //标志位
    public Integer flag;
}