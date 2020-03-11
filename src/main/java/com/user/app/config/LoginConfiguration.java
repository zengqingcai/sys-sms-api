//package com.user.app.config;
//
//import com.user.app.interceptor.LoginInterceptor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//
//@Configuration
//public class LoginConfiguration implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        // 注册拦截器
//        LoginInterceptor loginInterceptor = new LoginInterceptor();
//        InterceptorRegistration loginRegistry = registry.addInterceptor(loginInterceptor);
//        // 拦截路径
//        loginRegistry.addPathPatterns("/**");
//        // 排除路径
//        //首页
//        //loginRegistry.excludePathPatterns("/");
//        //登陆
//        loginRegistry.excludePathPatterns("/gologin");
//        loginRegistry.excludePathPatterns("/dologin");
//        //对外接口
//        loginRegistry.excludePathPatterns("/loginout");
////        loginRegistry.excludePathPatterns("/emp/empRegister");
////        loginRegistry.excludePathPatterns("/emp/doSaveEmp");
////        loginRegistry.excludePathPatterns("/empApi/saveEmp/**");
////        loginRegistry.excludePathPatterns("/empApi/findEmp/**");
////        loginRegistry.excludePathPatterns("/empApi/dologin");
////        loginRegistry.excludePathPatterns("/empApi/updatePassword");
////        loginRegistry.excludePathPatterns("/empApiTest/**");
//        loginRegistry.excludePathPatterns("/css/**");
//        loginRegistry.excludePathPatterns("/js/**");
//        loginRegistry.excludePathPatterns("/images/**");
//        //验证码
//        loginRegistry.excludePathPatterns("/getValidCode");
//    }
//}
