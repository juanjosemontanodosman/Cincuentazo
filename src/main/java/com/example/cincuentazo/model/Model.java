package com.example.cincuentazo.model;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Model {

    /** Array of integers, stores the indexes of the cards left in the deck in a given order
     * <p>represents the cards that haven't been drawn, in whatever order they were shuffled
     */
    private ArrayDeque<Integer> deck;
    private ArrayList<Card> cardsOnGame = new ArrayList<>();

    public Player player;
    public ArrayList<Machine> machines;
    int turn = 0;

    /** List of all cards in game, with a fixed order
     * <p>Used for assigning every possible card a unique address in memory and a unique index
     * This makes operations like shuffling the deck easier
     */
    Card[] cards = new Card[52];

    /**
     * Adds every possible index (from 0 to 51) to the deck list in a random order
     */
    public void shuffle(){
        deck = new ArrayDeque<>();
        int newIndex;
        for (int i = 0; i < 52; i++){
            do {
                newIndex = (int) (Math.random() * 52);
            } while(deck.contains(newIndex));
            deck.add(newIndex);
        }
    }

    /**
     * Public method for getting the last card in the deck (As in drawing the card on top of a real deck)
     * @return A Card object, with a suit and a symbol
     */
    public Card drawCard(){
        if (deck.isEmpty()){
            throw new RuntimeException("No quedan cartas en la baraja");
        }
        return cards[deck.poll()];
    }

    /**
     * Public method that makes the machines play a card, does nothing on the player's turn
     * @return False if the sum exceeds 50
     */
    public boolean nextTurn(){
        if (turn == machines.size()){
            turn = 0;
            return true;
        }
        cardsOnGame.add(machines.get(0).removeCard());
        if (getSum() > 50){
            return false;
        }
        return true;
    }

    public int getSum(){
        int sum = 0;
        for (Card card: cardsOnGame){
            sum += card.getMinValue();
        }
        return sum;
    }

    /**
     * Public method for assigning every player four random cards
     */
    public void startGame(){
        for (Machine m : machines){
            for (int i = 0; i < 4; i++) {
                m.addCard(drawCard());
            }
        }
        for (int i = 0; i < 4; i++) {
            player.addCard(drawCard());
        }
    }

    /**
     * Initializes every card's value in the cards list
     * @param botsNumber The number of bots to be added
     */
    Model(int botsNumber){

        for (int i = 0; i < botsNumber; i++)
        {
            machines.add(new Machine());
        }
        for (int suit = 0; suit < 4; suit++){
            for (int i = 0; i < 13; i++){
                char symbol;
                switch (i+1){
                    case 1:
                        symbol = 'A';
                        break;
                    case 11:
                        symbol = 'J';
                        break;
                    case 12:
                        symbol = 'Q';
                        break;
                    case 13:
                        symbol = 'K';
                        break;
                    default:
                        symbol = (char)('0'+i);
                        break;
                }
                cards[i+suit*13] = new Card((char)suit, symbol);
            }
        }
    }
}