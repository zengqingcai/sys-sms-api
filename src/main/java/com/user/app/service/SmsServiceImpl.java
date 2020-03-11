package com.user.app.service;

import com.alibaba.fastjson.JSONObject;
import com.user.app.utils.VerifyUtil;
import org.springframework.stereotype.Service;

/**
 * @Authod:zeng
 * @Date: 2020/3/11 15:10
 * @Version: 0.0.1
 */
@Service
public class SmsServiceImpl implements SmsService {
    @Override
    public JSONObject getSmsCode(String busType) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status",200);
        jsonObject.put("smsCode", VerifyUtil.getSmsCode());
        return jsonObject;
    }
}
