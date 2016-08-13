package aode.ssm.mapper;

import aode.ssm.model.Reply;
import aode.ssm.util.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by ${周欣文} on 2016/8/1.
 */
@Repository
public interface ReplyMapper extends BaseMapper<Reply> {

    List<Reply> getReplyByPostId(long id);

}