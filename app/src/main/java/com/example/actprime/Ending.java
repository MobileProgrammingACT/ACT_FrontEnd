package com.example.actprime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Ending extends AppCompatActivity {

    Button tutorial1, tutorial2, tutorial3;
    ImageView menuMed, menuHome, menuSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ending);

        tutorial1 = (Button) findViewById(R.id.tutorial1);
        tutorial2 = (Button) findViewById(R.id.tutorial2);
        tutorial3 = (Button) findViewById(R.id.tutorial3);

        tutorial1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TutorialActivity1.class);
                startActivity(intent);
            }
        });

        tutorial2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TutorialActivity2.class);
                startActivity(intent);
            }
        });

        tutorial3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TutorialActivity3.class);
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
