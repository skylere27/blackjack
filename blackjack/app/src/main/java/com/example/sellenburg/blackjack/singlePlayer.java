package com.example.sellenburg.blackjack;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Button;

import java.lang.reflect.Array;
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
    Button newround;
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
    int cardsInHand = 0;

    ArrayList<ImageView> P0visuals;
    ArrayList<ImageView> P1visuals;
    ArrayList<ImageView> P2visuals;
    //lists of the views where the drawables are displayed

    List<ArrayList<ImageView>> handVisuals = Arrays.asList(P0visuals, P1visuals, P2visuals);

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
        int cardValue = 0;
        for (HashMap.Entry<Integer, ArrayList<Integer>> entry : valueToCards.entrySet())
        {
            ArrayList<Integer> cardArray = entry.getValue();
            for (int i = 0; i < cardArray.size(); i++) {
                if (cardArray.get(i) == card) {
                    cardValue = entry.getKey();
                }
            }
        }
        // potentially change hashmap to card: value
        if (p == 0) { // dealer turn
            // updates dealer hand and dealer score
            dealerTurnTotal += cardValue;
            Log.i("DEALERTOTAL", ""+dealerTurnTotal);
            if (dealerTurnTotal == 21) {
                console.setText("BLACKJACK! Computer got blackjack!");
                newround.setEnabled(true);
            } else if (dealerTurnTotal > 21) {
                console.setText("BUST! Computer busted.");
                newround.setEnabled(true);
                //dealerTurnTotal = 0;
                // not sure what happens here
            }
        } else if (p == 1) { // player 1
            // updates player hand and player score
            userTurnTotal += cardValue;
            Log.i("PLAYERTOTAL", ""+userTurnTotal);
            console.setText("Your hand total: " + userTurnTotal);
            if (userTurnTotal == 21) {
                console.setText("BLACKJACK! You got blackjack!");
                hit.setEnabled(false);
                stand.setEnabled(false);
                newround.setEnabled(true);
                // will reveal dealer's card and determine win
            } else if (userTurnTotal > 21) {
                console.setText("BUST! You busted with " + userTurnTotal + ".");
                dealerTotal += 1;
                userTurnTotal = 0;
                hit.setEnabled(false);
                stand.setEnabled(false);
                newround.setEnabled(true);
                // round ends!! might call for reconstruction of hit method...like putting all of this into hit instead of deal
            }
        }
        return card;
    }

    private void dealerTurn() {
//will deal a card and update the image and score
        hit.setEnabled(false);
        stand.setEnabled(false);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                int recentCard = dealCard(0);
                console.setText("Your hand total: " + userTurnTotal + "\nThe dealer's hand total: " + dealerTurnTotal);
                if (dealerTurnTotal <= 16 && dealerTurnTotal > 0) { //Fix the problem when dealer busts!!
                    dealerTurn();
                } else {
                    endDealerTurn();
                }
            }
        }, 4000);

        /*if(recentCard == valueToCards.get(11).get(0) && recentCard + dealerTurnTotal ==)
        //|| recentCard == valueToCards.get(11).get(1) || recentCard == valueToCards.get(11).get(2) || recentCard == valueToCards.get(11).get(3))
        {

        }*/

    }

    private void endDealerTurn() {
        //compare with user to see if user or computer has a greater total
        console.setText("Round over!");
        if(userTurnTotal > dealerTurnTotal)
        {
            userTotal++;
            console.setText("User wins this round with " + userTurnTotal + " points! \nDealer score was " + dealerTurnTotal);
            score.setText("Your Wins: "+ userTotal + " Dealer Wins: "+dealerTotal);
            hit.setEnabled(false);
            stand.setEnabled(false);
            newround.setEnabled(true);
        }
        else
        {
            dealerTotal++;
            console.setText("Dealer wins this round with " + dealerTurnTotal + " points! \nYour score was " + userTurnTotal);
            score.setText("Your Wins: "+userTotal + " Dealer Wins: "+dealerTotal);
            hit.setEnabled(false);
            stand.setEnabled(false);
            newround.setEnabled(true);
        }
    }


    /* I don't think this makes sense anymore based on how other
        things got implemented -Erica
    public void refreshPlayerHandView(int p){
        //p=0 indicates dealer, p=1 indicates P1, p=2 indicates P2, etc
        ArrayList<Drawable> hand = hands.get(p);
        ArrayList<ImageView> handVisual = handVisuals.get(p);

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
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_player);

        score = findViewById(R.id.score);
        console = findViewById(R.id.console);
        newround = findViewById(R.id.newround);
        newround.setEnabled(false);

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
        dealer1.setImageResource(dealCard(0));
        dealer2.setImageResource(R.drawable.card_back);
        Log.i("ONSTART", "DEALT TWO CARDS EACH. PlayerTotal: " + userTurnTotal + " DealerTotal: " + dealerTurnTotal);
        cardsInHand = 2;
        console.setText("Your hand total: " + userTurnTotal);

        // CLICK HIT
        hit = findViewById(R.id.hit);
        hit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dealCard(1);
            };
        });

        // CLICK STAND
        stand = findViewById(R.id.stand);
        stand.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dealerTurn();
                console.setText("Your hand total: " + userTurnTotal + "\nDealer hand total: " + dealerTurnTotal);
            };
        });

        //CLICK NEWROUND
        newround.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                deck = cardsList;
                Collections.shuffle(deck);
                userTurnTotal = 0;
                dealerTurnTotal = 0;
                card1.setImageResource(dealCard(1)); // defaults at ace of diamonds
                card2.setImageResource(dealCard(1));
                dealer1.setImageResource(dealCard(0));
                dealer2.setImageResource(R.drawable.card_back);
                Log.i("ONSTART", "DEALT TWO CARDS EACH. PlayerTotal: " + userTurnTotal + " DealerTotal: " + dealerTurnTotal);
                cardsInHand = 2;
                console.setText("Your hand total: " + userTurnTotal);
                hit.setEnabled(true);
                stand.setEnabled(true);
                newround.setEnabled(false);
            };
        });

    }
}
