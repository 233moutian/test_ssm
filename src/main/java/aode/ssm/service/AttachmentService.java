package aode.ssm.service;

import aode.ssm.mapper.AttachmentMapper;
import aode.ssm.model.Attachment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ${周欣文} on 2016/8/17.
 */
@Service
public class AttachmentService {
    @Autowired
    AttachmentMapper attachmentMapper;

    public Attachment findByUid(Attachment attachment){
        return attachmentMapper.selectOne(attachment);
    }

    public void update(Attachment attachment){
        this.attachmentMapper.updateByPrimaryKeySelective(attachment);
    }

    public void save(Attachment attachment){
        this.attachmentMapper.insert(attachment);
    }

    public void saveOrUpdate(Attachment attachment){
//        Attachment temp = new Attachment();
        // 假如数据库中有一条数据的字段是uid,则表示是修改个人头像,没有表示第一次上传
//        temp.setUid(attachment.getUid());
//        if (findByUid(temp) != null){     // 修改个人头像
//            update(attachment);
//        }else {
            save(attachment);       // 第一次上传
//        }
    }
}
