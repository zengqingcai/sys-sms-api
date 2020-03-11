package com.user.app.controller;

import com.alibaba.fastjson.JSONObject;
import com.user.app.model.TestUser;
import com.user.app.utils.VerifyUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class TestController {

    @RequestMapping(value = "gologin", method = RequestMethod.GET)
    public String test(){
        return "login";
    }


    @RequestMapping("/getValidCode")
    public void gainCAPTCHA(HttpServletResponse response, HttpServletRequest request) throws Exception{
        HttpSession session=request.getSession();
        //利用图片工具生成图片
        //第一个参数是生成的验证码，第二个参数是生成的图片
        Object[] objs = VerifyUtil.createImage();
        //将验证码存入Session
        session.setAttribute("validCode",objs[0]);
        //将图片输出给浏览器
        BufferedImage image = (BufferedImage) objs[1];
        response.setContentType("image/png");
        OutputStream os = response.getOutputStream();
        ImageIO.write(image, "png", os);
    }


    @RequestMapping("/loginout")
    public String loginOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
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
