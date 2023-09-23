package blackjack;

import java.util.ArrayList;

import montyHall.MontyHall;

/**
 * The Blackjack class allows a single player to play a game of blackjack.
 * The class tracks the player's bankroll but makes no attempt to prevent
 * a negative bankroll.
 *
 */

public class Blackjack
{
	private static final int DECKS = 6, CARDS_PER_DECK = 52;
	private static final double SHOE_PENETRATION = 0.75;
	
    private Shoe shoe;
    
    private double playersMoney;
    
    private Hand playersHand;
    private double playersBet;
    
    private Hand dealersHand;
    
    /**
     * Constructs a blackjack object that is ready to play.
     * @param playersMoney the player's starting bankroll (all values, including 0 and negative values, are permitted)
     */
    public Blackjack(double playersMoney)
    {
    	this.playersMoney = playersMoney;
    	shoe = new Shoe(DECKS);
    	playersHand = null;
    	playersBet = -1;
    	dealersHand = null;
    }
    
    /**
     * Resets for another round, including reseting shoe if necessary
     */
    private void reset()
    {
    	int totalCards = DECKS*CARDS_PER_DECK;
        playersBet = -1;
        dealersHand = null;
        playersHand = null;
        
        if (totalCards <= totalCards * SHOE_PENETRATION)
        {
        	shoe.reset();
        }
    }
    
    /**
     * Returns the player's money (can be negative)
     * @return the player's money
     */
    public double getPlayersMoney()
    {
        return playersMoney;
    }
    
    /**
     * Returns the player's bet
     * @return the player's bet for the hand
     */
    public double getPlayersBet()
    {
        return playersBet;
    }
    
    /**
     * Places a bet at the start of a round. Deals cards to the player and dealer.
     * @param amount the amount to bet
     */
    public void placeBetAndDealCards(double amount)
    {
    	playersBet = amount;
    	
    	Card card1 = shoe.dealCard();
    	Card card2 = shoe.dealCard();
    	Card card3 = shoe.dealCard();
    	Card card4 = shoe.dealCard();
    	playersHand = new Hand(card1, card3);
    	dealersHand = new Hand(card2, card4);
    	
    }
    
    /**
     * Returns the player's hand
     * @return the player's hand
     */
    public Hand getPlayersHand()
    {
        return playersHand;
    }
    
    /**
     * Returns the dealer's hand
     * @return the dealer's hand
     */
    public Hand getDealersHand()
    {
        return dealersHand;
    }
    
    /**
     * Returns true if the player can hit, false otherwise
     * @return true if the player can hit, false otherwise
     */
    public boolean canHit()
    {
    	if (dealersHand.isBlackjack() || playersHand.isBlackjack())
    	{
    	return false;	
    	}   	
    	else if (playersHand.getValue() < 21)
        {
        	return true;
        }
        return false;
    }
    
    /**
     * Deals another card to the player's hand.
     * 
     * Precondition: canHit()
     */
    public void hit()
    {
    	if( ! canHit() )
    		throw new IllegalStateException("player cannot hit now");
    	
    	playersHand.addCard(shoe.dealCard());
    	
    }
    
    
    /**
     * Plays the dealer's hand.
     */
    public void playDealersHand()
    {	
    	if (!playersHand.isBlackjack())
    	{
    		while (dealersHand.getValue() < 17)
    		{
    			dealersHand.addCard(shoe.dealCard());
    		}
    	}
    }
    
    /**
     * Returns the result of the hand, as described below.
     * -1: player loss/dealer win
     *  0: push (tie)
     *  1: player wins without blackjack
     *  2: player wins with blackjack 
     * @return the result of the hand, as described
     */
    public int getResult()
    {
    	if (playersHand.getValue() > 21)
    	{
    		return -1;
    	}
    	
    	else if (dealersHand.getValue() > 21)
    	{
    		return 1;
    	}
    	 
    	else if (playersHand.getValue() == dealersHand.getValue())
    	{
    		return 0;
    	}
    	
    	else if (playersHand.isBlackjack()) 
    	{
    		return  2;	
    	}
    	
    	else if (dealersHand.isBlackjack())
    	{
    		return -1;
    	}
    	
    	else if (dealersHand.getValue() > playersHand.getValue())
    	{
    		return -1;
    	}
    	
    	else if (dealersHand.getValue() < playersHand.getValue())
    	{
    		return 1;
    	}
    	
    	return -1;
    }
    
    /**
     * Resolves the player's bets (updates player's money based on the
     * results of the round) and resets for another round
     */
    public void resolveBetsAndReset()
    {
        if (getResult() == -1)
        {
        	playersMoney -= playersBet;
        	playersBet = 0;
        }
        else if (getResult() == 0)
        {
        	playersMoney += playersBet;
        	playersBet = 0;
        }
        else if (getResult() == 1)
        {
        	playersMoney += playersBet;
        	playersBet = 0;
        }
        else if (getResult() == 2)
        {
        	playersMoney += playersBet * 1.5;
        	playersBet = 0;
        }
    	reset();
    }
}
