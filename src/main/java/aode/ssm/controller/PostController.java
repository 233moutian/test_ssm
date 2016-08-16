package aode.ssm.controller;

import aode.ssm.bean.AjaxResult;
import aode.ssm.model.Post;
import aode.ssm.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ${周欣文} on 2016/8/1.
 */
@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    // 页码暂不设置
    @RequestMapping("/getAllPost")
    public String getAllPost(Map<String,Object> map,@RequestParam() int pageNum){
       map.put("list", postService.postList(pageNum));
        return "list";
    }
    // 根据内容查或者根据发表者查
    @RequestMapping("/getPostList")
    public String getPostByPost(@RequestParam() String comment, Map<String,Object> map){
        map.put("list",postService.getPostByComment(comment));
        return "selectList";
    }

    @RequestMapping("/deletePost")
    public String deletePost(@RequestParam() long id,Map<String,Object> map,RedirectAttributes redirectAttributes){
        if (postService.deletePost(id) >= 1){
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "删除成功!"));
        } else{
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "删除失败!"));
        }
        return getAllPost(new HashMap<String,Object>(),1);
    }

    @RequestMapping("/AddPost")
    public String AddPost(Post post){
        postService.addPost(post);
        return getAllPost(new HashMap<String,Object>(),1);
    }

}
