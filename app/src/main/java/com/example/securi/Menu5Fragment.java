package com.example.securi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Menu5Fragment  extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.securi_mypage, container, false);
        Button serverInfo = view.findViewById(R.id.serverInfo);
        Button dataInfo = view.findViewById(R.id.dataInfo);
        Button notiInfo = view.findViewById(R.id.notiInfo);
        serverInfo.setOnClickListener(this);
        dataInfo.setOnClickListener(this);
        notiInfo.setOnClickListener(this);
        return view;
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.serverInfo:
                Intent intent = new Intent(getActivity(),securi_serverinfo.class);
                startActivity(intent);
                break;
            case R.id.dataInfo:
                Intent intent2 = new Intent(getActivity(),securi_datainfo.class);
                startActivity(intent2);
                break;
            case R.id.notiInfo:
                Intent intent3 = new Intent(getActivity(),securi_notiinfo.class);
                startActivity(intent3);
                break;
        }
    }
}
