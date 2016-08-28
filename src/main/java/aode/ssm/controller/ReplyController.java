package aode.ssm.controller;

import aode.ssm.bean.AjaxResult;
import aode.ssm.model.Post;
import aode.ssm.model.Reply;
import aode.ssm.service.PostService;
import aode.ssm.service.ReplyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${周欣文} on 2016/8/1.
 */
@Controller
@RequestMapping("/post")
public class ReplyController {
    @Resource
    private ReplyService replyService;
    @Resource
    private PostService postService;

    @RequestMapping("/getReply")
    public String getReplyByPostId(@RequestParam() String p_id,
                                   @RequestParam(required = false,defaultValue = "1") String pageNum,
                                   Map<String,Object> map){
     map.put("list",replyService.replyList(Integer.parseInt(p_id),Integer.parseInt(pageNum)));
        return "replys";
    }

    @RequestMapping("/updateReply")
    public String updateReply(RedirectAttributes redirectAttributes,
                              @RequestParam() String p_id,
                              Reply reply){
        if (replyService.updateReply(reply) >= 1) {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "修改成功!"));
        }else {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "修改失败!"));
        }
        return getReplyByPostId(p_id,"1", new HashMap<String, Object>());    // 操作完成后都返回第一页
    }

    @RequestMapping("/deleteReply")
    public String deleteReply(RedirectAttributes redirectAttributes,
                              @RequestParam() String p_id,
                              @RequestParam() String r_id){
        if (replyService.deleteReply(Integer.parseInt(r_id)) >= 1) {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "删除成功!"));
        }else {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "删除失败!"));
        }
        return getReplyByPostId(p_id,"1",new HashMap<String,Object>());// 操作完成后都返回第一页
    }
    // 添加回复的时候设置对应的post
    @RequestMapping("/addReply")
    public String addReply(@RequestParam() String p_id,Reply reply){
        Post post = new Post();
        post.setP_id(Integer.parseInt(p_id));
        reply.setPost(postService.getOnePost(post));
        replyService.addReply(reply);
        return "replys";
    }

}
