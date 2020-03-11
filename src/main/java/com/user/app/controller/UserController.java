package com.user.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/3/5 14:12
 * @Version: 0.0.1
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/loadMessage",method = RequestMethod.POST)
    @ResponseBody
    public Object loadMessage(){
        Map<String,Object> map = new HashMap<>();
        map.put("first","china");
        map.put("second","japan");
        return map;
    }
}
