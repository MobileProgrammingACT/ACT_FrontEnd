package com.example.actprime;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TutorialActivity2 extends AppCompatActivity {

    Button explanation;
    ImageButton tenBackward, playButton, pauseButton, tenForward, closeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_activity2);

        explanation = (Button) findViewById(R.id.explanation);

        tenBackward = (ImageButton) findViewById(R.id.tenBackward);
        tenForward = (ImageButton) findViewById(R.id.tenForward);
        playButton = (ImageButton) findViewById(R.id.playButton);
        pauseButton = (ImageButton) findViewById(R.id.pauseButton);
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
