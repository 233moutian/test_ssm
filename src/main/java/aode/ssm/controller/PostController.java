package aode.ssm.controller;

import aode.ssm.bean.AjaxResult;
import aode.ssm.model.Post;
import aode.ssm.model.User;
import aode.ssm.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
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
    public String getAllPost(Map<String, Object> map, @RequestParam(value = "pager.offset", required = false, defaultValue = "0") String pageNum) {
        map.put("postList", postService.postList(Integer.parseInt(pageNum)));   // 显示用的list
        map.put("count", postService.getPostCount());
        return "post/post";
    }

    // 根据内容查
    @RequestMapping("/getPostList")
    public String getPostByPost(@RequestParam() String content, Map<String, Object> map) {
        map.put("postList", postService.getPostByContent(content));
        return "post/post";
    }

    // 暂不支持
    @RequestMapping("/deletePost")
    public String deletePost(@RequestParam() long id, Map<String, Object> map, RedirectAttributes redirectAttributes) {
        if (postService.deletePost(id) >= 1) {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "删除成功!"));
        } else {
            redirectAttributes.addFlashAttribute("result", new AjaxResult(false, "删除失败!"));
        }
        map.put("postList", postService.postList(0));   // 显示用的list
        map.put("count", postService.getPostCount());
        return "post/post";
    }

    @RequestMapping("/AddPost")
    public String addPost(String content, Map<String, Object> map, HttpSession session) {
        System.out.println(content);
        Post post = new Post();
        post.setTitle(content);
        post.setPost_time(new Date());
        post.setP_author(((User) session.getAttribute("user")).getUsername());
        postService.addPost(post);
        map.put("postList", postService.postList(0));   // 显示用的list
        map.put("count", postService.getPostCount());
        return "post/post";
    }

}
