package com.example.actprime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Week3 extends AppCompatActivity {
    public static Context mContext;
    Button week3ActivityBtn1, week3ActivityBtn2, week3ActivityBtn3, week3ActivityBtn4, week3ActivityBtn5, week3ActivityBtn6, week3ActivityBtn7;
    View alertDialog;
    ImageView menuMed, menuHome ,menuSetting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week3);

        mContext = this;

        week3ActivityBtn1 = (Button) findViewById(R.id.week3ActivityBtn2);
        week3ActivityBtn2 = (Button) findViewById(R.id.week3ActivityBtn3);
        week3ActivityBtn3 = (Button) findViewById(R.id.week3ActivityBtn4);
        week3ActivityBtn4 = (Button) findViewById(R.id.week3ActivityBtn5);
        week3ActivityBtn5 = (Button) findViewById(R.id.week3ActivityBtn6);
        week3ActivityBtn6 = (Button) findViewById(R.id.week3ActivityBtn7);
        week3ActivityBtn7 = (Button) findViewById(R.id.week3ActivityBtn8);

        week3ActivityBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week3Activity1.class);
                startActivity(intent);
            }
        });

        week3ActivityBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week3Activity2.class);
                startActivity(intent);
            }
        });

        week3ActivityBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week3Activity3.class);
                startActivity(intent);
            }
        });

        week3ActivityBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week3Activity4.class);
                startActivity(intent);
            }
        });

        week3ActivityBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week3Activity5.class);
                startActivity(intent);
            }
        });

        week3ActivityBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week3Activity6.class);
                startActivity(intent);
            }
        });

        week3ActivityBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week3Activity7.class);
                startActivity(intent);
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
