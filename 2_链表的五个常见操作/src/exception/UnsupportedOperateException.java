package exception;

/**
 * @author : zyf
 * @since : 2018-12-28 19:29
 **/
public class UnsupportedOperateException extends RuntimeException{
    @Override
    public String getMessage() {
        return "不支持的操作异常："+super.getMessage();
    }
}
