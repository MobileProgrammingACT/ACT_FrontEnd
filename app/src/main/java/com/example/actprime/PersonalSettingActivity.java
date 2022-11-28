package com.example.actprime;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PersonalSettingActivity extends AppCompatActivity {

    ImageView goBackIcon, alarmRefreshBtn;
    TextView usingAccount, startDay, alarmTime;
    ImageView menuBookmark, menuHome ,menuSetting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_setting);

        // 1. 상단 뒤로가기 버튼 누르면 액티비티 종료
        goBackIcon = (ImageView) findViewById(R.id.goBackIcon);
        goBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        // 2. 하단 네비게이션 바 홈 버튼 클릭 시 홈버튼으로 이동하고 액티비티 종료
        menuHome = (ImageView) findViewById(R.id.menuHome);
        menuHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


    }
}
