package com.example.actprime;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TutorialActivity2 extends AppCompatActivity {

    Button explanation , btnNext, btnPrev;
    ImageButton tenBackward, playButton, pauseButton, tenForward, closeButton, closeButtonEx;
    MediaPlayer source;
    SeekBar seekBar;
    int point;
    ViewFlipper vFlipper;
    View tutorialActivity2Ex;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_activity2);

        seekBar = (SeekBar) findViewById(R.id.seekBar_t2);
        explanation = (Button) findViewById(R.id.explanation_t2);

        source = new MediaPlayer();
        source = MediaPlayer.create(TutorialActivity2.this, R.raw.tutorial_activity2_explanation);

        playButton = (ImageButton) findViewById(R.id.playButton_t2);
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

        tenForward = (ImageButton) findViewById(R.id.tenForward_t2);
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

        tenBackward = (ImageButton) findViewById(R.id.tenBackward_t2);
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

        closeButton = (ImageButton) findViewById(R.id.closeButton_t2);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MeditationActivity.class);
                startActivity(intent);
            }
        });

        /*화면에 진입했을 때 활동에 관한 설명이 바로 뜨게하기 */
        tutorialActivity2Ex = (View) View.inflate(TutorialActivity2.this, R.layout.tutorial_activity2_explanation, null);
        AlertDialog.Builder a1EX = new AlertDialog.Builder(TutorialActivity2.this);
        AlertDialog exit = a1EX.create();
        AlertDialog window = a1EX.create();
        window.setView(tutorialActivity2Ex);
        window.show();

        vFlipper = (ViewFlipper) tutorialActivity2Ex.findViewById(R.id.viewFlipper_t2);
        btnNext = (Button) tutorialActivity2Ex.findViewById(R.id.btnNext_t2);
        btnPrev = (Button) tutorialActivity2Ex.findViewById(R.id.btnPrev_t2);
        closeButtonEx = (ImageButton) tutorialActivity2Ex.findViewById(R.id.closeButtonEx_t2);
        //btnEnd = (Button) tutorialActivity1Ex.findViewById(R.id.btnEnd);
        //btnEnd.setVisibility(View.GONE);
        btnPrev.setVisibility(View.INVISIBLE);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showNext();
                count++;
                if(count==0)
                    btnPrev.setVisibility(View.INVISIBLE);
                else if(count>=1 && count <= 7) {
                    btnPrev.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.VISIBLE);
                    //btnEnd.setVisibility(View.GONE);
                } else if(count==8) {
                    btnNext.setVisibility(View.GONE);
                    //btnEnd.setVisibility(View.VISIBLE);
                }
            }
        });
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showPrevious();
                count--;
                if(count==0)
                    btnPrev.setVisibility(View.INVISIBLE);
                else if(count>=1 && count <= 7) {
                    btnPrev.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.VISIBLE);
                    //btnEnd.setVisibility(View.GONE);
                }
                else if(count==8) {
                    btnNext.setVisibility(View.GONE);
                    //btnEnd.setVisibility(View.VISIBLE);
                }
            }
        });

        closeButtonEx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                window.dismiss();
            }
        });

//        btnEnd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                count = 0;
//                window.dismiss();
//            }
//        });

        /*설명버튼(?버튼)을 누르면 다시 설명이 뜨게 */
        explanation = (Button) findViewById(R.id.explanation_t2);
        explanation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tutorialActivity2Ex = (View) View.inflate(TutorialActivity2.this, R.layout.tutorial_activity2_explanation, null);
                AlertDialog.Builder a1EX = new AlertDialog.Builder(TutorialActivity2.this);
                AlertDialog window = a1EX.create();
                window.setView(tutorialActivity2Ex);
                window.show();

                vFlipper = (ViewFlipper) tutorialActivity2Ex.findViewById(R.id.viewFlipper_t2);
                btnNext = (Button) tutorialActivity2Ex.findViewById(R.id.btnNext_t2);
                btnPrev = (Button) tutorialActivity2Ex.findViewById(R.id.btnPrev_t2);
                closeButtonEx = (ImageButton) tutorialActivity2Ex.findViewById(R.id.closeButtonEx_t2);
                //btnEnd = (Button) tutorialActivity1Ex.findViewById(R.id.btnEnd);
                //btnEnd.setVisibility(View.GONE);
                btnPrev.setVisibility(View.INVISIBLE);


                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vFlipper.showNext();
                        count++;
                        if (count == 0)
                            btnPrev.setVisibility(View.INVISIBLE);
                        else if (count>=1 && count <= 7) {
                            btnPrev.setVisibility(View.VISIBLE);
                            btnNext.setVisibility(View.VISIBLE);
                            //btnEnd.setVisibility(View.GONE);
                        } else if (count == 8) {
                            btnNext.setVisibility(View.GONE);
                            //btnEnd.setVisibility(View.VISIBLE);
                        }
                    }
                });
                btnPrev.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vFlipper.showPrevious();
                        count--;
                        if (count == 0)
                            btnPrev.setVisibility(View.INVISIBLE);
                        else if (count>=1 && count <= 7) {
                            btnPrev.setVisibility(View.VISIBLE);
                            btnNext.setVisibility(View.VISIBLE);
                            //btnEnd.setVisibility(View.GONE);
                        } else if (count == 8) {
                            btnNext.setVisibility(View.GONE);
                            //btnEnd.setVisibility(View.VISIBLE);
                        }
                    }
                });

                closeButtonEx.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        count = 0;
                        window.dismiss();
                    }
                });


//                btnEnd.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        count = 0;
//                        window.dismiss();
//                    }
//                });
            }
        });

    }

}