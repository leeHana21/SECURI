package com.example.securi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class securi_autoopen extends Activity {
    Button btndoorOpen, checkHistory;
    TextView doorStateTxt, serverState, lockState;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.securi_autoopen);
        serverState = findViewById(R.id.serverState);
        lockState = findViewById(R.id.lockState);
        doorStateTxt = findViewById(R.id.doorStateTxt);
        btndoorOpen = findViewById(R.id.btndoorOpen);
        checkHistory = findViewById(R.id.checkHistory);

        int a=1;
        if (a==0){
            doorStateTxt.setText("출입문 잠금 해제");
            serverState.setText("서버 연결 불안정");
            lockState.setText("잠긍장치 해제 상태");
        }else{
            doorStateTxt.setText("출입문 잠금 중");
            serverState.setText("서버 연결 정상");
            lockState.setText("잠긍장치 작동 중");
        }

        checkHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),securi_entryhistory.class);
                startActivity(intent);
            }
        });

        btndoorOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //문열림 서버 연결 코딩 해야함(서버 ->아두이노 통신)
            }
        });


    }
}