package com.example.securi.navActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.securi.R;


public class securi_home extends AppCompatActivity {
    Button autoOpen, outInfo, btnlogin;
    TextView camState, sensorState, doorState, joinState;
@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.securi_home);

        autoOpen = findViewById(R.id.autoOpen);
        outInfo = findViewById(R.id.outInfo);
        doorState = findViewById(R.id.doorState);
        camState = findViewById(R.id.camState);
        sensorState = findViewById(R.id.sensorState);
        btnlogin = findViewById(R.id.btnlogin);
        joinState = findViewById(R.id.joinState);

//        btnlogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                btnlogin.setVisibility(View.GONE);
//                joinState.setVisibility(View.VISIBLE);
//                joinState.setText(R.string.email+"님 환영합니다.");
//            }
//        });
        //상태 정보 받아와서 텍스트뷰에 작동상태 출력
        int a = 0;
        if(a == 1){
            camState.setText("OFF");
        }else{
            camState.setText("ON");
        }
        
        if(a == 1){
            sensorState.setText("OFF");
        }else{
            sensorState.setText("ON");
        }

        if(a==1){
            doorState.setText("잠금 해제");
        }else{
            doorState.setText("잠금 중");
        }
    }
}