package management.community.xiaonong.service;

import management.community.xiaonong.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhouzhongzhong on 2020/3/25
 */
@Service
public class QuestionService {
    @Autowired
    private UserMapper userMapper;

}
