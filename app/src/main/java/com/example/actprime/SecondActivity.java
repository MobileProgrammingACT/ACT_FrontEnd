package com.example.actprime;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    Button week1ActivityBtn1, week1ActivityBtn2;
    View alertDialog;

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

        // 활동1의 저장 버튼을 누를 시 activity2의 색 변경, 그냥 누르면 경고창 뜨고 넘어가려면 확인 눌러야 함 (이지만 일단 대화창 뜨고 다음 화면 넘어가는 것 까지만)
        week1ActivityBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog = (View) View.inflate(SecondActivity.this, R.layout.cant_go_other_activities, null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(SecondActivity.this);
                dlg.setTitle("이전 활동 미완료");
                dlg.setView(alertDialog);
                dlg.setPositiveButton("계속", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), ThirdActivity.class); // 원래는 활동2의 활동화면으로 가지만 일단 활동1 화면 ㄱㄱ
                        startActivity(intent);
                    }
                });
                dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(SecondActivity.this, "취소했습니다", Toast.LENGTH_SHORT).show();
                    }
                });
                dlg.show();

            }

        });

    }
}