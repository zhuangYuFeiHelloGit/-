package exception;

/**
 * 这个队列中没有元素
 *
 * @author : zyf
 * @since : 2019-01-02 15:34
 **/
public class EmptyQueueException extends RuntimeException{
    @Override
    public String getMessage() {
        return "这个队列中没有元素";
    }
}
