package management.community.xiaonong.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import management.community.xiaonong.service.AdminService;
import management.community.xiaonong.utils.IVerifyCodeGen;
import management.community.xiaonong.utils.VerifyCode;
import management.community.xiaonong.utils.impl.SimpleCharVerifyCodeGenImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by zhouzhongzhong on 2020/3/25
 */
@Slf4j
@Controller
public class LoginController {
    @Autowired
    private AdminService adminService;

    //用来判断验证码是否正确
    String code = "";

    //用来判断是否是登陆状态
    public static String token1 = "";

    //跳转到登陆页面
    @RequestMapping("/")
    public String index() {
        return "login";
    }

    //登陆跳转
    @RequestMapping("/callback")
    public String callback(@RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password,
                           @RequestParam(name = "verifycode") String verifycode,
                           HttpServletResponse response,
                           HttpServletRequest request,
                           Model model) {

        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("verifycode", verifycode);

        String code1 = verifycode.toUpperCase();

        if (username == null || username == "") {
            model.addAttribute("error", "用户名不能为空!");
            return "login";
        }
        if (password == null || password == "") {
            model.addAttribute("error", "密码不能为空!");
            return "login";
        }
        if (verifycode == null || verifycode == "") {
            model.addAttribute("error", "验证码不能为空!");
            return "login";
        }
        if (!code.equals(code1)) {
            model.addAttribute("error", "验证码输入错误!");
            return "login";
        }

        boolean a = adminService.adminLogin(username, password);

        if (a && code.equals(code1)) {
            //写一个cookie
            String token = UUID.randomUUID().toString();
            token1 = token;

//            request.getSession().setAttribute("token", token);
            response.addCookie(new Cookie("tokenmgt", token));

            System.out.println("管理员==="+username+"===登陆");
            return "index";
        } else {
            model.addAttribute("error", "用户名或密码输入错误!");
            return "login";
        }
    }

    //退出登陆
    @GetMapping("/logout")
    public String logout(HttpServletRequest request,
                         HttpServletResponse response) {
//        request.getSession().removeAttribute("user");
        Cookie cookie = new Cookie("tokenmgt", null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }

    //去测试验证码页面
    @GetMapping("/toVerifyCode")
    public String toVerifyCode() {
        return "verifyCode";
    }

    //验证码
    @ApiOperation(value = "验证码")
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 30);
            code = verifyCode.getCode();
            log.info(code);
            //将VerifyCode绑定session
            request.getSession().setAttribute("VerifyCode", code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            log.info("", e);
        }
    }

}
