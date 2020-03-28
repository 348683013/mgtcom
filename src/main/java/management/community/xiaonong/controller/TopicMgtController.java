package management.community.xiaonong.controller;

import management.community.xiaonong.dto.PaginationDTO;
import management.community.xiaonong.dto.TopicMgtDTO;
import management.community.xiaonong.exception.MgtErrorCode;
import management.community.xiaonong.service.TopicMgtService;
import management.community.xiaonong.utils.IsLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zhouzhongzhong on 2020/3/28
 */
@Controller
public class TopicMgtController {
    @Autowired
    private TopicMgtService topicMgtService;

    //所有话题并分页
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

    //查看话题内容
    @RequestMapping("/topicmgt/{id}")
    public String topicdes(@PathVariable(name = "id") Long id,
                           Model model,
                           HttpServletRequest request) {
        //判断是否登陆
        boolean b = IsLogin.isLogin(request, model);
        if (!b) {
            model.addAttribute("message", MgtErrorCode.NO_LOGIN.getMessage());
            return "error";
        }

        TopicMgtDTO topicMgtDTO = topicMgtService.findById(id);

        model.addAttribute("topicMgtDTO", topicMgtDTO);
        return "topicDescription";
    }

    //查询话题
    @RequestMapping("/topicsearch")
    public String topicsearch(@RequestParam(name = "topictitle") String topictitle,
                              Model model,
                              HttpServletRequest request) {
        if (topictitle == null || topictitle == "") {
            return "redirect:/topicmgt";
        }

        //判断是否登陆
        boolean b = IsLogin.isLogin(request, model);
        if (!b) {
            model.addAttribute("message", MgtErrorCode.NO_LOGIN.getMessage());
            return "error";
        }

        List<TopicMgtDTO> topicMgtDTOList = topicMgtService.findByTitle(topictitle);
        PaginationDTO paginationDTO = new PaginationDTO();
        paginationDTO.setData(topicMgtDTOList);
        model.addAttribute("pagination", paginationDTO);
        return "topicMgt";

    }

    //删除相应话题
    @RequestMapping("/topicmgtdel/{id}")
    public String topicmgtdel(@PathVariable(name = "id") Long id,
                           Model model,
                           HttpServletRequest request) {
        //判断是否登陆
        boolean b = IsLogin.isLogin(request, model);
        if (!b) {
            model.addAttribute("message", MgtErrorCode.NO_LOGIN.getMessage());
            return "error";
        }

        boolean isDel = topicMgtService.delById(id);

        if (isDel) {
            return "redirect:/topicmgt";
        } else {
            model.addAttribute("message", MgtErrorCode.DEL_FAIL.getMessage());
            return "error";
        }

    }
}
