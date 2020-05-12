package com.sun.androidlearn.ui.day10;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;
import com.sun.androidlearn.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 常用的网络库/框架
 * Retrofit & Okhttp
 */
public class RequestActivity extends AppCompatActivity {
    public static final String TAG = RequestActivity.class.getSimpleName();
    private TextView mTextView;
    private SimpleDraweeView mPic;
    private Handler mHandler =new Handler(Looper.myLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data2);

        initView();
        requestData();

    }

    private void initView(){
        mTextView = findViewById(R.id.text);
        mPic = findViewById(R.id.pic);
    }

    private void refreshData(OneModel model){
        if (model == null || model.getData() == null){
            return;
        }

        OneModel.DataBean dataBean = model.getData().get(1);
        mTextView.setText(dataBean.getText());
        mPic.setImageURI(Uri.parse(dataBean.getSrc()));
    }

    private void requestData(){
        String url = "http://api.youngam.cn/api/one.php";//server地址
        OkHttpClient okHttpClient = new OkHttpClient();

        RequestBody requestBody = new FormBody.Builder()
                .add("username", "qinzishuai")
                .add("password", "111111")
                .build();

        final Request request = new Request.Builder()
                .url(url)
                .get()
//                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
//                Log.d(TAG,response.body().string());
                String result = response.body().string();//jfson
                Gson gson = new Gson();

                //server json -->  Model
                final OneModel model = gson.fromJson(result, OneModel.class);

                //切到mainThread
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        refreshData(model);
                    }
                });
//                mHandler.post(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                });
//                mPic.post(new Runnable() {
//                    @Override
//                    public void run() {
//
//                    }
//                });

            }
        });
    }
}
