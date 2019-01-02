package linked;

import exception.EmptyQueueException;

/**
 * 基于链表实现的队列
 *
 * @author : zyf
 * @since : 2019-01-02 15:30
 **/
public class LinkedQueue {
    private Node head;
    private Node tail;

    public void enqueue(Node newNode){
        if(head == null){
            head = newNode;
        }else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public Node dequeue(){
        if(head == null){
            throw new EmptyQueueException();
        }
        Node result = this.head;

        head = head.getNext();
        return result;
    }


}
