package bean;

/**
 * 结点
 *
 * @author : zyf
 * @since : 2018-12-27 15:42
 **/
public class Node<T> {
    private T t;
    private Node<T> next;

    public Node(T t) {
        this.t = t;
    }

    public Node() {
    }

    public Node(T t, Node<T> next) {
        this.t = t;
        this.next = next;
    }

    public Node(Node<T> next) {
        this.next = next;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        String s= "";

        //哨兵的t为null，此处判断一下是否为哨兵
        if(t != null){
            s = t.toString();
        }

        if(next != null){
            s += next.toString();
        }
        return s;
    }
}
