package com.example.actprime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Week2 extends AppCompatActivity {
    public static Context mContext;
    Button week2ActivityBtn0, week2ActivityBtn1, week2ActivityBtn2, week2ActivityBtn3, week2ActivityBtn4, week2ActivityBtn5, week2ActivityBtn6, week2ActivityBtn7;
    ImageView menuMed, menuHome ,menuSetting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week2);

        mContext = this;

        week2ActivityBtn0 = (Button) findViewById(R.id.week2ActivityBtn1);
        week2ActivityBtn1 = (Button) findViewById(R.id.week2ActivityBtn2);
        week2ActivityBtn2 = (Button) findViewById(R.id.week2ActivityBtn3);
        week2ActivityBtn3 = (Button) findViewById(R.id.week2ActivityBtn4);
        week2ActivityBtn4 = (Button) findViewById(R.id.week2ActivityBtn5);
        week2ActivityBtn5 = (Button) findViewById(R.id.week2ActivityBtn6);
        week2ActivityBtn6 = (Button) findViewById(R.id.week2ActivityBtn7);
        week2ActivityBtn7 = (Button) findViewById(R.id.week2ActivityBtn8);

        week2ActivityBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week2Activity0.class);
                startActivity(intent);
            }
        });

        week2ActivityBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.actprime.Week2Activity1.class);
                startActivity(intent);
            }
        });

        week2ActivityBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.actprime.Week2Activity2.class);
                startActivity(intent);
            }
        });

        week2ActivityBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.actprime.Week2Activity3.class);
                startActivity(intent);
            }
        });

        week2ActivityBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.actprime.Week2Activity4.class);
                startActivity(intent);
            }
        });

        week2ActivityBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.actprime.Week2Activity5.class);
                startActivity(intent);
            }
        });

        week2ActivityBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.actprime.Week2Activity6.class);
                startActivity(intent);
            }
        });

        week2ActivityBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.actprime.Week2Activity7.class);
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
