package exception;

/**
 * @author : zyf
 * @since : 2018-12-28 18:12
 **/
public class CannotControlException extends RuntimeException{

    @Override
    public String getMessage() {
        return "无法满足的操作方式";
    }
}
