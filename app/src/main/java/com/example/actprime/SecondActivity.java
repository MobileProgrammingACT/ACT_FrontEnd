package com.example.actprime;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button week1ActivityBtn1, week1ActivityBtn2;
    View alertDialog;
    ImageView menuBookmark, menuHome ,menuSetting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_one);

        week1ActivityBtn1 = (Button) findViewById(R.id.week1ActivityBtn1);
        week1ActivityBtn2 = (Button) findViewById(R.id.week1ActivityBtn2);

        week1ActivityBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ThirdActivity.class);
                startActivity(intent);
            }
        });

        // 하단 네비게이션 바 활성화
        // 2. mainActivity 화면 넘어가기
        menuHome = (ImageView) findViewById(R.id.menuHome);

        menuHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
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