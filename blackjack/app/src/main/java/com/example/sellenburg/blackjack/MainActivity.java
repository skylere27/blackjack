package com.example.sellenburg.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // this is the home screen, decides which game to play

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    Button single;
    Button two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // access solo mode
        single = findViewById(R.id.single);
        single.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                singleMode(v);
            };
        });

        // access 2-player mode
        two = findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                twoMode(v);
            };
        });
    }

    // Called when user taps single-player mode
    public void singleMode(View view) {
        Intent intent = new Intent(this, singlePlayer.class);
        //String text = "YOU ARE IN SINGLE PLAYER MODE";
        //intent.putExtra(text);
        startActivity(intent);
    }

    // Called when user taps two-payer mode
    public void twoMode(View view) {
        Intent intent = new Intent(this, twoPlayer.class);
        //String text = "YOU ARE IN TWO PLAYER MODE";
        //intent.putExtra(text);
        startActivity(intent);
    }
}
