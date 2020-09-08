package com.example.securi.listView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.securi.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        adapter = new ListViewAdapter_datainfo(securi_datainfo.this, list);
        adapter.addDTO(new ListViewItem_datainfo("06/25", "data", R.mipmap.ic_launcher));
        listview_datainfo.setAdapter(adapter);

        listview_datainfo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListViewItem_datainfo dto = (ListViewItem_datainfo) adapter.getItem(position);

            }
        });
    }
}
