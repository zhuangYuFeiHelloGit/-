package exception;

/**
 * @author : zyf
 * @since : 2018-12-28 16:00
 **/
public class UnorderedLinkedException extends RuntimeException{
    @Override
    public String getMessage() {
        return "无序的列表";
    }
}
