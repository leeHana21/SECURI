package com.example.securi.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        TextView conSensor = view.findViewById(R.id.conSensor);
        TextView conCam = view.findViewById(R.id.conCam);
        LinearLayout conSensor_extend = view.findViewById(R.id.conSensor_extend);
        LinearLayout conCam_extend = view.findViewById(R.id.conCam_extend);
        addNfc.setOnClickListener(this);
        delNfc.setOnClickListener(this);
        conSensor.setOnClickListener(this);
        conSensor_extend.setOnClickListener(this);
        conCam.setOnClickListener(this);
        conCam_extend.setOnClickListener(this);

        return view;
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.addNfc:
                Intent intent = new Intent(getActivity(), securi_addnfc.class);
                startActivity(intent);
                break;
            case R.id.conCam:
            case R.id.conCam_extend:
                Toast.makeText(getActivity(), "카메라가 꺼졌습니다", Toast.LENGTH_SHORT).show();
                break;
            case R.id.conSensor:
            case R.id.conSensor_extend:
                Toast.makeText(getActivity(), "도어센서가 꺼졌습니다", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}