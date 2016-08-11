package aode.ssm.controller;

import aode.ssm.mapper.QuMapper;
import aode.ssm.mapper.ShengMapper;
import aode.ssm.mapper.ShiMapper;
import aode.ssm.model.Qu;
import aode.ssm.model.Sheng;
import aode.ssm.model.Shi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by ${周欣文} on 2016/8/11.
 */
@Controller
public class AreaController {
    @Autowired
    private ShengMapper shengMapper;
    @Autowired
    private ShiMapper shiMapper;
    @Autowired
    private QuMapper quMapper;

    public void getArea(@RequestParam(value = "method")String method ,
                          @RequestParam(value = "shengid" ,required = false)String shengid ,
                          @RequestParam(value = "shiid" ,required = false)String shiid,
                          Map<String,Object> map){
        if(method.equalsIgnoreCase("getSheng")){
            List<Sheng> shengs = shengMapper.selectAll();
            map.put("shengs",shengs);
        }else if(method.equalsIgnoreCase("getShi")){
            Shi shi = new Shi();
            shi.setSheng_id(Long.parseLong(shengid));
            List<Shi> shis = shiMapper.select(shi);
            map.put("shis",shis);
        }else if(method.equalsIgnoreCase("getQu")){
            Qu qu = new Qu();
            qu.setShi_id(Long.parseLong(shiid));
            List<Qu> qus = quMapper.select(qu);
            map.put("qus",qus);
        }
    }



}
