package com.sun.androidlearn;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sun.androidlearn.ui.ListActivity;
import com.sun.androidlearn.ui.WechatActivity;
import com.sun.androidlearn.ui.day01.TestFragment;
import com.sun.androidlearn.ui.day01.TestFragmentTwo;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    private TextView mTextView;
    private Dialog mDialog;
    private Context mContext;
    private TextView mWeChatView;
    private ConstraintLayout mContainer;
    private TestFragment mTestFragment;
    private FragmentTransaction mFragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG,"onCreate");
        setContentView(R.layout.activity_main);//second

//        mContext = getBaseContext();
        mContext = MainActivity.this;

        FragmentManager fragmentManager = getSupportFragmentManager();
        mFragmentTransaction = fragmentManager.beginTransaction();

        initList();
        initFragmentView();

    }





    private void initOneFragment(){
        mTestFragment = new TestFragment();
        mFragmentTransaction.add(R.id.container, mTestFragment);
        mFragmentTransaction.commit();
    }

    private void initFragmentView(){
        Button addButton = findViewById(R.id.fragment_add);
        Button removeButton = findViewById(R.id.fragment_remove);
        Button replaceButton = findViewById(R.id.fragment_replace);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initOneFragment();
            }
        });

        replaceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestFragmentTwo newFragment = new TestFragmentTwo();

                // Replace whatever is in the fragment_container view with this fragment,
                // and add the transaction to the back stack
                mFragmentTransaction.replace(R.id.container, newFragment);
                mFragmentTransaction.addToBackStack(null);

                // Commit the transaction
                mFragmentTransaction.commit();
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentTransaction.remove(mTestFragment);
                mFragmentTransaction.commit();
            }
        });

    }


    private void initList(){
        mContainer = findViewById(R.id.container);


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
     A -> B 跳转的生命周期执行顺序
     03-28 21:44:02.930 9696-9696/com.sun.androidlearn D/MainActivity: onCreate
     03-28 21:44:03.524 9696-9696/com.sun.androidlearn D/MainActivity: onStart
     03-28 21:44:03.538 9696-9696/com.sun.androidlearn D/MainActivity: onResume
     03-28 21:44:23.501 9696-9696/com.sun.androidlearn D/MainActivity: onPause
     03-28 21:44:23.667 9696-9696/com.sun.androidlearn D/ListActivity: onCreate
     03-28 21:44:23.702 9696-9696/com.sun.androidlearn D/ListActivity: onStart
     03-28 21:44:23.705 9696-9696/com.sun.androidlearn D/ListActivity: onResume
     03-28 21:44:24.486 9696-9696/com.sun.androidlearn D/MainActivity: onStop
     03-28 21:44:52.876 9696-9696/com.sun.androidlearn D/ListActivity: onPause
     03-28 21:44:52.913 9696-9696/com.sun.androidlearn D/MainActivity: onRestart
     03-28 21:44:52.924 9696-9696/com.sun.androidlearn D/MainActivity: onStart
     03-28 21:44:52.927 9696-9696/com.sun.androidlearn D/MainActivity: onResume
     03-28 21:44:53.620 9696-9696/com.sun.androidlearn D/ListActivity: onStop
     03-28 21:44:53.624 9696-9696/com.sun.androidlearn D/ListActivity: onDestroy
     */

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }

    //生命周期
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    //View可见的
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    //不可见
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
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
