package com.example.actprime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Week1Activity3 extends AppCompatActivity {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference ref = db.getReference();

    Button explanation, submit;
    ImageView menuMed, menuHome ,menuSetting;
    EditText row1col1, row1col2, row1col3, row2col1, row2col2, row2col3, row3col1, row3col2, row3col3;
    ImageButton musicButton;
    MediaPlayer musicPlayer;
    String shared = "file";
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week1_activity3);

        row1col1 = (EditText) findViewById(R.id.row1col1);
        row1col2 = (EditText) findViewById(R.id.row1col2);
        row1col3 = (EditText) findViewById(R.id.row1col3);
        row2col1 = (EditText) findViewById(R.id.row2col1);
        row2col2 = (EditText) findViewById(R.id.row2col2);
        row2col3 = (EditText) findViewById(R.id.row2col3);
        row3col1 = (EditText) findViewById(R.id.row3col1);
        row3col2 = (EditText) findViewById(R.id.row3col2);
        row3col3 = (EditText) findViewById(R.id.row3col3);
        submit = (Button) findViewById(R.id.submit);

        /*저장 메소드 - writereview불러오기*/
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content;
                content = row1col1.getText().toString() + "/" + row1col2.getText().toString() + "/" + row1col3.getText().toString();
                // DB 구조상 여러 행에 작성된 내용을 한번에 적기가 이쁘질 않아서.. firestore 시도해볼 예정
                writereview(content);
                Toast.makeText(Week1Activity3.this, "저장했습니다", Toast.LENGTH_SHORT).show();

                // 저장버튼 누른 이후 3분 카운트 : 현재 1분
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ((Week1) Week1.mContext).week1ActivityBtn4.setEnabled(true);
                    }
                }, 60000);
            }
        });

        /*Edittext 값 유지 메소드*/
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("key","");
        row1col1.setText(value);

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
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences  sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor  = sharedPreferences.edit();
        String value = row1col1.getText().toString();
        editor.putString("key", value);
        editor.commit();
    }

        /*작성하는 메소드 writereview 정의, DB에 저장되는 방식 "review"키 값 내에 저장하기*/
        public void writereview(String content) {
            WriteReview writereview = new WriteReview(content);
            ref.child("Act").child("Week1").child("week1act3").setValue(content);
        }


}
