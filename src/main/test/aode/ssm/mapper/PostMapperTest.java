package aode.ssm.mapper;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ${周欣文} on 2016/8/8.
 */
public class PostMapperTest {
    private ApplicationContext applicationContext;

    //在setUp这个方法得到spring容器
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
    }

    @Test
    public void getAll() throws Exception {
        PostMapper postMapper = (PostMapper) applicationContext.getBean("postMapper");
        System.out.println(postMapper.getAll().size());// 测试成功
        System.out.println(postMapper.getAll().get(1).getReplies().size());// 测试成功
    }

}