package com.dzr.javabean;

import lombok.Data;

import java.util.List;

/**
 * @author dingzr
 * @date 2021/5/1 12:09
 */
@Data
public class Dingding {

    private Integer userId;

    private List<Name> fieldList;

    @Data
    public static class Name {

        private String fieldCode;

        private String fieldName;

    }

}
