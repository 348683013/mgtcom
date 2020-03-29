package management.community.xiaonong.mapper;

import management.community.xiaonong.dto.CommentMgtDTO;
import management.community.xiaonong.model.Comment;

import java.util.List;

public interface CommentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    int insert(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    int insertSelective(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    Comment selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    int updateByPrimaryKeySelective(Comment record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment
     *
     * @mbg.generated Wed Mar 25 17:01:12 CST 2020
     */
    int updateByPrimaryKey(Comment record);

    //查找所有评论
    List<CommentMgtDTO> selectAllComment(int offset,int size);

    //评论总量
    Integer selectCommentCount();

    //查找评论
    List<CommentMgtDTO> searchComment(String content);

    //删除指定评论
    int deleteByPrimaryKey(Long id);
}