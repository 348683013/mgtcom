package management.community.xiaonong.utils;

import lombok.Data;

/**
 * Created by zhouzhongzhong on 2020/3/25
 * 验证码
 */
@Data
public class VerifyCode {

    private String code;

    private byte[] imgBytes;

    private long expireTime;

}
