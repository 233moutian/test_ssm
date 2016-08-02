import aode.ssm.mapper.UserMapper;
import aode.ssm.model.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by ${周欣文} on 2016/6/13.
 */
public class UserMapperTest {
    private ApplicationContext applicationContext;

    //在setUp这个方法得到spring容器
    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:beans.xml");
    }

    @Test
    public void list() throws Exception {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = (User)userMapper.findUserById(2);
        System.out.println(user);
    }

}