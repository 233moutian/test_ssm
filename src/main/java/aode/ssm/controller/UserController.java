package aode.ssm.controller;

import aode.ssm.bean.AjaxResult;
import aode.ssm.model.User;
import aode.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/4.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    //注册成功和登录成功后都应该去主页
    @RequestMapping("/login")
    public String login(@Valid User user, HttpSession session, RedirectAttributes redirectAttributes) throws Exception {
        User u = this.userService.getUser(user);
        if (u != null) {
            session.setAttribute("loginUser", u);
            return "redirect:/WEB-INF/index";
        } else {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "用户名或者密码错误"));
            return "saveuser";
        }
    }

    @RequestMapping(value = "logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.removeAttribute("loginUser");
        redirectAttributes.addFlashAttribute("result", new AjaxResult(true, "退出成功"));
        return "login";
    }

    @RequestMapping("/checkIsExist")
    @ResponseBody
    public void checkIsExist(@RequestParam("username") String username, Map<String, Object> map) throws Exception {
        User user = new User();
        user.setUsername(username);
        System.out.print(username);
        if (userService.selectByUserName(user)) {
            map.put("message", "此用户名已被占用!");
        } else {
            map.put("message", "此用户名可以使用!");
        }
    }
    // 注册
    @RequestMapping("/signup")
    public String signup(@Valid User user, HttpServletRequest request, HttpSession session) throws Exception {
        request.setCharacterEncoding("UTF-8");
        user.setU_id((long)userService.saveUser(user));
        session.setAttribute("loginUser",user);
        return "post";
    }
    // 回显
    @RequestMapping("/getUserMassage/{id}")
    public String getUserMassage(@PathVariable Integer id, Map<String, Object> map) {
        User user = new User();
        user.setU_id((long) id);
        userService.getUser(user);
        map.put("user", user);
        return "saveuser";
    }
    // 修改
    @RequestMapping("/updateUserMessage")
    public String updateUserMassage(@Valid User user, Map<String, Object> map,
                                    RedirectAttributes redirectAttributes) {
        if (userService.updateUser(user) >= 1) {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "修改成功!"));
        } else {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "修改失败!"));
        }
        map.put("user", user);
        return "post";
    }

}
