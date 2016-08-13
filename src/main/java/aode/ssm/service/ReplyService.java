package aode.ssm.service;

import aode.ssm.mapper.ReplyMapper;
import aode.ssm.model.Reply;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ${周欣文} on 2016/8/1.
 */
@Service
public class ReplyService {
    @Autowired
    private ReplyMapper replyMapper;

    public int test(){
        PageHelper.startPage(1, 10);
        List<Reply> list = replyMapper.selectAll();
        return list.size();
    }
    // 需要设置查第几页
    public List replyList(long id , int pageNum){
        Map<String, Object> replyMap = new HashMap<String, Object>();
        PageHelper.startPage(pageNum, 20);      //  固定设置一页20条记录
        List<Reply> replyList = replyMapper.getReplyByPostId(id);
        PageInfo<Reply> page = new PageInfo<Reply>(replyList);
        replyMap.put("pageNum",page.getPageNum());   // 当前页
        replyMap.put("PageSize()",page.getPageSize());   // 一页多少条
        replyMap.put("StartRow()",page.getStartRow());   // 从第几条开始
        replyMap.put("EndRow()",page.getEndRow());// 第几条结束
        replyMap.put("Total",page.getTotal());// 查询总条数
        replyMap.put("Pages",page.getPages());// 一共有几页
        replyMap.put("list",replyList);// list


        return replyList;
    }



    public void addReply(Reply reply){
        replyMapper.insert(reply);
    }

    public void deletePost(String content){
        Reply reply = new Reply();
        reply.setContent(content);
        replyMapper.delete(reply);
    }
}
