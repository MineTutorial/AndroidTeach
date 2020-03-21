package com.sun.androidlearn.ui;

import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sun.androidlearn.R;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
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
        data2.add("创造108");
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
