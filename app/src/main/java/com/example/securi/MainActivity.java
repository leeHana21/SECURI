package com.example.securi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    Menu3Fragment frag;
    Menu3Fragment frag2;
    FragmentManager manager;
    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    private FragmentManager fragmentManager = getSupportFragmentManager();
    // 4개의 메뉴에 들어갈 Fragment들
    private Menu1Fragment menu1Fragment = new Menu1Fragment();
    private Menu2Fragment menu2Fragment = new Menu2Fragment();
    private Menu3Fragment menu3Fragment = new Menu3Fragment();
    private Menu4Fragment menu4Fragment = new Menu4Fragment();
    private Menu5Fragment menu5Fragment = new Menu5Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        manager = getSupportFragmentManager();
        frag = (Menu3Fragment)manager.findFragmentById(R.id.joinState);
        frag2 = (Menu3Fragment)manager.findFragmentById(R.id.btnlogin);

        //앱 로딩화면 띄우기
        Intent intent = new Intent(this, LoadingActivity.class);
        startActivity(intent);

        //하단 네비게이션 선언
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);



        // 첫 화면 지정
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        manager.beginTransaction().replace(R.id.frame_layout, new Menu3Fragment()).commit();
        //transaction.replace(R.id.frame_layout, menu3Fragment).commitAllowingStateLoss();

        // bottomNavigationView의 아이템이 선택될 때 호출될 리스너 등록
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (item.getItemId()) {
                    case R.id.connect: {
                        manager.beginTransaction().replace(R.id.frame_layout, new Menu1Fragment()).commit();
                        break;
                    }
                    case R.id.autoOpen: {
                        manager.beginTransaction().replace(R.id.frame_layout, new Menu2Fragment()).commit();
                        //transaction.replace(R.id.frame_layout, menu2Fragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.home: {
                        manager.beginTransaction().replace(R.id.frame_layout, new Menu3Fragment()).commit();
                        //transaction.add(R.id.frame_layout, menu3Fragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.history: {
                        manager.beginTransaction().replace(R.id.frame_layout, new Menu4Fragment()).commit();
                        //transaction.replace(R.id.frame_layout, menu4Fragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.myPage: {
                        manager.beginTransaction().replace(R.id.frame_layout, new Menu5Fragment()).commit();
                        //transaction.replace(R.id.frame_layout, menu5Fragment).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });
//        //서버 연결
//        // URL 설정.
//        String url = "http://127.0.0.1/";
//
//        // AsyncTask를 통해 HttpURLConnection 수행.
//        NetworkTask networkTask = new NetworkTask(url, null);
//        networkTask.execute();
//    }
//
//    public class NetworkTask extends AsyncTask<Void, Void, String> {
//
//        private String url;
//        private ContentValues values;
//
//        public NetworkTask(String url, ContentValues values) {
//
//            this.url = url;
//            this.values = values;
//        }
//
//        @Override
//        protected String doInBackground(Void... params) {
//
//            String result; // 요청 결과를 저장할 변수.
//            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
//            result = requestHttpURLConnection.request(url, values); // 해당 URL로 부터 결과물을 얻어온다.
//
//            return result;
//        }

//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//
//            //doInBackground()로 부터 리턴된 값이 onPostExecute()의 매개변수로 넘어오므로 s를 출력한다.
//            welcomeTxt.setText(s);
//
        }

    public void mOnclick(View view){
        switch (view.getId()){
            case R.id.btnlogin:
                //TextView joinState = (TextView)frag.getView().findViewById(R.id.joinState);
                frag.setTextViewValue(R.string.email+"님 환영합니다 !");
                break;
        }
    }
}
