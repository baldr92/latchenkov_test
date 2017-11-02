package com.lpn.latchenkov_test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Api api;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataProvider dataProvider = new DataProvider();
        dataProvider.initApi();
        api = dataProvider.getApi();
        api.getPost(1);


        final CardsAdapter adapter = new CardsAdapter(this);
        CardsAdapter.PostGetListener listener = new CardsAdapter.PostGetListener() {
            @Override
            public void getPost(int id) {
                Post post = api.getPost(id);
                DataState state = new DataState();
                state.setPost(post);
                adapter.notifyDataSetChanged();
            }
        };
        adapter.setPostGetListener(listener);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}
