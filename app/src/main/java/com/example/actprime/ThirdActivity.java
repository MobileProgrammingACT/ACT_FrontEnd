package com.example.actprime;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ViewFlipper;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class ThirdActivity extends AppCompatActivity {

    Button explain1,btnNext, btnPrev, btnEnd;
    ImageButton musicButton;
    View activity1ExView;
    ViewFlipper vFlipper;
    MediaPlayer musicPlayer;
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_one_activity1);

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

        /*화면에 진입했을 때 활동에 관한 설명이 바로 뜨게하기 */
        activity1ExView = (View) View.inflate(ThirdActivity.this, R.layout.week_one_activity1_explanation, null);
        AlertDialog.Builder a1EX = new AlertDialog.Builder(ThirdActivity.this);
        AlertDialog exit = a1EX.create();
        AlertDialog window = a1EX.create();
        window.setView(activity1ExView);
        window.show();

        vFlipper = (ViewFlipper) activity1ExView.findViewById(R.id.viewFlipper1);
        btnNext = (Button) activity1ExView.findViewById(R.id.btnNext);
        btnPrev = (Button) activity1ExView.findViewById(R.id.btnPrev);
        btnEnd = (Button) activity1ExView.findViewById(R.id.btnEnd);
        btnEnd.setVisibility(View.GONE);
        btnPrev.setVisibility(View.INVISIBLE);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vFlipper.showNext();
                count++;
                if(count==0)
                    btnPrev.setVisibility(View.INVISIBLE);
                else if(count==1) {
                    btnPrev.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.VISIBLE);
                    btnEnd.setVisibility(View.GONE);
                }
                else if(count==2) {
                    btnNext.setVisibility(View.GONE);
                    btnEnd.setVisibility(View.VISIBLE);
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
                else if(count==1) {
                    btnPrev.setVisibility(View.VISIBLE);
                    btnNext.setVisibility(View.VISIBLE);
                    btnEnd.setVisibility(View.GONE);
                }
                else if(count==2) {
                    btnNext.setVisibility(View.GONE);
                    btnEnd.setVisibility(View.VISIBLE);
                }
            }
        });
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                window.dismiss();
            }
        });

        /*설명버튼(?버튼)을 누르면 다시 설명이 뜨게 */
        explain1 = (Button) findViewById(R.id.explanation);
        explain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity1ExView = (View) View.inflate(ThirdActivity.this, R.layout.week_one_activity1_explanation, null);
                AlertDialog.Builder a1EX = new AlertDialog.Builder(ThirdActivity.this);
                AlertDialog window = a1EX.create();
                window.setView(activity1ExView);
                window.show();

                vFlipper = (ViewFlipper) activity1ExView.findViewById(R.id.viewFlipper1);
                btnNext = (Button) activity1ExView.findViewById(R.id.btnNext);
                btnPrev = (Button) activity1ExView.findViewById(R.id.btnPrev);
                btnEnd = (Button) activity1ExView.findViewById(R.id.btnEnd);
                btnEnd.setVisibility(View.GONE);
                btnPrev.setVisibility(View.INVISIBLE);

                btnNext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vFlipper.showNext();
                        count++;
                        if(count==0)
                            btnPrev.setVisibility(View.INVISIBLE);
                        else if(count==1) {
                            btnPrev.setVisibility(View.VISIBLE);
                            btnNext.setVisibility(View.VISIBLE);
                            btnEnd.setVisibility(View.GONE);
                        }
                        else if(count==2) {
                            btnNext.setVisibility(View.GONE);
                            btnEnd.setVisibility(View.VISIBLE);
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
                        else if(count==1) {
                            btnPrev.setVisibility(View.VISIBLE);
                            btnNext.setVisibility(View.VISIBLE);
                            btnEnd.setVisibility(View.GONE);
                        }
                        else if(count==2) {
                            btnNext.setVisibility(View.GONE);
                            btnEnd.setVisibility(View.VISIBLE);
                        }
                    }
                });
                btnEnd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        count = 0;
                        window.dismiss();
                    }
                });
            }
        });
    }
    /*활동에서 나가면 음악이 꺼지게*/
    @Override
    protected void onStop() {
        super.onStop();
        musicPlayer.release();
        musicPlayer = null;
    }
}
