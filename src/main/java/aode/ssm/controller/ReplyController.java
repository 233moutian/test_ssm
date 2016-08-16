package aode.ssm.controller;

import aode.ssm.bean.AjaxResult;
import aode.ssm.model.Reply;
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

    @RequestMapping("/getReply")
    public String getReplyByPostId(@RequestParam() long p_id,
                                   @RequestParam(required = false,defaultValue = "1") int pageNum,
                                   Map<String,Object> map){
        map.put("list",replyService.replyList(p_id,pageNum));
        return "replys";
    }

    @RequestMapping("/updateReply")
    public String updateReply(RedirectAttributes redirectAttributes,
                              @RequestParam() long p_id,
                              Reply reply){
        if (replyService.updateReply(reply) >= 1) {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "修改成功!"));
        }else {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "修改失败!"));
        }
        return getReplyByPostId(p_id,1, new HashMap<String, Object>());    // 操作完成后都返回第一页
    }

    @RequestMapping("/deleteReply")
    public String deleteReply(RedirectAttributes redirectAttributes,
                              @RequestParam() long p_id,
                              @RequestParam() long r_id){
        if (replyService.deleteReply(r_id) >= 1) {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "删除成功!"));
        }else {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "删除失败!"));
        }
        return getReplyByPostId(p_id,1,new HashMap<String,Object>());// 操作完成后都返回第一页
    }

}
