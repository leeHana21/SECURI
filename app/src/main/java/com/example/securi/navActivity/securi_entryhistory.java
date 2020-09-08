package com.example.securi.navActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

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

public class securi_entryhistory extends AppCompatActivity {
    static final String[] LIST_MENU = {"LIST1","LIST2","LIST3"};
    private FirebaseDatabase mDatabase;
    private DatabaseReference mReference;
    private ChildEventListener mChild;
    List<Object> Array = new ArrayList<Object>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.securi_entryhistory);
        initDatabase();
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,LIST_MENU);
        final ListFragment menuListFrgmt = (ListFragment) getSupportFragmentManager().findFragmentById(R.id.frame_layout);
        menuListFrgmt.setListAdapter(adapter) ;
        mReference = mDatabase.getReference("Timestamp");
        mReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                adapter.clear();
                for (DataSnapshot messageData : dataSnapshot.getChildren()){
                    String msg2 = messageData.getValue().toString();
                    Array.add(msg2);
                    adapter.add(msg2);
                }
                adapter.notifyDataSetChanged();
                menuListFrgmt.setSelection(adapter.getCount()-1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    private void initDatabase() {

        mDatabase = FirebaseDatabase.getInstance();

        mReference = mDatabase.getReference("Push");
        mReference.child("Push").setValue("check");

        mChild = new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        mReference.addChildEventListener(mChild);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mReference.removeEventListener(mChild);
    }
}