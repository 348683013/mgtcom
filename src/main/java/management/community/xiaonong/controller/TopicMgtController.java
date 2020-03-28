package management.community.xiaonong.controller;

import management.community.xiaonong.dto.PaginationDTO;
import management.community.xiaonong.exception.MgtErrorCode;
import management.community.xiaonong.service.TopicMgtService;
import management.community.xiaonong.utils.IsLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhouzhongzhong on 2020/3/28
 */
@Controller
public class TopicMgtController {
    @Autowired
    private TopicMgtService topicMgtService;

    @RequestMapping("/topicmgt")
    public String topicmgt(@RequestParam(name = "page", defaultValue = "1") Integer page,
                           @RequestParam(name = "size", defaultValue = "13") Integer size,
                           Model model,
                           HttpServletRequest request) {
        //判断是否登陆
        boolean b = IsLogin.isLogin(request, model);
        if (!b) {
            model.addAttribute("message", MgtErrorCode.NO_LOGIN.getMessage());
            return "error";
        }

        PaginationDTO paginationDTO = topicMgtService.findAllTopic(page, size);
        model.addAttribute("pagination", paginationDTO);
        return "topicMgt";
    }
}
