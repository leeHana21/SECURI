package com.example.securi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.securi.R;
import com.example.securi.additionalActivity.securi_addnfc;

public class Menu1Fragment extends Fragment implements View.OnClickListener {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.securi_sensor,container,false);
        Button addNfc = view.findViewById(R.id.addNfc);
        Button delNfc = view.findViewById(R.id.delNfc);
        Button conSensor = view.findViewById(R.id.conSensor);
        Button conCam = view.findViewById(R.id.conCam);
        addNfc.setOnClickListener(this);
        delNfc.setOnClickListener(this);
        conSensor.setOnClickListener(this);
        conCam.setOnClickListener(this);

        return view;
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.addNfc:
                Intent intent = new Intent(getActivity(), securi_addnfc.class);
                startActivity(intent);
                break;
        }
    }

}