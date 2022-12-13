package com.example.actprime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Date;

public class SignupActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth = null;
    private FirebaseDatabase firebaseDB = FirebaseDatabase.getInstance();
    private DatabaseReference firebaseRef = firebaseDB.getReference();
    public EditText new_email, new_pwd;
    public Button SignupBtn;
    public CalendarView DateSelect;

    View dialogView;
    String text;
    Date startdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_signup);
        setTitle("이메일 회원가입");

        SignupBtn = (Button) findViewById(R.id.SignupBtn);
        new_email = (EditText) findViewById(R.id.join_email);
        new_pwd = (EditText) findViewById(R.id.join_pwd);

        text = new_email.getText().toString();

        firebaseAuth = FirebaseAuth.getInstance();

        SignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!new_email.getText().toString().equals("") && !new_pwd.getText().toString().equals("")) {
                    createUser(new_email.getText().toString(), new_pwd.getText().toString());
                    /**
                     * Intent dialogView = new Intent(SignupActivity.this, dialog.class);
                     * dialogView.putExtra("name", join_email.getText().toString());
                     * startActivity(dialogView); **/
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
                            Toast.makeText(SignupActivity.this, "회원가입 성공!" + text + "님 안녕하세요.", Toast.LENGTH_LONG).show();
                        } else {
                            // 계정이 중복된 경우
                            Toast.makeText(SignupActivity.this, "이미 존재하는 계정입니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}