package com.example.securi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.securi.R;
import com.example.securi.navActivity.securi_autoopen;
import com.example.securi.register.securi_login;
import com.example.securi.additionalActivity.securi_outdoorinfo;

public class Menu3Fragment extends Fragment implements View.OnClickListener {
TextView joinState;
Button outInfo, autoOpen, btnlogin;
    public Menu3Fragment(){

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.securi_home,container,false);
        outInfo = view.findViewById(R.id.outInfo);
        autoOpen = view.findViewById(R.id.autoOpen);
        btnlogin = view.findViewById(R.id.btnlogin);
        joinState = (TextView)view.findViewById(R.id.joinState);

        outInfo.setOnClickListener(this);
        autoOpen.setOnClickListener(this);
        btnlogin.setOnClickListener(this);

        return view;


    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.outInfo:
                Intent intent = new Intent(getActivity(), securi_outdoorinfo.class);
                startActivity(intent);
                break;
            case R.id.autoOpen:
                Intent intent2 = new Intent(getActivity(), securi_autoopen.class);
                startActivity(intent2);
                break;
            case R.id.btnlogin:
                btnlogin.setVisibility(View.GONE);
                joinState.setVisibility(View.VISIBLE);
                Intent intent3 = new Intent(getActivity(), securi_login.class);
                startActivity(intent3);

                break;
        }
    }
    public void setTextViewValue(String str){
        joinState.setText(str);
    }
   // @OnClick(R.id.btnlogin) void onClick(){

    //}
}