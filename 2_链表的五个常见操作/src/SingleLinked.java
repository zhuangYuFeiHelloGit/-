import bean.Node;
import com.sun.istack.internal.NotNull;
import exception.EmptyLinkedException;
import exception.LinkedOutOfBoundsException;

/**
 * 单链表
 *
 * @author : zyf
 * @since : 2018-12-27 15:42
 **/
public class SingleLinked<E> {

    private Node<E> first;

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
     * 在 单链表 的头结点前添加一个结点
     * 也就是在哨兵后添加一个结点
     *
     * @param e
     */
    public void addFirst(@NotNull E e) {
        linkedFirst(new Node<>(e));
    }

    /**
     * 在 单链表 的尾结点后添加一个结点
     *
     * @param newNode
     */
    public void addLast(@NotNull Node<E> newNode) {
        linkedLast(newNode);
    }

    /**
     * 在 单链表 的尾结点后添加一个结点
     *
     * @param e
     */
    public void addLast(@NotNull E e) {
        linkedLast(new Node<>(e));
    }

    /**
     * 在插入 头结点前添加一个结点
     *
     * @param newNode
     */
    private void linkedFirst(@NotNull Node<E> newNode) {
        if (first == null) {
            first = newNode;
        } else {
            newNode.setNext(first);
            first = newNode;
        }
    }


    /**
     * 在尾结点后添加一个结点
     *
     * @param newNode
     */
    private void linkedLast(@NotNull Node<E> newNode) {

        if (first == null) {
            first = newNode;
        } else {
            Node<E> temp = first;
            while (temp != null) {

                Node<E> mayLast = temp.getNext();

                if (mayLast == null) {
                    //说明 temp 为尾结点
                    temp.setNext(newNode);
                }

                temp = mayLast;
            }
        }
    }


    /**
     * 移除第一个
     */
    public void removeFirst() {
        if (first == null) {
            throw new EmptyLinkedException();
        }
        Node<E> next = first.getNext();
        if (next == null) {
            first = null;
            return;
        }

        //原头结点指向null
        first.setNext(null);
        //next作为新的头结点
        first = next;
    }

    /**
     * 移除最后一个
     */
    public void removeLast() {
        if (first == null) {
            throw new EmptyLinkedException();
        }
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

        first = null;

    }


    /**
     * 链表的反转可以想象成摸石头过河那个游戏
     * 两只脚配上三块砖头就可以前进了
     * <p>
     * 每次循环做的事：
     * ①第一块砖头的next改变
     * ②三块砖头前移一个位置
     *
     * @return 反转后的单链表
     */
    public SingleLinked<E> reverse() {
        Node<E> realHead = first;
        //无结点
        if (realHead == null) {
            return this;
        }

        Node<E> temp = realHead.getNext();
        //只有一个头结点
        if (temp == null) {
            return this;
        }

        Node<E> flag = temp.getNext();

        //把realHead与其下一个结点的连接断开
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
        first = temp;

        return this;
    }

    public boolean hasCircle() {
        Node<E> fast = first;
        Node<E> slow = first;

        while (fast != null && fast.getNext() != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();

            if (fast == slow) {
                //说明有环，fast追到了 slow
                return true;
            }
        }

        return false;
    }

    /**
     * 这个好难啊
     *
     * @param n
     */
    public void removeAtFromEnd(int n) {
        if (n <= 0) {
            throw new UnsupportedOperationException("n必须大于0");
        }
        Node<E> beforeFirst = new Node<>();
        beforeFirst.setNext(first);

        //现在快慢指针都在 -1 位置呢（如果假设头结点为 0 ）
        Node<E> fast = beforeFirst;
        Node<E> slow = beforeFirst;

        //开始移动 fast 直到到达 size - n 的位置
        while (fast != null && n > -1) {
            fast = fast.getNext();
            n--;
        }

        if (n > -1) {
            //说明要删除的位置超过了链表的长度
            throw new LinkedOutOfBoundsException();
        }

        //当 fast 处于 n 的位置的时候
        //再让 slow 与 fast 一起移动
        //这样当 fast 移动到链表尾部 fast==null 为 true 时
        //slow 正好移动到 size - n 的位置
        while (fast != null) {
            fast = fast.getNext();
            slow = slow.getNext();
        }

        slow.setNext(slow.getNext().getNext());

    }

    /**
     * 使用快慢指针即可拿到中间结点
     * 快指针比慢指针多走一步即可
     *
     * @return
     */
    public Node<E> getMiddleNode() {
        if (first == null) {
            throw new EmptyLinkedException();
        }
        Node<E> fast = first;
        Node<E> slow = first;

        while (fast.getNext() != null && fast.getNext().getNext() != null) {

            fast = fast.getNext().getNext();
            slow = slow.getNext();
        }

        return slow;


    }

    public Node<E> getFirst() {
        return first;
    }


    public void show() {
        System.out.println(ergodic(first));
    }

    /**
     * 递归遍历链表
     *
     * @param node
     * @return
     */
    public String ergodic(Node<E> node) {
        if (node == null) {
            return "";
        }

        return node.getT() + ergodic(node.getNext());
    }

}
