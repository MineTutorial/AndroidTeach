package com.sun.androidlearn.orderoffer;

import java.util.ArrayList;
import java.util.Collections;

public class PrintListNode03 {

    /**
     * 输入一个链表，按链表从尾到头顺序返回一个ArrayList
     * 递归
     */

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<>();
        helper(list,listNode);
        Collections.reverse(list);
        return list;
    }

    private void helper(ArrayList<Integer> list, ListNode listNode) {
    }


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        //(0,next->1)
        //(3,next->null)

        ArrayList<Integer> list = new ArrayList<>();
        //安全校验
        if (listNode == null ){
            return list;
        }

        //从头到尾
        //size length 概念
        //0 1 2 3 null
        while (listNode != null){
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        return list;
    }


}
