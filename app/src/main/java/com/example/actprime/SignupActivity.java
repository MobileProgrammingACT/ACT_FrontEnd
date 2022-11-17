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
            public void onClick(View v) {
                String newemail = join_email.getText().toString().trim();
                String newpwd = join_pwd.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(newemail, newpwd)
                        .addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(SignupActivity.this, AppCompatActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                               /*else {
                                    Toast.makeText(SignupActivity.this, "회원 가입 실패", Toast.LENGTH_SHORT).show();
                                    return;
                               }*/
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
        });
    }
}
