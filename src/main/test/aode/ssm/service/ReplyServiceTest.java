package aode.ssm.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ${周欣文} on 2016/8/3.
 */
public class ReplyServiceTest {
    private ApplicationContext applicationContext;

    //在setUp这个方法得到spring容器
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
    }
    @Test
    public void test1() throws Exception {
        ReplyService replyService = (ReplyService) applicationContext.getBean("replyService");

    }

}