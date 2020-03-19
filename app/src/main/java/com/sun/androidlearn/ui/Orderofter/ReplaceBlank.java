package com.sun.androidlearn.ui.Orderofter;

public class ReplaceBlank {
/**
 * 替换空格
 * 请实现一个函数，将字符串中的每一个空格替换成“%20”。we are happy
 */

    public String replaceSpace(StringBuffer str){
        String ret = "";
        //安全效验
        if (str == null){
            return ret;
        }

        int length = str.length();
        if (length == 0){
            return ret;
        }

        //空格 --> ' '
        //We Are Happy
        //char[]  ['W','e',' ','A'...]
        //char[] chars = str.toString().toCharArray();
        for (int i = 0; i < length; i++){
            if(str.charAt(i) == ' '){
                ret += "%20";//注意字符与字符串差异，二者也不能替换
            }else{
                ret += str.charAt(i);
            }
        }



        return ret;
    }

}
