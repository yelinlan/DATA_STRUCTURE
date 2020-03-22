package List.Stack;

import List.ListAndArray;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: ArrayStack
 * @类描述: 数组实现栈
 * @创建人: 权义翔
 * @创建时间: 2020/3/6 0:31
 **/
public class ArrayStack<T> extends ListAndArray {

    public ArrayStack() {
        super();
    }

    public ArrayStack(int initLength) {
        super(initLength);
    }

    public ArrayStack(T[] arr) {
        super(arr);
    }

    /**
     * @return : int
     * @方法名 : getTop
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 0:53
     * @功能描述 : 获取栈顶元素
     */
    public T getTop() {
        return (T)this.getElemByIndex(this.length - 1);
    }

    /**
     * @return : int
     * @方法名 : getLength
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 0:56
     * @功能描述 : 获取栈长
     */
    public int getLength() {
        return this.length;
    }

    /**
     * @return : void
     * @方法名 : push
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 0:57
     * @功能描述 : 入栈
     */
    public void push(int e) {
        this.addLast(e);
    }

    /**
     * @return : void
     * @方法名 : pop
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 1:01
     * @功能描述 : 出栈
     */
    public T pop() {
        if (this.length != 0) {
            return (T)this.remove(this.length);
        }
        return  null;
    }

    /**
     * @return : void
     * @方法名 : clear
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 1:02
     * @功能描述 : 栈清空
     */
    public void clear() {
        super.clear();
    }

    /**
     * @return : java.lang.Boolean
     * @方法名 : isEmpty
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 19:25
     * @功能描述 :栈空
     */
    public Boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public String toString() {
        return "ArrayStack{" + super.toString() + "}";
    }
}