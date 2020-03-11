package com.user.app.controller;

import com.user.app.model.TestUser;
import com.user.app.utils.VerifyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class LoginController {

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

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    @ResponseBody
    public Object emplogin(@RequestBody TestUser user, HttpServletRequest request) {
        HttpSession session=request.getSession();
        String validCode = (String) session.getAttribute("validCode");
        System.out.println("validCode:"+validCode);
        validCode = "1111";

        //登陆成功将登陆员工信息放入session
        session.setAttribute("user", user);
        Map<String,Object> msg = new HashMap<>();
        msg.put("code",200);
        return msg;
    }

    @RequestMapping("/loginout")
    public String loginOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return "login";
    }


}
