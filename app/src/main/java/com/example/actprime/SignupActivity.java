package com.example.actprime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth = null;
    private EditText join_email, join_pwd;
    public Button SignupBtn;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);
        setTitle("이메일 회원가입");

        SignupBtn = (Button) findViewById(R.id.SignupBtn);
        join_email = (EditText) findViewById(R.id.join_email);
        join_pwd = (EditText) findViewById(R.id.join_pwd);

        firebaseAuth = FirebaseAuth.getInstance();

        SignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!join_email.getText().toString().equals("") && !join_pwd.getText().toString().equals("")) {
                    createUser(join_email.getText().toString(), join_pwd.getText().toString());
                } else {
                    Toast.makeText(SignupActivity.this, "계정과 비밀번호를 입력하세요.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
        private void createUser(String email, String pwd) {
            firebaseAuth.createUserWithEmailAndPassword(email, pwd)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // 회원가입 성공시
                                Toast.makeText(SignupActivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                                finish();
                            } else {
                                // 계정이 중복된 경우
                                Toast.makeText(SignupActivity.this, "이미 존재하는 계정입니다.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

            dialogView = (View) View.inflate(SignupActivity.this, R.layout.dialog, null);
            AlertDialog.Builder dlg = new AlertDialog.Builder(SignupActivity.this);
            dlg.setView(dialogView);
            dlg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent main = new Intent(getApplicationContext(), MainActivity.class); //이거 로그인 페이지 뜨게 하기
                    startActivity(main);
                }
            });
            dlg.setNegativeButton("취소", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(SignupActivity.this, "취소했습니다", Toast.LENGTH_SHORT).show();
                }
            });
            dlg.show();
            }
        }