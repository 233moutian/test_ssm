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
    private  UserMapper userMapper;

    public List<User> list(int id)throws Exception{
        return userMapper.findUserById(id);
    }


    public User login(User user) {
        return userMapper.selectOne(user);
    }

    public void saveUser(User user) {
        userMapper.insert(user);
    }


    public boolean selectByUserName(User user) {
        if(userMapper.selectOne(user) != null){
            return true;//有值
        }else {
            return false;
        }
    }
}
