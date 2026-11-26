package com.example.cincuentazo.model;

import java.util.ArrayDeque;

public class Model {

    /** Array of integers, stores the indexes of the cards left in the deck in a given order
     * <p>represents the cards that haven't been drawn, in whatever order they were shuffled
     */
    private ArrayDeque<Integer> deck;

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
     * Initializes every card's value in the cards list
     */
    Model(){
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
