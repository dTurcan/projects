int hour;
int minute;
int second;

void setting()
{
  
}

void setup()
{
  size(700,700);
}

void draw()
{
  background(100,250,0);
  hour = hour();
  minute = minute();
  second = second();
  
  
  fill(250,0,100);
  textSize(50);
  
  if(second() < 10)
  {
  text("" + hour%12 + "   :   " + minute + "  :  0"  + second, 160,350);
  }
  if (second() >=10)
  {
      text("" + hour%12 + "   :   " + minute + "  :  "  + second, 160,350);
  }




}
