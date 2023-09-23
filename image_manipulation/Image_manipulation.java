package image_manipulation;

import processing.core.PApplet;
import processing.core.PImage;


public class Image_manipulation extends PApplet
{
    PImage picture;
    PImage greenscreen;
    PImage pineapple;
    PImage baby;
    PImage secret1;
    PImage secret2;

    public static void main(String[] args)
    {
        PApplet.main("image_manipulation.Image_manipulation");
    }
    
    public void settings()
    {
        size(1000, 800);
    }
    
    public void setup()
    {
        picture = loadImage("images/audi.jpg");
    	greenscreen = loadImage("images/greenscreen.jpg");
    	pineapple = loadImage("images/pineapple.jpg");
    	baby = loadImage("images/baby-window.png");
    	secret1 = loadImage("images/secret1.png");
    	secret2 = loadImage("images/secret2.png");

    	
    	//manipulate();
        //inverted();
        //mirrored();
        //greened();
    	babied();
    	//secreted();
    	//secreted2();
//<<<<<<< HEAD
    	//pixelate(10, 20 , 20); EXTRA: NOT  DONE!!!
//=======
    	//pixelate(1,picture, picture);
//>>>>>>> branch 'master' of git@github.com:WHHS-AP-CS/2021-2022-hj-p6-12249099.git
    }
    
    public void draw()
    {
    	//image(picture, 0, 0);
    	//image(pineapple, 0, 0);
       image(baby,0,0);
    	//image(secret1,0,0);
    	//image(secret2,0,0);
    }
    
    public void manipulate()
    {
   
        for(int x = 0; x < picture.width; x++)
        {
            for(int y = 0; y < picture.height; y++)
            {
                int pixel = picture.get(x, y);                
                int average = color((red(pixel) + green(pixel) + blue(pixel)) /3);
                picture.set(x, y, average);
            }
        }
    }


    public void inverted()
    {
   
        for(int x = 0; x < picture.width; x++)
        {
            for(int y = 0; y < picture.height; y++)
            {
                int pixel = picture.get(x, y);                
                float reds = 255 - red(pixel);
                float greens = 255 - green(pixel);
                float blues = 255 - blue(pixel);
                int invert = color(reds,greens,blues);
                picture.set(x, y, invert);
            }
        }
    }
    
    
    public void mirrored()
    {
   
        for(int x = 0; x < picture.width; x++)
        {
            for(int y = 0; y < picture.height; y++)
            {
                int pixel = picture.get(x, y);                
                picture.set(700 - x, y, pixel);    
            }
        }
    }
    
    public void greened()
    {
        for(int x = 0; x < pineapple.width; x++)
        {
            for(int y = 0; y < pineapple.height; y++)
            {
                int pixel = pineapple.get(x, y);                
                if (blue(pixel) > 150)                	
                	pineapple.set(x, y, greenscreen.get(x, y));
            }
        }
//     
        
    }



	public void babied()
	{
	 int colors;
		
	    for(int x = 0; x < baby.width; x++)
	    {
	        for(int y = 0; y < baby.height; y++)
	        {
	            int pixel = baby.get(x, y);                
	            float reds = red(pixel);
	            
	            if (reds % 2 == 0)
	            	{
	            	colors = color(0,0,0);
	            	}
	            else
	            {
	            	colors = color(255,255,255);
	            }
	            
	            
	            baby.set(x, y, colors);
	        }
	    }
	}
	
	
	public void secreted()
	{
	 int colors;
		
	    for(int x = 0; x < secret1.width; x++)
	    {
	        for(int y = 0; y < secret1.height; y++)
	        {
	            int pixel = secret1.get(x, y);                
	            float reds = red(pixel);
	            
	            if (reds % 2 == 0)
	            	{
	            	colors = color(0,0,0);
	            	}
	            else
	            {
	            	colors = color(255,255,255);
	            }
	            
	            
	            secret1.set(x, y, colors);
	        }
	    }
	}
	
	
	
	public void secreted2()
	{
	 int colors;
		
	    for(int x = 0; x < secret2.width; x++)
	    {
	        for(int y = 0; y < secret2.height; y++)
	        {
	            int pixel = secret2.get(x, y);                
	            float reds = red(pixel);
	            
	            if (reds % 2 == 0)
	            	{
	            	colors = color(0,0,0);
	            	}
	            else
	            {
	            	colors = color(255,255,255);
	            }
	            
	            
	            secret2.set(x, y, colors);
	        }
	    }
	}
	
	
	public void pixelate(int radius, int middleX, int middleY)
	{
		int redSum = 0;
		int greenSum = 0;
		int blueSum = 0;
		
		int count = 0;
		
		// pair of loops to find the averages
		for(int x = middleX - radius; x <= middleX + radius ; x++)
		{
			for(int y = middleY - radius; y < middleY + radius; y++)
		    {
				int pixel = picture.get(x, y);
			    greenSum += green(pixel);
				redSum += red(pixel);
				blueSum += blue(pixel);	  
				
				count++;
		    }
		}
		 
		float redAverage = redSum / count;
	    float greenAverage = greenSum / count;
	    float blueAverage = blueSum / count;
	   
	    
	    int newColor = color(redAverage, greenAverage, blueAverage);
	     
	     // pair of loops to set each pixel to the averages
	     for (int x = middleX - radius; x <= middleX + radius ; x++)
	     {
	    	 for(int y = middleY - radius; y < middleY + radius; y++)
	    	 {
	    		picture.set(x, y, newColor);
	    	 }
	
	     }
	}
	
	
	
//	public void pixelate(int middleX, int middleY)
//	{
//		int redSum = 0;
//		int greenSum = 0;
//		int blueSum = 0;
//		
//		for(int x = middleX - 1; x <= middleX + 1 ; x++)
//	    {
//	        for(int y = middleY -1; y < middleY + 1; y++)
//	        {
//	            int pixel = picture.get(x, y);
//			    greenSum += green(pixel);
//				redSum += red(pixel);
//				blueSum += blue(pixel);	            
//	        }
//	        redSum = redSum / 9;
//	        greenSum = greenSum / 9;
//	        blueSum = blueSum / 9;
//	        
//	        
//	        
//			picture.set(middleX,middleY,color(redSum, greenSum, blueSum));
//	
//	    }
//	}

}


	
