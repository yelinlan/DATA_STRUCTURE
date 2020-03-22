package Tree.TreeApply;
import List.Node;

import List.ListAndArray;
import Tree.BiTree;
import Tree.TreeNode;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: Huffman
 * @类描述: 哈夫曼编码
 * @创建人: 权义翔
 * @创建时间: 2020/3/14 11:20
 **/
public class Huffman<T> extends BiTree {
    ListAndArray<TreeNode<T>> list = new ListAndArray<>();

    public Huffman() {
    }

    /**
     * @方法名 : Huffman
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/14 15:14
     * @功能描述 : 节点集合
     */
    public Huffman(T[] d) {
        for (int i = 0; i < d.length; i++) {
            TreeNode<T> node = new TreeNode<>();
            node.data = (T) d[i];
            list.addFirst(node);
        }
    }

    /**
     * @return : List.ListAndArray<List.TreeNode<T>>
     * @方法名 : getList
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/14 16:28
     * @功能描述 : 获取节点
     */
    public ListAndArray<TreeNode<T>> getList() {
        return list;
    }

    /**
     * @return : void
     * @方法名 : getMinLeftAndRightWeight
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/14 15:26
     * @功能描述 : 取两个最小权重的节点
     */
    public TreeNode<T> getMinWeight() {
        int length = list.length;

        TreeNode<T> node = new TreeNode<>();
        node.data = list.getElemByIndex(0).data;
        int index = 0;
        //取最小
        for (int i = 0; i < length; i++) {
            T tempTreeNode = list.getElemByIndex(i).data;
            if ((Integer) node.data >= (Integer) tempTreeNode) {
                //得到最小值下标
                node.data = tempTreeNode;
                index = i;
            }
        }
        //获取后续节点
        node = list.getElemByIndex(index);
        //移除取出点
        list.remove(index + 1);
        return node;
    }

    /**
     * @return : void
     * @方法名 : doHuffman
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/14 15:50
     * @功能描述 : Huffman编码
     */
    public void doHuffman() {
        while (list.length > 1) {
            //获取两个小节点
            TreeNode<T> leftTreeNode = getMinWeight();
            TreeNode<T> rightTreeNode = getMinWeight();
            leftTreeNode.flag = 0;
            rightTreeNode.flag = 1;
            //全部向右
            if (rightTreeNode.leftChild == null && rightTreeNode.rightChild == null) {
                TreeNode<T> temp;
                temp = leftTreeNode;
                leftTreeNode = rightTreeNode;
                rightTreeNode = temp;

                leftTreeNode.flag = 0;
                rightTreeNode.flag = 1;
            }

            //得到父节点
            TreeNode<T> parentTreeNode = new TreeNode<>();
            //设置左右孩子父节点
            leftTreeNode.parent=parentTreeNode;
            rightTreeNode.parent=parentTreeNode;
            //设置左右孩子
            parentTreeNode.leftChild = leftTreeNode;
            parentTreeNode.rightChild = rightTreeNode;
            parentTreeNode.data = (T) (Object) ((Integer) leftTreeNode.data + (Integer) rightTreeNode.data);
            list.addFirst(parentTreeNode);
        }
    }

    /**
     * @return : void
     * @方法名 : printHuffmanCode
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/14 18:57
     * @功能描述 : 打印编码(也可以获取叶子节点)
     */
    public void printHuffmanCode(TreeNode node) {
        if (node!=null&&node.leftChild==null&&node.rightChild==null) {
            printNodeOne(node);
        } else {
            printHuffmanCode(node.leftChild);
            printHuffmanCode(node.rightChild);
        }
    }

    /**
     * @return : void
     * @方法名 : printNodeOne
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/14 18:58
     * @功能描述 : 打印一个叶子
     */
    public void printNodeOne(TreeNode node) {
        System.out.print("(数据，编码)   "+node.data+" : "+node.flag);
        while (node.parent!=null){
            node=node.parent;
            if(node.parent!=null){
                System.out.print(node.flag);
            }
        }
        System.out.println();
    }
}