package management.community.xiaonong.dto;

import lombok.Data;

/**
 * Created by zhouzhongzhong on 2020/3/29
 * 评论管理
 * 话题ID，话题名称ID，话题名称，评论等级，评论者ID，评论者姓名，评论时间，评论内容，子评论数
 */
@Data
public class CommentMgtDTO {
    private Long id;
    private Long parentId;
    private String title;
    private Integer type;
    private Long commentator;
    private String name;
    private Long gmtCreate;
    private String content;
    private Integer commentCount;
}
