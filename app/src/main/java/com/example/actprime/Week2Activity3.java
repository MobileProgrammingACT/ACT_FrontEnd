package com.example.actprime;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Week2Activity3 extends AppCompatActivity {

    Button submit;
    ImageView menuMed, menuHome ,menuSetting;
    ImageButton tenBackward, playButton, pauseButton, tenForward;
    MediaPlayer source;
    SeekBar seekBar;
    int point;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week2_activity3);

        submit = (Button) findViewById(R.id.submit);
        tenBackward = (ImageButton) findViewById(R.id.tenBackward);
        tenForward = (ImageButton) findViewById(R.id.tenForward);
        playButton = (ImageButton) findViewById(R.id.playButton);
        pauseButton = (ImageButton) findViewById(R.id.pauseButton);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        source = new MediaPlayer();
        source = MediaPlayer.create(Week2Activity3.this, R.raw.week2_activity3);

        playButton = (ImageButton) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playButton.setVisibility(View.GONE);
                pauseButton.setVisibility(View.VISIBLE);

                if (source == null) {
                    source.start();
                    // 음악 파일 재생이 완료됐을 때 호출될 콜백 세팅
                    source.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            source = null;
                        }
                    });
                } else if(!source.isPlaying()) {
                    source.seekTo(point);
                    source.start();
                }

                // seek바 mp3파일 연동 및 조절 가능
                seekBar.setMax(source.getDuration());
                seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int current, boolean fromUser) {
                        if(fromUser)
                            source.seekTo(current);
                    }
                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) { }
                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) { }
                });

                // Thread로 처리한 seekbar 움직이는 메소드
                new Thread(new Runnable(){
                    @Override
                    public void run() {
                        while(source.isPlaying()){
                            try{
                                Thread.sleep(1000);
                            } catch(Exception e){
                                e.printStackTrace();
                            }
                            seekBar.setProgress(source.getCurrentPosition());
                        }
                    }
                }).start();
            }
        });

        pauseButton = (ImageButton) findViewById(R.id.pauseButton);
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playButton.setVisibility(View.VISIBLE);
                pauseButton.setVisibility(View.GONE);

                if (source != null) {
                    source.pause();
                    point = source.getCurrentPosition();
                    Log.d("pause check", ":" + point);
                }
            }
        });

        tenForward = (ImageButton) findViewById(R.id.tenForward);
        tenForward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int forward = 10*1000;
                if (source != null) {
                    int current = source.getCurrentPosition();
                    if (current + forward <= source.getDuration()) {
                        source.seekTo(current + forward);
                    } else {
                        source.seekTo(source.getDuration());
                    }
                }
            }
        });

        tenBackward = (ImageButton) findViewById(R.id.tenBackward);
        tenBackward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int backward = 10*1000;
                if (source != null) {
                    int current = source.getCurrentPosition();
                    if (current - backward >= 0) {
                        source.seekTo(current - backward);
                    } else {
                        source.seekTo(0);
                    }
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Week2Activity3.this, "완료했습니다", Toast.LENGTH_SHORT).show();
                ((Week2) Week2.mContext).week2ActivityBtn4.setEnabled(true);
                ((Week2) Week2.mContext).week2ActivityBtn3.setBackgroundColor(Color.argb(100, 255, 153, 153));

                // 3분 카운터
                /**Handler handler = new Handler();
                 handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                ((Week1) Week1.mContext).week1ActivityBtn4.setEnabled(true);
                }
                }, 60000);**/
            }
        });

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
}
