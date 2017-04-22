package cn.jsonlu.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:JsonLu
 * DateTime:17/4/22 21:59
 * Email:jsonlu@qq.com
 * Desc:
 */

@RestController
@CrossOrigin(origins = "*")
/**允许跨域*/
@RequestMapping("/v1/test")
public class TestController extends BaseController {


    @RequestMapping("/get_token/{id}")
    public Object getToken(@PathVariable String id) {
        Map map = new HashMap<>();
        map.put("id", id);
        map.put("time", System.currentTimeMillis());
        return map;
    }

    @RequestMapping({"/", ""})
    public Object defaults() {
        Map map = new HashMap<>();
        map.put("data", "This is a Test Msg");
        map.put("time", System.currentTimeMillis());
        return map;
    }
}
