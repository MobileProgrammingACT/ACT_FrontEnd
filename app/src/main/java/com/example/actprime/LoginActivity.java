package com.example.actprime;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;

//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText email_join, pwd_join;
    public Button SignupBtn, LoginBtn, SubmitBtn;

    // FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        setTitle("이메일 로그인/회원가입");

        SignupBtn = (Button) findViewById(R.id.SignupBtn);
        LoginBtn = (Button) findViewById(R.id.LoginBtn);
        email_join = (EditText) findViewById(R.id.email_join);
        pwd_join = (EditText) findViewById(R.id.pwd_join);
        SubmitBtn = (Button) findViewById(R.id.SubmitBtn);

        // firebaseAuth = FirebaseAuth.getInstance();

        SignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email_join.setVisibility(View.VISIBLE);
                pwd_join.setVisibility(View.VISIBLE);
                SubmitBtn.setVisibility(View.VISIBLE);
            }
        });

        /** SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newemail = email_join.getText().toString().trim();
                String newpwd = pwd_join.getText().toString().trim();

                firebaseAuth.createUserWithEmailAndPassword(newemail, newpwd)
                        .addOnCompleteListener(AppCompatActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    Toast.makeText(MainActivity.this, "등록 에러", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            }
                        });
            }
        }); **/

    }
}
