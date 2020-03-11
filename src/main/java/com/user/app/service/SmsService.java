package com.user.app.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @Authod:zeng
 * @Date: 2020/3/11 15:09
 * @Version: 0.0.1
 */
public interface SmsService {

    JSONObject getSmsCode(String busType);
}
