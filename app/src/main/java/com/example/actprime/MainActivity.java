package com.example.actprime;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static Context maContext;
    ImageView weekSelectImgViewT, weekSelectImgView1, weekSelectImgView2, weekSelectImgView3, weekSelectImgView4;
    Button weekSelectBtnT, weekSelectBtn1, weekSelectBtn2, weekSelectBtn3, weekSelectBtn4;
    ImageView menuMed, menuHome ,menuSetting;
    TextView userid, startDay;
    String nickname, calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        nickname = getIntent().getStringExtra("userid");
        userid = (TextView) findViewById(R.id.userid);
        userid.setText(nickname);
        userid.setFreezesText(false);

        calendar = getIntent().getStringExtra("startdate");
        startDay = (TextView) findViewById(R.id.startDay);
        startDay.setText(calendar);
        startDay.setFreezesText(true);

        maContext = this;

        weekSelectImgViewT = (ImageView) findViewById(R.id.weekSelectImgViewT);
        weekSelectImgView1 = (ImageView) findViewById(R.id.weekSelectImgView1);
        weekSelectImgView2 = (ImageView) findViewById(R.id.weekSelectImgView2);
        weekSelectImgView3 = (ImageView) findViewById(R.id.weekSelectImgView3);
        weekSelectImgView4 = (ImageView) findViewById(R.id.weekSelectImgView4);

        weekSelectBtnT = (Button) findViewById(R.id.weekSelectBtnT);
        weekSelectBtn1 = (Button) findViewById(R.id.weekSelectBtn1);
        weekSelectBtn2 = (Button) findViewById(R.id.weekSelectBtn2);
        weekSelectBtn3 = (Button) findViewById(R.id.weekSelectBtn3);
        weekSelectBtn4 = (Button) findViewById(R.id.weekSelectBtn4);

        ImageView setting_btn = (ImageView) findViewById(R.id.menuSetting);

        setting_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(getApplicationContext(), PersonalSettingActivity.class);
               startActivity(intent);
            }
        });

        weekSelectImgViewT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Tutorial.class);
                startActivity(intent);
            }
        });

        weekSelectImgView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week1.class);
                startActivity(intent);
            }
        });

        weekSelectImgView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week2.class);
                startActivity(intent);
            }
        });

        weekSelectImgView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week3.class);
                startActivity(intent);
            }
        });

        weekSelectImgView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Ending.class);
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
                intent.putExtra("userid", nickname);
                intent.putExtra("startdate", calendar);
                startActivity(intent);
            }
        });
    }
}
