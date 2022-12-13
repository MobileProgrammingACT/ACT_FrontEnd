package com.example.actprime;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.actprime.alarm.AlertReceiver;

public class PersonalSettingActivity extends AppCompatActivity {

    ImageView goBackIcon, alarmRefreshBtn;
    TextView usingAccount, startDay, alarmTime;
    ImageView menuMed, menuHome;
    String nickname, calendar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_setting);

        nickname = getIntent().getStringExtra("userid");
        usingAccount = (TextView) findViewById(R.id.usingAccount);
        usingAccount.setText(nickname);

        calendar = getIntent().getStringExtra("startdate");
        startDay = (TextView) findViewById(R.id.startDay);
        startDay.setText(calendar);

        // 9시 옆 리셋 버튼 누르면 알람 동작 시작
        ImageView resetBtn = findViewById(R.id.alarmRefreshBtn);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTimeText();
                startAlarm();
            }
        });

        // 1. 상단 뒤로가기 버튼 누르면 액티비티 종료
        goBackIcon = (ImageView) findViewById(R.id.goBackIcon);
        goBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        menuMed = (ImageView) findViewById(R.id.menuMed);
        menuMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MeditationActivity.class);
                startActivity(intent);
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

    private void updateTimeText() {
        String timeText = "60초 뒤 알람이 울려요 :>";
        Toast.makeText(getApplicationContext(), timeText, Toast.LENGTH_SHORT).show();
    }

    private void startAlarm() {
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getApplicationContext(), AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),1,intent,PendingIntent.FLAG_IMMUTABLE);
        //60초 뒤 실행
        alarmManager.set(AlarmManager.RTC_WAKEUP, SystemClock.elapsedRealtime()+60*1000,pendingIntent);
    }

    private void cancelAlarm() {
        AlarmManager alarmManager = (AlarmManager) getApplicationContext().getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(getApplicationContext(), AlertReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),1,intent,0);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(getApplicationContext(), "알람 취소 !", Toast.LENGTH_SHORT).show();
    }
}