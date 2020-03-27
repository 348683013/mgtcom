package management.community.xiaonong.service;

import management.community.xiaonong.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhouzhongzhong on 2020/3/25
 * 登陆
 */
@Service
public class AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public boolean adminLogin(String username,String password) {
        int a = 0;
        a = adminMapper.selectByUandP(username, password);
        if (a == 0) {
            return false;
        } else {
            return true;
        }
    }
}
