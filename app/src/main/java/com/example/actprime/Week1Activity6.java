package com.example.actprime;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Week1Activity6 extends AppCompatActivity {
    Button submit, okay;
    EditText reasonET, resultET;
    TextView reasonTV, resultTV, text0, text1_1, text1_2, text2_1, text2_2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.week1_activity6);

        submit = (Button) findViewById(R.id.submit);
        okay = (Button) findViewById(R.id.okay);

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

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit.setVisibility(View.GONE);
                text0.setVisibility(View.VISIBLE);
                text1_1.setVisibility(View.VISIBLE);
                text1_2.setVisibility(View.VISIBLE);
                text2_1.setVisibility(View.VISIBLE);
                text2_2.setVisibility(View.VISIBLE);
                okay.setVisibility(View.VISIBLE);

                reasonTV.setText("내가 " + reasonET.getText().toString() + "다면, ");
                resultTV.setText(" 나는 " + resultET.getText().toString() + " 있어.");
                reasonTV.setPaintFlags(reasonTV.getPaintFlags()|Paint.STRIKE_THRU_TEXT_FLAG);

                reasonTV.setVisibility(View.VISIBLE);
                resultTV.setVisibility(View.VISIBLE);
            }
        });

        okay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.actprime.Week1.class);
                startActivity(intent);
            }
        });

    }
}
