package com.example.cincuentazo.model;


public class Card {

    /** Number or letter of the card*/
    private final char symbol;
    /** Suit of the card */
    private final char suit;

    /**
     * Constructor for setting the symbol (number or letter) and suit of a card
     * @param suit The suit
     * @param symbol The symbol (number or letter)
     */
    Card(char suit, char symbol){
        this.suit = suit;
        this.symbol = symbol;
    }

    /**
     * Public method for getting the highest possible value of the card
     * @return Value of the card, with Aces counted as 10s
     */
    public int getMaxValue(){
        if (symbol == 'A'){
            return 10;
        }
        else {
            return getValue();
        }
    }

    /**
     * Public method for getting the lowest possible value of the card
     * @return Value of the card, with Aces counted as 1s
     */
    public int getMinValue(){
        return getValue();
    }

    /**
     * Public method for getting the suit of a card
     * @return The suit, either Diamantes, Tréboles, Corazones or Picas
     */
    public char getSuit(){
        return suit;
    }

    /**
     * Private method for calculating the value the card has on the sum
     * @return The numerical value the card adds, where Aces are counted as 1s
     */
    private int getValue(){
        if (symbol == '9'){
            return 0;
        }
        else if (
                symbol == 'J' ||
                symbol == 'Q' ||
                symbol == 'K'
        ){
            return -10;
        }
        else if (symbol == 'A'){
            return 1;
        }
        return symbol-'0';
    }

}
