package management.community.xiaonong.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhouzhongzhong on 2020/2/20
 * 创建拦截器
 */
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private SessionInterceptor sessionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List list = new ArrayList();
        list.add("/");
        list.add("/verifyCode");
        list.add("/callback");
        list.add("/css/**");
        list.add("/fonts/**");
        list.add("/js/**");

        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns(list);
    }

}
