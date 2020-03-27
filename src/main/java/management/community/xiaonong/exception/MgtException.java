package management.community.xiaonong.exception;

/**
 * Created by zhouzhongzhong on 2020/3/26
 * 异常处理
 */
public class MgtException extends RuntimeException  {
    private Integer code;
    private String message;

    //关联MgtErrorCode
    public MgtException(MgtErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }
}
