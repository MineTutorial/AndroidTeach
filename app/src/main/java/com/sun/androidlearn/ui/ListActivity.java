package com.sun.androidlearn.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sun.androidlearn.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    public static final String TAG = "ListActivity";
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private SwipeRefreshLayout mRefreshView;
     ArrayList<String> data;
     ArrayList<String> data2;
    //作业：
    //微信列表：
    //微信列表：下拉数据刷新，更新新的数据

    /**

     图   Name
     图   chat
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Log.d(TAG,"onCreate");

//        Intent intent = ListActivity.this.getIntent();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String str = extras.getString("mian");
        String extra = intent.getStringExtra("putExtra");
        Toast.makeText(this,extra,Toast.LENGTH_LONG).show();


        //test data
        initData();

        recyclerView = findViewById(R.id.recycler);
        mRefreshView = findViewById(R.id.swiperefresh);
        mRefreshView.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(ListActivity.this,"刷新成功",Toast.LENGTH_LONG).show();
                mRefreshView.setRefreshing(false);
                data.clear();
                data.addAll(data2);
                mAdapter.notifyDataSetChanged();
            }
        });

        //LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);

//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new MyAdapter(data);
        recyclerView.setAdapter(mAdapter);
    }



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

    private void initData(){
        data = new ArrayList<>();
        data.add("盗墓笔记1");
        data.add("盗墓笔记2");
        data.add("盗墓笔记3");
        data.add("盗墓笔记4");
        data.add("盗墓笔记5");
        data.add("盗墓笔记6");
        data.add("盗墓笔记7");
        data.add("盗墓笔记8");
        data.add("盗墓笔记9");
        data.add("盗墓笔记10");
        data.add("盗墓笔记11");
        data.add("盗墓笔记12");
        data.add("盗墓笔记13");
        data.add("盗墓笔记14");
        data.add("盗墓笔记15");
        data.add("盗墓笔记16");


        data2 = new ArrayList<>();
        data2.add("创造101");
        data2.add("创造102");
        data2.add("创造103");
        data2.add("创造104");
        data2.add("创造105");
        data2.add("创造106");
        data2.add("创造107");
        data2.add(getBaseContext().getResources().getString(R.string.hint));
        data2.add(getBaseContext().getResources().getString(R.string.hint_two));//还可以getColor。。。
    }

    public void test() {
        recyclerView = null;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;

        public MyViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.item_text);
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.putExtra("setResult","hahhaa");
                    ListActivity.this.setResult(666,intent);
                    ListActivity.this.finish();
                }
            });
        }




        public void setData(String text) {
            textView.setText(text);
        }
    }

    //Adapter
    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> {
        private ArrayList<String> mList;

        public MyAdapter(ArrayList<String> list) {
            mList = list;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                               int viewType) {
            // create a new view
            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_item, parent, false);

            MyViewHolder vh = new MyViewHolder(v);
            return vh;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            // - get element from your dataset at this position
            // - replace the contents of the view with that element
            holder.setData(mList.get(position));

        }

        // Return the size of your dataset (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return mList.size();
        }
    }
}
