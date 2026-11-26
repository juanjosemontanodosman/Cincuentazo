package com.example.cincuentazo.model;
import java.util.ArrayList;

public class Player {

    /** List of cards the player has.
     * <p>Any card can be selected and be removed/added to the list, so an ArrayList is the most suitable data structure
     */
    public ArrayList<Card> hand;

    /**
     * Public method for accessing the cards in a player's hand
     * @return An ArrayList with cards
     */
    public ArrayList<Card> getHand(){ return hand; }

    /**
     * Returns the card with the lowest value that a player can select
     * <p> for validating if the player can continue without exceeding the 50 limit
     * @return The value of such card
     * @throws UnsupportedOperationException When the player has no cards
     */
    public int getLowestValue(){
        if (hand.size() < 1){
            throw new UnsupportedOperationException("El jugador no tiene cartas");
        }
        int lowest = hand.get(0).getMinValue();
        for (int i = 0; i < hand.size(); i++){
            if (hand.get(i).getMinValue() < lowest){
                // New lowest value
                lowest = hand.get(i).getMinValue();
            }
        }
        return lowest;
    }

}
