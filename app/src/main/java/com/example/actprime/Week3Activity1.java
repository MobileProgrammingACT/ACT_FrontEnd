package com.example.actprime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Week3Activity1 extends AppCompatActivity {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference ref = db.getReference();

    Button submit;
    ImageView menuMed, menuHome ,menuSetting;
    EditText row1col1, row1col2, row2col1, row2col2;
    ImageButton musicButton, goBackIcon;
    MediaPlayer musicPlayer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week3_activity1);

        DatabaseReference myref = db.getReference("/Act/Week3/day1");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                String arr[] = value.split(",");
                row1col1.setText(arr[0]);
                row1col2.setText(arr[1]);
                row2col1.setText(arr[2]);
                row2col2.setText(arr[3]);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                row1col1.setText("");
                row1col2.setText("");
                row2col1.setText("");
                row2col2.setText("");
            }
        });

        row1col1 = (EditText) findViewById(R.id.row1col1);
        row1col2 = (EditText) findViewById(R.id.row1col2);
        row2col1 = (EditText) findViewById(R.id.row2col1);
        row2col2 = (EditText) findViewById(R.id.row2col2);
        submit = (Button) findViewById(R.id.submit);
        musicButton = (ImageButton) findViewById(R.id.musicButton);

        /*?????? ????????? - writereview????????????*/
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content1, content2, fullcontent;
                content1 = row1col1.getText().toString() + "," + row1col2.getText().toString();
                content2 = row2col1.getText().toString() + "," + row2col2.getText().toString();
                fullcontent = content1 + "," + content2;
                writereview(fullcontent);
                Toast.makeText(Week3Activity1.this, "??????????????????", Toast.LENGTH_SHORT).show();
                ((Week3) Week3.mContext).week3ActivityBtn2.setEnabled(true);
                ((Week3) Week3.mContext).week3ActivityBtn1.setBackgroundColor(Color.argb(100, 255, 153, 153));

                // ???????????? ?????? ?????? 3??? ????????? w1a3?????? ?????????
                /**Handler handler = new Handler();
                 handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                ((Week1) Week1.mContext).week1ActivityBtn4.setEnabled(true);
                }
                }, 60000);**/
            }
        });

        goBackIcon = (ImageButton) findViewById(R.id.goBackIcon);
        goBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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

        // ?????? ??????????????? ??? ?????????
        // 1. meditation ?????? ????????????
        menuMed = (ImageView) findViewById(R.id.menuMed);
        menuMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MeditationActivity.class);
                startActivity(intent);
            }
        });

        // 2. mainActivity ?????? ????????????
        menuHome = (ImageView) findViewById(R.id.menuHome);
        menuHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // 3. personal_setting ?????? ????????????
        menuSetting = (ImageView) findViewById(R.id.menuSetting);
        menuSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PersonalSettingActivity.class);
                startActivity(intent);
            }
        });
    }

    /*???????????? ????????? writereview ??????, DB??? ???????????? ?????? "review"??? ??? ?????? ????????????*/
    public void writereview(String content) {
        WriteReview writereview = new WriteReview(content);
        ref.child("Act").child("Week3").child("day1").setValue(content);
    }

    // ???????????? ????????? ????????? ?????????
    @Override
    protected void onStop() {
        super.onStop();
        musicPlayer.release();
        musicPlayer = null;
    }
}
