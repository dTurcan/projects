package clock.clock;

import processing.core.PApplet;
import java.util.Calendar;
import java.util.Date;

public class Clock extends PApplet
{

	public static void main(String[] args)
	{
		PApplet.main("clock.clock.Clock");
	}

	int hour;
	int minute;
	int second;

	public void settings()
	{
		size(700,700);
	}

	public void setup()
	{
	}

	public void draw()
	{
		background(100,250,0);
		drawOutline();
		int hour = hour();
		int minute = minute();
		int second = second();
		text("" + drawDate(), 220,200);


		fill(250,0,100);
		textSize(50);

		
		
		if(second() < 10)
		{
			text("" + hour + " : " + minute + ": 0"  + second, 210,355);
		}
		if (second() >=10)
		{
			text("" + hour + " : " + minute + " : "  + second, 210,355);
		}

	}
	
	public void drawOutline()
	{

		for(int startX = 100,startY = 220, start1 = 500, start2 = 250; startX <= 150;startX += 10,
				startY += 10, start1 -= 20, start2 -= 20)
		{
			fill(random(1,255), random(1,255), random(1,255));
			rect(startX, startY,start1 ,start2, 25);
		}

	}


public String drawDate()
{
	String day = "";
	Calendar c = Calendar.getInstance();
	int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
	
	if (dayOfWeek == 1)
	{
		day = "Sunday";
	}
	else if (dayOfWeek == 2)
	{
		day = "Monday";
	}
	else if (dayOfWeek == 3)
	{
		day = "Tuesday";
	}
	else if (dayOfWeek == 4)
	{
		day = "Wednesday";
	}
	else if (dayOfWeek == 5)
	{
		day = "Thursday";
	}
	else if (dayOfWeek == 6)
	{
		day = "Friday";
	}
	else if (dayOfWeek == 7)
	{
		day = "Saturday";
	}	
	return (day);
}
}