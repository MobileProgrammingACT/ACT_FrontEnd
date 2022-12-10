package com.example.actprime;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class TutorialActivity3 extends AppCompatActivity {

    Button submit;
    RadioGroup radioGroup_01, radioGroup_02, radioGroup_03, radioGroup_04, radioGroup_05, radioGroup_06, radioGroup_07, radioGroup_08, radioGroup_09, radioGroup_10;
    RadioButton radioButton_never_01, radioButton_never_02, radioButton_never_03, radioButton_never_04, radioButton_never_05, radioButton_never_06, radioButton_never_07, radioButton_never_08, radioButton_never_09, radioButton_never_10;
    RadioButton radioButton_rarely_01, radioButton_rarely_02, radioButton_rarely_03, radioButton_rarely_04, radioButton_rarely_05, radioButton_rarely_06, radioButton_rarely_07, radioButton_rarely_08, radioButton_rarely_09, radioButton_rarely_10;
    RadioButton radioButton_sometimes_01, radioButton_sometimes_02, radioButton_sometimes_03, radioButton_sometimes_04, radioButton_sometimes_05, radioButton_sometimes_06, radioButton_sometimes_07, radioButton_sometimes_08, radioButton_sometimes_09, radioButton_sometimes_10;
    RadioButton radioButton_often_01, radioButton_often_02, radioButton_often_03, radioButton_often_04, radioButton_often_05, radioButton_often_06, radioButton_often_07, radioButton_often_08, radioButton_often_09, radioButton_often_10;
    RadioButton radioButton_always_01, radioButton_always_02, radioButton_always_03, radioButton_always_04, radioButton_always_05, radioButton_always_06, radioButton_always_07, radioButton_always_08, radioButton_always_09, radioButton_always_10;
    ImageButton closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_activity3);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Tutorial.class);
                startActivity(intent);
            }
        });

    }

}
