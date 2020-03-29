package management.community.xiaonong.interceptor;

import management.community.xiaonong.controller.LoginController;
import management.community.xiaonong.mapper.AdminMapper;
import management.community.xiaonong.mapper.UserMapper;
import management.community.xiaonong.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zhouzhongzhong on 2020/2/20
 */
//添加这个注解，让spring接管这个类，不然这个类不工作
@Service
public class SessionInterceptor implements HandlerInterceptor {
    @Autowired
    private AdminMapper adminMapper;

    //在所有请求（controller）执行之前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(handler);

        String tokengmtsession = (String) request.getSession().getAttribute("tokengmtsession");

        if (tokengmtsession == null || tokengmtsession == "") {
            response.sendRedirect(request.getContextPath() + "/");//拦截后跳转的方法
            System.out.println("拦截===跳转到登陆页面");
            return false;
        }
        return true;
    }

    //在请求执行之后执行
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    //在结束之后执行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
