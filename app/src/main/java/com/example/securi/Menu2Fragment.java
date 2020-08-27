package com.example.securi;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Menu2Fragment extends Fragment implements View.OnClickListener{

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.securi_autoopen, container, false);
        Button checkHistory = view.findViewById(R.id.checkHistory);
        checkHistory.setOnClickListener(this);
        return view;
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.checkHistory:
                Intent intent = new Intent(getActivity(),securi_datainfo.class);
                startActivity(intent);
                break;
        }
    }
}
