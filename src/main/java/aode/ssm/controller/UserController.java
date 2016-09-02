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

    @RequestMapping("/save")
    public String save() {
        return "user/save";
    }

    @RequestMapping("/getLogin")
    public String login() {
        return "user/login";
    }

    //注册成功和登录成功后都应该去主页
    @RequestMapping("/login")
    public String login(@Valid User user, HttpSession session, Map<String,Object> map) throws Exception {
        User u = this.userService.getUser(user);
        if (u != null) {
            session.setAttribute("user", u);
            return "forward:/post/getAllPost";
        } else {
            map.put("result", "用户名或者密码错误");
            return "user/login";
        }
    }

    @RequestMapping(value = "logout")
    public String logout(HttpSession session, RedirectAttributes redirectAttributes) {
        session.removeAttribute("user");
        return "user/login";
    }

    @RequestMapping("/checkIsExist")
    @ResponseBody
    public void checkIsExist(@RequestParam("username") String username, Map<String, Object> map) throws Exception {
        User user = new User();
        user.setUsername(username);
        if (userService.selectByUserName(user)) {
            map.put("message", "此用户名已被占用!");
            System.out.println("此用户名已被占用!");
        } else {
            map.put("message", "此用户名可以使用!");
            System.out.println("此用户名可以使用!");
        }
    }

    // 注册  支持修改
    @RequestMapping("/signup")
    public String save(@Valid User user, HttpSession session) throws Exception {
        user.setU_id((long) userService.saveOrUpdateUser(user));
        session.setAttribute("user", user);
        return "forward:/post/getAllPost";
    }

    // 回显
    @RequestMapping("/getUserMassage/{id}")
    public String getUserMassage(@PathVariable Integer id, Map<String, Object> map) {
        User user = new User();
        user.setU_id((long) id);
        map.put("user", userService.getUser(user));
        return "user/save";
    }

    // 修改 ------无用
    @RequestMapping("/updateUserMessage")
    public String updateUserMassage(@Valid User user, Map<String, Object> map,
                                    RedirectAttributes redirectAttributes) {
        if (userService.updateUser(user) >= 1) {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "修改成功!"));
        } else {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "修改失败!"));
        }
        map.put("user", user);
        return "forward:/post/getAllPost";
    }

}
