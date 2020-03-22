package Tree;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: BiTree
 * @类描述: 二叉树
 * @创建人: 权义翔
 * @创建时间: 2020/3/8 23:39
 **/
public class BiTree<T> {
    //头节点
    public TreeNode<T> TNode = new TreeNode<>();
    public int j = 0;
    public String[] treeStr;

    public BiTree() {
    }

    public BiTree(String[] str) {
        treeStr = str;
    }

    /**
     * @return : void
     * @方法名 : clear
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/9 19:21
     * @功能描述 : 清空树
     */
    public void clear() {
        this.TNode.nextTreeNode = null;
    }

    /**
     * @return : boolean
     * @方法名 : isEmpty
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/9 19:26
     * @功能描述 : 树空
     */
    public boolean isEmpty() {
        return null == this.TNode.nextTreeNode;
    }

    /**
     * @return : void
     * @方法名 : levelTravel
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/14 0:28
     * @功能描述 :层次创建
     */
    public void createlevelTree(TreeNode node, int level) {
        for (int i = 1; i <= level; i++) {
            createLevelOne(node, i);
        }
    }

    /**
     * @return : void
     * @方法名 : levelOne
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/14 0:35
     * @功能描述 : 最后一层数据 创建
     */
    public void createLevelOne(TreeNode node, int level) {
        //所有节点数据
        if (level == 1) {
            //如果是最后一层
            T ch = (T) treeStr[j++];
            if (!"Q".equals(ch.toString())) {
                node.data = ch;
            }
        } else {
            //否则递归到下层
            if (node != null && node.data != null) {
                if (node.leftChild == null) {
                    node.leftChild = new TreeNode<>();
                    node.leftChild.parent = node;
                }
                createLevelOne(node.leftChild, level - 1);
                if (node.rightChild == null) {
                    node.rightChild = new TreeNode<>();
                    node.rightChild.parent = node;
                }
                createLevelOne(node.rightChild, level - 1);
            }

        }
    }


    /**
     * @return : void
     * @方法名 : createTree
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/9 20:47
     * @功能描述 : 先序创建二叉树
     */
    public void createFirstTree(TreeNode<T> node) {
        T ch = (T) treeStr[j++];
        if (!"Q".equals(ch.toString())) {
            node.data = ch;
            node.leftChild = new TreeNode<>();
            node.leftChild.parent = node;
            createFirstTree(node.leftChild);
            node.rightChild = new TreeNode<>();
            node.rightChild.parent = node;
            createFirstTree(node.rightChild);
        }
    }

    /**
     * @return : void
     * @方法名 : createLastTree
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/13 23:11
     * @功能描述 : 中序创建二叉树
     */
    public void createMiddleTree(TreeNode<T> node) {
        T ch = (T) treeStr[j++];
        if (!"Q".equals(ch.toString())) {
            node.leftChild = new TreeNode<>();
            node.leftChild.parent = node;
            createFirstTree(node.leftChild);
            node.data = ch;
            node.rightChild = new TreeNode<>();
            node.rightChild.parent = node;
            createFirstTree(node.rightChild);
        }
    }

    /**
     * @return : void
     * @方法名 : createTree
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/9 20:47
     * @功能描述 : 后序创建二叉树
     */
    public void createLastTree(TreeNode<T> node) {
        T ch = (T) treeStr[j++];
        if (!"Q".equals(ch.toString())) {
            node.leftChild = new TreeNode<>();
            node.leftChild.parent = node;
            createFirstTree(node.leftChild);
            node.rightChild = new TreeNode<>();
            node.rightChild.parent = node;
            createFirstTree(node.rightChild);
            node.data = ch;
        }
    }

    /**
     * @return : void
     * @方法名 : Traverse
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/9 22:24
     * @功能描述 : 先序遍历
     */
    public void firstTraverse(TreeNode node) {
        //拥有数据即为节点
        //没有数据即包含空节点
        if (node != null && node.data != null) {
            System.out.println(node.data);
            firstTraverse(node.leftChild);
            firstTraverse(node.rightChild);
        }
    }

    /**
     * @return : void
     * @方法名 : Traverse
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/9 22:24
     * @功能描述 : 中序遍历
     */
    public void secondTraverse(TreeNode node) {
        if (node != null && node.data != null) {
            secondTraverse(node.leftChild);
            System.out.println(node.data);
            secondTraverse(node.rightChild);
        }
    }

    /**
     * @return : void
     * @方法名 : Traverse
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/9 22:25
     * @功能描述 : 后序遍历
     */
    public void lastTraverse(TreeNode node) {
        if (node != null && node.data != null) {
            lastTraverse(node.leftChild);
            lastTraverse(node.rightChild);
            System.out.println(node.data);
        }
    }

    /**
     * @return : void
     * @方法名 : levelTravel
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/14 0:28
     * @功能描述 :层次遍历
     */
    public void levelTravel(TreeNode node) {
        int level = biTreeDepth(node);
        System.out.println("(数据，标志)");
        for (int i = 1; i <= level; i++) {
            levelOne(node, i);
            System.out.println();
        }
    }

    /**
     * @return : void
     * @方法名 : levelOne
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/14 0:35
     * @功能描述 : 最后一层数据 先序输出
     */
    public void levelOne(TreeNode node, int level) {
        //所有节点数据
        if (node != null && node.data != null) {
            if (level == 1) {
                //如果是最后一层
                System.out.print("  ("+node.data + "-");
                System.out.print(node.flag + ") ");
            } else {
                //否则递归到下层
                levelOne(node.leftChild, level - 1);
                levelOne(node.rightChild, level - 1);
            }
        }
    }

    /**
     * @return : void
     * @方法名 : biTreeDepth
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/13 22:44
     * @功能描述 : 二叉树深度
     */
    public int biTreeDepth(TreeNode node) {
        if (node == null || node.data == null) {
            //如果是叶子
            return 0;
        } else {
            //否则递归调用左右孩子
            int left = biTreeDepth(node.leftChild);
            int right = biTreeDepth(node.rightChild);
            //取最大深度返回上一层+1
            return left > right ? left + 1 : right + 1;
        }
    }

    /**
     * @return : List.TreeNode<T>
     * @方法名 : getRoot
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/13 23:41
     * @功能描述 : 返回根节点
     */
    public TreeNode<T> getRoot() {
        return TNode;
    }
}