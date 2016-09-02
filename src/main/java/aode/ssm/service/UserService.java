package aode.ssm.service;

import aode.ssm.mapper.UserMapper;
import aode.ssm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/6/4.
 */
@Service("userService")
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> list(int id) throws Exception {
        return userMapper.findUserById(id);
    }


    public User getUser(User user) {
        return userMapper.selectOne(user);
    }

    public int saveOrUpdateUser(User user) {
        if(user.getU_id()==null){   // 注册
            System.out.println("注册了");
            return userMapper.insert(user);
        }else{  // 修改
            System.out.println("修改了");
            userMapper.updateByPrimaryKeySelective(user);
            return user.getU_id().intValue();
        }
    }

    public boolean selectByUserName(User user) {
        if (userMapper.selectOne(user) != null) {
            return true;//有值
        } else {
            return false;
        }
    }

    // 不对字段置空处理
    public int updateUser(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

}
