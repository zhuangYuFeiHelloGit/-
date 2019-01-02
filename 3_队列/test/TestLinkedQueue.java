import linked.LinkedQueue;
import linked.Node;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试基于链表的队列
 *
 * @author : zyf
 * @since : 2019-01-02 15:35
 **/
public class TestLinkedQueue {
    private LinkedQueue linkedQueue;

    @Before
    public void prepare(){
        linkedQueue = new LinkedQueue();
    }


    @Test
    public void t1(){
        linkedQueue.enqueue(new Node("a"));
        linkedQueue.enqueue(new Node("b"));

        System.out.println(linkedQueue.dequeue().getContent());
        System.out.println(linkedQueue.dequeue().getContent());
        linkedQueue.enqueue(new Node("c"));
        System.out.println(linkedQueue.dequeue().getContent());
    }
}
