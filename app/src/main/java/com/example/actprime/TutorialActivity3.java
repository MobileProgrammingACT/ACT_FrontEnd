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
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class TutorialActivity3 extends AppCompatActivity {

    private FirebaseDatabase db = FirebaseDatabase.getInstance();
    private DatabaseReference ref = db.getReference();

    Button submit;
    RadioButton never_01, never_02, never_03, never_04, never_05, never_06, never_07, never_08, never_09, never_10;
    RadioButton rarely_01, rarely_02, rarely_03, rarely_04, rarely_05, rarely_06, rarely_07, rarely_08, rarely_09, rarely_10;
    RadioButton sometimes_01, sometimes_02, sometimes_03, sometimes_04, sometimes_05, sometimes_06, sometimes_07, sometimes_08, sometimes_09, sometimes_10;
    RadioButton often_01, often_02, often_03, often_04, often_05, often_06, often_07, often_08, often_09, often_10;
    RadioButton always_01, always_02, always_03, always_04, always_05, always_06, always_07, always_08, always_09, always_10;
    ImageButton closeButton;
    int answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_activity3);
        answer = 0;

        never_01 = (RadioButton) findViewById(R.id.never_01);
        never_02 = (RadioButton) findViewById(R.id.never_02);
        never_03 = (RadioButton) findViewById(R.id.never_03);
        never_04 = (RadioButton) findViewById(R.id.never_04);
        never_05 = (RadioButton) findViewById(R.id.never_05);
        never_06 = (RadioButton) findViewById(R.id.never_06);
        never_07 = (RadioButton) findViewById(R.id.never_07);
        never_08 = (RadioButton) findViewById(R.id.never_08);
        never_09 = (RadioButton) findViewById(R.id.never_09);
        never_10 = (RadioButton) findViewById(R.id.never_10);

        rarely_01 = (RadioButton) findViewById(R.id.rarely_01);
        rarely_02 = (RadioButton) findViewById(R.id.rarely_02);
        rarely_03 = (RadioButton) findViewById(R.id.rarely_03);
        rarely_04 = (RadioButton) findViewById(R.id.rarely_04);
        rarely_05 = (RadioButton) findViewById(R.id.rarely_05);
        rarely_06 = (RadioButton) findViewById(R.id.rarely_06);
        rarely_07 = (RadioButton) findViewById(R.id.rarely_07);
        rarely_08 = (RadioButton) findViewById(R.id.rarely_08);
        rarely_09 = (RadioButton) findViewById(R.id.rarely_09);
        rarely_10 = (RadioButton) findViewById(R.id.rarely_10);

        sometimes_01 = (RadioButton) findViewById(R.id.sometimes_01);
        sometimes_02 = (RadioButton) findViewById(R.id.sometimes_02);
        sometimes_03 = (RadioButton) findViewById(R.id.sometimes_03);
        sometimes_04 = (RadioButton) findViewById(R.id.sometimes_04);
        sometimes_05 = (RadioButton) findViewById(R.id.sometimes_05);
        sometimes_06 = (RadioButton) findViewById(R.id.sometimes_06);
        sometimes_07 = (RadioButton) findViewById(R.id.sometimes_07);
        sometimes_08 = (RadioButton) findViewById(R.id.sometimes_08);
        sometimes_09 = (RadioButton) findViewById(R.id.sometimes_09);
        sometimes_10 = (RadioButton) findViewById(R.id.sometimes_10);

        often_01 = (RadioButton) findViewById(R.id.often_01);
        often_02 = (RadioButton) findViewById(R.id.often_02);
        often_03 = (RadioButton) findViewById(R.id.often_03);
        often_04 = (RadioButton) findViewById(R.id.often_04);
        often_05 = (RadioButton) findViewById(R.id.often_05);
        often_06 = (RadioButton) findViewById(R.id.often_06);
        often_07 = (RadioButton) findViewById(R.id.often_07);
        often_08 = (RadioButton) findViewById(R.id.often_08);
        often_09 = (RadioButton) findViewById(R.id.often_09);
        often_10 = (RadioButton) findViewById(R.id.often_10);

        always_01 = (RadioButton) findViewById(R.id.always_01);
        always_02 = (RadioButton) findViewById(R.id.always_02);
        always_03 = (RadioButton) findViewById(R.id.always_03);
        always_04 = (RadioButton) findViewById(R.id.always_04);
        always_05 = (RadioButton) findViewById(R.id.always_05);
        always_06 = (RadioButton) findViewById(R.id.always_06);
        always_07 = (RadioButton) findViewById(R.id.always_07);
        always_08 = (RadioButton) findViewById(R.id.always_08);
        always_09 = (RadioButton) findViewById(R.id.always_09);
        always_10 = (RadioButton) findViewById(R.id.always_10);

        RadioButton never[] = {never_01, never_02, never_03, never_04, never_05, never_06, never_07, never_08, never_09, never_10};
        RadioButton rarely[] = {rarely_01, rarely_02, rarely_03, rarely_04, rarely_05, rarely_06, rarely_07, rarely_08, rarely_09, rarely_10};
        RadioButton sometimes[] = {sometimes_01, sometimes_02, sometimes_03, sometimes_04, sometimes_05, sometimes_06, sometimes_07, sometimes_08, sometimes_09, sometimes_10};
        RadioButton often[] = {often_01, often_02, often_03, often_04, often_05, often_06, often_07, often_08, often_09, often_10};
        RadioButton always[] = {always_01, always_02, always_03, always_04, always_05, always_06, always_07, always_08, always_09, always_10};

        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < never.length; i++) {
                    if (never[i].isChecked()) {
                        answer += 1;
                    }
                    else if (rarely[i].isChecked()) {
                        answer += 2;
                    }
                    else if (sometimes[i].isChecked()) {
                        answer += 3;
                    }
                    else if (often[i].isChecked()) {
                        answer += 4;
                    }
                    else if (always[i].isChecked()) {
                        answer += 5;
                    }
                }
                Toast.makeText(TutorialActivity3.this, "수고하셨습니다, 결과를 확인해 보세요!", Toast.LENGTH_SHORT).show();
                ref.child("Act").child("firstscore").setValue(answer);
            }
        });

        closeButton = (ImageButton) findViewById(R.id.closeButton);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Tutorial.class);
                startActivity(intent);
            }
        });

    }

}
