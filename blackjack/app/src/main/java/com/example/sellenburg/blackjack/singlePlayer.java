package com.example.sellenburg.blackjack;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
    // make sure the cards have values! HASH MAP
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
    int userTurnTotal = 0; //means until someone wins
    int dealerTotal = 0;
    int dealerTurnTotal = 0;
    int cardsInUserHand = 0;
    int cardsInDealerHand = 0;

    ArrayList<ImageView> P0visuals;
    ArrayList<ImageView> P1visuals;
    ArrayList<ImageView> P2visuals;
    ArrayList<ArrayList<ImageView>> handVisuals;
    //lists of the views where the drawables are displayed

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

    // On deal, updates image and score
    private int dealCard(int p) {
        int card = deck.remove(0);
        int cardValue;
        for (HashMap.Entry<Integer, ArrayList<Integer>> cardArray : valueToCards.entrySet())
        {
            Log.i("DEALLOG", cardArray.toString());
//            for (int i; i < valueToCards.size(); i++) {
//                if (cardArray.getValue(i) == card) {
//                    //cardValue = valueToCards;
//                }
//            }
        }
        // potentially change hashmap to card: value
        if (p == 0) { // dealer turn
            // updates dealer hand and dealer score

            //assuming hand size counter has NOT been updated
            updateHandView(p,card);
            cardsInDealerHand++;
        } else if (p == 1) { // player 1
            // updates player hand and player score

            //assuming hand size counter has NOT been updated
            updateHandView(p,card);
            cardsInUserHand++;
        }
        return card;
    }




    public void hitClicked() {
        //cardImages.get(cardsInHand).setImageResource(dealCard())
        //
    }

    private void standClicked() {

    }
//ie computer


    private void dealerTurn() {
//will deal a card and update the image and score
        /*
        dealCard(0);
        while(dealerTurnTotal <= 16)
        {
            dealCard(0);
        }
        if(dealerTurnTotal == 21)
        {
            console = findViewById(R.id.console);
            score = findViewById(R.id.score);
            console.setText("Computer wins this round!");
            dealerTotal++;
            dealerTurnTotal = 0;
            score.setText("Your Wins: "+userTotal + " Dealer Wins: "+dealerTotal);
        }
        else if(dealerTurnTotal >= 17)
        {
            standClicked();
        }
        */
    }


    public void updateHandView(int p,int id){
        //p=0 indicates dealer, p=1 indicates P1, p=2 indicates P2, etc
        //id indicates new card
        Log.d("myDebugTag", "p: " + String.valueOf(p) +
                "; id: " + String.valueOf(id) +
                "; handVisuals: " + String.valueOf(handVisuals) +
                "; P0Visuals: " + String.valueOf(P0visuals) +
                "; P1Visuals: " + String.valueOf(P1visuals) +
                "; handVisuals.get(p): " + String.valueOf(handVisuals.get(p)));
        ArrayList<ImageView> handVisual = handVisuals.get(p);

        int cardsInHand = 0;
        if (p == 0) { // dealer turn
            cardsInHand = cardsInDealerHand;

        } else if (p == 1) { // player 1
            cardsInHand = cardsInUserHand;
        }

        ImageView card = handVisual.get(cardsInHand+1);
        Drawable drawable = getResources().getDrawable(id,null);
        card.setImageDrawable(drawable);

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
        P1visuals = new ArrayList<ImageView>(Arrays.asList(card1, card2, card3, card4, card5, card6, card7));


        dealer1 = findViewById(R.id.dealer1);
        dealer2 = findViewById(R.id.dealer2);
        dealer3 = findViewById(R.id.dealer3);
        dealer4 = findViewById(R.id.dealer4);
        dealer5 = findViewById(R.id.dealer5);
        dealer6 = findViewById(R.id.dealer6);
        dealer7 = findViewById(R.id.dealer7);
        P0visuals = new ArrayList<ImageView>(Arrays.asList(dealer1, dealer2, dealer3, dealer4, dealer5, dealer6, dealer7));

        handVisuals = new ArrayList<ArrayList<ImageView>>(Arrays.asList(P0visuals, P1visuals, P2visuals));

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
        card1.setImageResource(dealCard(1)); // defaults at ace of diamonds
        card2.setImageResource(dealCard(1));
        cardsInUserHand = 2;

        dealer1.setImageResource(dealCard(0));
        dealer2.setImageResource(R.drawable.card_back);

        console.setText("Your hand total: " + userTurnTotal);

        // CLICK HIT
        hit = findViewById(R.id.hit);
        hit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dealCard(1);
                console.setText("Your hand total: " + userTurnTotal);
            };
        });

        // CLICK STAND
        stand = findViewById(R.id.stand);
        stand.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dealerTurn();
                console.setText("Your hand total: " + userTurnTotal + "Dealer hand total: " + dealerTurnTotal);
            };
        });
    }
}
