package com.sun.androidlearn;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sun.androidlearn.ui.ListActivity;
import com.sun.androidlearn.ui.WechatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private Dialog mDialog;
    private Context mContext;
    private TextView mWeChatView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//second

//        mContext = getBaseContext();
        mContext = MainActivity.this;



        // 列表
        // ListView  很少很少
        // RecyclerView 用的比较多


        TextView view = findViewById(R.id.gotoListActivity);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,ListActivity.class));
            }
        });


        mWeChatView = findViewById(R.id.gotwechatActivity);
        mWeChatView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(mContext, WechatActivity.class));
            }
        });


        TextView dialog = findViewById(R.id.goto_dialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });

    }


    /**
     * 作业：写一个弹窗：有确认和取消，展示内容：修改成"列表页面"
     * 确认：关闭弹窗，修改文案
     * 取消：关闭弹窗
     */
    private void showDialog(){
        mDialog = new Dialog(mContext);
//        mDialog.setTitle("this is a dialog");
        mDialog.setContentView(R.layout.sample_dialog_layout);
        mDialog.show();

        Button closeButton = mDialog.findViewById(R.id.close_dialog);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDialog.dismiss();
                mWeChatView.setText("微信");
            }
        });
    }
}
