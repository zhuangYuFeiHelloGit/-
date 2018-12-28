package exception;

/**
 * 链表中无内容
 *
 * @author : zyf
 * @since : 2018-12-27 16:53
 **/
public class NullLinkedException extends RuntimeException{
    @Override
    public String getMessage() {
        return "链表中无内容，无法执行语句";
    }
}
