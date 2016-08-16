package aode.ssm.controller;

import aode.ssm.bean.AjaxResult;
import aode.ssm.mapper.QuMapper;
import aode.ssm.mapper.ShengMapper;
import aode.ssm.mapper.ShiMapper;
import aode.ssm.model.Qu;
import aode.ssm.model.Shi;
import aode.ssm.model.User;
import aode.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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
        User u = this.userService.getUser(user);
        if (u!=null){
            session.setAttribute("loginUser",u);
            return "redirect:/user/list";
        }else {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "用户名或者密码错误"));
            return "redirect:/post/list";
        }
    }

    @RequestMapping(value = "logout")
    public String logout(HttpSession session,RedirectAttributes redirectAttributes) {
        session.removeAttribute("loginUser");
        redirectAttributes.addFlashAttribute("result", new AjaxResult(true, "退出成功"));
        return "login";
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

    @RequestMapping("/getUserMassage/{id}")
    public String getUserMassage(@PathVariable Integer id,Map<String,Object> map){
        User user = new User();
        user.setId((long)id);
        userService.getUser(user);
        map.put("user",user);
        map.put("shengList",shengMapper.selectAll());
        return "userMassage";
    }

    @RequestMapping("/updateUserMessage")
    public String updateUserMassage(@Valid User user,Map<String,Object> map){
        if (userService.updateUser(user) >= 1){
            map.put("result","修改成功!");
        } else{
            map.put("result","修改失败!");
        }
        map.put("user",user);
        return "userMassage";
    }

    @Autowired
    private ShengMapper shengMapper;
    @Autowired
    private ShiMapper shiMapper;
    @Autowired
    private QuMapper quMapper;
    // 地区选择的AJAX三级联动效果
    public void getArea(@RequestParam(value = "method")String method ,
                        @RequestParam(value = "shengid" ,required = false)String shengid ,
                        @RequestParam(value = "shiid" ,required = false)String shiid,
                        Map<String,Object> map){
        if(method.equalsIgnoreCase("getShi")){
            Shi shi = new Shi();
            shi.setSheng_id(Long.parseLong(shengid));
            List<Shi> shis = shiMapper.select(shi);
            map.put("shis",shis);
        }else if(method.equalsIgnoreCase("getQu")){
            Qu qu = new Qu();
            qu.setShi_id(Long.parseLong(shiid));
            List<Qu> qus = quMapper.select(qu);
            map.put("qus",qus);
        }
    }

}
