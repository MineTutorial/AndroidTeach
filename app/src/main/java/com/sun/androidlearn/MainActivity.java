package com.sun.androidlearn;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.sun.androidlearn.ui.ListActivity;
import com.sun.androidlearn.ui.WechatActivity;
import com.sun.androidlearn.ui.day01.TestFragment;
import com.sun.androidlearn.ui.day01.TestFragmentMyThree;
import com.sun.androidlearn.ui.day01.TestFragmentTwo;
import com.sun.androidlearn.ui.day01.ViewListener;
import com.sun.androidlearn.ui.day01.ViewListenerTwo;
import com.sun.androidlearn.ui.day02.AnimActivity;
import com.sun.androidlearn.ui.day02.AnimActivityMyOne;
import com.sun.androidlearn.ui.day02.ViewPagerActivity;
import com.sun.androidlearn.ui.day02.ViewPagerActivityMy;
import com.sun.androidlearn.ui.day03.PermissionActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = "MainActivity";
    private TextView mTextView;
    private Dialog mDialog;
    private Context mContext;
    private TextView mWeChatView;
    private ConstraintLayout mContainer;
    private TestFragment mTestFragment;
    private TestFragmentMyThree mTestFragmentmythree;
    private FragmentTransaction mFragmentTransaction;
    private FragmentTransaction mFragmentTransactionMy;
    private ViewListener mClickView;
    private ViewListenerTwo mClickViewTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate");
        setContentView(R.layout.activity_main);//second

//        mContext = getBaseContext();
        mContext = MainActivity.this;

        FragmentManager fragmentManager = getSupportFragmentManager();
        mFragmentTransaction = fragmentManager.beginTransaction();

        initList();
        initFragmentView();
        initFragmentMyThree();//onCreate调用一下
        initFragmentView02();


        mClickView = new ViewListener();
        mClickView.setOnClickLisenter(new ViewListener.Listener() {
            @Override
            public void onClick() {
                Toast.makeText(mContext, "接口回调", Toast.LENGTH_LONG).show();
            }
        });

        mClickViewTwo = new ViewListenerTwo();//接口回调另一种方法
        mClickViewTwo.setOnClickLisenter(new ViewListenerTwo.Listener() {
            @Override
            public void onclick() {
            Toast.makeText(mContext,"接口回调",Toast.LENGTH_LONG).show();
            }
        });


        TextView anim = findViewById(R.id.goto_anim);
        anim.setOnClickListener(this);



        //动画
        TextView anim_myone = findViewById(R.id.goto_anim_myone);
        anim_myone.setOnClickListener(this);

        findViewById(R.id.goto_pager).setOnClickListener(this);
        findViewById(R.id.goto_camer).setOnClickListener(this);
        findViewById(R.id.goto_permission).setOnClickListener(this);
        findViewById(R.id.goto_camermy).setOnClickListener(this);
        findViewById(R.id.goto_pagermy).setOnClickListener(this);
        findViewById(R.id.goto_permissiomy).setOnClickListener(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 666){//List result
            if (data != null){
                Bundle extras = data.getExtras();
                String setResult = extras.getString("setResult");
                Toast.makeText(this,setResult,Toast.LENGTH_LONG).show();
            }

        }

    }

    @Override
    public void onActivityReenter(int resultCode, Intent data) {
        super.onActivityReenter(resultCode, data);
        if (resultCode == 777) {//anim res
            data.getExtras();//resultCode一个页面多种情况，， requestCode 多种页面使用一种情况

        }
    }

    private void initOneFragment() {
        mTestFragment = new TestFragment();
        mFragmentTransaction.add(R.id.container, mTestFragment);
        mFragmentTransaction.commit();
    }

    private void initFragmentView() {
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
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                mFragmentTransaction.remove(mTestFragment);
                mFragmentTransaction.commit();
            }
        });

    }

    //myTestFragmentMyThree=initOneFragment
    private void initFragmentMyThree(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        mFragmentTransactionMy = fragmentManager.beginTransaction();

        mTestFragmentmythree = new TestFragmentMyThree();
        mFragmentTransactionMy.add(R.id.container, mTestFragmentmythree);
        mFragmentTransactionMy.commit();//管理fragment
    }
    //3个add、remove、replace=initFragmentView
    private void initFragmentView02(){
        Button addButton02 = findViewById(R.id.fragment_add02);
        Button removeButton02 = findViewById(R.id.fragment_remove02);
        Button replaceButton02 = findViewById(R.id.fragment_replace02);

        addButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initFragmentMyThree();//调用
            }
        });

        replaceButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TestFragmentTwo newFragment = new TestFragmentTwo();
                mFragmentTransactionMy = getSupportFragmentManager().beginTransaction();
                mFragmentTransactionMy.replace(R.id.container, newFragment);
                mFragmentTransactionMy.addToBackStack(null);
                mFragmentTransactionMy.commit();
            }
        });

        removeButton02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentTransactionMy = getSupportFragmentManager().beginTransaction();
                mFragmentTransactionMy.remove(mTestFragmentmythree);
                mFragmentTransactionMy.commit();
            }
        });
    }






    private void initList() {
        mContainer = findViewById(R.id.container);


        // 列表
        // ListView  很少很少
        // RecyclerView 用的比较多


        TextView view = findViewById(R.id.gotoListActivity);

        view.setOnClickListener(this);


        mWeChatView = findViewById(R.id.gotwechatActivity);
        mWeChatView.setOnClickListener(this);


        TextView dialog = findViewById(R.id.goto_dialog);
        dialog.setOnClickListener(this);
    }


    /**
     * A -> B 跳转的生命周期执行顺序
     * 03-28 21:44:02.930 9696-9696/com.sun.androidlearn D/MainActivity: onCreate
     * 03-28 21:44:03.524 9696-9696/com.sun.androidlearn D/MainActivity: onStart
     * 03-28 21:44:03.538 9696-9696/com.sun.androidlearn D/MainActivity: onResume
     * 03-28 21:44:23.501 9696-9696/com.sun.androidlearn D/MainActivity: onPause
     * 03-28 21:44:23.667 9696-9696/com.sun.androidlearn D/ListActivity: onCreate
     * 03-28 21:44:23.702 9696-9696/com.sun.androidlearn D/ListActivity: onStart
     * 03-28 21:44:23.705 9696-9696/com.sun.androidlearn D/ListActivity: onResume
     * 03-28 21:44:24.486 9696-9696/com.sun.androidlearn D/MainActivity: onStop
     * 03-28 21:44:52.876 9696-9696/com.sun.androidlearn D/ListActivity: onPause
     * 03-28 21:44:52.913 9696-9696/com.sun.androidlearn D/MainActivity: onRestart
     * 03-28 21:44:52.924 9696-9696/com.sun.androidlearn D/MainActivity: onStart
     * 03-28 21:44:52.927 9696-9696/com.sun.androidlearn D/MainActivity: onResume
     * 03-28 21:44:53.620 9696-9696/com.sun.androidlearn D/ListActivity: onStop
     * 03-28 21:44:53.624 9696-9696/com.sun.androidlearn D/ListActivity: onDestroy
     */

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    //生命周期
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    //View可见的
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    //不可见
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
        mClickView.pause();
        mClickViewTwo.pause();//在onpause这个阶段去调ViewListenerTwo
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    /**
     * 作业：写一个弹窗：有确认和取消，展示内容：修改成"列表页面"
     * 确认：关闭弹窗，修改文案
     * 取消：关闭弹窗
     */
    private void showDialog() {
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

    @Override
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.gotoListActivity:
                Intent intent = new Intent(mContext, ListActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("mian","this is main");
                intent.putExtra("putExtra","sss");
                intent.putExtras(bundle);
//                startActivity(intent);
                startActivityForResult(intent,666);
                break;
            case R.id.gotwechatActivity:
                startActivity(new Intent(mContext, WechatActivity.class));
                break;
            case R.id.goto_dialog:
                showDialog();
                break;
            case R.id.goto_anim:
                startActivity(new Intent(mContext, AnimActivity.class));
                break;
            case R.id.goto_anim_myone:
                Intent intentMy = new Intent(mContext,AnimActivityMyOne.class);
                Bundle bundleMy = new Bundle();//intent 就是一个传递消息的工具,打开页面，还可以带加一些命令
                bundleMy.putString("mian","this is main");//bundle是一个器皿装转东西的
                intentMy.putExtra("putExtra","sss");//带有显隐式
                intentMy.putExtras(bundleMy);
//                startActivity(intentMy);
                startActivityForResult(intentMy,777);//区分码
                break;
            case R.id.goto_pager:
                startActivity(new Intent(mContext, ViewPagerActivity.class));
                break;
            case R.id.goto_pagermy:
                startActivity(new Intent(mContext, ViewPagerActivityMy.class));
                break;
            case R.id.goto_camer:
                Intent camer = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(camer);
                break;
            case R.id.goto_camermy:
                Intent camermy = new Intent(MediaStore.INTENT_ACTION_STILL_IMAGE_CAMERA);
                startActivity(camermy);
            case R.id.goto_permission:
                startActivity(new Intent(mContext, PermissionActivity.class));
                break;
            case R.id.goto_permissiomy:
                startActivity(new Intent(mContext, PermissionActivity.class));

        }
    }
}
