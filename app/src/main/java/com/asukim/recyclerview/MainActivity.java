package com.asukim.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<RecyclerItem> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //recyclerView에 표시할 데이터 리스트 생성.
        loadData();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        //recyclerView에 RecyclerAdapter 객체 지정.
        recyclerView.setAdapter(new RecyclerAdapter(getApplicationContext(), items, R.layout.activity_main));
    }

    public void loadData() {
        //recyclerView에 표시할 데이터 리스트 생성.
        for (int i = 0; i <= 20; i++) {
            items.add(new RecyclerItem(R.mipmap.ic_launcher, "text" + i));
        }
    }
}
