package management.community.xiaonong.dto;

import lombok.Data;

/**
 * Created by zhouzhongzhong on 2020/3/28
 * 把question里面的creator转换成user的name
 */
@Data
public class IdToNameDTO {
    private Long creator;
    private String name;
}
