package com.user.app.controller;

import com.user.app.utils.VerifyUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * @Authod:zeng
 * @Date: 2020/3/3 15:56
 * @Version: 0.0.1
 * 所有页面的跳转
 */
@Controller
@RequestMapping(value = "/")
public class PageIndexController {

    @RequestMapping(value = "home", method = RequestMethod.GET)
    public String test(){
        return "home/home";
    }

    @RequestMapping(value = "userCentre")
    public String userCentre(ModelMap modelMap){
        modelMap.put("name","zhangsan");
        return "home/user-centre";
    }

}
