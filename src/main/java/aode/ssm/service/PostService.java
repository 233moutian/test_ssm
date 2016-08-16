package aode.ssm.service;

import aode.ssm.mapper.PostMapper;
import aode.ssm.model.Post;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${周欣文} on 2016/8/13.
 */
@Service
public class PostService {
    @Autowired
    private PostMapper postMapper;

    //  pageSize表示限制一页有几条,而pageNum则表示查第几页
    public Map postList(int pageNum){
        Map<String, Object> postMap = new HashMap<String, Object>();
        PageHelper.startPage(pageNum, 10);      //  固定设置一页10条记录
        List<Post> postList = postMapper.getAll();
        PageInfo<Post> page = new PageInfo<Post>(postList);
        postMap.put("pageNum",page.getPageNum());   // 当前页
        postMap.put("PageSize()",page.getPageSize());   // 一页多少条
        postMap.put("StartRow()",page.getStartRow());   // 从第几条开始
        postMap.put("EndRow()",page.getEndRow());// 第几条结束
        postMap.put("Total",page.getTotal());// 查询总条数
        postMap.put("Pages",page.getPages());// 一共有几页
        postMap.put("list",postList);// list
//          需要从list里面提取的数据有回复量postList.get(0).getReplies().size();  可以在jsp页面上使用迭代
//          最后一条回复者postList.get(0).getReplies().get(postList.get(0).getReplies().size()-1).getR_author();

        return postMap;
    }

    public void addPost(Post post){
        postMapper.insert(post);
    }

    public int deletePost(long id){
        Post post = new Post();
        post.setP_id(id);
        return postMapper.delete(post);
    }

    public List getPostByComment(String comment){
        return postMapper.getPostByComment(comment);
    }
}
