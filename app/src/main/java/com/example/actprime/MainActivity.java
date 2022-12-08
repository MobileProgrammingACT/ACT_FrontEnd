package com.example.actprime;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    ImageView weekSelectImgViewT, weekSelectImgView1, weekSelectImgView2, weekSelectImgView3, weekSelectImgView4;
    View alertDialog;
    ImageView menuBookmark, menuHome ,menuSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        weekSelectImgViewT = (ImageView) findViewById(R.id.weekSelectImgViewT);
        weekSelectImgView1 = (ImageView) findViewById(R.id.weekSelectImgView1);
        weekSelectImgView2 = (ImageView) findViewById(R.id.weekSelectImgView2);
        weekSelectImgView3 = (ImageView) findViewById(R.id.weekSelectImgView3);
        weekSelectImgView4 = (ImageView) findViewById(R.id.weekSelectImgView4);

        weekSelectImgView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                startActivity(intent);
            }
        });

        // 활동1의 저장 버튼을 누를 시 activity2의 색 변경, 그냥 누르면 경고창 뜨고 넘어가려면 확인 눌러야 함 (이지만 일단 대화창 뜨고 다음 화면 넘어가는 것 까지만)
        weekSelectImgView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog = (View) View.inflate(MainActivity.this, R.layout.cant_go_other_activities, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("이전 활동 미완료");
                dlg.setView(alertDialog);
                dlg.setPositiveButton("계속", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), SecondActivity.class); // 원래는 활동2의 활동화면으로 가지만 일단 활동1 화면 ㄱㄱ
                        startActivity(intent);
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this, "취소했습니다", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();
            }
        });

        // 현재 글쓰기 내용은 DB에 저장안됨, 대신 아래 메소드를 통해 Realtime DB에 연결되었음은 확인가능
        weekSelectImgView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference myRef = database.getReference("message");

                myRef.setValue("Hello, World!");
            }
        });

        // 하단 네비게이션 바 동작
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
