package List.Stack;

import List.ListAndLink;

/**
 * @项目名称: DATA_STRUCTURE
 * @类名称: LinkStack
 * @类描述: 链表栈
 * @创建人: 权义翔
 * @创建时间: 2020/3/6 1:12
 **/
public class LinkStack<T> extends ListAndLink {
    public LinkStack() {
        super();
    }

    /**
     * @return : int
     * @方法名 : getTop
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 18:50
     * @功能描述 : 获取栈顶元素
     */
    public T getTop() {
        return (T)this.getElemByIndex(this.getLength());
    }

    /**
     * @return : int
     * @方法名 : getLength
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 18:54
     * @功能描述 : 获取栈长
     */
    public int getLength() {
        return super.getLength();
    }

    /**
     * @return : void
     * @方法名 : push
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 18:55
     * @功能描述 : 入栈
     */
    public void push(T e) {
        this.addLast(e);
    }

    /**
     * @return : void
     * @方法名 : pop
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 18:55
     * @功能描述 : 出栈
     */
    public T pop() {
        if (this.getLength() != 0) {
            return (T)this.remove(this.getLength());
        }
        return null;
    }

    /**
     * @return : void
     * @方法名 : clear
     * @创建人 : 权义翔
     * @创建日期 : 2020/3/6 18:56
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
        return this.getLength() == 0;
    }

    @Override
    public String toString() {
        return "LinkStack{" + super.toString() + "}";
    }
}