package exception;

/**
 * @author : zyf
 * @since : 2018-12-28 18:27
 **/
public class LinkedOutOfBoundsException extends RuntimeException{
    @Override
    public String getMessage() {
        return "越界了";
    }
}
