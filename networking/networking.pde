import processing.net.*;
Server myServer;
int val = 0;
String typing = "";
String saved = "";

String newtext = "";

ArrayList<Address> addresses;

void setup()
{
  size(500, 300);
  myServer = new Server(this, 5204);
}

void draw ()
{
   readTextIfAvailable();
}

 
void keyPressed() 
{
  if (key == '\n' )
  {
    saved = typing;
    typing = "";
    myServer.write(saved);
  } 
  else 
  { 
    typing = typing + key; 
  }

}

void readTextIfAvailable()
{
  Client c = myServer.available();
  if(c != null && c.available() > 0)
   {
     //String ipAddress = c.ip();
     newtext = (c.readString());
     println(newtext);
     myServer.write(newtext);
     newtext = "";
   }
}


 
