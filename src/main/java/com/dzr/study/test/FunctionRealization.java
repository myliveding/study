package com.dzr.study.test;

/**
 * @Auther: dingzr
 * @Date: 2020/3/23 11:28
 * @Description: 函数实现方法
 */
public class FunctionRealization {

    /**
     * 替换空格
     */
    private static void replaceBlank(String originalString){

        char[] temp = originalString.toCharArray();

        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < temp.length; i++) {
            if(temp[i] == ' '){
                newString.append("%20");
            }else {
                newString.append(temp[i]);
            }
        }
        System.err.println(newString.toString());
    }


    public static void main(String[] args) {
        replaceBlank("fff ipi u j h oiioh");
    }

}
