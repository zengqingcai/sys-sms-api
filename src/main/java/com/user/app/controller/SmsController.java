package com.user.app.controller;

import com.user.app.service.SmsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Authod:zeng
 * @Date: 2020/3/9 13:31
 * @Version: 0.0.1
 * 发送短信用的
 */
@RequestMapping(value = "/sms")
@Controller
@Api(value = "短信管理", description = "短信发送管理接口")
public class SmsController {

    @Autowired
    private SmsService smsService;

    @RequestMapping(value = "loginSmsCode",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "短信发送")
    public Object sms(){
        System.out.println("hhh");
        return smsService.getSmsCode("login");
    }


}
