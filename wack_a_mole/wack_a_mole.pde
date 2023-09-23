  PImage mole;
PImage circle;
PImage wackback;

int moleX = 150;
int moleY = 150;
int score = 0;
int lives = 3;
int time = millis() / 1000;

void settings()
{
 size(500, 500);  
}


void setup()
{
  mole = loadImage("mole.png");
  circle = loadImage("circle.png");
  wackback = loadImage("wackback.jpg");
}

void draw()
{
  background(0,230,0);
  image(wackback, 0, 0);
  image(mole, moleX, moleY);
  
  textSize(45);
  text("Score: " + score, 50, 430);
  text("Lives: " + lives, 300, 430);
 
  
     
     if (time == 4)
     {
      moleX = (int) random(0,4) * 100;
      moleY = (int) random(0,3) * 100;
      time = 0;
      lives --;
     }
     
 if (lives == 0)
  {
    // draw (including text) in your draw method or methods called from draw
    textSize(26);
    text("You lost:( Your high score was " + score, 30,250);
  }
      

}
  
  
void mousePressed()
{
  if(lives > 0)
  {
    if (mouseX >= moleX && mouseX <= moleX + 87 && mouseY >= moleY && mouseY <= moleY + 65)
    {
      moleX = (int) random(0,4) * 100;
      moleY = (int) random(0,3) * 100;
      score ++;
    }
    else
    {
      lives --;
    }
  }
  
  
}



  
