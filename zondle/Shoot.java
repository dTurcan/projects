package zondle;


import processing.core.PApplet;

public class Shoot 
{

	private PApplet parent;

	private int topLeftX, topLeftY;

	private int speedX, speedY;
	private int diameter; 
	
	
	public Shoot(PApplet p, int shipOneX, int shipOneY, int speedX, int speedY)
	{
		parent = p;

		topLeftX = shipOneX;
		topLeftY = shipOneY;
		this.speedX = speedX;
		this.speedY = speedY;
		diameter = 10;
	}
	
	
	public void setSpeedX(int numX)
	{
		speedX = numX;
	}
	
	public int getSpeedX()
	{
		return speedX;
	}
	
	public void setSpeedY(int numY)
	{
		speedY = numY;
	}
	
	public int getSpeedY()
	{
		return speedY;
	}
	
	public void moveShot()
	{
		
		topLeftX += speedX;
		topLeftY += speedY;
//		if (topLeftX >= 980)
//		{
//			topLeftX = 980;
//			speedX = -speedX;
//		}
//		else if (topLeftX <= 20)
//		{
//			topLeftX = 20;
//			speedX = -speedX;
//		}
//		if (topLeftY >= 980)
//		{
//			topLeftY = 980;
//			speedY = -speedY;
//		}
//		else if (topLeftY <= 20)
//		{
//			topLeftY = 20;
//			speedY = - speedY;
//		}
	}
	
	public void drawShot()
	{
		parent.fill(0);
		parent.ellipse(topLeftX, topLeftY, diameter, diameter);
	}
	
	
}


