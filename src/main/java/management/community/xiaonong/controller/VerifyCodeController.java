//package management.community.xiaonong.controller;
//
//import io.swagger.annotations.ApiOperation;
//import lombok.extern.slf4j.Slf4j;
//import management.community.xiaonong.utils.IVerifyCodeGen;
//import management.community.xiaonong.utils.VerifyCode;
//import management.community.xiaonong.utils.impl.SimpleCharVerifyCodeGenImpl;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by zhouzhongzhong on 2020/3/25
// * 验证码类
// */
//@Slf4j
//@Controller
//public class VerifyCodeController {
//
//    //去测试验证码页面
//    @GetMapping("/toVerifyCode")
//    public String toVerifyCode() {
//        return "verifyCode";
//    }
//
//    @ApiOperation(value = "验证码")
//    @GetMapping("/verifyCode")
//    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
//        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
//        try {
//            //设置长宽
//            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 30);
//            String code = verifyCode.getCode();
//            log.info(code);
//            //将VerifyCode绑定session
//            request.getSession().setAttribute("VerifyCode", code);
//            //设置响应头
//            response.setHeader("Pragma", "no-cache");
//            //设置响应头
//            response.setHeader("Cache-Control", "no-cache");
//            //在代理服务器端防止缓冲
//            response.setDateHeader("Expires", 0);
//            //设置响应内容类型
//            response.setContentType("image/jpeg");
//            response.getOutputStream().write(verifyCode.getImgBytes());
//            response.getOutputStream().flush();
//        } catch (IOException e) {
//            log.info("", e);
//        }
//    }
//}
