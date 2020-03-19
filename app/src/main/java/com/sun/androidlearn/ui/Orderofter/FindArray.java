package com.sun.androidlearn.ui.Orderofter;

public class FindArray {
    /**
     * 一个二维数组按顺序排列从左到右从上到下排序
     * 请输入这样一个二维数组和数字，判断是否有整数
     *
     *
     *
     * 1  2  3  4
     * 5  6  7  8
     * 9 10 11 12
     * 1--> res[0][0]
     * 4-->res[0][3]
     * 9-->res[2][0]
     */

    public boolean Find(int targer, int[][] array){
        if (array == null || array.length == 0) {
            return false;
        }

        //1.暴力解法遍历
//        for (int i = 0; i < array.length; i++){
//            for (int j = 0; j < array[i].length; j++){
//                if (array[i][j] == targer){
//                    return true;
//                }
//            }
//        }

        //2.利用递推属性
        int i = 0;
        int j = array[i].length-1;//正好是长度-1

        while (i < array.length && j > 0){
            if(array[i][j] == targer){
                return true;
            }else if(targer > array[i][j]){
                j = array[i].length-1;//重置到最后一个元素
                i++;
            }else{
                j--;
            }
        }
        return false;
    }

}
