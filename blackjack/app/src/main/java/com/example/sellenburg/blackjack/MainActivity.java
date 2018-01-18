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

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    Button single;
    Button two;
    ArrayList<Drawable> P0hand; //dealer hand
    ArrayList<Drawable> P1hand;
    ArrayList<Drawable> P2hand;
    //lists of the actual drawables

    ArrayList<ImageView> P0visuals;
    ArrayList<ImageView> P1visuals;
    ArrayList<ImageView> P2visuals;
    //lists of the views where the drawables are displayed

    List<ArrayList<Drawable>> hands = Arrays.asList(P0hand, P1hand, P2hand);
    List<ArrayList<ImageView>> handVisuals = Arrays.asList(P0visuals, P1visuals, P2visuals);

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
        //String text = "YOU ARE IN SINGLE PLAYER MODE";
        //intent.putExtra(text);
        startActivity(intent);
    }

    public void refreshPlayerHandView(int i){

        ArrayList<Drawable> hand = hands.get(i);
        ArrayList<ImageView> handVisual = handVisuals.get(i);

        ImageView card1 = handVisual.get(0);
        card1.setImageDrawable(hand.get(0));
        ImageView card2 = handVisual.get(1);
        card2.setImageDrawable(hand.get(1));
        ImageView card3 = handVisual.get(2);
        card3.setImageDrawable(hand.get(2));
        ImageView card4 = handVisual.get(3);
        card4.setImageDrawable(hand.get(3));
        ImageView card5 = handVisual.get(4);
        card5.setImageDrawable(hand.get(4));
        ImageView card6 = handVisual.get(5);
        card6.setImageDrawable(hand.get(5));
        ImageView card7 = handVisual.get(6);
        card7.setImageDrawable(hand.get(6));
    }



    // Called when user taps two-payer mode
    public void twoMode(View view) {
        Intent intent = new Intent(this, twoPlayer.class);
        //String text = "YOU ARE IN TWO PLAYER MODE";
        //intent.putExtra(text);
        startActivity(intent);
    }
}
