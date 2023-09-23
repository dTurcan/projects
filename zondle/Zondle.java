package zondle;


import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Zondle extends PApplet 
{
	private int x, y, rotationDegrees;

	private boolean rightArrowPressed, downArrowPressed, leftArrowPressed, upArrowPressed;
	PImage shipOne;
	PImage shipTwo;

	ArrayList<Shoot> bullets = new ArrayList<Shoot>();  
	int shipOneX = 100;
	int shipOneY = 50;
	int shipOneDiamater = 30;
	int shipOneSpeed = 3;
	int turnAmount = 90;
	

	//	private Shoot sh;

	public static void main(String[] args) 
	{

		PApplet.main("zondle.Zondle");


	}

	public void settings()
	{
		size(800,600);
	}

	public void setup()
	{
		shipOne = loadImage("images/rocket_1.png");
		shipTwo = loadImage("images/rocket_2.png");
		rotationDegrees = 45;

	}

	public void draw()
	{
		playerMovement();
		background(100,100,100);
		makeShip();

		for (int i = 0; i < bullets.size(); i++)
		{
			bullets.get(i).drawShot();
			bullets.get(i).moveShot();
		}


	}

	public void makeShip() 
	{

		fill(255);

		pushMatrix();

		translate(shipOneX,shipOneY);
		rotate(PApplet.radians(turnAmount));
		imageMode(CENTER);



		image(shipOne, 0, 0);

		popMatrix();
	}

	private void playerMovement() 
	{
		direction();


		if(rightArrowPressed && shipOneX < width - shipOneDiamater/2)
			shipOneX= shipOneX + shipOneSpeed;

		if(downArrowPressed && shipOneY < height - shipOneDiamater/2)
			shipOneY= shipOneY + shipOneSpeed;
		
		if(upArrowPressed && shipOneY > 0 - shipOneDiamater/2)
			shipOneY= shipOneY - shipOneSpeed;

		if(leftArrowPressed && shipOneX > 0 + shipOneDiamater/2)
			shipOneX= shipOneX - shipOneSpeed;


		if(shipOneX-40 > width)
		{
			shipOneX = -40;
		}
	}

	private void direction() {
		if (upArrowPressed && rightArrowPressed) {
			turnAmount = 45;
		}
		else if (downArrowPressed && rightArrowPressed) {
			turnAmount = 135;
		}
		else if (downArrowPressed && leftArrowPressed) {
			turnAmount = 225;
		}
		else if (upArrowPressed && leftArrowPressed) {
			turnAmount = 315;
		}
		else if(rightArrowPressed)
		{
			turnAmount = 90;
		}
		else if(downArrowPressed)
		{
			turnAmount = 180;
		}
		else if (leftArrowPressed) 
		{
			turnAmount = 270;
		}
		else if (upArrowPressed)
		{
			turnAmount = 0;
		}
	}

	public boolean upKeyPressed()
	{
		return upArrowPressed;
	}

	public boolean downKeyPressed()
	{
		return downArrowPressed;
	}

	public boolean leftKeyPressed()
	{
		return leftArrowPressed;
	}

	public boolean rightKeyPressed()
	{
		return rightArrowPressed;
	}
	
	public void mousePressed()
	{
		if(turnAmount == 45)
		{
			bullets.add(new Shoot(this, shipOneX+ 5, shipOneY + 5, 10,-10));
		}
		else if(turnAmount == 315)
		{
			bullets.add(new Shoot (this, shipOneX+ 5, shipOneY + 5, -10,-10));
		}
		else if(turnAmount == 135)
		{
			bullets.add(new Shoot(this, shipOneX+ 5, shipOneY + 5, 10, 10));	
		}
		else if(turnAmount == 225)
		{
			bullets.add(new Shoot (this, shipOneX+ 5, shipOneY + 5, -10,10));
		}	
		else if(turnAmount == 180)
		{
			bullets.add(new Shoot (this, shipOneX+ 5, shipOneY + 5, 0,10));
		}
		else if(turnAmount == 0)
		{
			bullets.add(new Shoot (this, shipOneX+ 5, shipOneY + 5, 0,-10));
		}
		else if(turnAmount == 90)
		{
			bullets.add(new Shoot (this, shipOneX+ 5, shipOneY + 5, 10,0));
		} 
		else if(turnAmount == 270)
		{
			bullets.add(new Shoot (this, shipOneX+ 5, shipOneY + 5, -10,0));
		}
	}
	
	public void keyPressed()
	{
		
		if(key == CODED)
		{

			if(keyCode == RIGHT)
			{
				rightArrowPressed = true;
			}
			else if(keyCode == DOWN)
			{
				downArrowPressed = true;
			}
			else if (keyCode == LEFT) 
			{
				leftArrowPressed = true;
			}
			else if (keyCode == UP)
			{
				upArrowPressed = true;
			}
		}

		
}

	public void keyReleased()
	{
		if(key == CODED)
		{
			if(keyCode == RIGHT)
				rightArrowPressed = false;
			else if(keyCode == DOWN)
				downArrowPressed = false;
			else if (keyCode == LEFT)
				leftArrowPressed = false;
			else if (keyCode == UP)
				upArrowPressed = false;
		}


	}


}


