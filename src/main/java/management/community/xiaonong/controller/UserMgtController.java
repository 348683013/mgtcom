package management.community.xiaonong.controller;

import management.community.xiaonong.dto.PaginationDTO;
import management.community.xiaonong.dto.ResultDTO;
import management.community.xiaonong.exception.MgtErrorCode;
import management.community.xiaonong.service.UserMgtService;
import management.community.xiaonong.utils.IsLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by zhouzhongzhong on 2020/3/27
 * 管理用户
 */
@Controller
public class UserMgtController {
    @Autowired
    private UserMgtService userMgtService;

    //跳转到用户管理页面，查询所有用户
    @RequestMapping("/usermgt")
    public Object usermgt(@RequestParam(name = "page", defaultValue = "1") Integer page,
                          @RequestParam(name = "size", defaultValue = "13") Integer size,
                          Model model,
                          HttpServletRequest request) {

        //判断是否登陆
        boolean b = IsLogin.isLogin(request, model);
        if (!b) {
            model.addAttribute("message", MgtErrorCode.NO_LOGIN.getMessage());
            return "error";
        }

        PaginationDTO paginationDTO = userMgtService.findAllUser(page,size);
        model.addAttribute("pagination", paginationDTO);
        return "userMgt";
    }

    //跳转到用户管理页面，查询指定账号用户
    @RequestMapping("/usersearch")
    public Object usermgt(@RequestParam(name = "userAccountId") String userAccountId,
                          Model model,
                          HttpServletRequest request) {

        if (userAccountId == null || userAccountId == "") {
            return "redirect:/usermgt";
        }

        //判断是否登陆
        boolean b = IsLogin.isLogin(request, model);
        if (!b) {
            model.addAttribute("message", MgtErrorCode.NO_LOGIN.getMessage());
            return "error";
        }

        PaginationDTO paginationDTO = userMgtService.findByAccountId(userAccountId);
        model.addAttribute("pagination", paginationDTO);
        return "userMgt";
    }
}
