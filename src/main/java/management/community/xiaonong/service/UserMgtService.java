package management.community.xiaonong.service;

import management.community.xiaonong.dto.PaginationDTO;
import management.community.xiaonong.dto.UserMgtDTO;
import management.community.xiaonong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhouzhongzhong on 2020/3/27
 * 用户管理
 */
@Service
public class UserMgtService {
    @Autowired
    private UserMapper userMapper;

    public PaginationDTO findAllUser(int page, int size) {
        PaginationDTO paginationDTO = new PaginationDTO();
        Integer totalPage;
        Integer totalCount = userMapper.selectUserCount();

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

        List<UserMgtDTO> userMgtDTOList = userMapper.selectAllUser(offset, size);

        for (UserMgtDTO userMgtDTO : userMgtDTOList) {
            userMgtDTO.setTieCount(userMapper.selectTieCount(userMgtDTO.getId()));
        }

        paginationDTO.setData(userMgtDTOList);
        return paginationDTO;
    }
}
