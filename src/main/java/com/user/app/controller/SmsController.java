package com.user.app.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Authod:zeng
 * @Date: 2020/3/9 13:31
 * @Version: 0.0.1
 * 发送短信用的
 */
@RequestMapping(value = "/")
@Controller
@Api(value = "短信管理", description = "短信发送管理接口")
public class SmsController {


    @RequestMapping(value = "loginSms",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "短信发送")
    public Object sms(){
        //验证码注册短信
        //验证码登陆短信
        System.out.println(System.currentTimeMillis()+"");
        JSONObject object = new JSONObject();
        object.put("test","abc");
        return object;
    }

    @RequestMapping(value = "doLogin",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "短信发送")
    public Object login(@RequestBody LoginVo loginVo, HttpServletRequest request)throws Exception{
        //验证码注册短信
        //验证码登陆短信
        String contentType = request.getHeader("content-type");
        String myContentType = request.getHeader("My-content-type");
        String myParams = request.getParameter("name");
        System.out.println("contentType:"+contentType+",myCont:"+myContentType+",myParams:"+myParams);

        Map<String,Object> map = null;
        HttpServletResponse response = null;
        PrintWriter printWriter = response.getWriter();
        printWriter.write(JSONObject.toJSONString(map).toString());
        printWriter.flush();

        System.out.println(System.currentTimeMillis()+",name:"+loginVo.getName());
        JSONObject object = new JSONObject();
        object.put("test","abc");
        return object;
    }

    @RequestMapping(value = "doRequestForJson",method = RequestMethod.GET)
    @ApiOperation(value = "返回json数据")
    public void doRequestForJson(HttpServletRequest request,HttpServletResponse response){
        PrintWriter printWriter = null;
        try {
            Map<String,Object> map = new HashMap<>();
            map.put("code","200");
            map.put("msg","交易成功");
            map.put("params",request.getParameter("name"));
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json;charset=utf-8");
            printWriter = response.getWriter();
            printWriter.write(JSONObject.toJSONString(map).toString());
            printWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }


    @RequestMapping(value = "doRequestForImg",method = RequestMethod.GET)
    @ApiOperation(value = "返回json数据")
    public void doRequestForImg(HttpServletRequest request,HttpServletResponse response)throws Exception{
        File file = new File("D:\\temp\\123.jpg");
        FileInputStream fis;
        fis = new FileInputStream(file);

        long size = file.length();
        byte[] temp = new byte[(int) size];
        fis.read(temp, 0, (int) size);
        fis.close();
        byte[] data = temp;
        OutputStream out = response.getOutputStream();
//        response.setContentType("image/png"); 都可以的
        response.setContentType("image/jpg");
        out.write(data);

        out.flush();
        out.close();
    }


}
