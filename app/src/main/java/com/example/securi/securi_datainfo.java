package com.example.securi;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class securi_datainfo extends AppCompatActivity {
    ListView listview_datainfo;
    ArrayList<ListViewItem_datainfo> list;
    ListViewAdapter_datainfo adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.securi_datainfo);
        listview_datainfo = findViewById(R.id.listview_datainfo);
        list = new ArrayList<>();

        //어댑터에 추가
        adapter = new ListViewAdapter_datainfo(securi_datainfo.this,list);
        adapter.addDTO(new ListViewItem_datainfo("06/25","data",R.mipmap.ic_launcher));
        listview_datainfo.setAdapter(adapter);

        listview_datainfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListViewItem_datainfo dto = (ListViewItem_datainfo)adapter.getItem(position);
            }
        });


    }
}
