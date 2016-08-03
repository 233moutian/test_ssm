package aode.ssm.service;

import aode.ssm.mapper.ReplyMapper;
import aode.ssm.model.User;
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

    public int test(){
        PageHelper.startPage(1, 10);
        List<User> list = replyMapper.selectAll();
        return list.size();
    }

}
