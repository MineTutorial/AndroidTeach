package com.sun.androidlearn.ui.day06;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.sun.androidlearn.Main2Activity;
import com.sun.androidlearn.R;


/**
 * 数据持久化，存放数据保证长久使用的sp，
 * 1.shared perferences
 */
public class DateMyActivity extends AppCompatActivity {
    EditText name,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_my);


        name = findViewById(R.id.usernamemy);//用户名作为key
        password = findViewById(R.id.passwordmy);
        Button login = findViewById(R.id.loginmy);
        login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //设置点击事件
//                    setSp(getBaseContext());//相当于记住密码

                    startActivity(new Intent(DateMyActivity.this,LaunchModeMyActivity.class));
//                    findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                            startActivity(new Intent(DateMyActivity.this, Main2Activity.class));
//                        }
//                    });
                }
        });
//        Button getPassword = findViewById(R.id.getPasswordmy);
//        getPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        getSp(getBaseContext());
    }

    private void setSp(Context context){
        SharedPreferences sp = context.getSharedPreferences("DateMyActivity",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();//找出edit，有edit才可以存东西
        editor.putString("name", name.getText().toString());//局限于非多账号，多账号需要以用户名作为key，读取password。而这个就是读取name/password来读出
        editor.putString("password", password.getText().toString());
//        editor.putInt("age",0);
//        editor.putBoolean("read",true);
//        editor.commit();   同步异步之差
        //提交时才用edit
        editor.apply();
    }

    private void getSp(Context context){

        SharedPreferences sp = context.getSharedPreferences("DateMyActivity", Context.MODE_PRIVATE);
        String spname = sp.getString("name",null);//null为初始值
        String sppasswordsp = sp.getString("password",null);
        //name不能和框架名重合
        if (name != null){
            name.setText(spname);//填充
        }
        if(password != null){
            password.setText(sppasswordsp);
        }
    }

}
