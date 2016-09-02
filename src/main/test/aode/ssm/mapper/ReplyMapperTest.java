package aode.ssm.mapper;

import aode.ssm.model.Reply;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by ${周欣文} on 2016/9/1.
 */
public class ReplyMapperTest {

    private ApplicationContext applicationContext;

    //在setUp这个方法得到spring容器
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
    }

    @Test
    public void getReplyByPostId() throws Exception {
        ReplyMapper replyMapper = (ReplyMapper) applicationContext.getBean("replyMapper");
        List<Reply> replies = replyMapper.getReplyByPostId(2);
        System.out.println(replies.get(0));

    }

}