package com.example.actprime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import android.os.Handler;

public class Week1Activity6 extends AppCompatActivity {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference ref = db.getReference();

    Button submit;
    EditText reasonET, resultET;
    TextView reasonTV, resultTV, text0, text1_1, text1_2, text2_1, text2_2;
    ImageButton musicButton, goBackIcon;
    MediaPlayer musicPlayer;
    ImageView menuMed, menuHome ,menuSetting;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week1_activity6);

        DatabaseReference myref = db.getReference("/Act/Week1/day6");
        myref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String value = snapshot.getValue(String.class);
                String arr[] = value.split("/");
                reasonET.setText(arr[0]);
                resultET.setText(arr[1]);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                reasonET.setText("");
                resultET.setText("");
            }
        });

        submit = (Button) findViewById(R.id.submit);

        reasonET = (EditText) findViewById(R.id.reasonET);
        resultET = (EditText) findViewById(R.id.resultET);

        reasonTV = (TextView) findViewById(R.id.reasonTV);
        resultTV = (TextView) findViewById(R.id.resultTV);

        text0 = (TextView) findViewById(R.id.text0);
        text1_1 = (TextView) findViewById(R.id.text1_1);
        text1_2 = (TextView) findViewById(R.id.text1_2);
        text2_1 = (TextView) findViewById(R.id.text2_1);
        text2_2 = (TextView) findViewById(R.id.text2_2);

        text1_1.setPaintFlags(text1_1.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);
        text2_1.setPaintFlags(text2_1.getPaintFlags()| Paint.STRIKE_THRU_TEXT_FLAG);

        /*?????? ????????? - writereview????????????*/
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.setVisibility(View.GONE);
                text0.setVisibility(View.VISIBLE);
                text1_1.setVisibility(View.VISIBLE);
                text1_2.setVisibility(View.VISIBLE);
                text2_1.setVisibility(View.VISIBLE);
                text2_2.setVisibility(View.VISIBLE);

                reasonTV.setText("?????? " + reasonET.getText().toString() + "??????, ");
                resultTV.setText(" ?????? " + resultET.getText().toString() + " ??????.");
                reasonTV.setPaintFlags(reasonTV.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);

                reasonTV.setVisibility(View.VISIBLE);
                resultTV.setVisibility(View.VISIBLE);

                writereview(reasonET.getText().toString() + "/" + resultET.getText().toString());
                Toast.makeText(Week1Activity6.this, "??????????????????", Toast.LENGTH_SHORT).show();
                ((Week1) Week1.mContext).week1ActivityBtn7.setEnabled(true);
                ((Week1) Week1.mContext).week1ActivityBtn6.setBackgroundColor(Color.argb(100, 255, 153, 153));

                /**
                 // ???????????? ?????? ?????? 3??? ????????? : ?????? 1???
                 Handler handler = new Handler();
                 handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                ((Week1) Week1.mContext).week1ActivityBtn3.setEnabled(true);
                }
                }, 60000);*/
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
        ref.child("Act").child("Week1").child("day6").setValue(content);
    }

    /*???????????? ????????? ????????? ?????????*/
    @Override
    protected void onStop() {
        super.onStop();
        musicPlayer.release();
        musicPlayer = null;
    }
}
