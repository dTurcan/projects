package clickyShape;

import processing.core.PApplet;

public class ClickyShape extends PApplet
{

	public static void main(String[] args) 
	{

		PApplet.main("clickyShape.ClickyShape");
	}



	int smileyX = 150;
	int smileyY = 250;
	int speedX = 2;
	int speedY = 2;
	int finalNumberX = 0;
	int finalNumberY = 0;
	
	int characterX = 600;
	int characterY = 500;
	int finalCharacterX = 0;
	int finalCharacterY = 0;
	
	int lives = 3;
	
private int timeOfNextChange;
	private final int CHANGE_DELAY = 5;
	
	public void settings()
	{
		
		size(1000, 800);

	}

	public void setup()
	{
		timeOfNextChange = CHANGE_DELAY;
	}


	public void draw()
	{
		//background(255,50,0);
		background(random(0,256), random(0,256), random(0,256));
	
		
		drawSmileyFace();
		drawCharacter();
		keyPressed();
		
		int time = millis() / 1000;

		
		smileyX = smileyX + speedX;
		smileyY = smileyY + speedY;

		if (smileyX >= 940) {
			smileyX = 940;
			speedX = -speedX;
		} else if (smileyX <= 0)
		{
			smileyX = 0;
			speedX = -speedX;
		}

		if (smileyY >= 700) {
			smileyY = 700;
			speedY = -speedY;
		} else if (smileyY <= 0)
		{
			smileyY = 0;
			speedY = -speedY;
		}
		
		if (characterX >= 940) {
			characterX = 940;
		} else if (characterX <= 0)
		{
			characterX = 0;
		}

		if (characterY >= 700) {
			characterY = 700;
		} else if (characterY <= 0)
		{
			characterY = 0;
		}
		
		fill(255,255,255);
		textSize(30);
		text("Lives: " + lives, 20,50);
		text("Time: " + time, 20,100);
		
		
		if (time >= timeOfNextChange)
		{
		speedX = speedX * 2;
		speedY = speedY * 2;
		
		timeOfNextChange = time + CHANGE_DELAY;
		}
		
		
		if (dist(characterX, characterY, smileyX, smileyY) <= 80)
		{
		characterX = 350;
		characterY = 350;
		smileyX = 50;
		smileyY = 100;
		lives --;
		}
		
		
		
		if (lives == 0)
		{
			background(255,0,20);
			
			 smileyX = 150;
			 smileyY = 250;
			 speedX = 0;
			 speedY = 0;
			 finalNumberX = 0;
			 finalNumberY = 0;
			
			 characterX = 600;
			 characterY = 500;
			 finalCharacterX = 0;
			 finalCharacterY = 0;
			text("You're bad! Your total time alive was " + time + " seconds:(",150,200);
		}
		
	}

	public void keyPressed()
	{
		if(key == CODED)
		{
			if(keyCode == UP)
			{
				characterY = characterY - 6;
			}
			else if (keyCode == DOWN)
			{
				characterY = characterY + 6;
			}
			else if (keyCode == RIGHT)
			{
			characterX = characterX + 6; 	
			}
			else if (keyCode == LEFT)
			{	
				characterX = characterX - 6; 
			}
		}
		else
		{
			if(key == ' ' && lives == 0)
			{
//				background(0,0,255);
				lives = 3;
				characterX = 350;
				characterY = 350;
				smileyX = 50;
				smileyY = 100;
				smileyX = 150;
				
			    speedX = 2;
				speedY = 2;
				//time = 0;
			}
		}
	}
	
	public void drawSmileyFace()
	{

		fill(250, 246, 0);
		ellipse(smileyX + 30, smileyY + 35, 70, 80);

		fill(0, 0, 0);
		ellipse(smileyX + 40, smileyY + 20, 5, 5);
		ellipse(smileyX + 20, smileyY + 20, 5, 5);

		arc(smileyX + 30, smileyY + 40, 40, 40, 0, PI, PIE);

		rect(smileyX + 40, smileyY + 70, 10, 30);
		rect(smileyX + 10, smileyY + 70, 10, 30);
		
	}

	
	public void drawCharacter() 
	{
		fill(250, 246, 0);
		ellipse(characterX + 30, characterY + 35, 70, 80);

		fill(0, 0, 0);
		ellipse(characterX + 40, characterY + 20, 5, 5);
		ellipse(characterX + 20, characterY + 20, 5, 5);

		arc(characterX + 30, characterY + 40, 40, 40, 0, PI, PIE);

		rect(characterX + 40, characterY + 70, 10, 30);
		rect(characterX + 10, characterY + 70, 10, 30);
		
		
	}

	
	public void mouseClicked()
	{
		int numberX = (int) (random((int)-100, ((int)101)));
		finalNumberX = numberX;

		int numberY = (int) (random((int)-100, ((int)101)));
		finalNumberY = numberY;

		speedX = finalNumberX;
		speedY = finalNumberY;

	}
	

//public void restart()
//{
//	if(keyPressed == getKeyCode() == 32)
//	{
//		
//		
//	}
//}




}
