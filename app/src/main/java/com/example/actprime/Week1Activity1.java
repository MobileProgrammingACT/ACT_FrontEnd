package com.example.actprime;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;

import com.example.actprime.Week1;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.os.Handler;

public class Week1Activity1 extends AppCompatActivity {

    /*DB 저장 정의용 - 위치 변경 X!!!*/
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference ref = db.getReference();

    Button submit;
    ImageView menuMed, menuHome ,menuSetting;
    ImageButton musicButton, goBackIcon;
    EditText content;
    MediaPlayer musicPlayer;
    String shared = "file"; //Edittext 값 저장용 -> 추후 삭제 예정
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week1_activity1);

        submit = findViewById(R.id.submit);
        content = findViewById(R.id.content);
        goBackIcon = (ImageButton) findViewById(R.id.goBackIcon);

        /*저장 메소드 - writereview불러오기*/
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                writereview(content.getText().toString());
                Toast.makeText(Week1Activity1.this, "저장했습니다", Toast.LENGTH_SHORT).show();
                ((Week1) Week1.mContext).week1ActivityBtn2.setEnabled(true);

                /**
                // 저장버튼 누른 이후 3분 카운트 : 현재 1분
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ((Week1) Week1.mContext).week1ActivityBtn2.setEnabled(true);
                    }
                }, 60000);*/

                ((Week1)Week1.mContext).week1ActivityBtn1.setBackgroundColor(Color.argb(100, 255, 153, 153));
            }
        });

        goBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Week1.class);
                startActivity(intent);
            }
        });

        /*Edittext 값 유지 메소드*/
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("key","");
        content.setText(value);

        /*music player*/
        musicPlayer = MediaPlayer.create(this, R.raw.music1);
        musicPlayer.start();
        musicPlayer.setLooping(true);

        musicButton = (ImageButton) findViewById(R.id.musicButton);
        musicButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicButton.setSelected(!musicButton.isSelected());
                if (musicPlayer.isPlaying()) {
                    musicPlayer.pause();
                } else {
                    musicPlayer.start();
                }
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
    /*Edittext 값 외부로 나간 이후에도 저장가능한 메소드*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences  sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor  = sharedPreferences.edit();
        String value = content.getText().toString();
        editor.putString("key", value);
        editor.commit();
    }

    /*작성하는 메소드 writereview 정의, DB에 저장되는 방식 "review"키 값 내에 저장하기*/
    public void writereview(String content) {
        WriteReview writereview = new WriteReview(content);
        ref.child("Act").child("Week1").child("day1").setValue(content);
    }

    /*활동에서 나가면 음악이 꺼지게*/
    @Override
    protected void onStop() {
        super.onStop();
        musicPlayer.release();
        musicPlayer = null;
    }
}
