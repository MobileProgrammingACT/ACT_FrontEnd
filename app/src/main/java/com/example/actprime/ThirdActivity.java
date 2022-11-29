package com.example.actprime;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ThirdActivity extends AppCompatActivity {

    /*DB 저장 정의용 - 위치 변경 X!!!*/
    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference ref = db.getReference();

    Button explain1,btnNext, btnPrev, btnEnd, submit;
    ImageView menuBookmark, menuHome ,menuSetting;
    ImageButton musicButton;
    View activity1ExView;
    EditText content;
    ViewFlipper vFlipper;
    MediaPlayer musicPlayer;
    String shared = "file"; //Edittext 값 저장용
    int count = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week_one_activity1);

        submit = findViewById(R.id.submit);
        content = findViewById(R.id.content);

        /*저장 메소드 - writereview불러오기*/
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // writereview(content.getText().toString());
                Toast.makeText(ThirdActivity.this, "저장했습니다", Toast.LENGTH_SHORT).show();
            }
        });

        /*Edittext 값 유지 메소드*/
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("key","");
        content.setText(value);

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

        submit = (Button) findViewById(R.id.submit);
        content = (EditText) findViewById(R.id.content);

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
                                                    if (count == 0)
                                                        btnPrev.setVisibility(View.INVISIBLE);
                                                    else if (count == 1) {
                                                        btnPrev.setVisibility(View.VISIBLE);
                                                        btnNext.setVisibility(View.VISIBLE);
                                                        btnEnd.setVisibility(View.GONE);
                                                    } else if (count == 2) {
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
                                                    if (count == 0)
                                                        btnPrev.setVisibility(View.INVISIBLE);
                                                    else if (count == 1) {
                                                        btnPrev.setVisibility(View.VISIBLE);
                                                        btnNext.setVisibility(View.VISIBLE);
                                                        btnEnd.setVisibility(View.GONE);
                                                    } else if (count == 2) {
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
                // 하단 네비게이션 바 활성화
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
    /*Edittext 값 외부로 나간 이후에도 저장가능한 메소드*/
    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences  sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor  = sharedPreferences.edit();
        String value = content.getText().toString();
        editor.putString("key", value);
        editor.commit();
    }

    /*작성하는 메소드 writereview 정의, DB에 저장되는 방식 "review"키 값 내에 저장하기*/
    public void writereview(String content) {
        WriteReview writereview = new WriteReview(content);
        ref.child("Act").child("Week1").child("week1act1").setValue(content);
    }

    /*활동에서 나가면 음악이 꺼지게*/
    @Override
    protected void onStop() {
        super.onStop();
        musicPlayer.release();
        musicPlayer = null;
    }
}
