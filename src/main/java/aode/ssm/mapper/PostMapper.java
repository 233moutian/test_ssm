package aode.ssm.mapper;

import aode.ssm.model.Post;
import aode.ssm.util.BaseMapper;

import java.util.List;

/**
 * Created by ${周欣文} on 2016/8/5.
 */
public interface PostMapper extends BaseMapper<Post> {

    List<Post> getAll();



}
