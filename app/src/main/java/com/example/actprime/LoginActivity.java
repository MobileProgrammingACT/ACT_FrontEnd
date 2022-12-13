package com.example.actprime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth = null;
    private EditText login_email, login_pwd;
    public Button LoginBtn;
    public TextView SignupText;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        LoginBtn = (Button) findViewById(R.id.LoginBtn);
        login_email = (EditText) findViewById(R.id.login_email);
        login_pwd = (EditText) findViewById(R.id.login_pwd);
        SignupText = (TextView) findViewById(R.id.SignupText);
        firebaseAuth = firebaseAuth.getInstance();

        LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mNow = System.currentTimeMillis();
                mDate = new Date(mNow);
                String startdate = mFormat.format(mDate);

                String loginEmail = login_email.getText().toString().trim();
                String loginPwd = login_pwd.getText().toString().trim();

                firebaseAuth.signInWithEmailAndPassword(loginEmail, loginPwd)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent goMain = new Intent(getApplicationContext(), MainActivity.class);
                                    goMain.putExtra("userid", loginEmail);
                                    goMain.putExtra("startdate", startdate);
                                    startActivity(goMain);
                                    finish();
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        SignupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goSignup = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(goSignup);
            }
        });


    }
}
