package com.example.securi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

public class securi_entryhistory extends AppCompatActivity {
    static final String[] LIST_MENU = {"LIST1","LIST2","LIST3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.securi_entryhistory);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,LIST_MENU);
        ListFragment menuListFrgmt = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        menuListFrgmt.setListAdapter(adapter) ;

    }
}