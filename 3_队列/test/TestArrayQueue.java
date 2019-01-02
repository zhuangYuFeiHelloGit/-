import array.ArrayQueue;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试
 *
 * @author : zyf
 * @since : 2019-01-02 14:04
 **/
public class TestArrayQueue {

    private ArrayQueue arrayQueue;

    @Before
    public void prepare(){
        arrayQueue = new ArrayQueue(5);

    }

    @Test
    public void t1(){
        arrayQueue.enqueue("呵呵呵");
        String dequeue = arrayQueue.dequeue();
        System.out.println(dequeue);
        dequeue = arrayQueue.dequeue();
        System.out.println(dequeue);
    }


}
