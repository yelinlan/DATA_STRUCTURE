package Tree.TreeApply;

import List.ListAndArray;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: ChildSet
 * @类描述:
 * @创建人: 权义翔
 * @创建时间: 2020/3/14 19:27
 **/
public class ChildSet<T> {
    public ListAndArray<T> list;
    public ListAndArray<T> listOut;
    public int index;
    public ChildSet() {
    }

    /**
     * @return :
     * @方法名 : ChildSet
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/14 19:40
     * @功能描述 : 构造集合
     */
    public ChildSet(T[] elem) {
        list = new ListAndArray<>(elem);
        listOut = new ListAndArray<>(elem.length);

    }

    /**
     * @return : void
     * @方法名 : doChildSet
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/14 19:42
     * @功能描述 : 搜索集合的幂集
     */
    public void doChildSet(ListAndArray<T> list, ListAndArray<T> listOut, T count) {
        //抉择第count个元素
        if ((int) (Object) count >= list.length) {
            System.out.println("set:  "+(++index)+"-->" + listOut);
        } else {
            //取出第count个元素
            T elem = list.getElemByIndex((int) (Object) count);
            //加入最后（选择）
            listOut.addLast(elem);
            doChildSet(list, listOut, (T) (Object) ((int) (Object) (count) + 1));
            //移除最后（不选择）
            listOut.removeLast();
            doChildSet(list, listOut, (T) (Object) ((int) (Object) (count) + 1));
        }
    }
}