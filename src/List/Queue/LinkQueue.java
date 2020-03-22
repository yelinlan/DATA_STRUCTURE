package List.Queue;

import List.ListAndLink;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: LinkQueue
 * @类描述:
 * @创建人: 权义翔
 * @创建时间: 2020/3/8 14:46
 **/
public class LinkQueue<T> extends ListAndLink {
    public LinkQueue() {
    }

    /**
     * @return : T
     * @方法名 : getTop
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:48
     * @功能描述 : 获取队尾元素
     */
    public T getTail() {
        return (T) this.getElemByIndex(this.getLength());
    }

    /**
     * @return : T
     * @方法名 : getTail
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:57
     * @功能描述 : 获取队头元素
     */
    public T getHead() {
        return (T) this.getElemByIndex(1);
    }

    /**
     * @return : int
     * @方法名 : getLength
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:49
     * @功能描述 : 取队长
     */
    public int getLength() {
        return super.getLength();
    }

    /**
     * @return : void
     * @方法名 : push
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:49
     * @功能描述 : 进队
     */
    public void enQueue(T e) {
        this.addLast(e);
    }

    /**
     * @return : T
     * @方法名 : pop
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:50
     * @功能描述 : 出队
     */
    public T deQueue() {
        if (this.getLength() != 0) {
            return (T) this.remove(1);
        }
        return null;
    }

    /**
     * @return : void
     * @方法名 : clear
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:55
     * @功能描述 : 队清空
     */
    public void clear() {
        super.clear();
    }

    /**
     * @return : java.lang.Boolean
     * @方法名 : isEmpty
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/8 14:55
     * @功能描述 : 队空
     */
    public Boolean isEmpty() {
        return this.getLength() == 0;
    }
}