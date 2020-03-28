package management.community.xiaonong.service;

import management.community.xiaonong.dto.IdToNameDTO;
import management.community.xiaonong.dto.PaginationDTO;
import management.community.xiaonong.dto.TopicMgtDTO;
import management.community.xiaonong.mapper.QuestionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouzhongzhong on 2020/3/28
 * 话题管理
 */
@Service
public class TopicMgtService {
    @Autowired
    private QuestionMapper questionMapper;

    public PaginationDTO findAllTopic(int page, int size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;

        //查询发帖量
        Integer totalCount = questionMapper.selectTopicCount();

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

        List<TopicMgtDTO> topicMgtDTOList = questionMapper.selectAllTopic(offset, size);
        List<IdToNameDTO> idToNameDTOList = questionMapper.selectTandU();


        //把creator转换成name,向topicMgtDTO里面添加name
        for (TopicMgtDTO topicMgtDTO : topicMgtDTOList) {
            for (IdToNameDTO idToNameDTO : idToNameDTOList) {
                if (topicMgtDTO.getCreator() == idToNameDTO.getCreator()) {
                    topicMgtDTO.setName(idToNameDTO.getName());
                }
            }
        }

        paginationDTO.setData(topicMgtDTOList);

        return paginationDTO;
    }

    //根据主键id查找用户
    public TopicMgtDTO findById(Long id) {
        return questionMapper.selectById(id);
    }

    //根据title关键词查找话题
    public List<TopicMgtDTO> findByTitle(String topictitle) {
        List<TopicMgtDTO> topicMgtDTOList = questionMapper.selectByTitle(topictitle);
        List<IdToNameDTO> idToNameDTOList = questionMapper.selectTandU();

        //把creator转换成name,向topicMgtDTO里面添加name
        for (TopicMgtDTO topicMgtDTO : topicMgtDTOList) {
            for (IdToNameDTO idToNameDTO : idToNameDTOList) {
                if (topicMgtDTO.getCreator() == idToNameDTO.getCreator()) {
                    topicMgtDTO.setName(idToNameDTO.getName());
                }
            }
        }
        return topicMgtDTOList;
    }
}
