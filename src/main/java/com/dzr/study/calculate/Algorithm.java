package com.dzr.study.calculate;

/**
 * 算法
 * @author SUCHENG
 */
public class Algorithm {

    private static Integer findArrayCentreElement(Integer[] paramArray){
        if(paramArray.length == 0){
            return -1;
        }

        // 查找数组的中心元素
        for (int i = 0; i < paramArray.length; i++) {
            if(i == 0 || i == paramArray.length -1){
                continue;
            }
            // 计算该位置数值左侧的所有数值之和是否和右侧相等
            int leftValue = 0;
            for(int j = 0; j < i; j++){
                leftValue = leftValue + paramArray[j];
            }

            int rightValue = 0;
            for(int j = i + 1; j < paramArray.length ; j++){
                rightValue = rightValue + paramArray[j];
            }
            if(leftValue == rightValue){
                return paramArray[i];
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Integer[] param = {1,2,3,4,5,6};
        System.err.println(findArrayCentreElement(param));
    }

}
