package loop;

import exception.EmptyQueueException;

/**
 * 循环队列
 *
 * @author : zyf
 * @since : 2019-01-02 18:04
 **/
public class LoopQueue {
    private String[] items;
    private int n;
    private int head;
    private int tail;


    public LoopQueue(int n) {
        items = new String[n];
        this.n = n;
        head = 0;
        tail = 0;
    }

    public boolean enqueue(String item){
        //根据推导出的 (tail+1)%n=head 判断是否已满
        if((tail+1)%n == head){
            return false;
        }

        //没满的话
        //存值
        items[tail] = item;
        // tail 后移一位，并且在后移时要注意判断边界问题
        if(tail == n - 1){
            tail = 0;
        }else {
            tail++;
        }

        return true;
    }

    public String dequeue(){
        //出队之前，要判断边界问题
        if(head == tail){
            //说明队列为空
            throw new EmptyQueueException();
        }
        //出队，tail都不用动。。。
        String item = items[head];
        if(head == n-1){
            head = 0;
        }else {
            head++;
        }

        return item;
    }
}
