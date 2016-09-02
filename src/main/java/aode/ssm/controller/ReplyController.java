package aode.ssm.controller;

import aode.ssm.model.Post;
import aode.ssm.model.Reply;
import aode.ssm.model.User;
import aode.ssm.service.PostService;
import aode.ssm.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Map;

/**
 * Created by ${周欣文} on 2016/8/1.
 */
@Controller
@RequestMapping("/reply")
public class ReplyController {
    @Resource
    private ReplyService replyService;
    @Resource
    private PostService postService;

    @RequestMapping("/getSaveJsp")
    public String getSaveJsp() {
        return "post/save";
    }

    @RequestMapping("/getReply")
    public String getReplyByPostId(@RequestParam() String p_id,
                                   @RequestParam(required = false, defaultValue = "0") String pageNum,
                                   Map<String, Object> map) {
        map.put("replyList", replyService.replyList(Integer.parseInt(p_id), Integer.parseInt(pageNum)));
        Post post = new Post();
        post.setP_id(Integer.parseInt(p_id));
        System.out.println(map.get("replyList"));
        map.put("post", postService.getOnePost(post));
        map.put("count", replyService.getReplyCount(Integer.parseInt(p_id)));
        return "post/reply";
    }

    // p_id用于重定向回reply页面
    @RequestMapping("/updateReply")
    public String updateReply(RedirectAttributes redirectAttributes,
                              String p_id,
                              String r_id,
                              String content) {
        System.out.println(p_id+r_id+content);
        Reply reply = new Reply();
        reply.setR_id(Integer.parseInt(r_id));
        reply.setContent(content);
        reply.setPost_id(Integer.parseInt(p_id));
        replyService.updateReply(reply);
        redirectAttributes.addAttribute("p_id", p_id);
        return "redirect:/reply/getReply";
    }

    // 操作完成后需要回到原来的页面
    @RequestMapping("/deleteReply")
    public String deleteReply(RedirectAttributes redirectAttributes,
                              @RequestParam() String p_id,
                              @RequestParam() String r_id) {
        System.out.println(replyService.deleteReply(Integer.parseInt(r_id)));
        redirectAttributes.addAttribute("p_id", p_id);
        return "redirect:/reply/getReply";
    }

    // p_id 用于属性值并且重定向回reply
    @RequestMapping("/addReply")
    public String addReply(@RequestParam() String p_id, String content, HttpSession session, RedirectAttributes redirectAttributes) {
        Reply reply = new Reply();
        reply.setPost_id(Integer.parseInt(p_id));
        reply.setContent(content);
        reply.setLast_update_time(new Date());
        reply.setR_author(((User) session.getAttribute("user")).getUsername());
        System.out.println(reply);
        replyService.addReply(reply);
        redirectAttributes.addAttribute("p_id", p_id);
        return "redirect:/reply/getReply";
    }

}
