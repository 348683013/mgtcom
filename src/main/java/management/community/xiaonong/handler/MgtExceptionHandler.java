package management.community.xiaonong.handler;

import com.alibaba.fastjson.JSON;
import management.community.xiaonong.dto.ResultDTO;
import management.community.xiaonong.exception.MgtErrorCode;
import management.community.xiaonong.exception.MgtException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhouzhongzhong on 2020/3/26
 * 捕获controller层的异常
 */
@ControllerAdvice
public class MgtExceptionHandler {
    @ExceptionHandler(Exception.class)
    ModelAndView handle(Throwable e, Model model, HttpServletRequest request, HttpServletResponse response) {
        String contentType = request.getContentType();
        if ("application/json".equals(contentType)) {
            ResultDTO resultDTO;
            //返回json
            if (e instanceof MgtException) {
                resultDTO = ResultDTO.errorOf((MgtException) e);
            } else {
                resultDTO = ResultDTO.errorOf(MgtErrorCode.OPERATE_ERROR);
            }

            try {
                response.setCharacterEncoding("utf-8");
                response.setContentType("application/json");
                response.setStatus(200);
                PrintWriter writer = response.getWriter();
                writer.write(JSON.toJSONString(resultDTO));
                writer.close();
            } catch (IOException ioe) {
            }
            return null;
        } else {
            //错误页面跳转
            if (e instanceof MgtException) {

                model.addAttribute("message", e.getMessage());
            } else {
                model.addAttribute("message", MgtErrorCode.OPERATE_ERROR.getMessage());
            }
            return new ModelAndView("error");
        }
    }
}
