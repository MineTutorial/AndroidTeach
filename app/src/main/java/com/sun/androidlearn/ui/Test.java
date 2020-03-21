package com.sun.androidlearn.ui;

import java.util.ArrayList;

/**
 * Author: jfson sun
 * Create on:  2020/3/21
 * Question:
 * Description:
 * Train of thought:
 */
public class Test {
    /**
     * 基本类型，包装类
     * Integer -- int 包装类
     char :   ''
     */
    public void test(){
        ArrayList<Integer> data = new ArrayList<>();
        data.add(1);

        Integer one = new Integer(1);

        char a = 'a';
        int numA = 1;// 2^-32 --2^32(-65536 -- 65535)
        long longA = 1000000000000L;//(2^64)
        float f = 0.1f;
        double d = 0.02;
        boolean b = false;//true
        String s = "s";
        byte[] bytes = s.getBytes();
        char[] chars = s.toCharArray();


    }
}
