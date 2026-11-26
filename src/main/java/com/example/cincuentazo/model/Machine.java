package com.example.cincuentazo.model;

/**
 * This method selects the card to be played, returns it and removes it from the hand
 */
public class Machine extends Player {
    public Card removeCard() {
        int lowest = 13;
        int index = 0;
        for (int i = 0; i < hand.size(); i++){
            if (hand.get(i).getMinValue() <= lowest){
                lowest = hand.get(i).getMinValue();
                index = i;
            }
        }
        return super.removeCard(index);
    }
}