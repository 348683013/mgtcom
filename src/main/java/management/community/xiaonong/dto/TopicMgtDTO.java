package management.community.xiaonong.dto;

import lombok.Data;

/**
 * Created by zhouzhongzhong on 2020/3/28
 * 话题管理
 * 查询所有话题的---ID，话题，内容，作者，创建时间，评论数，浏览量，标签
 */
@Data
public class TopicMgtDTO {
    private Long id;
    private String title;
    private String description;
    private String name;
    private Long creator;
    private Long gmtCreate;
    private Integer commentCount;
    private Integer viewCount;
    private String tag;
    private UserMgtDTO userMgtDTO;
}
