package aode.ssm.controller;

import aode.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/6/4.
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public String list(ModelMap map)throws Exception{
        map.addAttribute("list",userService.list(2));
        return "index";
    }

    //注册成功和登录成功后都应该去主页
    @RequestMapping("/login")
    public String login()throws Exception{

        return "index";
    }

    @RequestMapping("/signup")
    public String signup()throws Exception{

        return "index";
    }


}
