package com.example.day0927;

import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ExpandableListView elv;
    private MyExpandableListAdapter myExpandableListAdapter;

    //数据
    String[] group = {"张学友", "张国荣"};
    String[][] child = {
            {"饿狼传说", "遥远的她"},
            {"风继续吹", "春夏秋冬"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        listener();
    }

    private void initView() {
        elv = findViewById(R.id.elv);
        myExpandableListAdapter = new MyExpandableListAdapter(group, child, this);
        elv.setAdapter(myExpandableListAdapter);
    }


    private void listener() {
        //设置一级列表的点击事件
        elv.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Toast.makeText(MainActivity.this, group[groupPosition], Toast.LENGTH_SHORT).show();
                //返回false 否则一级列表不会展开
                return false;
            }
        });

        //设置二级列表的点击事件
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Toast.makeText(MainActivity.this, child[groupPosition][childPosition], Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

}
