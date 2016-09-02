package aode.ssm.service;

import aode.ssm.controller.ReplyController;
import aode.ssm.mapper.PostMapper;
import aode.ssm.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${周欣文} on 2016/8/26.
 */
public class PostServiceTest {
    @Test
    public void getOnePost() throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        Post post = new Post();
        post.setP_id(1);
        ReplyController replyController = (ReplyController) applicationContext.getBean("replyController");
        replyController.getReplyByPostId("1","1",map);
    }

    private ApplicationContext applicationContext;

    //在setUp这个方法得到spring容器
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
    }

    @Test
    public void postList() throws Exception {
        PostService postService = (PostService) applicationContext.getBean("postService");
        List<Post> postList = postService.postList(0);
        System.out.println(postList.size());
    }

    @Test
    public void getAll() throws Exception {
        PostMapper postMapper = (PostMapper) applicationContext.getBean("postMapper");
//        PageHelper.startPage(1, 1000);      // 设置到无穷大
        List<Post> list = postMapper.getAll();
//        PageInfo<Post> postPageInfo = new PageInfo<Post>(list);
//        System.out.println(postPageInfo.getTotal());
        System.out.println(list.size());           //  这个就是查询总数了.
    }

}