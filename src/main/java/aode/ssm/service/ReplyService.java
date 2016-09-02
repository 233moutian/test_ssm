package aode.ssm.service;

import aode.ssm.mapper.ReplyMapper;
import aode.ssm.model.Reply;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List replyList(long p_id,int pageNum){
        List<Reply> all = replyMapper.getReplyByPostId(p_id);
        List<Reply> replyList ;
        if (all.size() < pageNum + 20) {
            replyList = all.subList(pageNum,all.size());
        }else {
           replyList = all.subList(pageNum,pageNum+20);
        }
        return replyList;
    }

    public int getReplyCount(long p_id) {
        return replyMapper.getReplyByPostId(p_id).size();
    }

//    public List getReplyByComment(String comment) {
//        return replyMapper.getPostByConent(comment);
//    }

    public void addReply(Reply reply){
        replyMapper.insert(reply);
    }

    public int deleteReply(long r_id){
        Reply reply = new Reply();
        reply.setR_id(r_id);
        return replyMapper.deleteByPrimaryKey(reply);
    }

    // 传id和修改内容  空属性不会被修改进数据库
    public int updateReply(Reply reply){
        return replyMapper.updateByPrimaryKeySelective(reply);
    }

}
