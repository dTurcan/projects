package montyHall;
import processing.core.PApplet;
import processing.core.PImage;

public class MontyHallMain  extends PApplet{
	
	private MontyHall m;
	
	public static void main(String[] args) 
	{
		PApplet.main("montyHall.MontyHallMain");
//		m.pickInitialDoor(1);
//		m.openEmptyDoor();
//		m.switchOrStay(true);
//		m.playerWins();
	}

	public void settings()
	{
		size(700,450);
	}
	
	public void setup()
	{
		m = new MontyHall();
		m.randomizePrizeDoor();
	}
	
	public void draw()
	{
		mainDraw();
		if(m.getPlayersInitialPick() != -1)
		{
			text("Player's Initial Pick: " + m.getPlayersInitialPick(), 300,20);
		}
		
		if(m.getOpenDoor() != -1 && m.getPlayersFinalDoor() == -1) 
		{
			fill(0,255,0);
			rect(20,20,20,20);
			fill(255,0,0);
			rect(50,20,20,20);
			text("Prees green to stay, press red to switch", 50, 20);
		}
		
		if (m.getPlayersFinalDoor() != -1)
		{
			fill(0,0,0);
			if(m.getPrizeDoor() == 1)
			{
				rect(50,50,150,350);	
			}
			else if (m.getPrizeDoor() == 2)
			{
				rect(250,50,150,350);
			}
			else if (m.getPrizeDoor() == 3)
			{
				rect(450,50,150,350);
			}
			
		}
		winDraw();
		
		
	}

	private void winDraw() {
		if(m.getPrizeDoor() == m.getPlayersFinalDoor())
		{
			fill(0,255,0);
			rect(0,0,700,450);
			
			fill(0,0,0);
			text("You Won", 300, 200);
			fill(255,255,255);
			rect(225,325,275,375);
			fill(0,0,0);
			text("Play again", 300, 375);
			stats();
		}
		else if(m.getPlayersFinalDoor() != -1 && m.getPrizeDoor() != m.getPlayersFinalDoor())
		{
			fill(255,0,0);
			rect(0,0,700,450);
			fill(0,0,0);
			text("You Lost", 300, 200);
			fill(255,255,255);
			rect(225,325,275,375);
			fill(0,0,0);
			text("Play again", 300, 375);
			stats();
		}
	}
	private void stats() {
		fill(0,0,0);
		text("Times Switched"+ m.timesSwitched(), 25, 200);
		text("Times Stayed"+ m.timesStayed(), 50, 150);
		text("Times Lost"+ m.losses(), 75, 175);
		text("Times Won"+ m.wins(), 100, 225);
	}

	private void mainDraw() {
		background(0,0,0);
		
		fill(255,255,255);
		text("Door 1", 100, 45);
		text("Door 2", 300, 45);
		text("Door 3", 500, 45);
		fill(255,255,255);
		makeDoor(50,50,150,350, 1);
		makeDoor(250,50,150,350, 2);
		makeDoor(450,50,150,350, 3);
	}
	
	public void makeDoor(int posX, int posY, int width, int height, int doorNumber)
	{
		if(doorNumber == m.getOpenDoor())
		{					
			fill(255,0,0);
		}
		else
			fill(255);
		
		
		rect(posX,posY,width,height);
	}

	public void mousePressed()
	{ 
		if(m.getPlayersInitialPick() == -1)
		{
			if ((mouseX > 50 && mouseX < 200) && (mouseY > 50 && mouseY < 400))
			{
				m.pickInitialDoor(1);
			}
			else if ((mouseX > 250 && mouseX < 400) && (mouseY > 50 && mouseY < 400))
			{
				m.pickInitialDoor(2);
			}
			else if ((mouseX > 450 && mouseX < 600) && (mouseY > 50 && mouseY < 400))
			{
				m.pickInitialDoor(3);
			}
		}
		else if(m.getOpenDoor() == -1)
		{
			m.openEmptyDoor();
		}
		
		else if (mouseX > 20 && mouseX < 40 && mouseY > 20 && mouseY < 40)
		{
			m.switchOrStay(true);
		}
		else if (mouseX > 50 && mouseX < 70 && mouseY > 20 && mouseY < 40)
		{
			m.switchOrStay(false);
		}
		
		if(mouseX > 225 && mouseX < 500 && mouseY > 325 && mouseY <	700)
		{
			//rect(225,325,275,375);
			m.reset();
		}
	}
	
	
}



