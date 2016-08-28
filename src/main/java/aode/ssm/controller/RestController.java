package aode.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by ${周欣文} on 2016/8/26.
 */
@Controller
public class RestController {
    @RequestMapping("/test")
    public String test(Map<String,Object> map,@RequestParam(value = "pager.offset", required = false) String pageNum){
        map.put("zzz","zzz");
        System.out.println(1231313);
        System.out.println(pageNum);
        return "index2";
    }

}
