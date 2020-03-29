package management.community.xiaonong.service;

import management.community.xiaonong.dto.CommentMgtDTO;
import management.community.xiaonong.dto.PaginationDTO;
import management.community.xiaonong.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouzhongzhong on 2020/3/29
 * 评论管理
 */
@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    //查找所有评论
    public PaginationDTO findAllComment(Integer page, Integer size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;

        //查询发帖量
        Integer totalCount = commentMapper.selectCommentCount();

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }


        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        paginationDTO.setPagination(totalPage, page);

        //limit的offset = size*(page-1)
        Integer offset = size * (page - 1);

        List<CommentMgtDTO> commentMgtDTOList = commentMapper.selectAllComment(offset, size);

        paginationDTO.setData(commentMgtDTOList);
        return paginationDTO;
    }

    //查找评论并分页
    public PaginationDTO searchComment(String content) {
        PaginationDTO paginationDTO = new PaginationDTO();
        List<CommentMgtDTO> commentMgtDTOList = commentMapper.searchComment(content);
        paginationDTO.setData(commentMgtDTOList);
        return paginationDTO;
    }
}
