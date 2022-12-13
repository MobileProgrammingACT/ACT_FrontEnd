package com.example.actprime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.os.Handler;

public class Week2Activity4 extends AppCompatActivity {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference ref = db.getReference();

    Button value;
    ImageView menuMed, menuHome ,menuSetting;
    ImageButton musicButton;
    MediaPlayer musicPlayer;
    String shared = "file";
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week2_activity4);

        value = findViewById(R.id.findValue);

        /*저장 메소드 - writereview불러오기*/
        value.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Week2Activity4.this, "저장했습니다", Toast.LENGTH_SHORT).show();
                ((Week2) Week2.mContext).week2ActivityBtn3.setEnabled(true);

                /**
                 // 저장버튼 누른 이후 3분 카운트 : 현재 1분
                 Handler handler = new Handler();
                 handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                //btn2
                ((Week1) Week1.mContext).week1ActivityBtn3.setEnabled(true);
                }
                }, 60000);*/
            }
        });

        // 하단 네비게이션 바 활성화
        // 1. meditation 화면 넘어가기
        menuMed = (ImageView) findViewById(R.id.menuMed);

        menuMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MeditationActivity.class);
                startActivity(intent);
            }
        });

        // 2. mainActivity 화면 넘어가기
        menuHome = (ImageView) findViewById(R.id.menuHome);

        menuHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // 3. personal_setting 화면 넘어가기
        menuSetting = (ImageView) findViewById(R.id.menuSetting);

        menuSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PersonalSettingActivity.class);
                startActivity(intent);
            }
        });
    }
}
