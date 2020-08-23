package com.example.securi;

import androidx.fragment.app.ListFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
//import androidx.fragment.app.Fragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Menu4Fragment extends ListFragment{
ListViewAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adapter = new ListViewAdapter();
        setListAdapter(adapter);

        //추후 파이어베이스에서 가져올 수 있게 구현해야함
        adapter.addItem("08/20","출입","17시 20분 33초",R.mipmap.camera);
        adapter.addItem("08/20","출입","17시 20분 33초",R.mipmap.camera);
        adapter.addItem("08/20","출입","17시 20분 33초",R.mipmap.camera);
        //View view = inflater.inflate(R.layout.securi_entryhistory, container, false);

        return super.onCreateView(inflater, container, savedInstanceState);
    }
    public void onListItemClick(ListView l, View v, int position,  long id){
        Intent intent = new Intent(getActivity(),securi_datainfo.class);
        startActivity(intent);
       }
    }

