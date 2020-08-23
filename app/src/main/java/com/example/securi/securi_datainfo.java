package com.example.securi;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class securi_datainfo extends AppCompatActivity {
    static final String[] LIST_MENU = {"LIST1","LIST2","LIST3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.securi_datainfo);
        ListView listview_datainfo;
        ListViewAdapter_datainfo adapter;

        adapter = new ListViewAdapter_datainfo();
        listview_datainfo = findViewById(R.id.listview_datainfo);
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,LIST_MENU);
        listview_datainfo.setAdapter(adapter);

        adapter.addItem_dataInfo("06/24","data1",R.mipmap.camera);

        //추후 파이어베이스에서 가져올 수 있게 구현해야함
        listview_datainfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }
}
