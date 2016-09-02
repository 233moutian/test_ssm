package aode.ssm.service;

import aode.ssm.mapper.PostMapper;
import aode.ssm.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ${周欣文} on 2016/8/13.
 */
@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    // 可以设置二级缓存,将这个整list缓存好.
    //  pageSize表示限制一页有几条,而pageNum则表示查第几页
    public List postList(int pageNum) {
        List<Post> all = postMapper.getAll();      // 要显示的list
        List<Post> postList;
        if (all.size() < pageNum + 20) {
            postList = all.subList(pageNum, all.size());
        } else {
            postList = all.subList(pageNum, pageNum + 20);// 分割list 在sql里面分割无效,因为带有reply的对象
        }
        return postList;
    }

    public void addPost(Post post) {
        System.out.println(postMapper.insert(post));
    }

    public int getPostCount() {
        return postMapper.getAll().size();
    }

    public int deletePost(long id) {
        Post post = new Post();
        post.setP_id(id);
        return postMapper.delete(post);
    }

    public List getPostByContent(String content) {
        return postMapper.getPostByContent(content);
    }

    public Post getOnePost(Post post) {
        return postMapper.selectOne(post);
    }
}
