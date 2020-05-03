package com.sun.androidlearn.ui.day08;

import android.util.Log;

import com.google.gson.Gson;
import com.sun.androidlearn.ui.day06.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: jfson sun
 * Create on:  2020/5/3
 * Question:
 * Description:
 * Train of thought:
 */
public class JsonData {
    /**
     Json ：格式名称，用来做数据交互的格式。
     Server --- 发送网络请求 --- 告诉app 数据 ---> json 数据

     简单数据：
     {
     "firstName":"John" ,
     "lastName":"Doe" ,
     "age":17,
     "sex":"male",
     "height":170
     }

     复杂数据：
     {
     "firstName":"John" ,
     "employees":
     [
     { "firstName":"John" ,"lastName":"Doe" ,"age":17, "sex":"male","height":170    },
     { "firstName":"Anna" , "lastName":"Smith","age":17, "sex":"male","height":170  },
     { "firstName":"Peter" , "lastName":"Jones","age":17, "sex":"male","height":170 }
     ]
     }
     */

    public static List<Employer.VideosBean> testGSON(){
        String serverData = "{\n" +
                "\t\"firstName\": \"John\",\n" +
                "\t\"videos\": [{\n" +
                "\t\t\t\"firstName\": \"John\",\n" +
                "\t\t\t\"time\": \"Doe\",\n" +
                "\t\t\t\"age\": 17,\n" +
                "\t\t\t\"sex\": \"male\",\n" +
                "\t\t\t\"height\": 170\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"firstName\": \"Anna\",\n" +
                "\t\t\t\"lastName\": \"Smith\",\n" +
                "\t\t\t\"age\": 17,\n" +
                "\t\t\t\"sex\": \"male\",\n" +
                "\t\t\t\"height\": 170\n" +
                "\t\t},\n" +
                "\t\t{\n" +
                "\t\t\t\"firstName\": \"Peter\",\n" +
                "\t\t\t\"lastName\": \"Jones\",\n" +
                "\t\t\t\"age\": 17,\n" +
                "\t\t\t\"sex\": \"male\",\n" +
                "\t\t\t\"height\": 170\n" +
                "\t\t}\n" +
                "\t]\n" +
                "}";

        Gson gson = new Gson();
        Employer user = gson.fromJson(serverData, Employer.class);
        return user.getVideos();
    }

    /**
     * 复杂数组数据
     */
    public static ArrayList<User> testArray(){
        ArrayList<User> ret = new ArrayList<>();
        String serverData = "{\n" +
                "     \"firstName\":\"John\" ,\n" +
                "     \"users\":\n" +
                "     [\n" +
                "     { \"firstName\":\"John1\" ,\"lastName\":\"Doe\" ,\"age\":17, \"sex\":\"male\",\"height\":170    },\n" +
                "     { \"firstName\":\"Anna2\" , \"lastName\":\"Smith\",\"age\":18, \"sex\":\"male\",\"height\":170  },\n" +
                "     { \"firstName\":\"Peter3\" , \"lastName\":\"Jones\",\"age\":19, \"sex\":\"male\",\"height\":170 }\n" +
                "     ]\n" +
                "     }";

        try {

            //整体是个JSONObject
            JSONObject object = new JSONObject(serverData);

            JSONArray array = null;
            //users才是个数组
            if (object.has("users")){
                array = object.getJSONArray("users");
            }

            if (array == null || array.length() <= 0){
                return ret;
            }

            for (int i = 0; i < array.length(); i++) {
                User currUser = new User();
                JSONObject curr = array.getJSONObject(i);
                if (curr.has("firstName")){
                    String firstName = curr.getString("firstName");
                    Log.e("Test","firstName:" + firstName);
                    currUser.setUsername(firstName);
                }

                if (curr.has("age")){
                    int age = curr.getInt("age");
                    Log.e("Test","age:" + age);
                    currUser.setAge(String.valueOf(age));
                }

                ret.add(currUser);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return ret;
    }



    /**
     * 简单数据
     */
    public static void test(){
        String serverData = "{\n" +
                "     \"firstName\":\"John\" ,\n" +
                "     \"lastName\":\"Doe\" ,\n" +
                "     \"age\":17,\n" +
                "     \"sex\":\"male\",\n" +
                "     \"height\":170\n" +
                "     }\n";
        try {
            JSONObject object = new JSONObject(serverData);
            if (object.has("firstName")){
                String firstName = object.getString("firstName");
                Log.e("Test","firstName:" + firstName);
            }

            if (object.has("age")){
                int age = object.getInt("age");
                Log.e("Test","age:" + age);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
