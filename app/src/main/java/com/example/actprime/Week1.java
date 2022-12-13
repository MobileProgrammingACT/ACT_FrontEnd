package com.example.actprime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Week1 extends AppCompatActivity {
    public static Context mContext; // 다른 액티비티에서 변수 사용을 위함
    Button week1ActivityBtn1, week1ActivityBtn2, week1ActivityBtn3, week1ActivityBtn4, week1ActivityBtn5, week1ActivityBtn6, week1ActivityBtn7, week1ActivityBtn8;
    ImageButton closeButton, closeButtonEx;
    View alertDialog;



    ImageView menuMed, menuHome ,menuSetting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week1);

        mContext = this;

        week1ActivityBtn1 = (Button) findViewById(R.id.week1ActivityBtn2);
        week1ActivityBtn2 = (Button) findViewById(R.id.week1ActivityBtn3);
        week1ActivityBtn3 = (Button) findViewById(R.id.week1ActivityBtn4);
        week1ActivityBtn4 = (Button) findViewById(R.id.week1ActivityBtn5);
        week1ActivityBtn5 = (Button) findViewById(R.id.week1ActivityBtn6);
        week1ActivityBtn6 = (Button) findViewById(R.id.week1ActivityBtn7);
        week1ActivityBtn7 = (Button) findViewById(R.id.week1ActivityBtn8);

        week1ActivityBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week1Activity1.class);
                startActivity(intent);
            }
        });

        week1ActivityBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week1Activity2.class);
                startActivity(intent);
            }
        });

        week1ActivityBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week1Activity3.class);
                startActivity(intent);
            }
        });

        week1ActivityBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week1Activity4.class);
                startActivity(intent);
            }
        });

        week1ActivityBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week1Activity5.class);
                startActivity(intent);
            }
        });

        week1ActivityBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week1Activity6.class);
                startActivity(intent);
            }
        });

        week1ActivityBtn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week1Activity7.class);
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