import bean.Node;
import com.sun.istack.internal.NotNull;
import exception.NullLinkedException;

/**
 * 单链表
 *
 * @author : zyf
 * @since : 2018-12-27 15:42
 **/
public class SingleLinked<E> {

    //使用哨兵简化操作
    //此结点不保存数据
    //真正的头结点为：first.getNext()
    private Node<E> first;

    public SingleLinked() {
        //这里给head一个对象，就不需要判空了
        first = new Node<>();
    }

    /**
     * 在 单链表 的头结点前添加一个结点
     * 也就是在哨兵后添加一个结点
     *
     * @param newNode
     */
    public void addFirst(@NotNull Node<E> newNode) {
        linkedFirst(newNode);

    }

    /**
     * 在 单链表 的尾结点后添加一个结点
     *
     * @param newNode
     */
    public void addLast(@NotNull Node<E> newNode) {
        linkedLast(newNode);
    }

    private void linkedFirst(@NotNull Node<E> newNode) {
        newNode.setNext(first.getNext());
        first.setNext(newNode);
    }

    private void linkedLast(@NotNull Node<E> newNode) {
        Node<E> temp = first;

        while (temp != null) {

            Node<E> mayLast = temp.getNext();

            if (mayLast == null) {
                //说明 temp 为尾结点
                temp.setNext(newNode);
                return;
            } else {
                //不是尾结点则继续遍历
                temp = mayLast;
            }

        }
    }


    /**
     * 此处不做判空处理是因为使用了哨兵机制
     * 因为哨兵的存在，只要用户向链表中添加过element
     * 那么first.getNext()就不会为空
     * 若用户没添加过，那么正常的逻辑就应该出问题，告诉用户出问题了
     * 而不是我们自己在这里处理掉
     * <p>
     * 或者判空后抛出自定义异常也可以
     */
    public void removeFirst() {
        if (first.getNext() == null) {
            throw new NullLinkedException();
        }
        first.setNext(first.getNext().getNext());
    }

    public void removeLast() {
        Node<E> temp = first;

        while (temp.getNext() != null) {

            Node<E> t = temp.getNext();
            if (t.getNext() == null) {
                temp.setNext(null);
                return;
            } else {
                temp = t;
            }
        }
        throw new NullLinkedException();
    }


    /**
     * 链表的反转可以想象成摸石头过河那个游戏
     * 两只脚配上三块砖头就可以前进了
     *
     * 每次循环做的事：
     *  ①第一块砖头的next改变
     *  ②三块砖头前移一个位置
     *
     * @return 反转后的单链表
     */
    public SingleLinked<E> reverse() {
        Node<E> realHead = first.getNext();
        Node<E> temp = realHead.getNext();
        Node<E> flag = temp.getNext();

        realHead.setNext(null);

        //一次循环，只改变一个结点的指针反转
        //剩下就是temp flag 等引用的变化
        while (flag != null) {
            temp.setNext(realHead);
            realHead = temp;

            temp = flag;

            flag = flag.getNext();
        }

        temp.setNext(realHead);
        first.setNext(temp);

        return this;
    }

    public boolean hasCircle(){
        Node<E> fast = first.getNext();
        Node<E> slow = first.getNext();

        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if(fast == slow){
                //说明有环，fast追到了 slow
                return true;
            }
        }

        return false;
    }




    public Node<E> getFirst(){
        return first.getNext();
    }


    public void show(){
        System.out.println(ergodic(first.getNext()));
    }

    /**
     * 递归遍历链表
     * @param node
     * @return
     */
    public String ergodic(Node<E> node){
        if(node == null){
            return "";
        }

        return node.getT() + ergodic(node.getNext());
    }


}
