package List.Queue;

import List.ListAndArray;

import java.util.Arrays;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: ArrayQueue
 * @类描述: 数组队列（FIFO）,但是与真正的队效率有差异。
 *             基于数组，不存在空间浪费。这也不是循环队。
 *             有较高时间复杂度。
 *             优点：逻辑清晰。不需要绕来绕去的循环队列
 *             ，担心空间浪费。
 * @创建人: 权义翔
 * @创建时间: 2020/3/6 19:03
 **/
public class ArrayQueue<T> extends ListAndArray {
    public ArrayQueue() {
    }

    public ArrayQueue(int initLength) {
        super(initLength);
    }

    public ArrayQueue(Object[] arr) {
        super(arr);
    }

    /**
     * @return : void
     * @方法名 : clear
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:25
     * @功能描述 : 队列清空
     */
    public void clear() {
        super.clear();
    }

    /**
     * @return : Boolean
     * @方法名 : isEmpty
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:26
     * @功能描述 : 栈空
     */
    public Boolean isEmpty() {
        return this.length == 0;
    }

    /**
     * @return : T
     * @方法名 : getTop
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:27
     * @功能描述 : 获取队尾元素
     */
    public T getTail() {
        return (T) this.getElemByIndex(this.length - 1);
    }

/**
 * @方法名 : getTail
 * @创建人 : 权义翔
 * @创建日期 : 2020/3/8 14:35
 * @功能描述 : 获取队头元素
 *
 * @return : T
 */
    public T getHead() {
        return (T) this.getElemByIndex(0);
    }

    /**
     * @return : int
     * @方法名 : getLength
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:29
     * @功能描述 : 获取栈长
     */
    public int getLength() {
        return this.length;
    }

    /**
     * @return : void
     * @方法名 : push
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:30
     * @功能描述 : 进队
     */
    public void enQueue(int e) {
        this.addLast(e);
    }

    /**
     * @return : T
     * @方法名 : deQueue
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:31
     * @功能描述 : 出队
     */
    public T deQueue() {
        if (this.length != 0) {
            return (T) this.remove(1);
        }
        return null;
    }

    @Override
    public String toString() {
        return "ArrayQueue{" +
                "elem=" + Arrays.toString(elem) +
                ", length=" + length +
                ", Size=" + Size +
                '}';
    }
}