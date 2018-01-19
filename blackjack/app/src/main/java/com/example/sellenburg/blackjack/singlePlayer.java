package com.example.sellenburg.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;

public class singlePlayer extends AppCompatActivity {

    /*
    * Variables:
    * userTotal
    * userTurnTotal
    * dealerTotal
    * dealerTurnTotal
    *
    * Methods:
    * userTurn (aces are high!!)
    *   dealCard
    *       data of the cards
    *       shuffle function on arrayList
    *       card logic - randomize
    *       like roll, show new card, max out at 5
    *   hit or stand - buttons and methods
    *   // aceValue // pick one first (start with 11, toggle later)
    *   // changeAce // possible extension
    *   bust function
    *   // bet
    * dealerTurn
    *   uses the deal
    *   has its own logic for when to hit/stand
    *
    *
    // make sure the cards have values!
    // attribute a point value to each card
    // roll is now dealCard
    // hit calls deal
    // compturn that happens when you stay
    * */

    //dealCard branch

    TextView score;
    TextView console;
    ImageView card1;
    ImageView card2;
    ImageView card3;
    ImageView card4;
    ImageView card5;
    ImageView card6;
    ImageView card7;
    ImageView dealer1;
    ImageView dealer2;
    ImageView dealer3;
    ImageView dealer4;
    ImageView dealer5;
    ImageView dealer6;
    ImageView dealer7;
    Button hit;
    Button stand;
    ArrayList<Integer> deck;
    HashMap<Integer, ArrayList<Integer>> valueToCards = new  HashMap<Integer, ArrayList<Integer>> () {{
        put(11, new ArrayList<Integer>(Arrays.asList(R.drawable.ace_of_clubs, R.drawable.ace_of_diamonds, R.drawable.ace_of_hearts, R.drawable.ace_of_spades)));
        put(2, new ArrayList<Integer>(Arrays.asList(R.drawable.two_of_clubs, R.drawable.two_of_diamonds, R.drawable.two_of_hearts, R.drawable.two_of_spades)));
        put(3, new ArrayList<Integer>(Arrays.asList(R.drawable.three_of_clubs, R.drawable.three_of_diamonds, R.drawable.three_of_hearts, R.drawable.three_of_spades)));
        put(4, new ArrayList<Integer>(Arrays.asList(R.drawable.four_of_clubs, R.drawable.four_of_diamonds, R.drawable.four_of_hearts, R.drawable.four_of_spades)));
        put(5, new ArrayList<Integer>(Arrays.asList(R.drawable.five_of_clubs, R.drawable.five_of_diamonds, R.drawable.five_of_hearts, R.drawable.five_of_spades)));
        put(6, new ArrayList<Integer>(Arrays.asList(R.drawable.six_of_clubs, R.drawable.six_of_diamonds, R.drawable.six_of_hearts, R.drawable.six_of_spades)));
        put(7, new ArrayList<Integer>(Arrays.asList(R.drawable.seven_of_clubs, R.drawable.seven_of_diamonds, R.drawable.seven_of_hearts, R.drawable.seven_of_spades)));
        put(8, new ArrayList<Integer>(Arrays.asList(R.drawable.eight_of_clubs, R.drawable.eight_of_diamonds, R.drawable.eight_of_hearts, R.drawable.eight_of_spades)));
        put(9, new ArrayList<Integer>(Arrays.asList(R.drawable.nine_of_clubs, R.drawable.nine_of_diamonds, R.drawable.nine_of_hearts, R.drawable.nine_of_spades)));
        put(10, new ArrayList<Integer>(Arrays.asList(R.drawable.ten_of_clubs, R.drawable.ten_of_diamonds, R.drawable.ten_of_hearts, R.drawable.ten_of_spades,
                R.drawable.jack_of_clubs, R.drawable.jack_of_diamonds, R.drawable.jack_of_hearts, R.drawable.jack_of_spades,
                R.drawable.queen_of_clubs, R.drawable.queen_of_diamonds, R.drawable.queen_of_hearts, R.drawable.queen_of_spades,
                R.drawable.king_of_clubs, R.drawable.king_of_diamonds, R.drawable.king_of_hearts, R.drawable.king_of_spades)));
    }};

    int userTotal = 0;
    int userTurnTotal = 0;
    int dealerTotal = 0;
    int dealerTurnTotal = 0;
    int cardsInHand = 0;

    public static final ArrayList<Integer> cardsList =  new ArrayList<Integer>(Arrays.asList(R.drawable.ace_of_clubs, R.drawable.ace_of_diamonds, R.drawable.ace_of_hearts, R.drawable.ace_of_spades,
            R.drawable.eight_of_clubs, R.drawable.eight_of_diamonds, R.drawable.eight_of_hearts, R.drawable.eight_of_spades,
            R.drawable.five_of_clubs, R.drawable.five_of_diamonds, R.drawable.five_of_hearts, R.drawable.five_of_spades,
            R.drawable.four_of_clubs, R.drawable.four_of_diamonds, R.drawable.four_of_hearts, R.drawable.four_of_spades,
            R.drawable.three_of_clubs, R.drawable.three_of_diamonds, R.drawable.three_of_hearts, R.drawable.three_of_spades,
            R.drawable.jack_of_clubs, R.drawable.jack_of_diamonds, R.drawable.jack_of_hearts, R.drawable.jack_of_spades,
            R.drawable.king_of_clubs, R.drawable.king_of_diamonds, R.drawable.king_of_hearts, R.drawable.king_of_spades,
            R.drawable.nine_of_clubs, R.drawable.nine_of_diamonds, R.drawable.nine_of_hearts, R.drawable.nine_of_spades,
            R.drawable.queen_of_clubs, R.drawable.queen_of_diamonds, R.drawable.queen_of_hearts, R.drawable.queen_of_spades,
            R.drawable.seven_of_clubs, R.drawable.seven_of_diamonds, R.drawable.seven_of_hearts, R.drawable.seven_of_spades,
            R.drawable.six_of_clubs, R.drawable.six_of_diamonds, R.drawable.six_of_hearts, R.drawable.six_of_spades,
            R.drawable.ten_of_clubs, R.drawable.ten_of_diamonds, R.drawable.ten_of_hearts, R.drawable.ten_of_spades,
            R.drawable.two_of_clubs, R.drawable.two_of_diamonds, R.drawable.two_of_hearts, R.drawable.two_of_spades));


    private int dealCard() {
        return deck.remove(0);
        // show the card in the correct spot in hand
        // account for if deck has run out
    }

    public void hitClicked() {
        //cardImages.get(cardsInHand).setImageResource(dealCard())
        //
    }

    private void standClicked() {

    }

    private void dealerTurn() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        score = findViewById(R.id.score);
        console = findViewById(R.id.console);
        deck = cardsList;
        Collections.shuffle(deck); // deck is shuffled

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);
        card7 = findViewById(R.id.card7);
        dealer1 = findViewById(R.id.dealer1);
        dealer2 = findViewById(R.id.dealer2);
        dealer3 = findViewById(R.id.dealer3);
        dealer4 = findViewById(R.id.dealer4);
        dealer5 = findViewById(R.id.dealer5);
        dealer6 = findViewById(R.id.dealer6);
        dealer7 = findViewById(R.id.dealer7);
        card3.setVisibility(View.GONE);
        card4.setVisibility(View.GONE);
        card5.setVisibility(View.GONE);
        card6.setVisibility(View.GONE);
        card7.setVisibility(View.GONE);
        dealer3.setVisibility(View.GONE);
        dealer4.setVisibility(View.GONE);
        dealer5.setVisibility(View.GONE);
        dealer6.setVisibility(View.GONE);
        dealer7.setVisibility(View.GONE);

        // ON START - FIX, CODE THIS? on click of a START GAME button?
        card1.setImageResource(dealCard()); // defaults at ace of diamonds
        card2.setImageResource(dealCard());
        cardsInHand = 2;

        // CLICK HIT
        hit = findViewById(R.id.hit);
        hit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                hitClicked();
            };
        });

        // CLICK STAND
        stand = findViewById(R.id.stand);
        stand.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                standClicked();
                dealerTurn();
            };
        });
    }
}
