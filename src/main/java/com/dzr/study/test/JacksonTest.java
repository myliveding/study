package com.dzr.study.test;

import com.dzr.javabean.Paper;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;

/**
 * @author dingzr
 * @Description 顶顶顶顶顶顶
 * @ClassName JacksonTest
 * @since 2017/5/24 10:29
 */
public class JacksonTest {

    private static final Logger logger = LoggerFactory.getLogger(JacksonTest.class);

    private static void handelMap() throws Exception {
        String jsonString = "[{'id':'1'},{'id':'2'}]";
        ObjectMapper mapper = new ObjectMapper();
        List<Paper> beanList = mapper.readValue(jsonString, new TypeReference<List<Paper>>() {
        });
    }


    private static void jsonToType(String socialsetJson) {
        try {
            //json解析并进行校验，组装数据
            ObjectMapper mapper = new ObjectMapper();
            //获取社保公积金不同时段政策包的集合
            Map mapInfo = mapper.readValue(socialsetJson, Map.class);
        } catch (JsonParseException e) {
            logger.error("json格式错误");
            e.printStackTrace();
        } catch (JsonMappingException e) {
            logger.error("json匹配错误");
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("json解析错误");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        Paper student1 = new Paper();
        student1.setAddress("五险");
        student1.setId(1);

        Paper student3 = new Paper();
        student1.setAddress("一金");
        student1.setId(2);

        ObjectMapper mapper = new ObjectMapper();

        //Convert between List and JSON
        List<Paper> userList = new ArrayList<Paper>();
        userList.add(student1);
        userList.add(student3);
        String jsonfromList = mapper.writeValueAsString(userList);
        System.out.println(jsonfromList);
        //List Type is not required here.
        List userList2 = mapper.readValue(jsonfromList, List.class);
        System.out.println(userList2);
        System.out.println("************************************");

        //Convert Map to JSON
        Map<String, Object> map = new HashMap<>();
        map.put("userList", userList);
        map.put("class", "ClassName");
        String jsonfromMap = mapper.writeValueAsString(map);
        System.out.println(jsonfromMap);

        Map map2 = mapper.readValue(jsonfromMap, Map.class);
        System.out.println(map2);
        System.out.println(map2.get("userList"));
        System.out.println("************************************");

        //Convert Array to JSON
        Paper[] stuArr = {student1, student3};
        String jsonfromArr = mapper.writeValueAsString(stuArr);
        System.out.println(jsonfromArr);
        Paper[] stuArr2 = mapper.readValue(jsonfromArr, Paper[].class);
        System.out.println(Arrays.toString(stuArr2) + "---" + stuArr2[0].getId());
    }
}
