package List;

import java.util.Arrays;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: ListAndArray
 * @类描述:
 * @创建人: 权义翔
 * @创建时间: 2020/3/4 21:21
 **/
public class ListAndArray<T> {
    final int INIT_SIZE = 10;
    final float INCREMENT = 1.5f;
    public T[] elem;
    public int length;
    public int Size;

    /**
     * @return :
     * @方法名 : ListAndArray
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/4 22:19
     * @功能描述 : 默认空间初始化数组
     */
    public ListAndArray() {
        this.elem = (T[]) new Object[INIT_SIZE];
        this.length = 0;
        this.Size = INIT_SIZE;
    }

    /**
     * @return :
     * @方法名 : ListAndArray
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/4 22:19
     * @功能描述 : 指定空间初始化数组
     */
    public ListAndArray(int initLength) {
        this.elem = (T[]) new Object[initLength];
        this.length = 0;
        this.Size = initLength;
    }

    /**
     * @return :
     * @方法名 : ListAndArray
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/4 22:23
     * @功能描述 : 数组转MyArrayList
     */
    public ListAndArray(T arr[]) {
        elem = arr;
        length = arr.length;
        Size = arr.length;
    }


    /**
     * @return : List.ListAndArray
     * @方法名 : convert
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/4 22:23
     * @功能描述 : 指定空间初始化数组
     */
    public ListAndArray convert(T arr[]) {
        ListAndArray L = new ListAndArray(arr.length);
        for (int i = 0; i < arr.length; ++i) {
            L.elem[i] = arr[i];
        }
        L.length = arr.length;
        return L;
    }

    /**
     * @return : int
     * @方法名 : get
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/4 22:24
     * @功能描述 : 根据元素返回。第一个匹配位置(不是数组下标)
     */
    public int getIndexByElem(T e) {
        int pos = -1;
        for (int i = 0; i < this.length; ++i) {
            if (e.toString().compareTo(this.elem[i].toString()) == 0) {
                return i + 1;
            }
        }
        return pos;
    }

    /**
     * @return : int
     * @方法名 : remove
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/4 22:25
     * @功能描述 : 移除指定位置元素,下标从1开始
     */
    public T remove(int pos) {
        //是否越界
        if (pos > this.length || pos < 1) {
            return null;
        }
        T e = this.elem[pos - 1];
        for (int i = pos - 1; i < this.length; ++i) {
            if (i == this.length - 1) {
                //最后一个，即将越界
                this.elem[i] = null;
            } else {
                this.elem[i] = this.elem[i + 1];
            }
        }
        this.length--;
        return e;
    }

    /**
     * @return : T
     * @方法名 : removeLast
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/15 11:39
     * @功能描述 : 移除最后一个
     */
    public T removeLast() {
        return remove(this.length);
    }

    /**
     * @return : void
     * @方法名 : clear
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/4 22:25
     * @功能描述 : 清空
     */
    public void clear() {
        this.length = 0;
        this.elem = (T[]) new Object[this.Size];
    }

    /**
     * @return : int
     * @方法名 : add
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/4 22:26
     * @功能描述 : 根据位置pos插入元素e 从第一个位置开始插入1
     */
    public int add(int pos, T e) {
        //是否越界
        if (pos > this.length + 1 || pos < 1) {
            return -1;
        }

        ListAndArray L = this;
        //空间不足，则1.5倍扩容
        if (this.length == this.Size) {
            L = new ListAndArray((int) (this.Size * INCREMENT));
            for (int i = 0; i < this.length; ++i) {
                L.elem[i] = this.elem[i];
            }
            L.length = this.length;
        }
        //把pos位置后元素后移一位,腾出pos
        for (int i = L.length; i >= pos; --i) {
            L.elem[i] = L.elem[i - 1];
        }
        //插入
        L.elem[pos - 1] = e;
        //长度+1
        L.length++;
        return 1;
    }

    /**
     * @return : void
     * @方法名 : sort
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/4 22:27
     * @功能描述 : 排序
     */
    public void sort(int... sort) {
        int sortType = 1;
        if (sort.length == 0) {
            sortType = 0;
        }
        if (this.length == 0) {
            return;
        }
        //冒泡排序
        for (int i = 0; i < this.length - 1; ++i) {
            for (int j = 0; j < length - i - 1; ++j) {
                if (sortType == 0) {
                    //升序
                    if (this.elem[j].toString().compareTo(this.elem[j + 1].toString()) > 0) {
                        commonSwap(this, j, j + 1);
                    }
                } else {
                    //降序
                    if (this.elem[j].toString().compareTo(this.elem[j + 1].toString()) < 0) {
                        commonSwap(this, j, j + 1);
                    }
                }

            }
        }
    }

    /**
     * @return : void
     * @方法名 : commonSwap
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/4 22:27
     * @功能描述 : 公共交换方法
     */
    public void commonSwap(ListAndArray L, int m, int n) {
        T temp = null;
        temp = (T) L.elem[m];
        L.elem[m] = L.elem[n];
        L.elem[n] = temp;
    }

    /**
     * @return : List.ListAndArray
     * @方法名 : mergeList
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/4 22:27
     * @功能描述 : 合并有序表
     */
    public static ListAndArray mergeList(ListAndArray L_a, ListAndArray L_b) {
        ListAndArray L_c = new ListAndArray(L_a.length + L_b.length);
        L_c.length = L_c.Size;
        int i = 0;
        int j = 0;
        //未越界
        while (i < L_a.length && j < L_b.length) {
            if (L_a.elem[i].toString().compareTo(L_b.elem[j].toString()) < 0) {
                L_c.elem[i + j] = L_a.elem[i];
                i++;
            } else {
                L_c.elem[i + j] = L_b.elem[j];
                j++;
            }
        }
        //越界剩余到L_c
        if (L_a.length > i) {
            while (i < L_a.length) {
                L_c.elem[i + j] = L_a.elem[i];
                i++;
            }
        }
        if (L_b.length > j) {
            while (j < L_b.length) {
                L_c.elem[i + j] = L_b.elem[j];
                j++;
            }
        }
        return L_c;
    }

    /**
     * @return : void
     * @方法名 : addFirst
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 23:48
     * @功能描述 : 首行加
     */
    public void addFirst(T e) {
        add(1, e);
    }

    /**
     * @return : void
     * @方法名 : addLast
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/5 23:49
     * @功能描述 : 尾行加
     */
    public void addLast(T e) {
        add(this.length + 1, e);
    }

    /**
     * @return : List.ListAndLink
     * @方法名 : toListAndLink
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 0:46
     * @功能描述 : 数组转链表
     */
    public ListAndLink toListAndLink() {
        ListAndLink listAndLink = new ListAndLink();
        listAndLink.create_Head(this.length);
        Node p = listAndLink.node.nextNode;
        for (int i = 0; i < this.length; i++) {
            p.data = this.elem[i];
            p = p.nextNode;
        }
        return listAndLink;
    }

    /**
     * @return : T
     * @方法名 : getElemByIndex
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:38
     * @功能描述 : 下标从0开始
     */
    public T getElemByIndex(int index) {
        index = (index >= 0 && index < this.length) ? index : -1;
        if (index == -1) {
            throw new RuntimeException("不存在的元素");
        }
        return this.elem[index];
    }

    @Override
    public String toString() {
        return "ListAndArray{" +
                "INIT_SIZE=" + INIT_SIZE +
                ", INCREMENT=" + INCREMENT +
                ", length=" + length +
                ", Size=" + Size +
                ", elem=        " + Arrays.toString(elem) +
                '}';
    }
}