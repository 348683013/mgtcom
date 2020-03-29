package management.community.xiaonong.controller;

import management.community.xiaonong.dto.PaginationDTO;
import management.community.xiaonong.exception.MgtErrorCode;
import management.community.xiaonong.mapper.CommentMapper;
import management.community.xiaonong.service.CommentService;
import management.community.xiaonong.utils.IsLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhouzhongzhong on 2020/3/29
 * 评论管理
 */
@Controller
public class CommentMgtController {
    @Autowired
    private CommentService commentService;

    //所有评论并分页
    @RequestMapping("/commentmgt")
    public String commentmgt(@RequestParam(name = "page", defaultValue = "1") Integer page,
                           @RequestParam(name = "size", defaultValue = "13") Integer size,
                           Model model,
                           HttpServletRequest request) {
        //判断是否登陆
        boolean b = IsLogin.isLogin(request, model);
        if (!b) {
            model.addAttribute("message", MgtErrorCode.NO_LOGIN.getMessage());
            return "error";
        }

        PaginationDTO paginationDTO = commentService.findAllComment(page, size);
        model.addAttribute("pagination", paginationDTO);
        return "commentMgt";
    }

    //查找评论并分页
    @RequestMapping("/commentsearch")
    public String commentsearch(@RequestParam(name = "content") String content,
                                Model model,
                                HttpServletRequest request) {

        //判断是否登陆
        boolean b = IsLogin.isLogin(request, model);
        if (!b) {
            model.addAttribute("message", MgtErrorCode.NO_LOGIN.getMessage());
            return "error";
        }

        if (content == null || content == "") {
            return "redirect:/commentmgt";
        }

        PaginationDTO paginationDTO = commentService.searchComment(content);
        model.addAttribute("pagination", paginationDTO);
        return "commentMgt";
    }

    //删除指定评论
    @RequestMapping("/commentdel/{id}")
    public String delComment(@PathVariable(name = "id") Long id,
                             Model model,
                             HttpServletRequest request) {
        //判断是否登陆
        boolean b = IsLogin.isLogin(request, model);
        if (!b) {
            model.addAttribute("message", MgtErrorCode.NO_LOGIN.getMessage());
            return "error";
        }

        boolean isDel = commentService.delById(id);

        if (isDel) {
            return "redirect:/commentmgt";
        } else {
            model.addAttribute("message", MgtErrorCode.DEL_FAIL.getMessage());
            return "error";
        }

    }
}
