package com.example.actprime;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

public class Meditation3 extends AppCompatActivity {

    ImageButton tenBackward, playButton, pauseButton, tenForward, closeButton;
    MediaPlayer source;
    SeekBar seekBar;
    int point;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meditation_activity3);

        seekBar = (SeekBar) findViewById(R.id.seekBar);

        source = new MediaPlayer();
        source = MediaPlayer.create(Meditation3.this, R.raw.meditation_activity3);

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

        closeButton = (ImageButton) findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MeditationActivity.class);
                startActivity(intent);
            }
        });

    }

}