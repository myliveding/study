package com.dzr.study.test;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.dzr.study.framework.exception.ApiException;
import com.dzr.study.po.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: dingzr
 * @Date: 2020/1/20 10:48
 * @Description:
 */
@Slf4j
public class FastJson {


    private static List<User> handelQuestionJson (String content) {
        try {
            //把问卷题目的json转换成集合存储到对象中
            return JSONObject.parseArray(content, User.class);
        } catch (Exception e) {
            log.info("问卷题目的json转换成集合出错！" + e.getMessage());
            throw new ApiException(1520001, "问卷题目的json转换成集合出错！");
        }
    }

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setName("sssss");
        user.setPhone(2158752);
        list.add(user);

        System.err.println(JSONArray.toJSONString(list));

        handelQuestionJson("[{\"name\":\"sssss\",\"phone\":2158752}]").forEach(t ->{
            System.err.println(t.getName() + "---" + t.getPhone());
        });
    }

}
