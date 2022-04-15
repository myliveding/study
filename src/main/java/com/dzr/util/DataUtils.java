package com.dzr.util;

import com.dzr.javabean.User;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @FileName DataUtils
 * @Author dingzr
 * @CreateTime 2017/9/9 23:10 九月
 */
public class DataUtils {

    public static boolean isEmpty(CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static boolean isNotEmpty(CharSequence cs) {
        return !isEmpty(cs);
    }

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        User user = new User();
        user.setName("sssss");
        map.put("orderInfo", user);

        JSONObject partnerInfo = new JSONObject();
        partnerInfo.put("partnerId", "dddd-ff");
        JSONObject userInfo = new JSONObject();
        userInfo.put("openId", "111111");
        userInfo.put("realName", "红枫湖");
        JSONObject basicInfo = new JSONObject();
        basicInfo.put("userInfo", userInfo);
        basicInfo.put("partnerInfo", partnerInfo);
        map.put("basicInfo", basicInfo);
        System.err.println(map.toString());
    }

}
