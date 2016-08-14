package aode.ssm.controller;

import aode.ssm.bean.AjaxResult;
import aode.ssm.model.User;
import aode.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Administrator on 2016/6/4.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {
    @Resource
    private UserService userService;

    //注册成功和登录成功后都应该去主页
    @RequestMapping("/login")
    public String login(@Valid User user, HttpSession session, RedirectAttributes redirectAttributes)throws Exception{
        User u = this.userService.login(user);
        if (u!=null){
            session.setAttribute("loginUser",u);
            return "redirect:/user/list";
        }else {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "用户名或者密码错误"));
            return "redirect:/post/list";
        }
    }

    @RequestMapping("/checkIsExist")
    public String checkIsExist(@Valid User user,HttpServletResponse response)throws Exception{
        String result=null;
        if(userService.selectByUserName(user)){
            result="<font color='red'>该用户名已经被使用</font>";
        }else{
            result="<font color='red'>该用户名可以使用</font>";
        }
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(result);
        return "addUser";
    }

    @RequestMapping("/signup")
    public String signup(@Valid User user)throws Exception{
        userService.saveUser(user);
        return "redirect:/post/list";
    }

}
