package com.example.securi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class securi_entryhistory extends AppCompatActivity {
    ImageView entryData;
    private ListView listview;
    private ListViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.securi_entryhistory);

//        entryData = findViewById(R.id.entryData);
//        entryData.setOnClickListener(new View.OnClickListener() {
//         @Override
//             public void onClick(View view) {
//                 Intent intent = new Intent(getApplicationContext(),securi_datainfo.class);
//                 startActivity(intent);
//             }
//         });
        adapter = new ListViewAdapter();

        listview = (ListView)findViewById(R.id.listview);
        listview.setAdapter(adapter);

        adapter.addItem("제목1", R.mipmap.securilogo,"내용1");
        adapter.notifyDataSetChanged();
    }
}