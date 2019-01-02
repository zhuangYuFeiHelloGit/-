import loop.LoopQueue;
import org.junit.Before;
import org.junit.Test;

/**
 * 测试循环队列
 *
 * @author : zyf
 * @since : 2019-01-02 18:16
 **/
public class TestLoopQueue {
    private LoopQueue loopQueue;

    @Before
    public void prepare(){
        loopQueue = new LoopQueue(5);
    }

    @Test
    public void t1(){
        loopQueue.enqueue("a");
        loopQueue.enqueue("b");
        loopQueue.enqueue("c");
        loopQueue.enqueue("d");
        //被装满了后，e f 就装不进去了
        loopQueue.enqueue("e");
        loopQueue.enqueue("f");

        try {
            String fromQueue = null;
            do {
                fromQueue = loopQueue.dequeue();
                System.out.println(fromQueue);
            }while (fromQueue != null);
        }catch (RuntimeException e){
            System.out.println("队列被取光了");
        }
    }
}
