package com.example.actprime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Week2Activity3 extends AppCompatActivity {

    Button submit;
    ImageView menuMed, menuHome ,menuSetting;
    ImageButton tenBackward, playButton, pauseButton, tenForward;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week2_activity3);

        submit = (Button) findViewById(R.id.submit);
        tenBackward = (ImageButton) findViewById(R.id.tenBackward);
        tenForward = (ImageButton) findViewById(R.id.tenForward);
        playButton = (ImageButton) findViewById(R.id.playButton);
        pauseButton = (ImageButton) findViewById(R.id.pauseButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Week2Activity3.this, "완료했습니다", Toast.LENGTH_SHORT).show();
                ((Week2) Week2.mContext).week2ActivityBtn4.setEnabled(true);

                //3분 카운터
                /**Handler handler = new Handler();
                 handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                ((Week1) Week1.mContext).week1ActivityBtn4.setEnabled(true);
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