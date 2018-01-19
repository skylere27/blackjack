package com.example.sellenburg.blackjack;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // this is the home screen, decides which game to play

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
        Intent intent = new Intent(this, singlePlayer.class); //creates a new page
        startActivity(intent);
    }




    // Called when user taps two-payer mode
    public void twoMode(View view) {
        Intent intent = new Intent(this, twoPlayer.class);
        startActivity(intent);
    }
}
