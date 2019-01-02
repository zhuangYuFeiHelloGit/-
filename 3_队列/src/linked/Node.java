package linked;

/**
 * 链表结点
 *
 * @author : zyf
 * @since : 2019-01-02 15:29
 **/
public class Node {
    private String content;
    private Node next;

    public Node(String content) {
        this.content = content;
    }

    public Node(Node next) {
        this.next = next;
    }

    public Node(String content, Node next) {
        this.content = content;
        this.next = next;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
