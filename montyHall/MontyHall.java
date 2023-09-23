package montyHall;

public class MontyHall
{

	private int prizeDoor, playersInitialDoor, eliminatedDoor, playerFinalDoor;
	private int timesSwitched, timesStayed, timesWon, timesLost, switchWin, stayWin;
	
	public MontyHall()
	{
		playersInitialDoor = -1;
		eliminatedDoor = -1;
		playerFinalDoor = -1;
	}
	
	public void randomizePrizeDoor()
	{
		prizeDoor = (int) (Math.random() * 3 + 1);
		System.out.println("Prizedoor is " + prizeDoor);
	}
	
	public int getPrizeDoor()
	{
		return prizeDoor;
	}
	
	public void pickInitialDoor(int choice)
	{
		playersInitialDoor = choice;
		System.out.println("Player selected Door " + playersInitialDoor);
	}
	
	// returns the players initial pick (1, 2, 3) or -1 if player has not yet picked initial door
	public int getPlayersInitialPick()
	{
		return playersInitialDoor;
	}

	public int openEmptyDoor()
	{
		
		eliminatedDoor = (int) (Math.random() * 3 + 1);
		while(eliminatedDoor == playersInitialDoor || eliminatedDoor == prizeDoor)
		{
			eliminatedDoor = (int) (Math.random() * 3 + 1);
		}
		
		System.out.println("elmininated door is " + eliminatedDoor);
		return eliminatedDoor;
	}
	
	public int getOpenDoor()
	{
		return eliminatedDoor;
	}
	
	public int getPlayersFinalDoor()
	{
		return playerFinalDoor;
	}
	
	public void switchOrStay(boolean stay)
	{
		if (stay)
		{
			playerFinalDoor = playersInitialDoor;
			timesStayed++;
		}
		else if (!stay && (playersInitialDoor != prizeDoor))
		{
			playerFinalDoor = prizeDoor;
			timesSwitched++;
		}
		else if (!stay && (playersInitialDoor == prizeDoor))
		{
			playerFinalDoor = 6 - (eliminatedDoor + playersInitialDoor);
		}
		System.out.println("playerfinaldoor is: " + playerFinalDoor);
		playerWins();
	}
	

	
	public boolean playerWins()
	{
		if (playerFinalDoor == prizeDoor)
		{
			timesWon++;
			System.out.println("you win!");
			return true;
		}
		else{
			timesLost++;
			System.out.println("you lose!");
			return false;
		}
	}
	public int timesSwitched()
	{
		return timesSwitched;
	}
	public int timesStayed()
	{
		return timesStayed;
	}
	public int losses()
	{
		return timesLost;
	}
	public int wins()
	{
		return timesWon;
	}
	
	public void reset()
	{
		playersInitialDoor = -1;
		eliminatedDoor = -1;
		playerFinalDoor = -1;
	}
}
