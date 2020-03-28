package management.community.xiaonong.exception;

/**
 * Created by zhouzhongzhong on 2020/3/26
 * 异常处理
 */
public enum  MgtErrorCode implements IMgtErrorCode {
    OPERATE_ERROR(3000, "操作失败"),
    NO_LOGIN(3001, "用户未登录"),
    DEL_FAIL(3002, "删除失败"),
    ;

    private String message;
    private Integer code;

    MgtErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
