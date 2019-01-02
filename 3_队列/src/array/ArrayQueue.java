package array;

/**
 * 使用数组实现的队列
 *
 * @author : zyf
 * @since : 2019-01-02 13:57
 **/
public class ArrayQueue {

    /**
     * 数组：items，数组大小：n
     */
    private String[] items;
    private int n = 0;

    /**
     * head 表示队头在数组中的下标
     * tail 表示队尾在数组中的下标
     */
    private int head = 0;
    private int tail = 0;

    /**
     * 申请一个大小为 capacity 的数组
     *
     * @param capacity
     */
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        this.n = capacity;
    }

    /**
     * 入队
     *
     * @param item
     * @return
     */
    public boolean enqueue(String item) {
//        version：1
//        if(tail == n){
//            填满了
//            return false;
//        }
//
//        items[tail++] = item;
//        return true;

//        version：2
        if (tail == n) {
            //当 tail == n && head==0 为true时，
            // 说明对头在数组0位置队尾在数组末尾，此时数组是占满状态
            //返回false 表示不可再添加数据了
            if (head == 0) return false;

            //如果head不等于0，而队尾处于数组末尾，说明执行过出队操作
            //那么需要进行数据迁移，将head位置的元素，移到数组0位置
            for (int i = head; i < tail; i++) {
                items[i - head] = items[i];
            }

            //数据搬移完毕，更新 head 和 tail 这两个指针
            tail -= head;
            head = 0;
        }

        //数据搬移完毕，（或 tail != n 无需搬移）
        //执行添加操作
        items[tail++] = item;
        return true;

    }

    public String dequeue() {
        if (head == tail) {
            //表示队列为空
            return null;
        }

        return items[head++];
    }
}
