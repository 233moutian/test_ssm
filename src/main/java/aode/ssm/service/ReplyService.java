package aode.ssm.service;

import aode.ssm.mapper.ReplyMapper;
import aode.ssm.model.Reply;
import com.github.pagehelper.PageHelper;
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
    // 前期测试
    public int test(){
        PageHelper.startPage(1, 10);
        List<Reply> list = replyMapper.selectAll();
        return list.size();
    }
    public List replyList(long id,int pagenum){
        Map<String, Object> replyMap = new HashMap<String, Object>();
        List<Reply> all = replyMapper.getReplyByPostId(id);
        List<Reply> replyList = all.subList(pagenum,pagenum+20);    // 固定设置为20条 优化的时候可以修改为变量
        replyMap.put("replyList",replyList);    // 显示用的list
        return replyList;
    }



    public void addReply(Reply reply){
        reply.getPost().setLastReply(reply);
        replyMapper.insert(reply);
    }

    public int deleteReply(long r_id){
        Reply reply = new Reply();
        reply.setR_id(r_id);
        return replyMapper.delete(reply);
    }
    // 传id和修改内容  空属性不会被修改进数据库
    public int updateReply(Reply reply){
        return replyMapper.updateByPrimaryKeySelective(reply);
    }

}
