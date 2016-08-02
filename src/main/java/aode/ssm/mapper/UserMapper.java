package aode.ssm.mapper;

import aode.ssm.model.User;
import aode.ssm.util.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2016/6/4.
 */
@Repository
public interface UserMapper extends BaseMapper<User>{

    public List<User> findUserById(int id) throws Exception;



}
