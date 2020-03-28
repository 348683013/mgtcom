package management.community.xiaonong.dto;

import lombok.Data;

/**
 * Created by zhouzhongzhong on 2020/3/27
 * 用户管理
 * 查询所有用户的ID，账户ID，姓名，创建时间，上次登陆时间，发帖数量
 */
@Data
public class UserMgtDTO {
    private Long id;
    private String accountId;
    private String name;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer tieCount;
}
