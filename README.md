# blackjack
Google Applied CS group code sprint - Blackjack Game

Blackjack rules based off http://www.bicyclecards.com/how-to-play/blackjack/

The basic rules of this app's Blackjack Game are as follows:
The goal for each player is to have a hand that totals to as close to 21 points as possible. All face cards count as 10 points, and the ace can count as either 1 or 11, as the player chooses.

1) The computer always plays as the dealer. There can be either one or two human players, in which case they will pass the phone to take their turns.
2) At the start of the game each human player is dealt two face-up cards (meaning that if there are two human players they can see eachother's cards). The computer is dealt one face-up card and one face-down card.
3) If a human player's initial deal is a ten and an ace (blackjack) and the computer's is not a blackjack, then that player automatically wins the round. If the computer has blackjack and neither human player does, the computer automatically wins the round. If both a human player and the computer have blackjack the round is a draw.
4) If no blackjack occurs then play continues. The first human player has the chance to either stand or hit. If the player stands their turn is over. If the player hits they will be dealt one more card. They can then choose again to either stand or hit. If the player's hand totals over 21 they "bust" and their turn ends.
5) When the player's turn ends either the next player takes a turn or the computer takes a turn.
6) The computer always follows the dealer's rules, as presented at the cited URL:
When the dealer has served every player, his face-down card is turned up. If the total is 17 or more, he must stand. If the total is 16 or under, he must take a card. He must continue to take cards until the total is 17 or more, at which point the dealer must stand. If the dealer has an ace, and counting it as 11 would bring his total to 17 or more (but not over 21), he must count the ace as 11 and stand.
7) The round ends once the computer has played its turn. The player can then choose to start another round, and new hands will be dealt to all players.

A betting feature may be added afterwards.
