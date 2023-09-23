package blackjack;

import java.text.NumberFormat;
import java.util.Scanner;

import cashRegister.CashRegister;

/**
 * A text based user interface that allows the user to
 * play a game of blackjack.
 */
public class BlackjackUI
{
	private Blackjack bj; 
	private Scanner fromKeyboard;
	private NumberFormat nf;
	
	/**
	 * Constructs a blackjack game with $1,000 in player bankroll
	 */
	public BlackjackUI()
	{
		 fromKeyboard = new Scanner(System.in);
	     bj = new Blackjack(1000);
	     nf = NumberFormat.getCurrencyInstance();
	}
	
	/**
     * Returns a valid numerical bet obtained from the player
     * @return a valid numerical bet obtained from the player
     */
    double getValidBet()
    {
    	System.out.println("Cash: " + bj.getPlayersMoney());
        System.out.println("Bet Amount: ");
        String input = fromKeyboard.nextLine();
    	
        while (stringToNumber(input) == -1 || stringToNumber(input) > bj.getPlayersMoney() || stringToNumber(input) <= 0)
        {
        	System.out.println("Ur poor");
        	System.out.println("Cash: " + bj.getPlayersMoney());
            System.out.println("Bet Amount: ");
            input = fromKeyboard.nextLine();
        }
        return stringToNumber(input);
    }
    
	/**
	 * Plays a single hand of blackjack
	 */
    public void playHand()
    {
        bj.placeBetAndDealCards(getValidBet());
        playPlayersHand();
        bj.playDealersHand();
        displayResult();
        bj.resolveBetsAndReset();
    }
    
    /**
     * Plays blackjack hands until the user chooses to quit
     */
    public void playHandsUntilQuit()
    {   	
    	
    	String pORq = "p";
    	while(pORq.equals("p"))
    	{    		
    		playHand();
    		System.out.println("Play(p) or Quit(q)?");
        	pORq = fromKeyboard.nextLine();
    	}
    	System.out.println("money: " + bj.getPlayersMoney());
    	
    	
    	
    }

    /**
     * Allows the player to hit until it is no longer possible
     * TODO so or until the player chooses to stand
     */
	private void playPlayersHand()
	{
		// you need somethin ghere
		
		
		boolean playerStood = false;
		while(bj.canHit() && ! playerStood)
		{
			System.out.println("dealer hand:" + bj.getDealersHand().getCards().get(0));
			System.out.println("Player hand:" + bj.getPlayersHand());
			System.out.println("Hit(h) or Stand(s)");
			String hOrS = fromKeyboard.nextLine();
			if (hOrS.equals("h"))
			{
				bj.hit();	
			}
			else if (hOrS.equals("s"))
			{
				playerStood = true;
				// this code runs when the user picks stand
			} 	
			else
			{
				System.out.println("your brainded do an h or s");
			}
		}

	}

	/**
	 * Displays the result of the hand (push, player win, player blackjack or loss)
	 */
	private void displayResult()
	{
		System.out.println("dealer hand: " + bj.getDealersHand());
		System.out.println("players hand: " + bj.getPlayersHand());
		if(bj.getResult() == -1)
		{
			System.out.println("You lose");	
		}
		else if (bj.getResult() == 0)
		{
			System.out.println("tie");
		}
		else if (bj.getResult() == 1)
		{
			System.out.println("You win!");
		}
		else
		{
			System.out.println("Blackjack!");
		}
				
	}

	/**
	 * Returns the numeric representation of input or -1 if input is not numeric
	 * @param input the value to be converted to a number
	 * @return numeric representation or -1
	 */
	private double stringToNumber(String input)
	{
		try
		{
			return Double.parseDouble(input);
		}
		catch(NumberFormatException e)
		{
			return -1;
		}
	}
}
