/**
 * 元素结点
 *
 * @author : zyf
 * @since : 2018-12-26 17:43
 **/
public class Node {
    private int value;
    private Node next;

    public Node(int value) {
        this.value = value;
    }

    public Node() {
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
