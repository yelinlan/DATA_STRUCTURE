package List;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: ListAndLink
 * @类描述: 链表
 * @创建人: 权义翔
 * @创建时间: 2020/3/4 23:06
 **/
public class ListAndLink<T> {
   protected Node<T> node = new Node<>();
    /**
     * @方法名 : create_Head
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/4 23:06
     * @功能描述 : 链表创建(头插法)
     */
    public void create_Head(int n) {
        Node q = this.node;
        for (int i = 0; i < n; ++i) {
            Node p = new Node();
            p.nextNode = q.nextNode;
            q.nextNode = p;
        }
    }

    /**
     * @方法名 : create_tail
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 22:28
     * @功能描述 : 链表创建(尾插法)
     */
    public void create_tail(int n) {
        Node q = this.node;
        for (int i = 0; i < n; ++i) {
            //创建在里面，外面会死循环，用的同一个p,无意义。
            Node p = new Node();
            q.nextNode = p;
            q = q.nextNode;
        }
    }

    /**
     * @方法名 : clear
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 22:32
     * @功能描述 : 清空
     */
    public void clear() {
        this.node.nextNode = null;
    }

    /**
     * @方法名 : remove
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 22:33
     * @功能描述 : 链表的删除，下标从1开始
     */
    public T remove(int pos) {
        Node p = this.node;
        int i = 0;
        //查找pos
        while (p != null && i < pos - 1) {
            p = p.nextNode;
            i++;
        }
        //如果越界（左<-----p---->右）
        if (p == null || i > pos - 1) {
            return null;
        }
        if (p.nextNode == null) {
            return null;
        }
        T e = (T)p.nextNode.data;
        p.nextNode = p.nextNode.nextNode;
        return e;
    }

    /**
     * @方法名 : add
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 22:36
     * @功能描述 : 在pos>0位置插入e元素
     */
    public int add(int pos, T e) {
        Node p = this.node;
        int i = 0;
        //查找pos
        while (p != null && i < pos - 1) {
            p = p.nextNode;
            i++;
        }
        //如果越界（左<-----p---->右）
        if (p == null || i > pos - 1) {
            return -1;
        }
        //插入
        Node q = new Node();
        q.data = e;
        q.nextNode = p.nextNode;
        p.nextNode = q;
        return 1;
    }

    /**
     * @方法名 : sort
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 22:38
     * @功能描述 :     排序 0 升序(左到右增加)1 *  降序(左到右减少) 只适用于字符串
     */
    public void sort(int... sort) {
        int sortType = 1;
        if (sort.length == 0) {
            sortType = 0;
        }
        Node p = this.node;
        if (p.nextNode == null) {
            return;
        }
        //冒泡排序
        int len = this.getLength();
        for (int i = 1; i < len; ++i) {
            for (int j = 1; j < len - i + 1; ++j) {
                if (sortType == 0) {
                    if (getElemByIndex(j).toString().compareTo(getElemByIndex(j + 1).toString())>0) {
                        T a = getElemByIndex(j);
                        T b = getElemByIndex(j + 1);
                        setElemByIndex(j, b);
                        setElemByIndex(j + 1, a);
                    }
                } else {
                    if (getElemByIndex(j).toString().compareTo(getElemByIndex(j + 1).toString())<0) {
                        T a = getElemByIndex(j);
                        T b = getElemByIndex(j + 1);
                        setElemByIndex(j, b);
                        setElemByIndex(j + 1, a);
                    }
                }
            }
        }

    }

    /**
     * @方法名 : setElemByIndex
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 22:41
     * @功能描述 : 下标设置元素
     */
    public void setElemByIndex(int pos, T e) {
        Node p = this.node;
        int i = 0;
        while (p != null && i < pos) {
            p = p.nextNode;
            i++;
        }
        if (p == null || i > pos) {
            return;
        }
        p.data = e;
    }

    /**
     * @方法名 : getElemByIndex
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 22:41
     * @功能描述 : 下标获取元素 下标从1开始
     */
    public T getElemByIndex(int pos) {
        Node p = this.node;
        int i = 0;
        while (p != null && i < pos) {
            p = p.nextNode;
            i++;
        }
        if (p == null || i > pos) {
            return null;
        }
        return (T)p.data;
    }

    /**
     * @方法名 : getLength
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 22:40
     * @功能描述 : 获取链表长度
     */
    public int getLength() {
        Node p = this.node;
        int len = 0;
        while (p != null) {
            p = p.nextNode;
            len++;
        }
        return len - 1;
    }

    /**
     * @方法名 : mergeList
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 22:44
     * @功能描述 : 合并有序链表
     */
    public void mergeList(ListAndLink La, ListAndLink Lb) {
        Node pc = this.node;
        Node pa = La.node;
        Node pb = Lb.node;
        pa = pa.nextNode;
        pb = pb.nextNode;
        while (pa != null && pb != null) {
            if (pa.data.toString().compareTo(pb.data.toString()) > 1) {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                pc.data = pb.data;
                pb = pb.nextNode;
            } else {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                pc.data = pa.data;
                pa = pa.nextNode;
            }
        }
        if (pb != null) {
            while (pb != null) {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                pc.data = pb.data;
                pb = pb.nextNode;
            }

        }
        if (pa != null) {
            while (pa != null) {
                Node Lnode = new Node();
                pc.nextNode = Lnode;
                pc = pc.nextNode;
                pc.data = pa.data;
                pa = pa.nextNode;

            }
        }
    }

    /**
     * @return : List.ListAndArray
     * @方法名 : toListAndArray
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 23:50
     * @功能描述 : ；链表转数组
     */
    public ListAndArray toListAndArray() {
        ListAndArray listAndArray = new ListAndArray(this.getLength());
        Node p = this.node;
        while (p.nextNode != null) {
            p = p.nextNode;
            listAndArray.addLast(p.data);
        }
        return listAndArray;
    }

    /**
     * @return : void
     * @方法名 : addFirst
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 23:53
     * @功能描述 : 首行加
     */
    public void addFirst(T e) {
        this.add(1, e);
    }

    /**
     * @方法名 : addLast
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 23:55
     * @功能描述 : 尾行加
     *
     * @return : void
     */
    public void addLast(T e) {
        this.add(this.getLength()+1, e);
    }

    @Override
    public String toString() {
        String s = "[   ";
        Node p = this.node;
        while (p.nextNode != null) {
            p = p.nextNode;
            s = s + p.data.toString() + ",";
        }
        int len = s.length();
        s=s.substring(0,len-1);
        s = s + "   ]";
        return "ListAndLink{" +
                "node=" + s +
                "}";
    }
}