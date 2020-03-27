package management.community.xiaonong.utils;

import management.community.xiaonong.controller.LoginController;
import org.springframework.ui.Model;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhouzhongzhong on 2020/3/27
 * 判断是否登陆
 */
public class IsLogin {
    public static boolean isLogin(HttpServletRequest request,
                               Model model){
        //判断是否是登陆状态
        boolean b = false;
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String cookie1 = cookie.getName();
            String cookie1v = cookie.getValue();
            if (cookie1.equals("token") && cookie1v.equals(LoginController.token1)) {
                b = true;
            }
        }
        if (!b) {
            //不是登陆状态返回错误页
//            model.addAttribute("message", MgtErrorCode.NO_LOGIN.getMessage());
            return false;
//            return ResultDTO.errorOf(MgtErrorCode.NO_LOGIN);
        }
        return true;
    }
}
